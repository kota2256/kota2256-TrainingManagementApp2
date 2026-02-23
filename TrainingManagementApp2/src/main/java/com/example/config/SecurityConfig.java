package com.example.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration				// 設定ファイルであることを示すアノテーション
@EnableWebSecurity	//カスタムセキュリティ設定を有効（デフォルトのセキュリティ設定が無効）にする
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure (WebSecurity web) throws Exception {		//WebSecurity：セキュリティフィルター自体通過させない設定
		web.ignoring()
			.antMatchers("/css/**")
			.antMatchers("/webjars/**")
			.antMatchers("/js/**")
			.antMatchers("/h2-console/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		//HttpSecurity：URLパスごとの認証・認可ルール設定
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/signup").permitAll()
			.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
			.anyRequest().authenticated();
		
		http.formLogin()
		.loginProcessingUrl("/login")				//ログイン処理のパス
		.loginPage("/login")								//ログインページの指定
		.usernameParameter("email")
		.passwordParameter("password")
		.failureUrl("/login?error")						//ログイン失敗時のリダイレクト先
		.defaultSuccessUrl("/home", true);		//認証後にリダイレクトする場所を指定
		
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout");
		
		http.csrf().disable();	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = passwordEncoder();
		
//		//インメモリ認証
//		auth.inMemoryAuthentication()
//			.withUser("user")
//				.password(encoder.encode("user"))
//				.roles("GENERAL")
//			.and()
//			.withUser("admin")
//				.password(encoder.encode("admin"))
//				.roles("ADMIN");
		
		//ユーザーデータ認証
		//自作したUserDetailsServiceをauth.userDetailsServiceメソッドの引数に渡せばOK
		auth.userDetailsService(userDetailsService)		
			.passwordEncoder(encoder);
	}
	
}

package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class LoginForm {

	@NotBlank
	@Email
	public String email;
	@NotBlank
	@Length(max=10, min=4)
	public String password;
}

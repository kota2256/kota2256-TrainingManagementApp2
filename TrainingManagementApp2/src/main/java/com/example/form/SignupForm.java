package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank
	public String name;
	@NotBlank
	public String password;
	@NotBlank
	@Email
	public String email;
}

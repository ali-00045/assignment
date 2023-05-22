package com.task.security.request;

import org.hibernate.validator.constraints.UniqueElements;

import com.task.security.entity.Role;

import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @NotNull(message = "First Name required.")
  @NotEmpty(message = "First Name required.")
  private String firstname;

  @NotNull(message = "Last Name required.")
  @NotEmpty(message = "Last Name required.")
  private String lastname;

  @NotNull(message = "Username required.")
  @NotEmpty(message = "Username required.")
  private String username;
  @Email
  private String email;
  @Pattern(regexp = "^(?=.*[0-9])?(?=.*[a-z]).{8,20}$", message = "Min 8 character.")
  private String password;
  private Role role = Role.USER;
}

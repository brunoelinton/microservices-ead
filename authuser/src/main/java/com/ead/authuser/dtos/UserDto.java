package com.ead.authuser.dtos;

import com.ead.authuser.validation.UserNameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.ead.authuser.dtos.UserDto.UserView.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    public interface UserView {
        public static interface RegistrationPost {}
        public static interface UserPut {}
        public static interface PasswordPut {}
        public static interface ImagePut {}

    }

    @NotBlank(groups = RegistrationPost.class)
    @Size(min = 4, max = 50, groups = RegistrationPost.class)
    @UserNameConstraint(groups = RegistrationPost.class)
    @JsonView({RegistrationPost.class})
    private String username;

    @NotBlank(groups = RegistrationPost.class)
    @Email(groups = RegistrationPost.class)
    @JsonView({RegistrationPost.class})
    private String email;

    @NotBlank(groups = {RegistrationPost.class, PasswordPut.class})
    @Size(min = 6, max = 20, groups = {RegistrationPost.class, PasswordPut.class})
    @JsonView({RegistrationPost.class, PasswordPut.class})
    private String password;

    @NotBlank(groups = PasswordPut.class)
    @Size(min = 6, max = 20, groups = PasswordPut.class)
    @JsonView({PasswordPut.class})
    private String oldPassword;

    @JsonView({RegistrationPost.class, UserPut.class})
    private String fullName;

    @JsonView({RegistrationPost.class, UserPut.class})
    private String phoneNumber;

    @JsonView({RegistrationPost.class, UserPut.class})
    private String cpf;

    @NotBlank(groups = ImagePut.class)
    @JsonView({ImagePut.class})
    private String imageUrl;
}

package com.example.registration_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Long id;

    @NotBlank(message = "firstname is not empty")
    @Size(min = 2, max = 25)
    private String firstname;

    @NotBlank(message = "lastname is not empty")
    @Size(min = 2, max = 25)
    private String lastname;

    @NotNull
    @Min(value = 18)
    private Integer age;

    @Email(message = "Email cannot be empty")
    @Pattern(regexp = "^(?:^|\\\\s)[\\\\w!#$%&'*+/=?^`{|}~-](\\\\.?[\\\\w!#$%&'*+/=?^`{|}~-]+)*@\\\\w+[.-]?\\\\w*\\\\.[a-zA-Z]{2,3}\\\\b$\"", message = "Email must be in the correct format")
    private String email;

    @NotBlank(message = "Phone cannot be empty")
    @Pattern(regexp = "^(0|(\\\\(84\\\\)\\\\+))+([9][0-1][0-9]{7})$\"", message = "Phone must be in the correct format")
    private String phone;

    private  boolean flag = true;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}

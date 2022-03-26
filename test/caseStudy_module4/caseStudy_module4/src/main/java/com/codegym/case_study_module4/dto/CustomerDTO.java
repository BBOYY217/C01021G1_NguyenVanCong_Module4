package com.codegym.case_study_module4.dto;


import com.codegym.case_study_module4.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDTO implements Validator {
    private Integer id;
    @NotBlank(message = "Họ tên không được để trống.")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10}|[\\p{Lu}]\\d*[\\p{Lu}]*|\\d*)){0,5}$",
            message = "Họ tên phải đúng định dạng.")
    private  String customerName;

    private String customerBirthday;

    private String gender;

    @NotBlank(message = "Số CMND không được để trống.")
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$",
            message = "Số CMND phải đúng định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX.")
    private  String customerIdCard;

    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Số điện thoại phải đúng định dạng: 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;

    @NotBlank(message = "Email không được để trống.")
    @Pattern(regexp = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$",
            message = "Email phải đúng định dạng.")
    private String email;

    @NotBlank(message = "Không được để trống địa chỉ")
    private String address;

    private CustomerType customerTypes;

    public CustomerDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerTypes() {
        return customerTypes;
    }

    public void setCustomerTypes(CustomerType customerTypes) {
        this.customerTypes = customerTypes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        return;
    }


}

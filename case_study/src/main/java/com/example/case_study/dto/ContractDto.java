package com.example.case_study.dto;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.service.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContractDto implements Validator {
    private String contractId;

    @NotBlank(message = "Ngày bắt đầu hợp đồng không được để trống.")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$")
    private String startDate;

    @NotBlank(message = "Ngày kết thúc hợp đồng không được để trống.")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$")
    private String endDate;

    //    @NotBlank(message = "Tiền đặt cọc không được để trống.")
    @Min(value = 1, message = "Tiền đặt cọc phải là số dương.")
    private Double contractDeposit;

    @NotNull(message = "Tổng tiền không được để trống.")
    @Min(value = 1, message = "Tổng tiền phải là số dương.")
    private Double contractTotalMoney;

    private Employee employee;

    private Customer customer;

    private Service Service;

    //    @OneToMany(mappedBy = "contract")
//    private Set<ContractDetail> contractDetails;
    private Boolean flag;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public com.example.case_study.model.service.Service getService() {
        return Service;
    }

    public void setService(com.example.case_study.model.service.Service service) {
        Service = service;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
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

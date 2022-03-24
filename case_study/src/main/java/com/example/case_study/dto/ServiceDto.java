package com.example.case_study.dto;

import com.example.case_study.model.service.RentType;
import com.example.case_study.model.service.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ServiceDto implements Validator {

    private String serviceId;

    @NotBlank(message = "Hãy nhập tên")
    private String serviceName;

    @NotBlank(message = "Khu vực trống")
    @Min(value = 1, message = "Khu vực phải là số dương.")
    private String serviceArea;

    @NotBlank(message = "Giá không được để trống.")
    @Min(value = 1, message = "Giá phải là số dương.")
    private String serviceCost;

    @NotBlank(message = "Số lượng người không được để trống.")
    @Min(value = 1, message = "Số lượng người ít nhất là 1 .")
    private String serviceMaxPeople;

    private RentType rentType;
    private ServiceType serviceType;

    @NotBlank(message = "Hãy nhập số phòng")
    @Pattern(regexp = "^([1-9])([0-9]*)$",
            message = "Số lượng phòng phải là một số nguyên dương")
    private String standardRoom;

    @NotBlank(message = "Hãy nhập mô tả sự tiện lợi")
    private String descriptionOtherConvenience;

    @NotBlank(message = "Khu vục hồ bơi không dược để trống")
    private String poolArea;

    @NotBlank(message = "Số tầng không được để trống.")
    @Min(value = 1, message = "Số tầng phải là số dương.")
    private String numberOfFloor;

    private boolean flag;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
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

package com.codegym.case_study_module4.dto;

import com.codegym.case_study_module4.model.RentType;
import com.codegym.case_study_module4.model.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ServiceDto implements Validator {
    private Integer id;

    private String serviceName;

    private Integer area;

    private double serviceCost;

    private Integer serviceMaxPeople;

    private String description;

    private double poolArea;

    private Integer numberOfFloors;

    private ServiceType serviceType;

    private RentType rentType;

    public ServiceDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if (serviceDto.serviceCost <= 0) {
            errors.rejectValue("serviceCost", "", "Chi phí dịch vụ không được để trống và lớn hơn 0");
        }
        if (serviceDto.serviceMaxPeople == null || serviceDto.serviceMaxPeople <= 0) {
            errors.rejectValue("serviceMaxPeople", "", "Số người tối  đa không được để trống và lớn hơn 0");
        }
        if (serviceDto.numberOfFloors == null || serviceDto.numberOfFloors <= 0) {
            errors.rejectValue("numberOfFloors", "", "Số tầng không được để trống và lớn hơn 0");
        }
    }
}

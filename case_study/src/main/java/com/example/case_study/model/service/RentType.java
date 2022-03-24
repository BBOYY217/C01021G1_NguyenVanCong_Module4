package com.example.case_study.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rentType")
public class RentType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int rentTypeId;
    private String rentTypeName;
    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    @JsonBackReference
    List<Service> serviceList;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, Double rentTypeCost) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

}

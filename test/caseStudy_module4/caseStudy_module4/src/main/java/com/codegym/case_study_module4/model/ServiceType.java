package com.codegym.case_study_module4.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    @JsonManagedReference
    private Set<Service1> service1;

    public ServiceType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<Service1> getService1() {
        return service1;
    }

    public void setService1(Set<Service1> services) {
        this.service1 = services;
    }
}

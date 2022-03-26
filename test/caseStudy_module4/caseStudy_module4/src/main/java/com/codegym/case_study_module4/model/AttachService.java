package com.codegym.case_study_module4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameAttach;

    private Double costAttach;
    private Integer attachUnit;
    private String attachStatus;

    @OneToMany(mappedBy = "attachService")
    private Set<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(Integer id, String nameAttach, Double costAttach,
                         Integer attachUnit, String attachStatus, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.nameAttach = nameAttach;
        this.costAttach = costAttach;
        this.attachUnit = attachUnit;
        this.attachStatus = attachStatus;
        this.contractDetails = contractDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameAttach() {
        return nameAttach;
    }

    public void setNameAttach(String nameAttach) {
        this.nameAttach = nameAttach;
    }

    public Double getCostAttach() {
        return costAttach;
    }

    public void setCostAttach(Double costAttach) {
        this.costAttach = costAttach;
    }

    public Integer getAttachUnit() {
        return attachUnit;
    }

    public void setAttachUnit(Integer attachUnit) {
        this.attachUnit = attachUnit;
    }

    public String getAttachStatus() {
        return attachStatus;
    }

    public void setAttachStatus(String attachStatus) {
        this.attachStatus = attachStatus;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}

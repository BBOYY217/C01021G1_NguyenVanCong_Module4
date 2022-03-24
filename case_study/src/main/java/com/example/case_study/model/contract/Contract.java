package com.example.case_study.model.contract;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.service.Service;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(generator = "id_gen_contract")
    @GenericGenerator(name = "id_gen_contract", parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "HD-"), strategy = "com.example.case_study.model.contract.IdGenerator")

    private String contractId;
    private String startDate;
    private String endDate;
    private double contractDeposit;
    private double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employeeId" )
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId" )
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "Service_id",referencedColumnName = "serviceId" )
    private Service Service;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;


    public Contract() {
    }

    public Contract(String contractId, String startDate, String endDate, double contractDeposit, double contractTotalMoney, Employee employee, Customer customer, com.example.case_study.model.service.Service service, Set<ContractDetail> contractDetails) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        Service = service;
        this.contractDetails = contractDetails;
    }

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

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
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
}

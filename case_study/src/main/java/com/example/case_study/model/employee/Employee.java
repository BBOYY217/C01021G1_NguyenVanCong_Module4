package com.example.case_study.model.employee;

import com.example.case_study.model.contract.Contract;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(generator = "id_gen_employee")
    @GenericGenerator(name = "id_gen_employee", parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "NV-"), strategy = "com.example.case_study.model.employee.IdGenerator")
    private String employeeId;

    private String employeeName;
    private String employeeBirth;
    private String employeeIdCard;
    private String employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private boolean flag;

    @OneToMany(mappedBy = "employee")
    private List<Contract> contract;

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "positionId")
    private Position positionId;

    @ManyToOne
    @JoinColumn(name = "educationDegree_id",referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegreeId;

    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "divisionId")
    private Division divisionId;


    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String employeeBirth, String employeeIdCard, String employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, boolean flag, List<Contract> contract, Position positionId, EducationDegree educationDegreeId, Division divisionId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirth = employeeBirth;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.flag = flag;
        this.contract = contract;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirth() {
        return employeeBirth;
    }

    public void setEmployeeBirth(String employeeBirth) {
        this.employeeBirth = employeeBirth;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public EducationDegree getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(EducationDegree educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Contract> getContract() {

        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }
}

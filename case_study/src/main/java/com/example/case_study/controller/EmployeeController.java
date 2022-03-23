package com.example.case_study.controller;

import com.example.case_study.dto.EmployeeDto;
import com.example.case_study.model.employee.Division;
import com.example.case_study.model.employee.EducationDegree;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.employee.Position;
import com.example.case_study.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.rmi.MarshalledObject;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @ModelAttribute("position")
    public List<Position> positionList() {
        return employeeService.listPosition();
    }

    @ModelAttribute("education")
    public List<EducationDegree> educationDegreeList() {
        return employeeService.listEducationDegree();
    }

    @ModelAttribute("division")
    public List<Division> divisionList() {
        return employeeService.listDivision();
    }

    @GetMapping("")
    public ModelAndView employeeList(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                     @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Employee> employees = employeeService.findAll(keyword, pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list", "employees", employees);
        modelAndView.addObject("keyword", keyword);
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("employee/create",
                "employeeDto",new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public String createEmployee(@ModelAttribute @Valid EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employee.setFlag(true);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","create successfully");
        return "redirect:/employee";
    }

    @GetMapping("/edit-employee")
    public String showEdit(@RequestParam String id, Model model){
        Employee employee = this.employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        return "employee/edit";
    }

    @PostMapping("/edit-employee")
    public String editEmployee(@ModelAttribute @Valid EmployeeDto employeeDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employee.setFlag(true);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","edit successfully");
        return "redirect:/employee";
    }

    @PostMapping("/delete-employee")
    public String deleteEmployee(@RequestParam String id,RedirectAttributes redirectAttributes){
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("msg","delete successfully");
        return "redirect:/employee";
    }

    @GetMapping("/detail-employee")
    public  String view(@RequestParam String id,Model model){
        model.addAttribute("employee",employeeService.findById(id));
        return "employee/detail";
    }
}

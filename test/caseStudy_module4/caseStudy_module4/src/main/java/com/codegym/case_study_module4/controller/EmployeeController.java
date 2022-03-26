package com.codegym.case_study_module4.controller;


import com.codegym.case_study_module4.dto.EmployeeDto;
import com.codegym.case_study_module4.model.Employee;
import com.codegym.case_study_module4.service.employeeService.IDivisionService;
import com.codegym.case_study_module4.service.employeeService.IEducationService;
import com.codegym.case_study_module4.service.employeeService.IEmployeeService;
import com.codegym.case_study_module4.service.employeeService.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationService educationService;

    @GetMapping("/employeeList")
    public ModelAndView showEmployeeList(@PageableDefault (value = 2)Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("employee/employeeList");
        modelAndView.addObject("employeeList", employeeService.findAll(pageable));
        modelAndView.addObject("position", positionService.findAll());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("education", educationService.findAll());
        return modelAndView;
    }

    @GetMapping("/employeeCreate")
    public ModelAndView showCreateEmployee() {
        ModelAndView modelAndView = new ModelAndView("employee/createEmployee");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        modelAndView.addObject("position", positionService.findAll());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("education", educationService.findAll());
        return modelAndView;
    }
    @PostMapping("/employeeCreate")
    public String createEmployee(@Valid EmployeeDto employeeDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("position", positionService.findAll());
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("education", educationService.findAll());
            return "employee/createEmployee";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "create successfully");
        }
        return "redirect:/employeeList";
    }

    @GetMapping("/employeeEdit/{id}")
    public ModelAndView showEditEmployee(@PathVariable Integer id, Model model) {
        ModelAndView modelAndView = new ModelAndView("employee/editEmployee");
        modelAndView.addObject("position", positionService.findAll());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("education", educationService.findAll());
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        return modelAndView;
    }
    @PostMapping("/employeeEdit")
    public String editEmployee(@Valid EmployeeDto employeeDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("position", positionService.findAll());
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("education", educationService.findAll());
            return "employee/editEmployee";
        }else{
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "edit successfully");
        }
        return "redirect:/employeeList";
    }

    @PostMapping("/employeeDelete")
    public String deleteEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.remove(employee);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/employeeList";
    }

    @GetMapping("/searchEmployee")
    public String searchEmployee(@RequestParam(name = "search", required = false) String name,
                                 @PageableDefault(value = 2) Pageable pageable, Model model){
        model.addAttribute("employeeList", employeeService.searchByName(name,pageable));
        return "/employee/employeeList";
    }

    @GetMapping("/employeeView/{id}")
    public ModelAndView showViewEmployee(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("employee/employeeView");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

}

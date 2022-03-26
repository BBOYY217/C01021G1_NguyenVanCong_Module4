package com.codegym.case_study_module4.controller;


import com.codegym.case_study_module4.dto.CustomerDTO;
import com.codegym.case_study_module4.model.Customer;
import com.codegym.case_study_module4.service.customerService.ICustomerService;
import com.codegym.case_study_module4.service.customerService.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView("HomePage");
        return modelAndView;
    }
    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/customerList")
    public ModelAndView showCustomer(@PageableDefault(value = 4) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/listCustomer");
        modelAndView.addObject("customerList", customerService.findAll(pageable));
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }


    @GetMapping("/customerCreate")
    public ModelAndView showCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("/customer/createCustomer");
        modelAndView.addObject("customerDTO", new CustomerDTO());
        modelAndView.addObject("customerType", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/customerCreate")
    public String createCustomer(@Valid CustomerDTO customerDTO, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/createCustomer";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "create successfully");
        }
        return "redirect:/customerList";
    }



    @GetMapping("/customerEdit/{id}")
    public ModelAndView showEditCustomer(@PathVariable Integer id, Model model) {
        ModelAndView modelAndView = new ModelAndView("/customer/editCustomer");
        model.addAttribute("customerType", customerTypeService.findAll());
        Customer customer = customerService.findById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        model.addAttribute("customerDTO", customerDTO);
        return modelAndView;
    }

    @PostMapping("/customerEdit")
    public String editCustomer(@Valid CustomerDTO customerDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/editCustomer";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customer, customerDTO);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Edit successfully");
        }
        return "redirect:/customerList";
    }

//    @GetMapping("/customerDelete/{id}")
//    public ModelAndView showDeleteCustomer(@PathVariable Integer id) {
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/customer/deleteCustomer");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("customerType", customerTypeService.findAll());
//        return modelAndView;
//    }


// cos 2 cachs để viết delete

    // 1 là viết bth 2 là viết bằng modal- đang viết theo kiểu modal
    @PostMapping("/customerDelete")
    public String deleteCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/customerList";
    }

    @GetMapping("/searchCustomer")
    public String searchByName(@RequestParam(name = "search", required = false) String name, Model model,@PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("customerList",customerService.searchByName(name, pageable));
        return "/customer/listCustomer";
    }

    @GetMapping("/viewCustomer/{id}")
    public ModelAndView showViewCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/viewCustomer");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }


}

package com.codegym.case_study_module4.controller;

import com.codegym.case_study_module4.model.Contract;
import com.codegym.case_study_module4.service.contract.IContractDetailService;
import com.codegym.case_study_module4.service.contract.IContractService;
import com.codegym.case_study_module4.service.customerService.ICustomerService;
import com.codegym.case_study_module4.service.employeeService.IEmployeeService;
import com.codegym.case_study_module4.service.serviceService.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContractController {
    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IServiceService serviceService;

    @GetMapping("/contractList")
        public ModelAndView showListContract(Pageable pageable){
            ModelAndView modelAndView = new ModelAndView("contract/listContract");
            modelAndView.addObject("contractList", contractService.findAll(pageable));
            modelAndView.addObject("contractDetailService", contractDetailService.findAll(pageable));
            modelAndView.addObject("customerService", customerService.findAll(pageable));
            modelAndView.addObject("employeeService", employeeService.findAll(pageable));
            modelAndView.addObject("serviceService", serviceService.findAll(pageable));

            return modelAndView;
    }

    @GetMapping("/contractCreate")
    public ModelAndView showCreateContract(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("contract/createContract");
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("contractDetailService", contractDetailService.findAll(pageable));
        modelAndView.addObject("customerService", customerService.findAll(pageable));
        modelAndView.addObject("employeeService", employeeService.findAll(pageable));
        modelAndView.addObject("serviceService", serviceService.findAll(pageable));
        return modelAndView;
    }
    @PostMapping("/contractCreate")
    public String createContract(Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "create"+contract.getTotalMoney() +"successfully");
        return "redirect:/contractList";
    }
}

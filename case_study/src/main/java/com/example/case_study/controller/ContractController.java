package com.example.case_study.controller;

import com.example.case_study.dto.ContractDto;
import com.example.case_study.dto.EmployeeDto;
import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.service.Service;
import com.example.case_study.service.contract.IContractService;
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
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @ModelAttribute ("employee")
    public List<Employee> employeeList(){
       return contractService.listEmployee();
    }

    @ModelAttribute ("customer")
    public List<Customer> customerList(){
        return contractService.listCustomer();
    }

    @ModelAttribute ("service")
    public List<Service> serviceList(){
        return contractService.listService();
    }

    @GetMapping("")
    public ModelAndView list(@RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0),10);
        Page<Contract> contracts =contractService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("contract/list");
        modelAndView.addObject("contracts",contracts);
        return modelAndView;
    }

    @GetMapping("/create-contract")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("contract/create",
                "contractDto",new ContractDto());
        return modelAndView;
    }

    @PostMapping(value = "/create-contract")
    public String createContract(@ModelAttribute @Valid ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new ContractDto().validate(contractDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contract.setFlag(true);
        this.contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg","create successfully");
        return "redirect:/contract";
    }

    @GetMapping("/edit-contract")
    public String showEdit(@RequestParam String id, Model model){
        Contract contract = this.contractService.findById(id);
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract,contractDto);
        model.addAttribute("contractDto",contractDto);
        return "contract/edit";
    }

    @PostMapping("/edit-contract")
    public String editEmployee(@ModelAttribute @Valid ContractDto contractDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(contractDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "contract/edit";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contract.setFlag(true);
        this.contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg","edit successfully");
        return "redirect:/contract";
    }

}

package com.example.case_study.controller;

import com.example.case_study.dto.CustomerDto;
import com.example.case_study.dto.ServiceDto;
import com.example.case_study.model.service.RentType;
import com.example.case_study.model.service.Service;
import com.example.case_study.model.service.ServiceType;
import com.example.case_study.service.service.IServiceService;
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
@RequestMapping("service")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @ModelAttribute("rentType")
    private List<RentType> rentTypeList(){
        return serviceService.ListRentType();
    }

    @ModelAttribute("serviceType")
    private List<ServiceType> serviceType(){
        return serviceService.ListServiceType();
    }

    @GetMapping("")
    public ModelAndView list(@RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0),10);
        Page<Service> services =serviceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("services",services);
        return modelAndView;
    }

    @GetMapping("/create-service")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("service/create",
                "serviceDto",new ServiceDto());
        return modelAndView;
    }

    @PostMapping(value = "/create-service")
    public String createService(@ModelAttribute @Valid ServiceDto serviceDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new ServiceDto().validate(serviceDto,bindingResult);
        System.err.println(serviceDto.getServiceName());
        if (bindingResult.hasErrors()){
            return "service/create";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto,service);
        service.setFlag(true);
        this.serviceService.save(service);
        redirectAttributes.addFlashAttribute("msg","create successfully");
        return "redirect:/service";
    }

    @GetMapping(value = "/edit-service")
    public String showEdit(@RequestParam String id, Model model){
        Service service = this.serviceService.findById(id);
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service,serviceDto);
        model.addAttribute("serviceDto",serviceDto);
        return "service/edit";
    }

    @PostMapping(value = "/edit-service")
    public String editService(@ModelAttribute @Valid ServiceDto serviceDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        new ServiceDto().validate(serviceDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "service/edit";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto,service);
        service.setFlag(true);
        this.serviceService.save(service);
        redirectAttributes.addFlashAttribute("msg","edit successfully");
        return "redirect:/service";
    }

    @PostMapping("/delete-service")
    public String deleteEmployee(@RequestParam String id, RedirectAttributes redirectAttributes ){
        serviceService.remove(id);
        redirectAttributes.addFlashAttribute("msg","successful delete");
        return  "redirect:/service";
    }
}

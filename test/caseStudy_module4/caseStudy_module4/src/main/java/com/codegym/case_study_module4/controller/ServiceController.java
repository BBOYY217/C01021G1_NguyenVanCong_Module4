package com.codegym.case_study_module4.controller;

import com.codegym.case_study_module4.dto.ServiceDto;
import com.codegym.case_study_module4.model.Service1;
import com.codegym.case_study_module4.service.serviceService.IRentTypeService;
import com.codegym.case_study_module4.service.serviceService.IServiceService;
import com.codegym.case_study_module4.service.serviceService.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
public class ServiceController {

    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IRentTypeService rentTypeService;
    @Autowired
    private IServiceTypeService serviceTypeService;

    @GetMapping("/serviceList")
    public ModelAndView serviceList(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("service/listService");
        modelAndView.addObject("serviceList", serviceService.findAll(pageable));
        modelAndView.addObject("rentType", rentTypeService.findAll());
        modelAndView.addObject("serviceType", serviceTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/serviceCreate")
    public ModelAndView showCreateService() {
        ModelAndView modelAndView = new ModelAndView("service/createService");
        modelAndView.addObject("serviceDto", new ServiceDto());
        modelAndView.addObject("rentType", rentTypeService.findAll());
        modelAndView.addObject("serviceType", serviceTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/serviceCreate")
    public String createService(@Valid ServiceDto serviceDto, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        new ServiceDto().validate(serviceDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("rentType", rentTypeService.findAll());
            model.addAttribute("serviceType", serviceTypeService.findAll());
            return "/service/createService";
        }
        Service1 service1 = new Service1();
        BeanUtils.copyProperties(serviceDto, service1);
        serviceService.save(service1);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/serviceList";
    }

    @GetMapping("/serviceEdit/{id}")
    public ModelAndView showEditService(@PathVariable Integer id, Model model) {
        ModelAndView modelAndView = new ModelAndView("service/editService");
        model.addAttribute("rentType", rentTypeService.findAll());
        model.addAttribute("serviceType", serviceTypeService.findAll());
        Service1 service1 = serviceService.findById(id);
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service1, serviceDto);
        model.addAttribute("serviceDto", serviceDto);
        return modelAndView;
    }
    @PostMapping("/serviceEdit")
    public String editService(@Valid ServiceDto serviceDto, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        new ServiceDto().validate(serviceDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("rentType", rentTypeService.findAll());
            model.addAttribute("serviceType", serviceTypeService.findAll());
            return "/service/editService";
        }
        Service1 service1 = new Service1();
        BeanUtils.copyProperties(serviceDto, service1);
        serviceService.save(service1);
        redirectAttributes.addFlashAttribute("message", "edit successfully");
        return "redirect:/serviceList";
    }
    @GetMapping("/serviceDelete")
    public String deleteService(Service1 service1, RedirectAttributes redirectAttributes) {
        serviceService.remove(service1);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/serviceList";
    }
    @GetMapping("/searchService")
    public String searchService(@RequestParam(name = "search", required = false) String name,
                                @PageableDefault(value = 2) Pageable pageable, Model model) {
        model.addAttribute("serviceList", serviceService.search(name, pageable));
        return "/service/listService";
    }



}

package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.service.IClassRoomService;
import vn.codegym.service.ICourseService;
import vn.codegym.service.IStudentService;

import java.sql.Date;

@Controller
@RequestMapping({"/student", "/home"})
public class StudentController {

    @Qualifier("studentServiceImpl")
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassRoomService classRoomService;

    @Autowired
    private ICourseService courseService;


    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    public ModelAndView showStudentList(@PageableDefault(value = 10,
        sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ModelAndView("student",
                "studentList", studentService.findAll(pageable));
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {

        model.addAttribute("classRoomList", classRoomService.findAll());
        model.addAttribute("courseList", courseService.findAll());

        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes) {

        System.out.println(student);
        student.getAccount().setDateCreate(new Date(System.currentTimeMillis()));
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message",
                "Create student: " + student.getName() + " OK!");

        return "redirect:/student/list";
    }

    @GetMapping("/search")
    public ModelAndView searchStudent(@RequestParam("kq") String keyword) {
        return new ModelAndView("student",
                "studentList", studentService.searchByName(keyword));
    }
}

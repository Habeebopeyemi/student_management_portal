package com.example.student_management_portal.controllers;

import com.example.student_management_portal.entities.Student;
import com.example.student_management_portal.services.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentServiceImplementation studentService;

    public StudentController(StudentServiceImplementation studentService){
        this.studentService = studentService;
    }

    @RequestMapping(value = "/createStudent")
    public ModelAndView CreateStudent()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/portal/createStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/registerStudent")
    public ModelAndView RegisterStudent(@RequestParam(value = "student_name") String name,
                                        @RequestParam(value = "student_gender") String gender,
                                        @RequestParam(value = "student_email") String email,
                                        @RequestParam(value = "student_track") String track)
    {
        studentService.createNewStudent(name, gender, email, track);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.setViewName("/portal/registerStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/allStudents")
    public ModelAndView ListStudents() {
        ModelAndView modelAndView = new ModelAndView();

        List<Student> studentList = studentService.getAllStudents();

        modelAndView.setViewName("portal/list");
        modelAndView.addObject("students", studentList);
        return modelAndView;
    }

    @RequestMapping(value = "/editStudent/{id}", method = RequestMethod.GET)
    public ModelAndView EditStudent(@PathVariable(value = "id") long id)
    {
        Student student = studentService.getStudent(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal/editStudent");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Update successful");
        return modelAndView;
    }

    @RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.POST)
    public ModelAndView UpdateStudent(Student student, @PathVariable(value = "id") long id, RedirectAttributes redirectAttributes)
    {
        student.setId(id);
        studentService.updateStudent(student);

        redirectAttributes.addFlashAttribute("message", "Student updated successfully");

        return new ModelAndView("redirect:/student/allStudents");
    }

    @RequestMapping(value = "/confirmDelete/{id}", method = RequestMethod.GET)
    public ModelAndView ConfirmDeleteStudent(@PathVariable(value = "id") long id) {
        Student student = studentService.getStudent(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal/confirmDelete");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteConfirmed/{id}", method = RequestMethod.POST)
    public ModelAndView DeleteConfirmedStudent(@PathVariable(value = "id") long id, RedirectAttributes redirectAttributes) {
        studentService.deleteStudent(id);
        redirectAttributes.addFlashAttribute("message", "Student deleted successfully");
        return new ModelAndView("redirect:/student/allStudents");
    }

    @RequestMapping(value = "/viewStudent/{id}", method = RequestMethod.GET)
    public ModelAndView View(@PathVariable(value = "id") long id)
    {
        Student student = studentService.getStudent(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portal/viewStudent");
        modelAndView.addObject("student", student);
        return modelAndView;
    }
}

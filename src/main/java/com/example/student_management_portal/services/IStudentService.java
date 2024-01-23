package com.example.student_management_portal.services;

import com.example.student_management_portal.entities.Student;

import java.util.List;

public interface IStudentService {
    public void createNewStudent(String name, String gender, String email, String track);
    public List<Student> getAllStudents();
    public void updateStudent(Student student);
    public Student getStudent(long id);
    public void deleteStudent(long id);
}

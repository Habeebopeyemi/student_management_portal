package com.example.student_management_portal.services;

import com.example.student_management_portal.entities.Student;
import com.example.student_management_portal.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public void createNewStudent(String name, String gender, String email, String track) {
        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setGender(gender);
        newStudent.setEmail(email);
        newStudent.setTrack(track);
        studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(long id) {
        Optional<Student> optionals = studentRepository.findById(id);
        if (optionals.isPresent()) {
            return optionals.get();
        }
        return null;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }


}

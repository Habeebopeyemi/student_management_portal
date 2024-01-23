package com.example.student_management_portal.repositories;

import com.example.student_management_portal.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}

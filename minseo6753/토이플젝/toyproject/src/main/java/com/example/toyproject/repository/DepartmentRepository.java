package com.example.toyproject.repository;

import com.example.toyproject.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}

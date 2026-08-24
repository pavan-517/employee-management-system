package com.employe.employemanagement.repository;

import com.employe.employemanagement.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employe, Long> {

}
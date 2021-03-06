package com.FApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FApp.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}

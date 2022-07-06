package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.employee.entity.Emp;

@Repository
public interface EmployeeRepo extends JpaRepository <Emp, Long> {
	 

}

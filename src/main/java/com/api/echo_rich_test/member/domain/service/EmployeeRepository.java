package com.api.echo_rich_test.member.domain.service;

import com.api.echo_rich_test.member.domain.model.Department;
import com.api.echo_rich_test.member.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findById(long id);
    List<Employee> findByDepartment(Department department);
}

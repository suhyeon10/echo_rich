package com.api.echo_rich_test.member.domain.service;

import com.api.echo_rich_test.member.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

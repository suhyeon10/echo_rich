package com.api.echo_rich_test.member.domain.service;

import com.api.echo_rich_test.member.domain.model.Employee;
import com.api.echo_rich_test.member.domain.model.JobHistory;
import com.api.echo_rich_test.member.domain.model.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryReadRepository extends JpaRepository<JobHistory, JobHistoryId> {
    List<JobHistory> findByEmployee(Employee employee);
}

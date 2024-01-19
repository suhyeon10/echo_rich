package com.api.echo_rich_test.member.application;

import com.api.echo_rich_test.common.exception.BusinessException;
import com.api.echo_rich_test.common.exception.ErrorCode;
import com.api.echo_rich_test.member.domain.model.Employee;
import com.api.echo_rich_test.member.domain.model.JobHistory;
import com.api.echo_rich_test.member.domain.service.EmployeeRepository;
import com.api.echo_rich_test.member.domain.service.JobHistoryReadRepository;
import com.api.echo_rich_test.member.presentation.response.EmployeeHistoryReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeHistoryReadService {
    private final JobHistoryReadRepository jobHistoryReadRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeHistoryReadResponse readEmployeeJobHistory(long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()
                -> new BusinessException(ErrorCode.EMPLOYEE_NOT_FOUND));
        List<JobHistory> jobHistoryList = jobHistoryReadRepository.findByEmployee(employee);

        if (jobHistoryList == null) {
            jobHistoryList = Collections.emptyList();
        }
        return EmployeeHistoryReadResponse.makeResponse(jobHistoryList);
    }
}

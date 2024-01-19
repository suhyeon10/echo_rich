package com.api.echo_rich_test.member.application;

import com.api.echo_rich_test.common.exception.BusinessException;
import com.api.echo_rich_test.common.exception.ErrorCode;
import com.api.echo_rich_test.member.domain.model.Employee;
import com.api.echo_rich_test.member.domain.service.EmployeeRepository;
import com.api.echo_rich_test.member.presentation.response.EmployeeReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeReadService {

    private final EmployeeRepository employeeRepository;
    public EmployeeReadResponse readEmployee(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new BusinessException(ErrorCode.EMPLOYEE_NOT_FOUND));

        Employee manager = null;
        if (employee.getManagerId() != null) {
            manager = employeeRepository.findById(employee.getManagerId())
                    .orElseThrow(() -> new BusinessException(ErrorCode.EMPLOYEE_NOT_FOUND));
        }
        System.out.println(employee.getFirstName());
        EmployeeReadResponse response = EmployeeReadResponse.makeResponse(employee, manager);
        return response;
    }

}

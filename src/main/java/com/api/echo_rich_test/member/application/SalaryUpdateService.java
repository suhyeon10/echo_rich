package com.api.echo_rich_test.member.application;

import com.api.echo_rich_test.common.Response.ResponseService;
import com.api.echo_rich_test.common.exception.BusinessException;
import com.api.echo_rich_test.common.exception.ErrorCode;
import com.api.echo_rich_test.member.domain.model.Department;
import com.api.echo_rich_test.member.domain.model.Employee;
import com.api.echo_rich_test.member.domain.service.DepartmentRepository;
import com.api.echo_rich_test.member.domain.service.EmployeeRepository;
import com.api.echo_rich_test.member.presentation.response.EmployeeReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SalaryUpdateService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional
    public void increaseSalary(int departmentId, double percentage) {
        // 특정 부서의 사원들을 가져오기
        List<Employee> employees = getEmployeesByDepartment(departmentId);

        // 급여 인상 로직 적용
        for (Employee employee : employees) {
            BigDecimal currentSalary = employee.getSalary();
            BigDecimal increasedSalary = calculateIncreasedSalary(currentSalary, percentage);
            employee.updateSalary(increasedSalary);
            employeeRepository.save(employee);
        }
    }

    public List<Employee> getEmployeesByDepartment(long departmentId){
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new BusinessException(ErrorCode.DEPARTMENT_NOT_FOUND));
        List<Employee> employees = employeeRepository.findByDepartment(department);

        if (employees.isEmpty()) {
            throw new BusinessException(ErrorCode.NO_EMPLOYEES_IN_DEPARTMENT);
        }
        return employees;
    }

    private BigDecimal calculateIncreasedSalary(BigDecimal currentSalary, double percentage) {
        BigDecimal percentageMultiplier = BigDecimal.valueOf(1 + (percentage / 100));
        return currentSalary.multiply(percentageMultiplier);
    }
}

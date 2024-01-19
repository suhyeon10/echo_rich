package com.api.echo_rich_test.member.presentation.response;

import com.api.echo_rich_test.member.domain.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReadResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private String jobTitle;
    private String salary;
    private String commissionPct;
    private String managerName;
    private String departmentName;

    public static EmployeeReadResponse makeResponse(Employee employee, Employee manager) {
        return EmployeeReadResponse.builder()
                .firstName(getOrDefault(employee.getFirstName()))
                .lastName(getOrDefault(employee.getLastName()))
                .email(getOrDefault(employee.getEmail()))
                .phoneNumber(getOrDefault(employee.getPhoneNumber()))
                .hireDate(getOrDefault(employee.getHireDate()))
                .jobTitle(getOrDefault(employee.getJob() != null ? employee.getJob().getJobTitle() : null))
                .salary(getOrDefault(employee.getSalary()))
                .commissionPct(getOrDefault(employee.getCommissionPct()))
                .managerName(getOrDefault(Employee.getName(manager)))
                .departmentName(getOrDefault(employee.getDepartment() != null ? employee.getDepartment().getDepartmentName() : null))
                .build();
    }

    private static String getOrDefault(BigDecimal value) {
        return value != null ? value.toString() : "";
    }

    private static <T> T getOrDefault(T value) {
        return value != null ? value : (T)"";
    }



}

package com.api.echo_rich_test.member.presentation.response;

import com.api.echo_rich_test.member.domain.model.Department;
import com.api.echo_rich_test.member.domain.model.Employee;
import com.api.echo_rich_test.member.domain.model.Job;
import com.api.echo_rich_test.member.domain.model.JobHistory;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class EmployeeHistoryReadResponse {
    private List<JobHistoryResponse> jobHistoryResponseList;
    @Getter
    @Builder
    @AllArgsConstructor
    public static class JobHistoryResponse{
        private String employeeName;
        private LocalDate startDate;
        private LocalDate endDate;
        private String jobName;
        private String departmentName;
    }

    public static JobHistoryResponse makeJobHistoryResponse(JobHistory jobHistory) {
        return JobHistoryResponse.builder()
                .employeeName(getOrDefault(Employee.getName(jobHistory.getEmployee()), "Unknown"))
                .jobName(getOrDefault(jobHistory.getJob().getJobTitle(), "Unknown"))
                .startDate(jobHistory.getStartDate())
                .endDate(jobHistory.getEndDate())
                .departmentName(getOrDefault(jobHistory.getDepartment().getDepartmentName(), "Unknown"))
                .build();
    }

    private static <T> T getOrDefault(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    public static List<JobHistoryResponse> makeJobHistoryResponseList(List<JobHistory> jobHistories){
        return jobHistories.stream().map(jobHistory -> makeJobHistoryResponse(jobHistory)).collect(Collectors.toList());
    }

    public static EmployeeHistoryReadResponse makeResponse(List<JobHistory> jobHistories){
        return EmployeeHistoryReadResponse.builder()
                .jobHistoryResponseList(makeJobHistoryResponseList(jobHistories))
                .build();
    }


}

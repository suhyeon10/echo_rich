package com.api.echo_rich_test.member.presentation.request;

public record SalaryUpdateRequest(
        int departmentId, double percentage
) {
}

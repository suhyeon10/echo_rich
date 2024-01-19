package com.api.echo_rich_test.member.presentation;

import com.api.echo_rich_test.common.Response.CommonResult;
import com.api.echo_rich_test.common.controller.BaseController;
import com.api.echo_rich_test.member.application.SalaryUpdateService;
import com.api.echo_rich_test.member.presentation.request.SalaryUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/salaries")
@RestController
public class SalaryUpdateController extends BaseController {
    private final SalaryUpdateService salaryUpdateService;
    /**
    * 특정 부서의 직원들의 임금을 특정 비율만큼 인상하는 API
     * @Params departmentId 부서의 id
     * @Params percentage 임금 인상 비율
    * */
    @PostMapping("/update")
    public CommonResult read(@RequestBody SalaryUpdateRequest request) {
        salaryUpdateService.increaseSalary(
                request.departmentId(),
                request.percentage()
        );
        return success();
    }
}

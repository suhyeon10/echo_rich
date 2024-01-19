package com.api.echo_rich_test.member.presentation;

import com.api.echo_rich_test.common.Response.CommonResult;
import com.api.echo_rich_test.common.controller.BaseController;
import com.api.echo_rich_test.member.application.EmployeeReadService;
import com.api.echo_rich_test.member.presentation.response.EmployeeReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/employees")
@RestController
public class EmployeeReadController extends BaseController {
    private final EmployeeReadService employeeReadService;
    /**
     * 특정 사원의 현재 정보 조회 가능한 API
     * @Params employeeId 사원의 id
     * */
    @GetMapping("/read")
    public CommonResult read(@RequestParam int employeeId) {
        EmployeeReadResponse employee = employeeReadService.readEmployee(employeeId);
        return result(employee);
    }
}

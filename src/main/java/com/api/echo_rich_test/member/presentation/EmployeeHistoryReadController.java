package com.api.echo_rich_test.member.presentation;

import com.api.echo_rich_test.common.Response.CommonResult;
import com.api.echo_rich_test.common.controller.BaseController;
import com.api.echo_rich_test.member.application.EmployeeHistoryReadService;
import com.api.echo_rich_test.member.presentation.response.EmployeeHistoryReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/jobHistories")
@RestController
public class EmployeeHistoryReadController extends BaseController {
    private final EmployeeHistoryReadService employeeHistoryReadService;
    /**
     * 특정 사원의 이력 정보 조회 가능한 API
     * @Params employeeId 사원의 id
     * */
    @GetMapping("/read")
    public CommonResult read(@RequestParam int employeeId) {
        EmployeeHistoryReadResponse response = employeeHistoryReadService.readEmployeeJobHistory(employeeId);
        return result(response);
    }

}

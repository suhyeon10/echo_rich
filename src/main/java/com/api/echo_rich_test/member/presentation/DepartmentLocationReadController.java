package com.api.echo_rich_test.member.presentation;

import com.api.echo_rich_test.common.Response.CommonResult;
import com.api.echo_rich_test.common.controller.BaseController;
import com.api.echo_rich_test.member.application.DepartmentLocationReadService;
import com.api.echo_rich_test.member.presentation.response.DepartmentLocationReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/departments")
@RestController
public class DepartmentLocationReadController extends BaseController {
    private final DepartmentLocationReadService departmentLocationReadService;
    /**
    * 부서 및 위치 정보 조회 가능한 API
    * */
    @GetMapping("/read")
    public CommonResult read() {
        DepartmentLocationReadResponse response = departmentLocationReadService.readDepartment();
        return result(response);
    }
}

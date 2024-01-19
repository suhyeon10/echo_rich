package com.api.echo_rich_test.common.controller;
import com.api.echo_rich_test.common.Response.CommonResult;
import com.api.echo_rich_test.common.Response.ResponseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class BaseController {
    @Autowired
    private ResponseService responseService;

    public CommonResult success()
    {
        return responseService.getSuccessResult();
    }
    public CommonResult result(Object data)
    {
        return responseService.getSingleResult(data);
    }


}

package com.api.echo_rich_test.common.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {

    // @ApiModelProperty(value = "응답 성공여부 : true/false")
    private boolean success;

    // @ApiModelProperty(value = "응답 코드 번호 : 200 정상, 500 비정상")
    private int code;

    // @ApiModelProperty(value = "응답 메시지")
    private String msg;

}

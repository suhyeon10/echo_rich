package com.api.echo_rich_test.common.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResult<T> extends CommonResult {

    private List<T> list;

}
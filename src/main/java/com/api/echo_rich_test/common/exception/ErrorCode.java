package com.api.echo_rich_test.common.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    NOT_FOUND(HttpStatus.BAD_REQUEST.value(),"request형식 확인필요"),
    PERSON_DUPLICATE(HttpStatus.BAD_REQUEST.value(),"A person with the same name already exists"),
    EMPLOYEE_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),"존재하지 않는 사원입니다."),
    DEPARTMENT_NOT_FOUND(HttpStatus.BAD_REQUEST.value(),"존재하지 않는 부서입니다."),

    NO_EMPLOYEES_IN_DEPARTMENT(HttpStatus.BAD_REQUEST.value(), "해당 부서에는 사원이 존재하지 않습니다.");
    private final int status;
    private final String msg;

    ErrorCode(int status, String msg){
        this.status = status;
        this.msg = msg;
    }
    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.msg;
    }

}

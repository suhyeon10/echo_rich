package com.api.echo_rich_test.member.application;

import com.api.echo_rich_test.member.domain.model.Department;
import com.api.echo_rich_test.member.domain.service.DepartmentRepository;
import com.api.echo_rich_test.member.presentation.response.DepartmentLocationReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentLocationReadService {

    private final DepartmentRepository departmentRepository;

    public DepartmentLocationReadResponse readDepartment(){
        List<Department> departmentList = departmentRepository.findAll();
        if(departmentList.size() == 0) return null;
        return DepartmentLocationReadResponse.makeResponse(departmentList);
    }

}

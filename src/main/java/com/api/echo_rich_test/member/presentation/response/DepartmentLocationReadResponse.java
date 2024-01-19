package com.api.echo_rich_test.member.presentation.response;

import com.api.echo_rich_test.member.domain.model.Department;
import com.api.echo_rich_test.member.domain.model.Employee;
import com.api.echo_rich_test.member.domain.model.Location;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class DepartmentLocationReadResponse {

    private List<DepartmentReponse> departments;
    @Getter
    @Builder
    public static class DepartmentReponse{
        private String departmentName;
        private String managerName;
        private LocationResponse location;

    }

    @Getter
    @Builder
    public static class LocationResponse{
        private Long id;
        private String streetAddress;
        private String postalCode;
        private String city;
        private String stateProvince;
        private String country;
    }

    public static LocationResponse makeLocationResponse(Location location){
        if (location == null) {
            return LocationResponse.builder().build();
        }
        return LocationResponse.builder()
                .id(location.getId())
                .streetAddress(location.getStreetAddress())
                .postalCode(location.getPostalCode())
                .city(location.getCity())
                .stateProvince(location.getStateProvince())
                .country(location.getCountry())
                .build();
    }

    public static DepartmentReponse makeDepartmentResponse(Department department){
        if (department == null) {
            return DepartmentReponse.builder().build();
        }
        return DepartmentReponse.builder()
                .departmentName(department.getDepartmentName())
                .managerName(Employee.getName(department.getManager()))
                .location(makeLocationResponse(department.getLocation()))
                .build();
    }

    public static List<DepartmentReponse> makeDeparmentResponseList(List<Department> departments){
        return departments.stream().map(department -> makeDepartmentResponse(department)).collect(Collectors.toList());
    }

    public static DepartmentLocationReadResponse makeResponse(List<Department> departments){
        return DepartmentLocationReadResponse.builder()
                .departments(makeDeparmentResponseList(departments))
                .build();
    }
}

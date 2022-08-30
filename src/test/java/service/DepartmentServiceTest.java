package service;

import entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.dao.DepartmentDao;
import service.dto.DepartmentDto;
import service.mapper.DepartmentMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentDao departmentDao;

    @Mock
    private DepartmentMapper departmentMapper;

    List<Department> departmentList = new ArrayList<>();
    Department dep1 = new Department(1, "admin", LocalDate.of(2022, 8, 8));
    Department dep2 = new Department(2, "IT", LocalDate.of(2022, 4, 4));
    DepartmentDto departmentDto1 = new DepartmentDto(1, "Admin", LocalDate.of(2022, 8, 8));
    DepartmentDto departmentDto2 = new DepartmentDto(2, "IT", LocalDate.of(2022, 4, 4));

    @BeforeEach
    void setUp() {
        departmentList.add(dep1);
        departmentList.add(dep2);
    }


    @Test
    void testGetAll_shouldReturnData_whenUsed() {
        List<DepartmentDto> expectedDepartmentList = new ArrayList<>();
        expectedDepartmentList.add(departmentDto1);
        expectedDepartmentList.add(departmentDto2);

        when(departmentDao.findAll()).thenReturn(departmentList);
        when(departmentMapper.toDtos(departmentList)).thenReturn(expectedDepartmentList);

        List<DepartmentDto> actualDepartments = departmentService.getAll();

        assertEquals(expectedDepartmentList.size(), actualDepartments.size());
    }


}
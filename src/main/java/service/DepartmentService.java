package service;

import service.dao.DepartmentDao;
import service.dto.DepartmentDto;
import service.mapper.DepartmentMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DepartmentService {
    @Inject
    private DepartmentDao departmentDao;

    @Inject
    private DepartmentMapper departmentMapper;

    public List<DepartmentDto> getAll(){
        return departmentMapper.toDtos(departmentDao.findAll());
    }
}

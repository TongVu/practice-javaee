package service.dao;

import entity.Department;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public interface DepartmentDao {
    List<Department> findAll();
}

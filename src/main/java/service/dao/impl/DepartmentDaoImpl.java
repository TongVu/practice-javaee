package service.dao.impl;

import entity.Department;
import service.dao.DepartmentDao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DepartmentDaoImpl implements DepartmentDao {
    @PersistenceContext(name = "axonactive")
    EntityManager em;

    @Override
    public List<Department> findAll(){
        Query allDepartmentQuery = em.createQuery("SELECT d FROM Department d", Department.class);

        return allDepartmentQuery.getResultList();
    }
}

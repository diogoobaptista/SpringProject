package com.dmsb.employeesapi.service;

import com.dmsb.employeesapi.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EntityManager entityManager;

    public EmployeeServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Optional<Employee> getEmployee(long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        query.select(root).where(cb.equal(root.get("id"), id));

        return entityManager.createQuery(query).getResultStream().findFirst();
    }

    @Override
    @Transactional
    public void deleteEmployee(long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);
        Root<Employee> root = delete.from(Employee.class);

        delete.where(cb.equal(root.get("id"), id));
        entityManager.createQuery(delete).executeUpdate();
    }

    @Override
    @Transactional
    public Employee updateEmployee(long id, Employee employee) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Employee> update = cb.createCriteriaUpdate(Employee.class);
        Root<Employee> root = update.from(Employee.class);

        update.set("name", employee.getName());
        update.set("companyPosition", employee.getCompanyPosition());
        update.set("age", employee.getAge());
        update.set("companyYears", employee.getCompanyYears());
        update.set("salary", employee.getSalary());

        update.where(cb.equal(root.get("id"), id));

        int rowsUpdated = entityManager.createQuery(update).executeUpdate();

        return rowsUpdated > 0 ? entityManager.find(Employee.class, id) : null;
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        query.select(root).where(cb.like(root.get("name"), "%" + name + "%"));

        return entityManager.createQuery(query).getResultList();
    }
}

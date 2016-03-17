package com.mahe.poc.unittest.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.mahe.poc.unittest.entity.EmployeeEntity;

@Named
@Stateless
@Transactional
public class EmployeeBean implements Serializable {

    @PersistenceContext(unitName="test")
    private EntityManager entityManager;
    
    public void savePerson(final EmployeeEntity e) {
        entityManager.persist(e);
    }
    
    public EmployeeEntity getEmployee(final long id) {
        return entityManager.find(EmployeeEntity.class, id);
    }
}
package com.mahe.poc.unittest.ejb;


import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.mahe.poc.unittest.entity.EmployeeEntity;

@RunWith(Arquillian.class)
public class EmployeeBeanTest {
    
    @Inject
    private EmployeeBean testBean;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addPackage(EmployeeBean.class.getPackage())
            .addPackage(EmployeeEntity.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource("wildfly-ds.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Test
    public final void testGetPerson() throws Exception {
        testBean.savePerson(new EmployeeEntity("bob"));
        
        assertEquals("bob", testBean.getEmployee(1).getFirstName());
    }
}
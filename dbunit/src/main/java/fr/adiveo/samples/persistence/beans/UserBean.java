package fr.adiveo.samples.persistence.beans;

import fr.adiveo.samples.persistence.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserBean {

    @PersistenceContext(unitName = "test")
    private EntityManager entityManager;


    List<User> listAllUsers(){
        return entityManager.createNamedQuery("User.findAll").getResultList();

    }
}

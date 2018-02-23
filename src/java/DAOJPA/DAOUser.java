/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJPA;

import donnes.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovo
 */
public class DAOUser extends DAO<Utilisateur> {

   
    
    @Override
    public Utilisateur find(Utilisateur data) throws DAOException {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac = em.getTransaction();
         Utilisateur u=em.find(Utilisateur.class,data.getIdutilisateur());
         em.close();
         return u; 
    }

    @Override
    public void create(Utilisateur data) throws DAOException {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac = em.getTransaction();
         transac.begin();
         Utilisateur u=find(data);
          if(u==null)
           {
           em.persist(data);
           }
        transac.commit();
    }

    @Override
    public void update(Utilisateur data) throws DAOException {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac = em.getTransaction();
            }

    @Override
    public void delete(Utilisateur data) throws DAOException {
        
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac = em.getTransaction();
    }
    
}

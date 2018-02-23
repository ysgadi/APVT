/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJPA;

import donnes.Tweet;
import javax.persistence.*;

/**
 *
 * @author younes
 */
public class DAOTwitter extends DAO<Tweet>{

    @Override
    public Tweet find(Tweet data) throws DAOException {
       
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac = em.getTransaction();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Tweet data) throws DAOException {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
       EntityManager em = emf.createEntityManager();
       EntityTransaction transac = em.getTransaction();
       transac.begin();
       em.persist(data);
       transac.commit();
       
    }

    @Override
    public void update(Tweet data) throws DAOException {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
         EntityManager em = emf.createEntityManager();
         EntityTransaction transac = em.getTransaction();
         transac.begin();
           // Tweet t=em.find(Tweet.class,data.getIdtweet());
            //§§data.setOpinion();
          em.merge(data);
    
        
         transac.commit();
    }

    @Override
    public void delete(Tweet data) throws DAOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();
    }
    
}

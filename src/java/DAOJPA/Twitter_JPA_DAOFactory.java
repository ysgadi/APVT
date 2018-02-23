/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJPA;

import donnes.*;

/**
 *
 * @author younes
 */
public class Twitter_JPA_DAOFactory  extends TwitterDAOFactory{
  private DAOTwitter daotwitter = null; 
   private DAOUser daotuser = null; 
    @Override
    public DAO<Tweet> getDAOTwitter() throws DAOException {
     if (daotwitter == null) 
           daotwitter = new DAOTwitter();
	   return daotwitter;
    }
    @Override
    public DAO<Utilisateur> getDAOUser() throws DAOException {
     if (daotuser == null) 
           daotuser = new DAOUser();
	   return daotuser;
    }

   
    
}

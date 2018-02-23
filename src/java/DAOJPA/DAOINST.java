/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJPA;


import donnes.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author utilisateur
 */

public class DAOINST {
     
         TwitterDAOFactory factory = AbstractDAOFactory.getDAOFactory();

      
         public  DAO<Tweet> getdaotwitter()
         {
             try {
                 return factory.getDAOTwitter();
             } catch (DAOException ex) {
                 Logger.getLogger(DAOINST.class.getName()).log(Level.SEVERE, null, ex);
             }
             return null;
     
         }
         
         public  DAO<Utilisateur> getdaouser()
         {
             try {
                 return factory.getDAOUser();
             } catch (DAOException ex) {
                 Logger.getLogger(DAOINST.class.getName()).log(Level.SEVERE, null, ex);
             }
             return null;
     
         }
        
       
    
}

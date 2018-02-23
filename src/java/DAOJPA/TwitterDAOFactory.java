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
public abstract class TwitterDAOFactory {
     public abstract DAO<Tweet> getDAOTwitter() throws DAOException;  
     public abstract DAO<Utilisateur> getDAOUser() throws DAOException;  
}

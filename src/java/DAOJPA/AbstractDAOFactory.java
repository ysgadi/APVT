package DAOJPA;

/**
 * Factory renvoyant une factory de DAO en fonction du support de persistance choisi
 * @author Eric
 */
public class AbstractDAOFactory {

    public static TwitterDAOFactory getDAOFactory() {
      
              return new Twitter_JPA_DAOFactory();
        }
    }

        


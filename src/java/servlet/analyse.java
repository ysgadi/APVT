/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import Elixa.Elixa;
import static Elixa.Elixa.ELIXA;
import donnes.Tweet;
import donnes.searchOpinion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class analyse extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
       
       
      List<String> listOpinion = new ArrayList<String>();
        /********************génerer le fichier .tab******************************************/
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("//home//zerguine//Bureau//Elixa-master//a.tab")));    
     PrintWriter pWriter = new PrintWriter(writer);
      int i=0;
      
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
                            EntityManager em = emf.createEntityManager();
                            javax.persistence.Query querhTweet = em.createQuery("select t from Tweet t ");                        
                            List<Tweet> listTweet =querhTweet.getResultList();
                            int o=listTweet.size()-1;
                             while(o>=0)
                             {
                                   pWriter.println(i+1+"\t"+listTweet.get(o).getTweetnettoyer());
                                   o--;
                                   i++;
                            }
                            
                            
                 
                               
                             
                            
                                    
                            pWriter.close() ;
                         i=0;
                        
     /********************************************************************************/
     //Elixa.ELIXA("");
      String[] cmd = { "/bin/sh","-c","sh /home/zerguine/Bureau/Elixa-master/Commande.sh"};
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.getOutputStream().close();
            p.getInputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          
    }
}
    


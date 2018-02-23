/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import donnes.Savetweet;
import donnes.Tweet;
import donnes.searchOpinion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
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
public class sauvgarde  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String dmd = req.getParameter("req").trim();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");
            PrintWriter out = resp.getWriter();
             switch(dmd){
              case("sauvgarde"):
              {
                  resp.setContentType("text/plain");
                 
                 // resp.getWriter().write("c'est bon");
                 EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
                  EntityManager em = emf.createEntityManager();
                  javax.persistence.Query querhTweet = em.createQuery("select t from Tweet t order by t.idtweet"); 
                  javax.persistence.Query querhTweetsave = em.createQuery("select s from Savetweet s ");

                  List<Tweet> listTweet =querhTweet.getResultList();
                   List<Tweet> listTweetSave =querhTweetsave.getResultList();
                   int trouve=0;
                  if(listTweet.size()>=1)
                  {
                      for(Tweet t:listTweet)
                      {
                                
                                for(Tweet tt:listTweetSave)
                                {
                                    if(tt.equals(t))
                                    trouve=1;
                                }
                                if(trouve!=1)
                                {
                                Savetweet s=new Savetweet();
                                s.setIdtweet(t.getIdtweet());
                                s.setDatecreation(t.getDatecreation());
                                s.setTweetcomplet(t.getTweetcomplet());
                                s.setTweetnettoyer(t.getTweetnettoyer());
                                s.setRt(t.getRt());
                                s.setLocation(t.getLocation());
                                s.setCategorie(t.getCategorie());
                                s.setOpinion(t.getOpinion());
                                s.setIduser(t.getIduser().getIdutilisateur());
                                EntityTransaction transac = em.getTransaction();
                                transac.begin();
                                em.persist(s);
                                transac.commit();
                                }
                                else
                                trouve=0;
                      }
                  }
                  
               
                BufferedReader in1 = new BufferedReader(new FileReader("//home//zerguine//Bureau//Elixa-master//output_tagged.txt"));
    String line1;
    int cpt1=0;
   
     
        
     /****************************generer fichier .txt elixa************************************************/
           javax.persistence.Query querhTweet1 = em.createQuery("select t from Tweet t order by t.idtweet");                        
                  List<Tweet> listTweet1 =querhTweet1.getResultList();
      BufferedReader in = new BufferedReader(new FileReader("//home//zerguine//Bureau//Elixa-master//output_tagged.txt"));
			String line;
                        int cptt=0;
                        int numTwe=0;
			while ((line = in.readLine()) != null )
			{
                         cptt++;
                         if(cptt>=1)
                         {
                         String phrase=searchOpinion.searchOp(cptt);
                         if(phrase!=null)
                         {
                            StringTokenizer st = new StringTokenizer(phrase);
                               String textNotoyer="";
                                int cpt=0;
                                while (st.hasMoreTokens() && cpt==0) 
                                    {
                                      String es=st.nextToken();
                                      if(es.startsWith("neutral")|| es.startsWith("positive") || es.startsWith("negative"))
                                      {
                                           
                                          EntityTransaction transac = em.getTransaction();
                                           transac.begin();
                                          Tweet tt=listTweet1.get(numTwe);
                                           Tweet t=em.find(Tweet.class,tt.getIdtweet());
                                
                                             t.setOpinion(es);
                               
                                           em.persist(t);
                                            transac.commit();
                                           numTwe++;
                                          // System.out.println(t.getOpinion());
                                          //stocker dans la bd
                                         cpt=1;
                                      }     
                                   }
                         }//fin if
                         }
                         
                        }
			in.close(); 
   
                 
      
              }   
              break;
          
             }
    }
    
    
}

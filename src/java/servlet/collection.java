/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAOJPA.DAOException;
import DAOJPA.DAOINST;
import NettoyerTweet.NettoyerTwt;
import donnes.Tweet;
import donnes.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.Query.Unit;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import donnes.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovo
 */
public class collection extends HttpServlet{

    public boolean terminer=false;
    public int taille=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
            String dmd = req.getParameter("req").trim();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");
            PrintWriter out = resp.getWriter();
             switch(dmd){
              case("CollectionEnCours"):
              {
                  resp.setContentType("text/plain");
                  if(this.terminer==true)
                  {
                  if(this.taille<1)
                  resp.getWriter().write("tour2");
                  else
                  resp.getWriter().write("tour1");  
                  }
                 
                  }//fin if req
              break;
          
             }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     this.terminer=false;
     String MotRecherche=req.getParameter("recherche");
     String typeMot =req.getParameter("cat");
    // String Ville =req.getParameter("Ville");
     
     if("H".equals(typeMot))
     {
     MotRecherche="#"+MotRecherche;
     }
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
     EntityManager em = emf.createEntityManager();
     javax.persistence.Query querhTweet = em.createQuery("select t from Tweet t ");                        
     List<Tweet> listTweett =querhTweet.getResultList();
      EntityTransaction transac = em.getTransaction();
     if(listTweett.size()>=1)
     {
         for(Tweet t:listTweett)
         {
             transac.begin();
             em.remove(t);
             transac.commit();
         }
     }
         ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("oPjIdKvONS5ncxhChClnfeOFr");
        cb.setOAuthConsumerSecret("31DHSjcSMXRF4T5paZf56UfqkT9bWAMCM6Q4mK3ZJl1j8anrFy");
        cb.setOAuthAccessToken("832902810706571264-zX0c71mxeKMsgsFEcYfaVGkvRSV86ZZ");
        cb.setOAuthAccessTokenSecret("wtR9rkx35csWncakoSPr9Uxg8247rxtC23G33MHFJ0ufN");
                
               
                
          	Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		   List<Status> tweetList = new ArrayList<Status>();
               // ArrayList<Date> tweetListDate = new ArrayList<>();
		   
		try {
		
                        //
                        //
	               Query query = new Query(MotRecherche).lang("fr");
                                 QueryResult result;
                       
			do {
				//  System.out.println("Collection en cours " );
                            result = twitter.search(query);
                             //System.out.println("Collection en cours " );
				List<Status> tweetss = result.getTweets();
				for(Status t :tweetss)
				{
				//la collection se fait uniquement avec les tweets avec geolocation disponible
				//if(t.getUser().getLocation().indexOf(Ville)!=-1 || t.getUser().getLocation().indexOf(Ville.toLowerCase())!=-1 ||t.getUser().getLocation().indexOf(Ville.toUpperCase())!=-1)
                                   tweetList.add(t);   
				}
                                 
				//System.out.println("Collection en cours " );
			} while (tweetList.size()<80 && (query = result.nextQuery()) != null);
		     } catch (TwitterException te) {
			System.out.println("Failed to search tweets: " + te.getMessage());
		     }
     
   /******Supprimer les doublons************************/
            /* if(tweetList.size()>=1)
                 {
                    int k;
                     for(Status t:tweetList)
                    {
                      k=0;
                      Status tmp=t;
                      for(Status tt:tweetList)
                      {
                          if(tt==tmp)
                          {
                              k++;
                              if(k>1)
                                  tweetList.remove(tt);
                          }
                      }
                    }
                 }*/
 /******************************************************/    
                if(tweetList.size()>=1)
                 {
                        DAOINST dao=new DAOINST();
      
                for(Status t:tweetList)
                {
                 /*********************************************/
                    
                   Utilisateur u=new Utilisateur();
                   u.setIdutilisateur(Long.toString(t.getUser().getId()));
                   u.setProfileimgurl(t.getUser().getProfileImageURL());
                   u.setScreenname(t.getUser().getScreenName());
                   u.setFullname(t.getUser().getName());
                   u.setNbrfollowers(t.getUser().getFollowersCount());
                   u.setBio(t.getUser().getDescription());
                   u.setLocation(t.getUser().getLocation());
                   u.setCreatedat(t.getUser().getCreatedAt());
                            try {
                                dao.getdaouser().create(u);
                            } catch (DAOException ex) {
                                Logger.getLogger(collection.class.getName()).log(Level.SEVERE, null, ex);
                            }
                   
                   
                   Tweet tt=new Tweet();
                    //System.out.println("idTweet: "+t.getId()+" text: "+t.getText()+" date: "+t.getda);
                    tt.setIdtweet(Long.toString(t.getId()));
                    tt.setDatecreation(t.getCreatedAt());
                    tt.setTweetcomplet(t.getText());
                    NettoyerTwt TwtNe=new NettoyerTwt(t.getText());
                    tt.setTweetnettoyer(TwtNe.NettoyerTw());
                    if(t.isRetweet())
                        tt.setRt("OUI");
                    else
                    tt.setRt("NAN");
                    tt.setLocation(t.getUser().getLocation());
                    tt.setIduser(u);
                            try {
                                dao.getdaotwitter().create(tt);
                                /*******************************/
                            } catch (DAOException ex) {
                                Logger.getLogger(collection.class.getName()).log(Level.SEVERE, null, ex);
                            }

                }
              
                 }
     this.terminer=true;
     this.taille=tweetList.size();
     
     
    }
    
    
}

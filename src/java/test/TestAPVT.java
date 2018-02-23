/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import NettoyerTweet.NettoyerTwt;
import donnes.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.Query.Unit;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovo
 */
public class TestAPVT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
                 List<String> listOpinion = new ArrayList<String>();  
                 EntityManagerFactory emf = Persistence.createEntityManagerFactory("APVTPU");
                 EntityManager em = emf.createEntityManager();
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
                                //listOpinion.get(par)
                                             t.setOpinion("");
                               
                                           em.persist(t);
                                            transac.commit();
                                           numTwe++;
                                           System.out.println(t.getOpinion());
                                          //stocker dans la bd
                                         cpt=1;
                                      }     
                                   }
                         }//fin if
                         }
                         
                        }
			in.close();
                        System.out.println(listOpinion.size());
    }  

             
    
    
}



package NettoyerTweet;

import java.util.StringTokenizer;


public class NettoyerTwt {
    
    public String test;

    public NettoyerTwt(String test) {
        this.test = test;
    }
    public String NettoyerTw()
    {
       // String test="RT @bembelly: Ah! Face à la #Droitisation de #Macron, la responsable du comité #Enmarche claque la porte.. https://t.co/X2s1g7rsgM https://…";
         StringTokenizer st = new StringTokenizer(test);
         String textNotoyer="";
         //suprimer le @user , http et RT
        while (st.hasMoreTokens()) 
         {
           String es=st.nextToken();
	   if(!es.startsWith("http") &&!es.startsWith("RT") &&!es.startsWith("@")&&!es.startsWith("►►"))
           {
              textNotoyer+=es;
              textNotoyer+=" ";
           }     
	}
        String textNotoyerHashT="";
        StringTokenizer st1 = new StringTokenizer(textNotoyer);
        while (st1.hasMoreTokens()) 
         {
           String es=st1.nextToken();
	   if(es.startsWith("#"))
           {
              textNotoyerHashT+=es.substring(1);
              textNotoyerHashT+=" ";
           }
           else
           {
                textNotoyerHashT+=es;
                textNotoyerHashT+=" ";
           }   
         }

        return textNotoyerHashT;

    }
        
    
}

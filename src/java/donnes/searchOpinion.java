/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Lenovo
 */

public class searchOpinion {
    public String opinion;
    
    public static String searchOp(int index) throws FileNotFoundException, IOException
    {
         BufferedReader in = new BufferedReader(new FileReader("//home//zerguine//Bureau//Elixa-master//output_tagged.txt"));
			String line;
                        int j=0;
			while ((line = in.readLine()) != null)
			{
                            j++;
                           if(j>2)
                              {
                                       StringTokenizer st = new StringTokenizer(line);
                                       int num=Integer.parseInt(st.nextToken());
                                       if(index==num)
                                       {
                                       String Op=line;
                                       in.close();
                                       return Op;
                                       }
                              
                           }
			}   
        return null;
    }
    
}

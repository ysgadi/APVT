/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elixa;

/**
 *
 * @author zerguine
 */
public class Elixa {
    
    
      public static void ELIXA(String par)
      {
          String[] cmd = { "/bin/sh","-c", par };
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.getOutputStream().close();
            p.getInputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
    
    
}

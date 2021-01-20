/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geracao_binario;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class IdentifyVariables {
    
    public Object [] Variables;
    public ArrayList operations;
    
    public int[] whatIndexOfVariable(String littleSentence)
    {
       if(littleSentence.length() == 2) 
       {
           int[] var = new int[1];
           for(int i = 0; i < Variables.length; i++)
           {
               char temp = (char) Variables[i];
               if(littleSentence.charAt(1) == temp)
               {
                   var[0] = i;
               }
           }
           
           return var;
       }
       
       if(littleSentence.length() == 3)
       {
           int[] vars = new int[2];
           for(int i = 0; i < Variables.length; i++)
           {
               char temp = (char) Variables[i];
               
               if(littleSentence.charAt(0) == temp)
               {
                   
                   vars[0] = i;
                   
               }
               
               if(littleSentence.charAt(2) == temp)
               {
                   vars[1] = i;
               }
           }
           
           return vars;
           
       }
       
       return null;
    }
    
    public int[] whatIndexOfVariable2(String littleSentence)
    {
        int[] var = new int[littleSentence.length()-1];
        
       if(littleSentence.length() == 2) 
       {
           
           
            for(int i = 0; i < Variables.length; i++)
            {
                char temp = (char) Variables[i];
                if(littleSentence.charAt(1) == temp)
                {
                    var[0] = i;
                }
            }
            
            if(Character.isDigit(littleSentence.charAt(1)))
            {
                var[0] = - (Integer.parseInt(String.valueOf(littleSentence.charAt(1))) + 1);
            }
          
           
           
           return var;
       }
       
       if(littleSentence.length() == 3)
       {
           
           for(int i = 0; i < Variables.length; i++)
           {
               char temp = (char) Variables[i];
               
               if(littleSentence.charAt(0) == temp)
               {
                   
                   var[0] = i;
                   
               }
               
               if(littleSentence.charAt(2) == temp)
               {
                   var[1] = i;
               }
           }
           
           if(Character.isDigit(littleSentence.charAt(2)))
           {
               var[1] = - (Integer.parseInt(String.valueOf(littleSentence.charAt(2)))+1);
           }
           
           if(Character.isDigit(littleSentence.charAt(0)))
           {
               var[0] = - (Integer.parseInt(String.valueOf(littleSentence.charAt(0)))+1);
           }
           
           return var;
           
       }
       
       return null;
    }
    
    public String identifyOperations(String sentence)
    {
        if(sentence.contains("!"))
        {
            return "!";
        }
        else if(sentence.contains("&"))
        {
            return "&";
        }
        else if(sentence.contains("|"))
        {
            return "|";
        }
        
        return "";
    }
    
    public boolean hasDigitInSentence(String littleSentence)
    {
        for(int i = 0; i < littleSentence.length(); i++)
        {
            if(Character.isDigit(littleSentence.charAt(i)))
            {
                return true;
                
            }
        }
        
        return false;
    }
    
}

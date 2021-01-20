/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_De_Analise;

import java.util.ArrayList;

/**
 *
 * @author ht3000052
 */
public class PrecedenceAnalisys {
        private String AND = "&";
	private String OR  = "|";
	private String NOT = "!";
        private String Variables;
        public SyntaxAnalisys syntax;
        ArrayList operations   = new ArrayList();
        int indice             = 0;
        String finalSentence   = "";
        
        public String precedenceNOT()
        {
            String tempSentence    = syntax.sentence;
            String sentence        = "";
            
            for(int i = 0 ; i < tempSentence.length() - 1; i++)
            {
                if(NOT.equals(String.valueOf(tempSentence.charAt(i))))
                {                    
                    if(tempSentence.charAt(i+1) == '(')
                    {
                        
                    }else{
                        
                        sentence = tempSentence.substring(i, i+2);
                        tempSentence = tempSentence.replace(sentence, ""+indice+"");
                        operations.add(indice, sentence);
                        //System.out.println(sentence);
                       // System.out.println(tempSentence);
                        indice++;
                    }
                    
                }
            }
            
            
            
            //System.out.println(operations.toString());
            
            return tempSentence;
                        
        }
        
        public String precedenceAND()
        {
            String tempSentence    = this.precedenceNOT();
            String sentence        = "";
            for(int j = 0 ;j < syntax.numberOfAnds(); j++)
            {
                for(int i = 0 ; i < tempSentence.length() - 1; i++)
                {
                    if(AND.equals(String.valueOf(tempSentence.charAt(i))))
                    {                    
                        if(tempSentence.charAt(i+1) == '(')
                        {

                        }else{

                            sentence = tempSentence.substring(i-1, i+2);
                            tempSentence = tempSentence.replace(sentence, ""+indice+"");
                            operations.add(indice, sentence);
                            //System.out.println(sentence);
                            //System.out.println(tempSentence);
                            indice++;
                        }

                    }
                }
            }
            
                        
            //System.out.println(operations.toString());
            
            return tempSentence;
        }
        
        public String precedenceOR()
        {
            String tempSentence    = this.precedenceAND();
            String sentence        = "";
            
            for(int i = 0 ; i < tempSentence.length() - 1; i++)
            {
                if(OR.equals(String.valueOf(tempSentence.charAt(i))))
                {                    
                    if(tempSentence.charAt(i+1) == '(')
                    {
                        
                    }else{
                        
                        sentence = tempSentence.substring(i-1, i+2);
                        tempSentence = tempSentence.replace(sentence, ""+indice+"");
                        operations.add(indice, sentence);
                       // System.out.println(sentence + " OR");
                        //System.out.println(tempSentence + " OR");
                        indice++;
                    }
                    
                }
            }
                        
           System.out.println(operations.toString());
            
            return tempSentence;
        }
        
        public ArrayList Precedence()
        {
            String tempSentence = this.precedenceOR();
            if(syntax.numberOfVariables() > 2 || syntax.numberOfOperators() >= 2)
            {
                operations.add(indice, tempSentence);
            }
            
            return operations;
        }
        
        
}

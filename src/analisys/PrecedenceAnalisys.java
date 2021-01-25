/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisys;

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
        
        private String precedenceNOT()
        {
        	//operations = new ArrayList();
            String tempSentence    = syntax.sentence;
            String sentence        = "";
            
            for(int i = 0 ; i < tempSentence.length() - 1; i++)
            {
                if(NOT.equals(String.valueOf(tempSentence.charAt(i))))
                {        
                	sentence = tempSentence.substring(i, i+2);
                    tempSentence = tempSentence.replace(sentence, ""+indice+"");
                    operations.add(indice, sentence);
                    
                    indice++;                                      
                }
            }
                                               
            return tempSentence;
                        
        }
        
        private  String precedenceAND()
        {
            String tempSentence    = this.precedenceNOT();
            String sentence        = "";
            for(int j = 0 ;j < syntax.numberOfAnds(); j++)
            {
                for(int i = 0 ; i < tempSentence.length() - 1; i++)
                {
                    if(AND.equals(String.valueOf(tempSentence.charAt(i))))
                    {    
                    	sentence = tempSentence.substring(i-1, i+2);
                        tempSentence = tempSentence.replace(sentence, ""+indice+"");
                        operations.add(indice, sentence);
                        indice++;                        
                    }
                }
            }
            
                        
            //System.out.println(operations.toString());
            
            return tempSentence;
        }
        
        private String precedenceOR()
        {
            String tempSentence    = this.precedenceAND();
            String sentence        = "";
            
            for(int i = 0 ; i < tempSentence.length() - 1; i++)
            {
                if(OR.equals(String.valueOf(tempSentence.charAt(i))))
                {      
                	sentence = tempSentence.substring(i-1, i+2);
                    tempSentence = tempSentence.replace(sentence, ""+indice+"");
                    operations.add(indice, sentence); 
                    indice++;
                }
            }
                                               
            return tempSentence;
        }
        
        public ArrayList Precedence()
        {
        	if (this.operations.size() > 0) {
        		return this.getOperations();
        	} else {
	    		
        		String tempSentence = this.precedenceOR();
	            if(syntax.numberOfVariables() > 2 || syntax.numberOfOperators() >= 2)
	            {
	                operations.add(indice, tempSentence);
	            }
	            
	            return operations;
        		
        	}            
        }
        
        public void setSyntax(SyntaxAnalisys syntax) {
        	this.syntax = syntax;
        }
        
        public ArrayList getOperations() {
        	return this.operations;
        }
}

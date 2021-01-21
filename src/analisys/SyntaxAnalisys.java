/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ht3000052
 */
public class SyntaxAnalisys {
    public String sentence;
	private String AND = "&";
	private String OR  = "\\|";
	private String NOT = "!";
    private String Variables;
    
    public SyntaxAnalisys(String sentence)
    {
    	this.sentence = sentence;
    }
	
	
        
    public boolean checkUp()
    {
        if(this.hasNumber() == true)
        {
            JOptionPane.showMessageDialog(null,"A Entrada Contém números, para gerar a tabela retire os números","ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.hasRepeatLetter())
        {
            JOptionPane.showMessageDialog(null,"A Entrada possui letras repetidas. Ex: AA","ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!this.checkValidityOperatorsNOT())
        {
            JOptionPane.showMessageDialog(null,"Erro prÃ³ximo ao operador \"!\" ","ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!this.checkValidityOperatorsAND())
        {
            JOptionPane.showMessageDialog(null,"Erro prÃ³ximo ao operador \"&\" ","ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.hasLetterTogether())
        {
            JOptionPane.showMessageDialog(null,"Possui duas variaveis juntas ","ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
	public boolean hasNumber()
	{
		for(int i = 0; i < this.sentence.length(); i++ ){
			
			if(Character.isDigit(this.sentence.charAt(i)))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasRepeatLetter()
	{
		for(int i = 0; i < this.sentence.length() - 1; i++ ){
			
			if(this.sentence.charAt(i) == this.sentence.charAt(i+1))
			{
				return true;
			}
		}
		
		return false;
	}
        
        public boolean hasLetterTogether()
        {
            for(int i = 0; i < this.sentence.length() - 1; i++ ){
            	
            	char temp = this.sentence.charAt(i);	
                
            	if(Character.isAlphabetic(temp))
                {
                    temp = this.sentence.charAt(i+1);
                    
                    if(Character.isAlphabetic(temp))
                    {
                        return true;
                    }                        
                }
            }
		          System.out.println(this.sentence + "teste");
		return false;
            
        }
	
	
	public int numberOfVariables()
	{
            String tempSentence = this.sentence;
            int result 		= 0;
            ArrayList values 	= new ArrayList();
            tempSentence = tempSentence.replaceAll(NOT, "");
            tempSentence = tempSentence.replaceAll(OR, "");
            tempSentence = tempSentence.replaceAll(AND, "");							

            for(int i = 0; i < tempSentence.length(); i++ ){
                if(!values.contains(tempSentence.charAt(i)))
                {
                        values.add(tempSentence.charAt(i));
                }
            }				
            
            Variables = values.toString();
            return values.size();							
	}
        
        public Object[] getVariables()
        {
                        
            String tempSentence = this.sentence;            
            ArrayList values 	= new ArrayList();
            
            tempSentence        = tempSentence.replaceAll(NOT, "");
            tempSentence        = tempSentence.replaceAll(OR, "");
            tempSentence        = tempSentence.replaceAll(AND, "");							

            for(int i = 0; i < tempSentence.length(); i++ ){

                    if(!values.contains(tempSentence.charAt(i)))
                    {
                            values.add(tempSentence.charAt(i));
                    }
            }				
              

            return values.toArray(); 					
                        
        }
        
        
        public boolean checkValidityOperatorsAND()
        {
            for(int i = 0; i < this.sentence.length() - 1 ; i++ ){
                    
                    if(AND.equals(String.valueOf(this.sentence.charAt(i))))
                    {
                        
                        if(i == 0 || this.sentence.length() == 2 || this.sentence.endsWith(AND))
                        {
                            return false;
                        }                                                
                        
                        if(Character.isAlphabetic(this.sentence.charAt(i + 1)) == false && this.sentence.charAt(i+1) != '!' && this.sentence.charAt(i+1) != '(')
                        {
                            return false;
                        }
                        
                        
                        switch(this.sentence.charAt(i - 1))
                        {
                            case '!' :
                            case ' ' :
                            case '|' :
                            case '(' :
                            case '[' :
                            case '&' :
                                return false;
                        }
                        
                        switch(this.sentence.charAt(i + 1))
                        {                            
                            case ' ' :
                            case '|' :                                                        
                            case '&' :                            
                                return false;
                        }                                                                                                                        
                        
                    }                                        
            }
            
            return true;
        }
        
        public boolean checkValidityOperatorsNOT()
        {
            if(this.sentence.endsWith(NOT))
            {
                return false;
            }
            
            for(int i = 0; i < this.sentence.length() - 1 ; i++ ){
                    
                    if(NOT.equals(String.valueOf(this.sentence.charAt(i))))
                    {
                       
                        if(i > 0 && (this.sentence.charAt(i - 1) == '!' || Character.isAlphabetic(this.sentence.charAt(i - 1)) == true))
                        {                            
                            return false;
                        }
                                                                                                
                        
                        if(Character.isAlphabetic(this.sentence.charAt(i + 1)) == false && this.sentence.charAt(i + 1) != '(')
                        {
                            return false;
                        }
                        
                        switch(this.sentence.charAt(i + 1))
                        {                            
                            case ' ' :
                            case '|' :                                                        
                            case '&' :                            
                                return false;
                        }                                                                                                                        
                        
                    }                                        
            }
            
            return true;
        }
        
        
        
        public boolean hasEvenParentheses()
        {
            if(this.sentence.contains("(")&& this.sentence.contains(")"))
            {
                int numParIn  = 0;
                int numParOut = 0;
                
                for(int i = 0; i < this.sentence.length(); i++)
                {
                    if(this.sentence.charAt(i) == '(')
                    {
                        numParIn++;
                    }
                    
                    if(this.sentence.charAt(i) == ')')
                    {
                        numParOut++;
                    }
                }
                
                if((numParIn + numParOut) % 2 == 0)
                {
                    return true;
                }else{
                    return false;
                }
                
            }else{
                System.out.println("false");
                return false;
            }
        }
        
        public int numberOfOperators()
        {
            int numbers = 0;
             for(int i = 0; i < this.sentence.length(); i++ ){

                    if(AND.equals(String.valueOf(this.sentence.charAt(i))) || OR.equals(String.valueOf(this.sentence.charAt(i))) || NOT.equals(String.valueOf(this.sentence.charAt(i))))
                    {
                        numbers++;
                    }
             }			
             
             return numbers;
        }
        
        public int numberOfAnds()
        {
            
            int numberOfAnds    = 0;                        							

            for(int i = 0; i < this.sentence.length(); i++ ){

                    if(AND.equals(String.valueOf(this.sentence.charAt(i))))
                    {
                        numberOfAnds++;
                    }
            }				

            return numberOfAnds;							
            
        }
	
        public int numberOfOrs()
        {
            
            int numberOfOrs   = 0;                        							

            for(int i = 0; i < this.sentence.length(); i++ ){

                    if(OR.equals(String.valueOf(this.sentence.charAt(i))))
                    {
                        numberOfOrs++;
                    }
            }				

            return numberOfOrs;							
            
        }
		
}

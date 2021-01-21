/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryGenerator;

import java.util.Arrays;

import analisys.SyntaxAnalisys;

/**
 *
 * @author david
 */
public class BinaryGenerator {
    
    
    SyntaxAnalisys syntax;
    public int numberOfVariables;
    
    public String intToBin(int number)
    {        
        String num;
        
        num = Integer.toBinaryString(number);
        
        
        if(num.length() < numberOfVariables)
        {
            String temp = "";
            if(number == 1 || number == 0)
            {
                
                for(int i = 0; i < numberOfVariables - 1; i++)
                {
                    temp += "0";
                }
                
            }else{
                
                for(int i = num.length(); i <= numberOfVariables - 1; i++)
                {
                    temp += "0";
                }
            }
            
            
            num = temp + num;
        }      

        return num;
                
        
    }
    
    public Character[] RowBin(int number)
    {
        String numberBin = this.intToBin(number);
        Character row[]     = new Character[numberBin.length()];
        for(int i = 0 ; i < numberBin.length(); i++)
        {
            row[i] = numberBin.charAt(i);
        }
        
        return row;
        
    }
    
    public Character[][] TableBin()
    {
        int number      = (int) Math.pow(2,this.numberOfVariables);
        Character [][] table = new Character[this.numberOfVariables][number];  ;
        Character temp[];
        
        
        
        for(int j = this.numberOfVariables - 1; j >= 0 ; j--)
        {
            for(int i = 0; i < number; i++)
            {
                temp = RowBin(i);
                table[j][i] = temp[j];
            }
            
            
        }
                
        return table;
    }
}

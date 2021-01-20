/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geracao_binario;

/**
 *
 * @author ht3000052
 */
public class Functions {
    
        
    
    public String NOT(String i)
    {
        if(i.equals("0"))
        {
            return "1";
        }else if(i.equals("1")){
            return "0";
        }
        
        return "";
    }
    
     public char NOT(char i)
    {
        if(i == '0')
        {
            return '1';
        }else if(i == '1'){
            return '0';
        }
        
        return ' ';
    }
    
    public int NOT(int i)
    {
        if(i == 0)
        {
            return 1;
        }else if(i == 1){
            return 0;
        }
        
        return 0;
    }
    
    public int[] NOTTable(int[] parametroA)
    {
        int[] result  = new int[parametroA.length];
        
        for(int i = 0 ; i < parametroA.length; i++)
        {
            result[i] = this.NOT(parametroA[i]);
        }
        
        return result;
    }
    
    public Character[] NOTTableChar(Character[] parametroA)
    {
        Character[] result  = new Character[parametroA.length];
        
        for(int i = 0 ; i < parametroA.length; i++)
        {
            result[i] = (char) this.NOT(parametroA[i]);
        }
        
        return result;
    }
    
    public int AND(int a, int b)
    {
                
        int r =  a * b;
        
        return r;
        
    }
    
    public int AND(String parametroA, String parametroB)
    {
        int a = Integer.parseInt(parametroA);
        int b = Integer.parseInt(parametroB);
        
        int r =  a * b;
                
        
        return r;
        
    }
    
    public Character ANDChar(Character parametroA, Character parametroB)
    {
        
        if(parametroA == '0' && parametroB == '0')        
            return '0';
        else if(parametroA == '0' && parametroB == '1')        
            return '0';
        else if(parametroA == '1' && parametroB == '0')        
            return '0';
        else if(parametroA == '1' && parametroB == '1')        
            return '1';
        else
            return 'X';            
        
    }
    
    public int[] ANDTable(String[] parametroA, String[] parametroB)
    {
      
      int[] result = new int[parametroA.length];
      
      for(int i = 0; i < parametroA.length && i < parametroB.length; i++)
      {
          result[i] = this.AND(parametroA[i], parametroB[i]);
      }
      
      return result;
        
    }       
    
    public Character[] ANDTable(Character[] parametroA, Character[] parametroB)
    {
      
      Character[] result = new Character[parametroA.length];
      
      for(int i = 0; i < parametroA.length && i < parametroB.length; i++)
      {
          result[i] = this.ANDChar(parametroA[i], parametroB[i]);
      }
      
      return result;
        
    }  
    
    public int OR(String parametroA, String parametroB)
    {
        
        int a = Integer.parseInt(parametroA);
        int b = Integer.parseInt(parametroB);
        
        int r = a + b;
        
        if(r == 2)
            return r -1;
        
        return r;
    }
    
    public int OR(int parametroA, int parametroB)
    {
                
        int r = parametroA + parametroB;
        
        if(r == 2)
            return r - 1;
        
        return r;
    }
    
    public Character OR(Character parametroA, Character parametroB)
    {
                
        if(parametroA == '0' && parametroB == '0')
        {
            return '0';
        }else if(parametroA == '0' && parametroB == '1')
        {
            return '1';
        }else if(parametroA == '1' && parametroB == '0')
        {
            return '1';
        }else if(parametroA == '1' && parametroB == '1')
        {
            return '1';
        }else{
            return '0';
        }
    }
    
    public int[] ORTable(int[] parametroA, int[] parametroB)
    {
        int[] result = new int[parametroA.length];
        
        for(int i = 0; i < parametroA.length; i++)
        {
            result[i] = this.OR(parametroA[i], parametroB[i]);
        }
        
        return result;
    }
    
    public int[] ORTable(String[] parametroA, String[] parametroB)
    {
        int[] result = new int[parametroA.length];
        
        for(int i = 0; i < parametroA.length; i++)
        {
            result[i] = this.OR(parametroA[i], parametroB[i]);
        }
        
        return result;
    }
    
    public Character[] ORTableChar(Character[] parametroA, Character[] parametroB)
    {
        Character[] result = new Character[parametroA.length];
        
        for(int i = 0; i < parametroA.length; i++)
        {
            result[i] = this.OR(parametroA[i], parametroB[i]);
        }
        
        return result;
    }

    public int[] ANDTable(int[] parametroA, int[] parametroB) {
        
        int[] result = new int[parametroA.length];
      
        for(int i = 0; i < parametroA.length && i < parametroB.length; i++)
        {
            result[i] = this.AND(parametroA[i], parametroB[i]);
        }

        return result;
    }
    
}

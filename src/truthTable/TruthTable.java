package truthTable;

import java.util.ArrayList;
import java.util.Arrays;

import analisys.PrecedenceAnalisys;
import analisys.SyntaxAnalisys;
import binaryGenerator.BinaryGenerator;
import binaryGenerator.Functions;
import binaryGenerator.IdentifyVariables;


public class TruthTable {
	String sentence;
	SyntaxAnalisys syntaxAnalisys;
	PrecedenceAnalisys precedenceAnalisys;
	BinaryGenerator binaryGenerator;
	ArrayList columns;
	Character[][] tableBin;
	
	public TruthTable(String sentence) {
		this.sentence = sentence;
		this.syntaxAnalisys = new SyntaxAnalisys(sentence );
		this.precedenceAnalisys = new PrecedenceAnalisys();
		this.precedenceAnalisys.setSyntax(syntaxAnalisys);
		 
		columns = new ArrayList();
		
		binaryGenerator = new BinaryGenerator();
		binaryGenerator.setNumberOfVariables((int) this.syntaxAnalisys.numberOfVariables());
		tableBin = binaryGenerator.TableBin();			
	}
	
	public ArrayList<?> getOperations()
	{
		return precedenceAnalisys.Precedence();
	}
	
	public String getSentence()
	{
		return this.sentence;
	}
	
	public void getTable()
	{
		
	}
	
	public ArrayList<?> getColumns()
	{
		this.binaryGenerator.numberOfVariables = this.syntaxAnalisys.numberOfVariables();
        Object[] variables = syntaxAnalisys.getVariables();
                                                   
        for(int i = 0; i < this.syntaxAnalisys.numberOfVariables(); i++)
        {
        	columns.add(variables[i].toString());            
        }   
        
        processExpression();
        
        return columns;
	}
	
	private void processExpression()
	{
		Object[] variables = syntaxAnalisys.getVariables();
		int rows = (int) Math.pow(2, syntaxAnalisys.numberOfVariables());
		
		Character[] tempTable = new Character[rows];
        binaryGenerator.IdentifyVariables identify = new binaryGenerator.IdentifyVariables();
        identify.Variables = variables;
        binaryGenerator.Functions function = new binaryGenerator.Functions();
        
        ArrayList operations = this.getOperations();	    
        int indiceOperations = 0;
        ArrayList operationsMade = new ArrayList();
        Character[][] table = binaryGenerator.TableBin();  
	        
	        for(int i = 0 ; i < operations.size(); i++)
	        {
	            String tempCab = (String) operations.get(i);
	            String tempOperations = identify.identifyOperations(tempCab);
	            
	            if(identify.hasDigitInSentence(tempCab))
	            {               
	                int[] tempIndex = new int[2];
	                
	                switch(tempOperations){
	                    case "!":
	                        tempIndex = identify.whatIndexOfVariable2(tempCab);
	                        if(tempIndex[0] < 0)
	                        {
	                            int tempIndice = Math.abs(tempIndex[0]);
	                            tempTable = function.NOTTableChar((Character[]) operationsMade.get(tempIndice));
	                            
	                        }else{
	                            
	                            tempTable = function.NOTTableChar(table[tempIndex[0]]);
	                            
	                        }                                                                        
	                                                                          
	                        
	                        break;
	                        
	                    case "&":
	                        tempIndex = identify.whatIndexOfVariable2(tempCab);
	                        
	                        
	                        if(tempIndex[0] < 0 && tempIndex[1] < 0)
	                        {
	                            int tempIndice  = Math.abs(tempIndex[0]) - 1;
	                            int tempIndice2 = Math.abs(tempIndex[1]) - 1;
	                            //tempTable = function.ANDTable((Character[]) operationsMade.get(tempIndice),(Character[]) operationsMade.get(tempIndice2) );
	                            
	                        }else if(tempIndex[0] < 0){
	                            
	                            int tempIndice  = Math.abs(tempIndex[0]) - 1;                            
	                            //tempTable = function.ANDTable((Character[]) operationsMade.get(tempIndice), table[tempIndex[1]] );
	                        
	                        }else if(tempIndex[1] < 0){
	                            
	                            int tempIndice  = Math.abs(tempIndex[1]) - 1;                            
	                            //tempTable = function.ANDTable(table[tempIndex[0]],(Character[]) operationsMade.get(tempIndice));
	                            
	                        }else{
	                                                        
	                            //tempTable = function.ANDTable(table[tempIndex[0]], table[tempIndex[1]]);
	                            
	                        } 
	                                                                       
	                        break;
	                    case "|":                        
	                        tempIndex = identify.whatIndexOfVariable2(tempCab);
	                        
	                        
	                        if(tempIndex[0] < 0 && tempIndex[1] < 0)
	                        {
	                            int tempIndice  = Math.abs(tempIndex[0]) - 1;
	                            int tempIndice2 = Math.abs(tempIndex[1]) - 1;
	                            tempTable = function.ORTableChar((Character[]) operationsMade.get(tempIndice),(Character[]) operationsMade.get(tempIndice2) );
	                            
	                        }else if(tempIndex[0] < 0){
	                            
	                            int tempIndice  = Math.abs(tempIndex[0]) - 1;                            
	                            tempTable = function.ORTableChar((Character[]) operationsMade.get(tempIndice), table[tempIndex[1]] );
	                        
	                        }else if(tempIndex[1] < 0){
	                            
	                            int tempIndice  = Math.abs(tempIndex[1]) - 1;                            
	                            tempTable = function.ORTableChar(table[tempIndex[0]],(Character[]) operationsMade.get(tempIndice));
	                            
	                        }else{
	                                                        
	                            tempTable = function.ANDTable(table[tempIndex[0]], table[tempIndex[1]]);
	                            
	                        } 
	                         
	                        break;
	                        
	                }
	                
	                if(i == operations.size() - 1)
	                {
	                    columns.add("Resultado"); 
	                }else{
	                    columns.add(i + " - " + tempCab); 
	                }
	                    
	                
	            }else{
	                
	                
	                int[] tempIndex = new int[2];   
	                
	                switch(tempOperations){
	                    case "!":
	                        tempIndex = identify.whatIndexOfVariable(tempCab);
	                        tempTable = function.NOTTableChar(table[tempIndex[0]]);                                                
	                        
	                        columns.add(i + " - " + tempCab);                            
	                        
	                        break;
	                        
	                    case "&":
	                        tempIndex = identify.whatIndexOfVariable(tempCab);
	                        tempTable = function.ANDTable(table[tempIndex[0]], table[tempIndex[1]]);
	                        columns.add(i + " - " + tempCab);  
	                        break;
	                    case "|":                        
	                        tempIndex = identify.whatIndexOfVariable(tempCab);
	                        tempTable = function.ORTableChar(table[tempIndex[0]], table[tempIndex[1]]);
	                        columns.add(i + " - " + tempCab);  
	                        break;
	                        
	                }                                                               
	            }
	            
	            operationsMade.add(indiceOperations, tempTable);
	            indiceOperations++;	            
	        }
	}
	
	public int getNumberOfRows() {
		int rows = (int) Math.pow(2, syntaxAnalisys.numberOfVariables());
		return rows;
	}
	
	public int getNumberOfVariables() {
		return (int) this.syntaxAnalisys.numberOfVariables();
	}
	
	public int getNumberOfOperations() {
		return this.getOperations().size();
	}
	
	public char getTableValue(int row, int column) {		
	    return this.tableBin[column][row];		
	}
}

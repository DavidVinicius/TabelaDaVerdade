package truthTable;

import java.util.ArrayList;

import analisys.PrecedenceAnalisys;
import analisys.SyntaxAnalisys;
import binaryGenerator.BinaryGenerator;


public class TruthTable {
	String sentence;
	SyntaxAnalisys syntaxAnalisys;
	PrecedenceAnalisys precedenceAnalisys;
	BinaryGenerator binaryGenerator;
	
	public TruthTable(String sentence) {
		this.sentence = sentence;
		this.syntaxAnalisys = new SyntaxAnalisys(sentence );
		this.precedenceAnalisys = new PrecedenceAnalisys();
		this.precedenceAnalisys.setSyntax(syntaxAnalisys);
		
		binaryGenerator = new BinaryGenerator();
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
        Character[][] table = binaryGenerator.TableBin();                
        
        
        ArrayList columns = new ArrayList();
        
        for(int i = 0; i < this.syntaxAnalisys.numberOfVariables(); i++)
        {
        	columns.add(variables[i].toString());            
        }   
        
        return columns;
	}
}

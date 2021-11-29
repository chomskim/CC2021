package parser.s1;

import java.util.ArrayList;

class S1jSymTab
{
	private ArrayList<String> symbol;
	//-----------------------------------------
	public S1jSymTab()
	{
		symbol = new ArrayList<String>();
	}
	//-----------------------------------------
	public void enter(String s)
	{
		int index = symbol.indexOf(s);

		// if s is not in symbol, then add it
		if (index < 0)
			symbol.add(s);
	}
	//-----------------------------------------
	public String getSymbol(int i)
	{
		return symbol.get(i);
	}
	//-----------------------------------------
	public int getSize()
	{
		return symbol.size();
	}
}                                    // end of S1jSymTab
//======================================================

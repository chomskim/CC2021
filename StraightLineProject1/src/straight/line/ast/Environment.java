/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

import java.util.HashMap;

public class Environment {

	public HashMap<String, Double> identValueMap = null;
	
	public Environment(){
		identValueMap = new HashMap<String, Double>();
	}
}

/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

import java.util.HashMap;

public class Environment<T> {

	public HashMap<String, T> identValueMap = null;
	
	public Environment(){
		identValueMap = new HashMap<String, T>();
	}
	
	public void listEnv() {
		for (String k : identValueMap.keySet()) {
			System.out.println(k +" -- "+ identValueMap.get(k));
		}
	}
}

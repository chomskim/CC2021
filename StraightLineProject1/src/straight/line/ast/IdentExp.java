/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

public class IdentExp extends Exp {

	String ident;
	public IdentExp(String id) { 
		ident = id; 
	}
	@Override
	public double eval(Environment e) {
		return lookup(e, ident);
	}
	double lookup(Environment e, String id){
		return e.identValueMap.get(id);
	}

}

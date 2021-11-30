/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

public class NumberExp extends Exp {

	String numstr;
	public NumberExp(String num) { 
		numstr = num; 
	}
	@Override
	public double eval(Environment e) {
		return Double.parseDouble(numstr);
	}

}

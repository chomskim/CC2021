/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

public class PlusExp extends Exp {

	Exp e1,e2;
	public PlusExp(Exp a1, Exp a2) { e1=a1; e2=a2; }
	@Override
	public double eval(Environment e) {
		return e1.eval(e)+e2.eval(e);
	}

}

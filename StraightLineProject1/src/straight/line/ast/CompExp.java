/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

public class CompExp extends Exp {

	StatementList stmtList = null;
	Exp exp = null;
	public CompExp(StatementList slist, Exp exp){
		this.stmtList = slist;
		this.exp = exp;
	}
	@Override
	public double eval(Environment e) {
		stmtList.eval(e);
		return exp.eval(e);
	}
}

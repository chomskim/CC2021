/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

public class CompExp<T> extends Exp<T> {

	StatementList<T> stmtList = null;
	Exp<T> exp = null;
	public CompExp(StatementList<T> slist, Exp<T> exp){
		this.stmtList = slist;
		this.exp = exp;
	}
	@Override
	public T accept(Visitor<T> v) {
		return v.visit(this);
	}

}

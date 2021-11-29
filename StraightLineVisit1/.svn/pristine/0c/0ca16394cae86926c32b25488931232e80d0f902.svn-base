/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

public class PrintStatement<T> extends Statement<T> {

	PExpList<T> expList = null;
	public PrintStatement(PExpList<T> elist){
		expList = elist;
	}
	@Override
	public void accept(Visitor<T> v) {
		v.visit(this);
	}
}

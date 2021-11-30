/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

public class AssignStatement<T> extends Statement<T> {

	String id = null;
	Exp<T> exp = null;
	public AssignStatement(String id, Exp<T> e){
		this.id = id;
		this.exp = e;
	}
	@Override
	public void accept(Visitor<T> v) {
		v.visit(this);
	}
}

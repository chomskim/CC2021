/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

public class DivideExp<T> extends Exp<T> {

	Exp<T> e1,e2;
	public DivideExp(Exp<T> a1, Exp<T> a2) { e1=a1; e2=a2; }
	@Override
	public T accept(Visitor<T> v) {
		return v.visit(this);
	}
}

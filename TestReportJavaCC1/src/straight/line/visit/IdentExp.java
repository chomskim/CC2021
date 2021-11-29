/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

public class IdentExp<T> extends Exp<T> {

	String ident;
	public IdentExp(String id) { ident = id; }
	@Override
	public T accept(Visitor<T> v) {
		return v.visit(this);
	}
}

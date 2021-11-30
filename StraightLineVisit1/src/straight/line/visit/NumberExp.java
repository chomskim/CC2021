/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

public class NumberExp<T> extends Exp<T> {

	String numString;
	public NumberExp(String n0) { numString = n0; }
	@Override
	public T accept(Visitor<T> v) {
		return v.visit(this);
	}
}

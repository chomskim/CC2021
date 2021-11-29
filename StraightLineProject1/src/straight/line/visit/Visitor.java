/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

import java.util.ArrayList;

public interface Visitor<T> {
	public T visit(PlusExp<T> n);
	public T visit(MinusExp<T> n);
	public T visit(TimesExp<T> n);
	public T visit(DivideExp<T> n);
	public T visit(IdentExp<T> n);
	public T visit(NumberExp<T> n);
	public T visit(CompExp<T> n);
	public ArrayList<T> visit(PExpList<T> pl);
	public T visit(AssignStatement<T> s);
	public T visit(PrintStatement<T> s);
	public T visit(StatementList<T> sl);
	public T visit(Program<T> p);

}

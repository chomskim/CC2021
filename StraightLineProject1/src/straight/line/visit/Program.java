/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

public class Program<T> {

	StatementList<T> stmtList;
	
	public Program(StatementList<T> slist){
		stmtList = slist;
	}
	public void accept(Visitor<T> v) {
     	v.visit(this);
	}
	
}

/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

import java.util.ArrayList;

public class StatementList<T> extends Statement<T> {

	ArrayList<Statement<T>> statements = null;
	
	public StatementList(){
		statements = new ArrayList<Statement<T>>();
	}
	public void addStatement(Statement<T> stmt){
		statements.add(stmt);
	}
	@Override
	public void accept(Visitor<T> v) {
		v.visit(this);
		
	}
}

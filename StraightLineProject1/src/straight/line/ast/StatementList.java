/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

import java.util.ArrayList;
import java.util.List;

public class StatementList extends Statement {

	private List<Statement> statements = null;
	
	public StatementList(){
		statements = new ArrayList<Statement>();
	}
	public void addStatement(Statement stmt){
		statements.add(stmt);
	}
	@Override
	public void eval(Environment e) {
		for (Statement s:statements){
			s.eval(e);
		}
		
	}
}

/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

public class Program {

	private StatementList stmtList;
	
	public Program(StatementList sl){
		stmtList = sl;
	}
	public void eval(Environment e) {
		stmtList.eval(e);
	}
}

/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

public class AssignStatement extends Statement {

	String id = null;
	Exp exp = null;
	public AssignStatement(String id, Exp e){
		this.id = id;
		this.exp = e;
	}
	@Override
	public void eval(Environment e) {
		Double res = exp.eval(e);
		e.identValueMap.put(id, res);
	}
}

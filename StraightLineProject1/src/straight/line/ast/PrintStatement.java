/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

import java.util.ArrayList;

public class PrintStatement extends Statement {

	PExpList expList = null;
	public PrintStatement(PExpList elist){
		expList = elist;
	}
	@Override
	public void eval(Environment e) {
		ArrayList<Double> plist = expList.eval(e);
		for (Double d:plist){
			System.out.print(d+" ");
		}
		System.out.println();
	}
}

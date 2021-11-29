/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.ast;

import java.util.ArrayList;

public class PExpList {

	ArrayList<Exp> expList = null;
	public PExpList(){
		expList = new ArrayList<Exp>();
	}
	public void addExp(Exp exp){
		expList.add(exp);
	}
	public ArrayList<Double> eval(Environment e) {
		ArrayList<Double> result = new ArrayList<Double>();
		for (Exp exp:expList){
			result.add(new Double(exp.eval(e)));
		}
		return result;
	}

}

/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

import java.util.ArrayList;

public class PExpList<T> {

	ArrayList<Exp<T>> expList = null;
	public PExpList(){
		expList = new ArrayList<Exp<T>>();
	}
	public void addExp(Exp<T> exp){
		expList.add(exp);
	}
	public ArrayList<T> accept(Visitor<T> v) {
		return v.visit(this);
	}

}

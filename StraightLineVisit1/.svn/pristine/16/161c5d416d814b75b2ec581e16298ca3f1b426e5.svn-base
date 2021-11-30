/*
 *	StraightLine program Interpreter Using JacaCC
 *	Programmed By cskim, cse, hufs.ac.kr
 *	2012.11.26
 *	Copy Right -- Free for Educational Purpose
 */
package straight.line.visit;

import java.util.ArrayList;

public class VisitorInterpreter implements Visitor<Double> {

	private Environment<Double> env = null;
	
	public VisitorInterpreter(Environment<Double> e){
		this.env = e;
	}

	Double lookup(String id){
		return env.identValueMap.get(id);
	}
	
	@Override
	public Double visit(PlusExp<Double> n) {
		return n.e1.accept(this)+n.e2.accept(this);
	}
	@Override
	public Double visit(MinusExp<Double> n) {
		return n.e1.accept(this)-n.e2.accept(this);
	}
	@Override
	public Double visit(TimesExp<Double> n) {
		return n.e1.accept(this)*n.e2.accept(this);
	}
	@Override
	public Double visit(DivideExp<Double> n) {
		return n.e1.accept(this)/n.e2.accept(this);
	}
	@Override
	public Double visit(IdentExp<Double> n) {
		return lookup(n.ident);
	}
	@Override
	public Double visit(NumberExp<Double> n) {
		return Double.parseDouble(n.numString);
	}
	@Override
	public Double visit(CompExp<Double> n) {
		n.stmtList.accept(this);
		return n.exp.accept(this);

	}
	@Override
	public ArrayList<Double> visit(PExpList<Double> plist) {
		ArrayList<Double> result = new ArrayList<Double>();
		for (Exp<Double> exp:plist.expList){
			result.add(new Double(exp.accept(this)));
		}
		return result;
	}
	@Override
	public Double visit(AssignStatement<Double> s) {
		double res = (double)s.exp.accept(this);
		env.identValueMap.put(s.id, new Double(res));
		return null;
	}
	@Override
	public Double visit(PrintStatement<Double> s) {
		ArrayList<Double> plist = s.expList.accept(this);
		for (Double d:plist){
			System.out.print(d+" ");
		}
		System.out.println();
		return null;
	}
	@Override
	public Double visit(StatementList<Double> slist) {
		for (Statement<Double> s:slist.statements){
			s.accept(this);
		}
		return null;

	}
	@Override
	public Double visit(Program<Double> p){
		System.out.println("Visit Program");
		p.stmtList.accept(this);
		return null;

	}
}

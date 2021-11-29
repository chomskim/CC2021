package straight.line.visit;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VisitorJSONBuild implements Visitor<JSONAware> {
	
	private Environment<JSONAware> env = null;
	
	public VisitorJSONBuild(Environment<JSONAware> e){
		this.env = e;
	}

	@Override
	public JSONAware visit(PlusExp<JSONAware> n) {
		//PlusExp(Exp e1, Exp e2)
		JSONObject jtemp = new JSONObject();
		jtemp.put("exp1", visit(n.e1));
		jtemp.put("exp2", visit(n.e2));
		
		JSONObject jexp = new JSONObject();
		jexp.put("PlusExp", jtemp);

		return jexp;
	}

	@Override
	public JSONAware visit(MinusExp<JSONAware> n) {
		// TODO Auto-generated method stub
		//MinusExp(Exp e1, Exp e2)
		JSONObject jtemp = new JSONObject();
		jtemp.put("exp1", visit(n.e1));
		jtemp.put("exp2", visit(n.e2));
		
		JSONObject jexp = new JSONObject();
		jexp.put("MinusExp", jtemp);
		
		return jexp;
	}

	@Override
	public JSONAware visit(TimesExp<JSONAware> n) {
		// TODO Auto-generated method stub
		//TimesExp(Exp e1, Exp e2)
		JSONObject jtemp = new JSONObject();
		jtemp.put("exp1", visit(n.e1));
		jtemp.put("exp2", visit(n.e2));
		
		JSONObject jexp = new JSONObject();
		jexp.put("TimesExp", jtemp);
		
		return jexp;
	}

	@Override
	public JSONAware visit(DivideExp<JSONAware> n) {
		// TODO Auto-generated method stub
		//DivideExp(Exp e1, Exp e2)
		JSONObject jtemp = new JSONObject();
		jtemp.put("exp1", visit(n.e1));
		jtemp.put("exp2", visit(n.e2));
		
		JSONObject jexp = new JSONObject();
		jexp.put("DivideExp", jtemp);
		
		return jexp;
	}

	public JSONAware visit(Exp<JSONAware> n) {
		// visit by instance class
		if (n instanceof IdentExp) {
			return visit((IdentExp)n);
		}
		else if (n instanceof NumberExp) {
			return visit((NumberExp)n);
		}
		else if (n instanceof PlusExp) {
			return visit((PlusExp)n);
		}
		else if (n instanceof MinusExp) {
			return visit((MinusExp)n);
		}
		else if (n instanceof TimesExp) {
			return visit((TimesExp)n);
		}
		else if (n instanceof DivideExp) {
			return visit((DivideExp)n);
		}
		else if (n instanceof CompExp) {
			return visit((CompExp)n);
		}
			return null;
	}
	
	@Override
	public JSONAware visit(IdentExp<JSONAware> n) {
		// IdentExp(String id)
		JSONObject jexp = new JSONObject();
		jexp.put("IdentExp", n.ident);
		
		return jexp;
	}

	@Override
	public JSONAware visit(NumberExp<JSONAware> n) {		
		//NumberExp(String num)
		JSONObject jexp = new JSONObject();
		jexp.put("NumberExp", n.numString);
		
		return jexp;
	}	
	
	@Override
	public JSONAware visit(CompExp<JSONAware> n) {
		// TODO Auto-generated method stub
		//CompExp(StatementList slist, Exp exp)
		JSONObject jtemp = new JSONObject();
		jtemp.put("StatementList", visit((StatementList)n.stmtList));
		jtemp.put("Exp", visit((Exp)n.exp));
		JSONObject jexp = new JSONObject();
		jexp.put("CompExp", jtemp);
		
		return jexp;
	}

	@Override
	public ArrayList<JSONAware> visit(PExpList<JSONAware> pl) {
		// TODO Auto-generated method stub
		//PExpList(){Exp*}
		JSONArray jstmt = new JSONArray();
		for (Exp ex : pl.expList) {
			jstmt.add(visit(ex));
		}
		return jstmt;
	}

	@Override
	public JSONAware visit(AssignStatement<JSONAware> s) {
		//AssignStatement(String id, Exp exp)
		JSONObject jtemp = new JSONObject();
		jtemp.put("String", s.id);
		jtemp.put("Exp", visit((Exp)s.exp));
		JSONObject jexp = new JSONObject();
		jexp.put("AssignmentStatement", jtemp);
		return jexp;
	}

	@Override
	public JSONAware visit(PrintStatement<JSONAware> s) {
		// TODO Auto-generated method stub
		//PrintStatement(PExpList elist)
		JSONObject jtemp = new JSONObject();
		jtemp.put("ExpList", visit((PExpList)s.expList));
		JSONObject jexp = new JSONObject();
		jexp.put("PrintStatement", jtemp);
		return jexp;
	}

	public JSONAware visit(Statement<JSONAware> s) {
		if (s instanceof AssignStatement) {
			return visit((AssignStatement)s);
		}
		else if (s instanceof PrintStatement) {
			return visit((PrintStatement)s);
		}
		else
			return null;
	}
	@Override
	public JSONAware visit(StatementList<JSONAware> sl) {
		//StatementList(Statement*)
		JSONArray jstmt = new JSONArray();
		for (Statement st : sl.statements) {
			jstmt.add(visit(st));
		}
		return jstmt;
	}

	@Override
	public JSONAware visit(Program<JSONAware> p) {
		// Program(StatementList statement*)
		JSONObject jprog = new JSONObject();
		jprog.put("Program", visit(p.stmtList));
		// System.out.println(jprog.toJSONString());
		
		// Pretty Printing으로 보기 편하게 출력
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(jprog));
		return jprog;
	}

}

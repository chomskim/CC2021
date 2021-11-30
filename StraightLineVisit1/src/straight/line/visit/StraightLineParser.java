/* Generated By:JavaCC: Do not edit this line. StraightLineParser.java */
package straight.line.visit;

import java.io.FileInputStream;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;


public class StraightLineParser implements StraightLineParserConstants {

        static Visitor visitor = null;
        static Program prog = null;

        public static void main(String[] args) throws IOException
        {
        StraightLineParser slParser =
                new StraightLineParser(new FileInputStream("test.txt"));

        try {
                prog = slParser.program();
                System.out.println("Parsing successfully Ends.");
                Environment env = new Environment<Double>();
                visitor = new VisitorJSONBuild(env);
                //visitor = new VisitorInterpreter(env);
                prog.accept(visitor);
                env.listEnv();
                System.out.println("Visitor Interpreter Successfully Ends.");
        }
        catch(ParseException e){
                System.out.println("***Encountered errors during parse.");
                e.printStackTrace();
        }
        }

  final public Program program() throws ParseException {
        StatementList stmtList;
    stmtList = statements();
    jj_consume_token(0);
                //System.out.println("Parse END");
                {if (true) return new Program(stmtList);}
    throw new Error("Missing return statement in function");
  }

  final public StatementList statements() throws ParseException {
        StatementList stmtList = new StatementList();
        Statement st1, st2, st3;
    st1 = statement();
                         stmtList.addStatement(st1);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PRINT:
      case IDENT:
      case SEMI:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PRINT:
      case IDENT:
        st2 = statement();
                          stmtList.addStatement(st2);
        break;
      case SEMI:
        jj_consume_token(SEMI);
        st3 = statement();
                               stmtList.addStatement(st3);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
          {if (true) return stmtList;}
    throw new Error("Missing return statement in function");
  }

  final public Statement statement() throws ParseException {
  Exp exp;
  Token id;
  PExpList elist = new PExpList();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
      id = jj_consume_token(IDENT);
      jj_consume_token(ASSIGN);
      exp = expression();
    {if (true) return new AssignStatement(id.image, exp);}
      break;
    case PRINT:
      jj_consume_token(PRINT);
      jj_consume_token(LPAREN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENT:
      case NUMBER:
      case LPAREN:
        elist = expressions();
        break;
      default:
        jj_la1[2] = jj_gen;
        ;
      }
      jj_consume_token(RPAREN);
        {if (true) return new PrintStatement(elist);}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public PExpList expressions() throws ParseException {
  Exp exp1;
  Exp exp2;
  PExpList elist = new PExpList();
    exp1 = expression();
                         elist.addExp(exp1);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      jj_consume_token(COMMA);
      exp2 = expression();
                             elist.addExp(exp2);
    }
    {if (true) return elist;}
    throw new Error("Missing return statement in function");
  }

  final public StatementList statements1() throws ParseException {
        StatementList stmtList = new StatementList();
        Statement st1;
        Statement st2;
    st1 = statement();
                    stmtList.addStatement(st1);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMI:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      jj_consume_token(SEMI);
      st2 = statement();
                         stmtList.addStatement(st2);
    }
    {if (true) return stmtList;}
    throw new Error("Missing return statement in function");
  }

  final public Exp expression() throws ParseException {
  StatementList slist;
  Exp temp;
  Exp t1;
    if (jj_2_1(3)) {
      jj_consume_token(LPAREN);
      slist = statements1();
      jj_consume_token(COMMA);
      temp = expression();
      jj_consume_token(RPAREN);
    {if (true) return new CompExp(slist, temp);}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENT:
      case NUMBER:
      case LPAREN:
        temp = term();
        label_4:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS:
          case MINUS:
            ;
            break;
          default:
            jj_la1[6] = jj_gen;
            break label_4;
          }
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS:
            jj_consume_token(PLUS);
            t1 = term();
            temp = new PlusExp(temp, t1);
            break;
          case MINUS:
            jj_consume_token(MINUS);
            t1 = term();
            temp = new MinusExp(temp, t1);
            break;
          default:
            jj_la1[7] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
    {if (true) return temp;}
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Exp term() throws ParseException {
  Exp temp;
  Exp t1;
    temp = factor();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TIMES:
      case DIVIDE:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TIMES:
        jj_consume_token(TIMES);
        t1 = factor();
        temp = new TimesExp(temp, t1);
        break;
      case DIVIDE:
        jj_consume_token(DIVIDE);
        t1 = factor();
        temp = new DivideExp(temp, t1);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return temp;}
    throw new Error("Missing return statement in function");
  }

  final public Exp factor() throws ParseException {
  Token tok;
  Exp temp;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
      tok = jj_consume_token(IDENT);
    {if (true) return new IdentExp(tok.image);}
      break;
    case NUMBER:
      tok = jj_consume_token(NUMBER);
    {if (true) return new NumberExp(tok.image);}
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      temp = expression();
      jj_consume_token(RPAREN);
    {if (true) return temp;}
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_9() {
    if (jj_scan_token(PRINT)) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_6() {
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3R_8() {
    if (jj_scan_token(IDENT)) return true;
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_7() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_8()) {
    jj_scanpos = xsp;
    if (jj_3R_9()) return true;
    }
    return false;
  }

  /** Generated Token Manager. */
  public StraightLineParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x8060,0x8060,0x10c0,0x60,0x4000,0x8000,0x30000,0x30000,0x10c0,0xc0000,0xc0000,0x10c0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public StraightLineParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public StraightLineParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new StraightLineParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public StraightLineParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new StraightLineParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public StraightLineParser(StraightLineParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(StraightLineParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[21];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 21; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
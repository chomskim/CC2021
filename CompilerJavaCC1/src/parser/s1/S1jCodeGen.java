package parser.s1;

import java.io.PrintWriter;

class S1jCodeGen
{
  private PrintWriter outFile;
  private S1jSymTab st;
  //-----------------------------------------
  public S1jCodeGen(PrintWriter outFile, S1jSymTab st)
  {
    this.outFile = outFile;
    this.st = st;
  }
  //-----------------------------------------
  public void emitInstruction(String op)
  {
    outFile.printf("          %-4s%n", op); 
  }
  //-----------------------------------------
  public void emitInstruction(String op, String opnd)
  {
    outFile.printf(
                  "          %-4s      %s%n", op, opnd); 
  }
  //-----------------------------------------
  public void emitdw(String label, String value)
  {
    outFile.printf(
             "%-9s dw        %s%n", label + ":", value);
  }
  //-----------------------------------------
  public void endCode()
  {
    outFile.println();
    emitInstruction("halt");

    int size = st.getSize();
    // emit dw for each symbol in the symbol table
    for (int i=0; i < size; i++) 
      emitdw(st.getSymbol(i), "0");
  }
}                             // end of S1jCodeGen class

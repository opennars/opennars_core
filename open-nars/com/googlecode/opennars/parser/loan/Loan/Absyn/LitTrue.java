package com.googlecode.opennars.parser.loan.Loan.Absyn; // Java Package generated by the BNF Converter.

public class LitTrue extends Literal {

  public LitTrue() { }

  public <R,A> R accept(com.googlecode.opennars.parser.loan.Loan.Absyn.Literal.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.googlecode.opennars.parser.loan.Loan.Absyn.LitTrue) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}


package nars.language;

import java.util.*;
import nars.io.Symbols;
import nars.entity.TermLink;
import nars.main.Memory;

/**
 * A Statement about an Equivalence relation.
 */
public class Equivalence extends Statement {
    
    /**
     * constructor with partial values, called by make
     * @param n The name of the term
     * @param arg The component list of the term
     */
    protected Equivalence(String n, ArrayList<Term> arg) {
        super(n, arg);
    }

    /**
     * constructor with full values, called by clone
     * @param cs component list
     * @param open open variable list
     * @param closed closed variable list
     * @param i syntactic complexity of the compound
     * @param n The name of the term
     */
    protected Equivalence(String n, ArrayList<Term> cs, ArrayList<Variable> open, ArrayList<Variable> closed, short i) {
        super(n, cs, open, closed, i);
    }
    
    /**
     * override the cloning methed in Object
     * @return A new object, to be casted into a Similarity
     */
    public Object clone() {
        return new Equivalence(name, (ArrayList<Term>) cloneList(components),
                (ArrayList<Variable>) cloneList(openVariables), (ArrayList<Variable>) cloneList(closedVariables), complexity);
    }
     
    /**
     * Try to make a new compound from two components. Called by the inference rules.
     * @param subject The first compoment
     * @param predicate The second compoment
     * @return A compound generated or null
     */
    public static Equivalence make(Term subject, Term predicate) {
        if (invalidStatement(subject, predicate))
            return null;
        if (subject.compareTo(predicate) > 0)
            return make(predicate, subject);
        String name = makeStatementName(subject, Symbols.EQUIVALENCE_RELATION, predicate);
        Term t = Memory.nameToListedTerm(name);
        if (t != null)
            return (Equivalence) t;
        ArrayList<Term> argument = argumentsToList(subject, predicate);
        return new Equivalence(name, argument);
    }
    
    /**
     * get the operator of the term.
     * @return the operator of the term
     */
    public String operator() {
        return Symbols.EQUIVALENCE_RELATION;
    }
    
    /**
     * Check if the compound is communitative.
     * @return true for communitative
     */
    public boolean isCommutative() {
        return true;
    }
}

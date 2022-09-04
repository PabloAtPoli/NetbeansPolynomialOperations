package operation;

public class Term implements Comparable<Term> {

    private double coefficient;
    private int exponent;

    public Term(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        String term = "";

        term = Double.toString(Math.abs(coefficient));

        if (exponent == 0) {
            term += exponent;
        } else {
            if (exponent == 1) {
                term += "X";
            } else {
                term += "X^" + exponent;
            }
        }

        return term;
    }

    // Implements compareTo method so that sort method of Collections can be used
    @Override
    public int compareTo(Term term) {
        if (getExponent() == term.getExponent()) {
            return 0;
        } else {
            if (getExponent() > term.getExponent()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}

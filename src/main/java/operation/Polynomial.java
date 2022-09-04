package operation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {

    private List<Term> listTerm = new LinkedList<>();

    public Polynomial() {
        listTerm = new LinkedList<>();
    }

    public Polynomial(List<Term> listTerm) {
        this.listTerm = listTerm;
    }

    public void addTerm(Term term) {
        listTerm.add(term);
    }

    public void symplify() {
        List<Term> listSimplified = new LinkedList<>();;

        for (int i = 0; i < listTerm.size(); i++) {
            Term term1 = listTerm.get(i);
            double coefficient = term1.getCoefficient();
            int exponent = term1.getExponent();

            int j = i + 1;
            while (j < listTerm.size()) {

                Term term2 = listTerm.get(j);

                if (term1.getExponent() == term2.getExponent()) {
                    coefficient += term2.getCoefficient();
                    listTerm.remove(j);
                } else {
                    j++;
                }
            }

            listSimplified.add(new Term(coefficient, exponent));
        }

        // It sorts the polynomial by exponent in descending order
        Collections.sort(listSimplified);

        // It overwrites the initial list of terms
        listTerm = listSimplified;
    }

    @Override
    public String toString() {
        String polynomial = "";
        boolean isFirstTerm = true;

        for (Term term : listTerm) {
            if (term.getCoefficient() != 0) {
                // It does not show the coefficient if it is zero

                if (isFirstTerm) {
                    isFirstTerm = false;
                    if (term.getCoefficient() < 0) {
                        polynomial += "-";
                    }
                } else {
                    if (term.getCoefficient() < 0) {
                        polynomial += "-";
                    } else {
                        polynomial += "+";
                    }
                }
                polynomial += term.toString();
            }

        }
        return polynomial;
    }

    public List<Term> getListTerm() {
        return listTerm;
    }

    public Polynomial add(Polynomial poly) {

        Polynomial polyResult = new Polynomial(listTerm);

        List<Term> listTerm = poly.getListTerm();

        for (Term term : listTerm) {
            polyResult.addTerm(term);
        }

        polyResult.symplify();

        return polyResult;
    }

    public Polynomial subtract(Polynomial poly) {

        Polynomial polyResult = new Polynomial(listTerm);

        List<Term> listTerm = poly.getListTerm();

        for (Term term : listTerm) {
            // Change coefficient sign
            Term term2 = new Term(term.getCoefficient()*-1,term.getExponent());
            polyResult.addTerm(term2);
        }

        polyResult.symplify();

        return polyResult;
    }
    
        public Polynomial multiply(Polynomial poly) {

        Polynomial polyResult = new Polynomial();

        List<Term> listTerm1 = poly.getListTerm();

        for (Term term1 : listTerm1) {
            List<Term> listTerm2 = getListTerm();
            
             for (Term term2 : listTerm2) {
                 Term term = new Term(term1.getCoefficient()*term2.getCoefficient(), term1.getExponent()+term2.getExponent());
                 polyResult.addTerm(term);
             }
          
        }

        polyResult.symplify();

        return polyResult;
    }
}

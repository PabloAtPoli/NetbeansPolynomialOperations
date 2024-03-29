package operation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {

    private List<Term> listTerm;
    private Polynomial polyDividendRemainder;
    private Polynomial polyDivisor;

    public void setPolyDividendRemainder(Polynomial polyDividendRemainder) {
        this.polyDividendRemainder = polyDividendRemainder;
    }

    public void setPolyDivisor(Polynomial polyDivisor) {
        this.polyDivisor = polyDivisor;
    }

    public void setListTerm(List<Term> listTerm) {
        this.listTerm = listTerm;

    }

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

        // It eliminates terms with zero coefficients
        int i = 0;
        while (i < listSimplified.size()) {
            if (listSimplified.get(i).getCoefficient() == 0) {
                listSimplified.remove(i);
            } else {
                i++;
            }
        }

        // It overwrites the initial list of terms
        listTerm = listSimplified;
    }

    @Override
    public String toString() {
        String strPolynomial = "";
        boolean isFirstTerm = true;

        // It sorts the Polynomial by exponent in descending order
        Collections.sort(listTerm);

        for (Term term : listTerm) {
            if (isFirstTerm) {
                isFirstTerm = false;
                if (term.getCoefficient() < 0) {
                    strPolynomial += "-";
                }
            } else {
                if (term.getCoefficient() < 0) {
                    strPolynomial += "-";
                } else {
                    strPolynomial += "+";
                }
            }
            strPolynomial += term.toString();
        }

        // This code is used when division is performed
        if (polyDividendRemainder != null) {
            // The strPolynomial division has a remainder
            if (polyDivisor.getListTerm().size()>1){
                 strPolynomial += " + (" + polyDividendRemainder.toString() + ") / " + "("+ polyDivisor.toString()+")";
            }else{
                 strPolynomial += " + (" + polyDividendRemainder.toString() + ") / " + polyDivisor.toString();
            } 
        }

        return strPolynomial;
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

        // It adds the negative terms of Polynomial parameter method 
        for (Term term : listTerm) {
            // Change coefficient sign
            Term term2 = new Term(term.getCoefficient() * -1, term.getExponent());
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
                Term term = new Term(term1.getCoefficient() * term2.getCoefficient(), term1.getExponent() + term2.getExponent());
                polyResult.addTerm(term);
            }

        }

        polyResult.symplify();

        return polyResult;
    }

    public Polynomial divide(Polynomial polyDivisor) {

        Polynomial polyQuotient = new Polynomial();

        //   List<Term> listTermDividend = getListTerm();
        Polynomial poliDividend = new Polynomial(this.getListTerm());

        List<Term> listTermDividend = poliDividend.getListTerm();

        int i = 0;
        boolean continueProcess = true;
        while (i < listTermDividend.size() && continueProcess) {
            List<Term> listTermDivisor = polyDivisor.getListTerm();

            double coefficient = listTermDividend.get(0).getCoefficient()
                   / listTermDivisor.get(0).getCoefficient();

            if (listTermDividend.get(0).getExponent() >= listTermDivisor.get(0).getExponent()) {
                int exponent = listTermDividend.get(0).getExponent() - 
                        listTermDivisor.get(0).getExponent();
                Term termQuotient = new Term(coefficient, exponent);
                polyQuotient.addTerm(termQuotient);

                Polynomial monomial = new Polynomial();
                monomial.addTerm(termQuotient);

                Polynomial polyMultiplication = polyDivisor.multiply(monomial);

                poliDividend = poliDividend.subtract(polyMultiplication);

                listTermDividend = poliDividend.getListTerm();
                i++;
            } else {
                continueProcess = false;
            }
        }

        polyQuotient.symplify();

        polyQuotient.setPolyDividendRemainder(poliDividend);
        polyQuotient.setPolyDivisor(polyDivisor);

        return polyQuotient;
    }

}

package operation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Polynomial poly = new Polynomial();

//        poly = readPolynomial();
//        hard coded polynomial-9x^3+10x^3-5x^2+8x-7+5x^2
//        poly.addTerm(new Term(-9, 3));
//        poly.addTerm(new Term(10, 3));
//        poly.addTerm(new Term(-5, 2));
//        poly.addTerm(new Term(8, 1));
//        poly.addTerm(new Term(-7, 0));
//        poly.addTerm(new Term(5, 2));

//        System.out.println("The polynomial read is " + poly.toString());
//        System.out.println("The hardcoded polynomial is " + poly.toString());
//        poly.symplify();
//
//        System.out.println("The symplified polynomial is " + poly.toString());
        //  p1(x)=6y^2−9y + 4
        //  p2(x)=−7y^2 +5y + 1 
//        Polynomial poly1 = new Polynomial();
//        poly1.addTerm(new Term(6, 2));
//        poly1.addTerm(new Term(-9, 1));
//        poly1.addTerm(new Term(4, 0));
//
//        Polynomial poly2 = new Polynomial();
//        poly2.addTerm(new Term(-7, 2));
//        poly2.addTerm(new Term(5, 1));
//        poly2.addTerm(new Term(1, 0));
//
//        System.out.println("The polynomial1 is " + poly1.toString());
//        System.out.println("The polynomial2 is " + poly2.toString());
//
//        Polynomial polyAddition = poly1.add(poly2);
//        System.out.println("The addition polynomial is " + polyAddition.toString());
//
//        Polynomial polySubtraction = poly1.subtract(poly2);
//        System.out.println("The subtraction polynomial is " + polySubtraction.toString());

//         (p^2+p−6)(p^2 −6)
        Polynomial poly3 = new Polynomial();
        poly3.addTerm(new Term(1, 2));
        poly3.addTerm(new Term(1, 1));
        poly3.addTerm(new Term(-6, 0));

        Polynomial poly4 = new Polynomial();
        poly4.addTerm(new Term(1, 2));
        poly4.addTerm(new Term(-6, 0));

        System.out.println("The polynomial 3 is " + poly3.toString());
        System.out.println("The polynomial 4 is " + poly4.toString());

        Polynomial polyMultiplication = poly3.multiply(poly4);
        System.out.println("The multiplication polynomial is " + polyMultiplication.toString());

//        List<Term> listTerm1 = new LinkedList<>();
//
//        listTerm1.add(
//                new Term(5, 5));
//        listTerm1.add(
//                new Term(5, 5));
//        listTerm1.add(
//                new Term(3, 2));
//        listTerm1.add(
//                new Term(-10, 2));
//        listTerm1.add(
//                new Term(7, 2));
//        listTerm1.add(
//                new Term(3, 8));
//        listTerm1.add(
//                new Term(3, 3));
//        Polynomial poly5 = new Polynomial(listTerm1);
//
//        System.out.println(
//                "The hardcoded polynomial 1 is " + poly5.toString());
//        poly5.symplify();
//
//        System.out.println(
//                "The symplified polynomial 1 is " + poly5.toString());
//
//        List<Term> listTerm2 = new LinkedList<>();
//
//        listTerm2.add(
//                new Term(5, 5));
//        listTerm2.add(
//                new Term(-3, 3));
//
//        Polynomial poly6 = new Polynomial(listTerm2);
//
//        System.out.println(
//                "The hardcoded polynomial 2 is " + poly6.toString());
//        poly6.symplify();
//
//        System.out.println(
//                "The symplified polynomial 2 is " + poly6.toString());
//
//        Polynomial polyAddition = poly5.add(poly6);
//
//        System.out.println(
//                "The addition of the two polynomials is " + polyAddition.toString());
//        Polynomial  polyDividend = new Polynomial();
//        polyDividend.addTerm(new Term(4, 4));
//        polyDividend.addTerm(new Term(-23, 3));
//        polyDividend.addTerm(new Term(16, 2));
//        polyDividend.addTerm(new Term(-4, 1));
//        polyDividend.addTerm(new Term(-1, 0));
//
//        Polynomial polyDivisor = new Polynomial();
//        polyDivisor.addTerm(new Term(1, 2));
//        polyDivisor.addTerm(new Term(-5, 1));
//        
//        Polynomial polyQuotient = polyDividend.divide(polyDivisor);
//        
//        System.out.println("The dividend polynomial is " + polyDividend.toString());
//        System.out.println("The divisor polynomial is " + polyDivisor.toString());
//        System.out.println("The quotient polynomial is " + polyQuotient.toString());
    }

    public static Polynomial readPolynomial() {

        Polynomial poly = new Polynomial();

        System.out.print("Enter the number of terms:");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Reading term " + (i + 1) + "...");

            System.out.print("Enter coefficient: ");
            double coefficient = input.nextDouble();

            System.out.print("Enter exponent: ");
            int exponent = input.nextInt();

            poly.addTerm(new Term(coefficient, exponent));
        }

        return poly;
    }
}

package operation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Polynomial poly = new Polynomial();

//        poly = readPolynomial();
//        System.out.println("The polynomial read is " + poly.toString());
//        poly.symplify();
//
//        System.out.println("The symplified polynomial is " + poly.toString());

        // (6y^2−9y + 4)−(−7y^2 +5y + 1 )
        Polynomial poly1 = new Polynomial();
        poly1.addTerm(new Term(6, 2));
        poly1.addTerm(new Term(-9, 1));
        poly1.addTerm(new Term(4, 0));

        Polynomial poly2 = new Polynomial();
        poly2.addTerm(new Term(-7, 2));
        poly2.addTerm(new Term(5, 1));
        poly2.addTerm(new Term(1, 0));

        System.out.println("The polynomial1 is " + poly1.toString());
        System.out.println("The polynomial2 is " + poly2.toString());

        Polynomial polySubtraction = poly1.subtract(poly2);
        System.out.println("The subtraction polynomial is " + polySubtraction.toString());

        
       // (p^2+p−6)(p^2 −6)
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
//        Polynomial poly1 = new Polynomial(listTerm1);
//
//        System.out.println(
//                "The hardcoded polynomial 1 is " + poly1.toString());
//        poly1.symplify();
//
//        System.out.println(
//                "The symplified polynomial 1 is " + poly1.toString());
//
//        List<Term> listTerm2 = new LinkedList<>();
//
//        listTerm2.add(
//                new Term(5, 5));
//        listTerm2.add(
//                new Term(5, 3));
//
//        Polynomial poly2 = new Polynomial(listTerm2);
//
//        System.out.println(
//                "The hardcoded polynomial 2 is " + poly2.toString());
//        poly2.symplify();
//
//        System.out.println(
//                "The symplified polynomial 2 is " + poly2.toString());
//
//        Polynomial polyAddition = poly1.add(poly2);
//
//        System.out.println(
//                "The addition of the two polynomials is " + polyAddition.toString());
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
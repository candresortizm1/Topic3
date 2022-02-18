package com.globant;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class EvaluateExponential {
    static final Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        EvaluateExponential evaluateExponential = new EvaluateExponential();
    }

    EvaluateExponential(){
        final int cases = scaner.nextInt();
        final double[] entries = new double[cases];

        final ArrayList<Double> doubleEntries = getEntries.apply(cases);

        doubleEntries.stream().map(value-> {
            return getResult.apply(value);
        }).forEach(value->{
            System.out.println(Math.round(value*10000.0)/10000.0);
        });

    }

    //function to get the double entries and save return it in a ArrayList
    public Function<Integer, ArrayList<Double>> getEntries = (valuesSize) -> {
        ArrayList<Double> doubleArray = new ArrayList<Double>();
        IntStream.rangeClosed(0, valuesSize - 1).forEach(value -> {
            doubleArray.add((double) Math.round(scaner.nextDouble()*10000.0)/10000.0);
        });
        return doubleArray;
    };


    //Recursive function to get the factorial of a number
    double factorial(double number, double result) {
        return (number == 0) ? result : factorial(number - 1, result * number);
    }

    //Currying function to get the potentiation of a term
    public Function<Double, Function<Double, Double>> powNumber = (number1) -> {
        return (number2) -> {
            return Math.pow(number1,number2);
        };
    };

    //Function to get the e^x series of a double value
    public Function<Double, Double> getResult = (entryValue) -> {
        Function<Double, Double> partialFunction = powNumber.apply(entryValue);
        final OptionalDouble result = IntStream.rangeClosed(0, 9).mapToDouble(value ->
                partialFunction.apply((double) value)/factorial(value,1)).reduce((a, b) -> a + b);
        return result.getAsDouble();
    };

}

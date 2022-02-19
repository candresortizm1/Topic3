package com.globant;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PasswordCracker {
    static final Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        PasswordCracker passwordCracker = new PasswordCracker();
    }

    PasswordCracker(){
        int cases = scaner.nextInt();
        final ArrayList<String> doubleEntries = getEntries.apply(cases);
        doubleEntries.stream().forEach(value->{
            System.out.println(value);
        });
    }

    //function to get the double entries and save return it in a ArrayList
    public Function<Integer, ArrayList<String>> getEntries = (valuesSize) -> {
        ArrayList<String> stringArray = new ArrayList<String>();
        IntStream.rangeClosed(1, valuesSize).forEach(value -> {
            String numberPwd = scaner.nextLine();
            String passwords = scaner.nextLine();
            String attemptString = scaner.nextLine();
            String[] arrayPasswords = passwords.split(" ");
            List<String> allPasswords = Arrays.asList(arrayPasswords);
            String result = totalResult("",attemptString,allPasswords);
            stringArray.add(result);
        });
        return stringArray;
    };

    public String totalResult(String result,String restOfAttempt,List<String> allPasswords){
        List<String> findPasswords = choosePasswords.apply(restOfAttempt,allPasswords);
        if(findPasswords.isEmpty()){
            return "WRONG PASSWORD";
        }else{
            String longest = getMaxLengthString.apply(findPasswords)+" ";
            result += longest;
            String newString = restOfAttempt.substring(longest.length()-1);
            if(!newString.isEmpty()){
                return totalResult(result,newString, allPasswords);
            }else{
                return result;
            }
        }
    }

    public Function<List<String>,String> getMaxLengthString = (posibles) -> {
        return posibles.stream().max(Comparator.comparingInt(String::length)).get();
    };

    public Function<String, Function<List<String>, List<String>>> choosePwd = (attemptString) -> {
        return (allPasswords) -> {
            return allPasswords.stream().filter(password -> attemptString.startsWith(password))
                    .collect(Collectors.toList());
        };
    };

    public BiFunction<String, List<String>,List<String>> choosePasswords = (attemptString,allPasswords) -> {
        return allPasswords.stream().filter(password -> attemptString.startsWith(password))
                .collect(Collectors.toList());
    };
}

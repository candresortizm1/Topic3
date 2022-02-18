package com.globant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PasswordCracker {
    static final Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        PasswordCracker passwordCracker = new PasswordCracker();
    }

    PasswordCracker(){
        System.out.println("Hola Password");
        int users = scaner.nextInt();
        ArrayList<String> allPasswords = (ArrayList<String>) Arrays.stream(scaner.nextLine().split(" ")).toList();
        String logginAttemp = scaner.nextLine();

    }

}

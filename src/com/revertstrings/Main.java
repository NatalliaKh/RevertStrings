package com.revertstrings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            String[] sourceList = readStrings();
            replaceSymbols(sourceList);
        } catch (Exception e) {
            System.out.println("Некорректная операция");
        }
    }

    private static String[] readStrings() {
        System.out.println("Введите количество строк в списке:");
        Scanner scanner = new Scanner(System.in);
        int stringAmount = scanner.nextInt();
        if (stringAmount < 1) {
            throw new InputMismatchException();
        }
        String[] stringsList = new String[stringAmount];
        Scanner stringScanner = new Scanner(System.in);
        for (int i = 0; i < stringAmount; i++) {
            stringsList[i] = stringScanner.nextLine();
        }
        return stringsList;
    }

    private static String changeFirstLastChars(String source) {
        if (source.length() < 2) {
            return source;
        } else {
            char firstSymbol = source.charAt(0);
            char lastSymbol = source.charAt(source.length() - 1);
            String subSource = source.substring(1, source.length() - 1);
            return lastSymbol + subSource + firstSymbol;
        }
    }

    private static void replaceSymbols(String[] stringList) {
        for (int i = 1; i < stringList.length; i = i + 2) {
            stringList[i] = changeFirstLastChars(stringList[i]);
        }
        System.out.println("Результат:");
        for (int i = 0; i < stringList.length; i++) {
            System.out.println(stringList[i]);
        }
    }
}

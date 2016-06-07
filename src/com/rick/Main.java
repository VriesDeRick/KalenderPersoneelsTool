package com.rick;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> inputLines = vraagInput();
        ArrayList<Werkdag> dagen = createWerkdagen(inputLines);
        for (int i = 0; i<inputLines.size(); i++){
            System.out.println(inputLines.get(i));
        }
    }

    private static ArrayList<Werkdag> createWerkdagen(ArrayList<String> inputLines) {
        for (int i = 0; i < 7; i++) inputLines.remove(0); //Troep bovenaan tabel eruit
        ArrayList<Werkdag> dagen = new ArrayList<Werkdag>();
        for (int j = 0; j < inputLines.size(); j = j + 6){
            String dagVanWeek = inputLines.get(j);
            String datum = inputLines.get(j + 1);
            String beginTijd = inputLines.get(j + 2);
            String eindTijd = inputLines.get(j + 3);
            Werkdag dag = new Werkdag(beginTijd, dagVanWeek, datum, eindTijd);
            dagen.add(dag);
        }
        return dagen;
    }

    private static ArrayList<String> vraagInput() {
        System.out.println("Plak hier input-tabel");
        Scanner sc = new Scanner(System.in);

        ArrayList<String> inputLines = new ArrayList<String>();
        for (int i = 0; i < 49; i++){
            inputLines.add(sc.nextLine());
        }
        sc.close();
        return inputLines;
    }
}
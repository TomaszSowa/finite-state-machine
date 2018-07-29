package com.sowa.fsm;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final String PATH = "./src/main/resources/";
        Scanner sc = new Scanner(System.in);
        String fileName;

        try {
            System.out.print("Enter transition file name: ");
            fileName = sc.next();
            Graph graph = new Graph(PATH + fileName);
            System.out.print("Enter sequence file name: ");
            fileName = sc.next();
            graph.checkSequence(PATH + fileName);
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.err.println("Proper file not found.");
        }
    }





}
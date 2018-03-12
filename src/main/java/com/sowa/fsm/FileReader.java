package com.sowa.fsm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public void read() throws FileNotFoundException {

        Scanner scanner =  new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

//    public String readLines() throws FileNotFoundException {
//        StringBuilder lines = new StringBuilder();
//        Scanner s = new Scanner(read());
//        int i = 1;
//        while (s.hasNextLine()) {
//            String line = s.nextLine();
//            if (i >= fromLine) {
//                lines.append(line).append("\n");
//            }
//            i++;
//        }
//        lines.deleteCharAt(lines.length()-1);
//        return lines.toString();
//    }
}

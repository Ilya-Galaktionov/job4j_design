package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/dataresult.txt")) {
            output.write("    ".getBytes());
            for (int i = 1; i <= 10; i++) {
                output.write(String.format("%4d ", i).getBytes());
            }
            output.write(System.lineSeparator().getBytes());
            output.write(("-----------------------------------------------------"
                    + System.lineSeparator()).getBytes());
            for (int i = 1; i <= 10; i++) {
                output.write(String.format("%2d |", i).getBytes());
                for (int j = 1; j <= 10; j++) {
                    output.write(String.format("%4d ", i * j).getBytes());
                }
                output.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package day9.puzzle1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("example.txt");
        File input = new File("input");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
    }
}
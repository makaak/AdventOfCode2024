package day18.puzzle2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day18/puzzle2/example.txt");
        File input = new File("day18/puzzle2/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
    }
}
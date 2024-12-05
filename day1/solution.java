package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day1/example.txt");
        File input = new File("day1/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        String[] lineElements = new String[2];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        while ((line = exReader.readLine()) != null) {
            lineElements = line.split("   ");
            left.add(Integer.parseInt(lineElements[0]));
            right.add(Integer.parseInt(lineElements[1]));
        }
        left.sort(null);
        right.sort(null);
        int ans = 0;
        for (int i = 0; i < left.size(); i++) {
            ans += Math.abs(left.get(i) - right.get(i));
        }
        System.out.printf("example ans: %d%n", ans);
        left.clear();
        right.clear();

        while ((line = inReader.readLine()) != null) {
            lineElements = line.split("   ");
            left.add(Integer.parseInt(lineElements[0]));
            right.add(Integer.parseInt(lineElements[1]));
        }
        left.sort(null);
        right.sort(null);
        ans = 0;
        for (int i = 0; i < left.size(); i++) {
            ans += Math.abs(left.get(i) - right.get(i));
        }
        System.out.printf("P1 ans: %d%n", ans);
        exReader.close();
        inReader.close();
    }
}

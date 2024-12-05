package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day1/example.txt");
        File input = new File("day1/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        String[] lineElements = new String[2];
        ArrayList<Integer> leftEx = new ArrayList<>();
        ArrayList<Integer> rightEx = new ArrayList<>();
        while ((line = exReader.readLine()) != null) {
            lineElements = line.split("   ");
            leftEx.add(Integer.parseInt(lineElements[0]));
            rightEx.add(Integer.parseInt(lineElements[1]));
        }
        exReader.close();

        leftEx.sort(null);
        rightEx.sort(null);
        int ansP1 = 0;
        for (int i = 0; i < leftEx.size(); i++) {
            ansP1 += Math.abs(leftEx.get(i) - rightEx.get(i));
        }
        System.out.printf("example ans: %d%n", ansP1);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        while ((line = inReader.readLine()) != null) {
            lineElements = line.split("   ");
            left.add(Integer.parseInt(lineElements[0]));
            right.add(Integer.parseInt(lineElements[1]));
        }
        inReader.close();

        left.sort(null);
        right.sort(null);
        ansP1 = 0;
        for (int i = 0; i < left.size(); i++) {
            ansP1 += Math.abs(left.get(i) - right.get(i));
        }
        System.out.printf("P1 ans: %d%n", ansP1);

        long ansP2 = 0;
        int min = Math.min(leftEx.getFirst(), rightEx.getFirst());
        int max = Math.max(leftEx.getLast(), rightEx.getLast());
        int[] countEx = new int[max - min + 1];
        for (Integer i : rightEx) {
            countEx[i - min] += 1;
        }

        for (Integer i : leftEx) {
            ansP2 += i * countEx[i - min];
        }
        System.out.printf("P2 example answer: %d%n", ansP2);

        ansP2 = 0;
        min = Math.min(left.getFirst(), right.getFirst());
        max = Math.max(left.getLast(), right.getLast());
        int[] count = new int[max - min + 1];
        for (Integer i : right) {
            count[i - min] += 1;
        }

        for (Integer i : left) {
            ansP2 += i * count[i - min];
        }
        System.out.printf("P2 answer: %d%n", ansP2);
    }
}

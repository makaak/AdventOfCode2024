package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class solution {

    static boolean testList(ArrayList<Integer> list) {
        boolean inc;
        boolean test = false;
        inc = list.get(0) - list.get(1) > 0;
        for (int i = 0; i < list.size() - 1; i++) {
            test = test
                    || ((list.get(i) - list.get(i + 1) > 0) ^ inc)
                    || (Math.abs(list.get(i) - list.get(i + 1)) < 1)
                    || (Math.abs(list.get(i) - list.get(i + 1)) > 3);
        }
        return test;
    }

    public static void main(String[] args) throws Exception {
        File example = new File("day2/example.txt");
        File input = new File("day2/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        String[] lineElements;
        int ansEx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while ((line = exReader.readLine()) != null) {
            lineElements = line.split(" ");
            list.clear();
            for (String string : lineElements) {
                list.add(Integer.parseInt(string));
            }
            ansEx = testList(list) ? ansEx : ansEx + 1;
        }
        exReader.close();

        System.out.printf("P1 example answer: %d%n", ansEx);

        int ans = 0;
        while ((line = inReader.readLine()) != null) {
            lineElements = line.split(" ");
            list.clear();
            for (String string : lineElements) {
                list.add(Integer.parseInt(string));
            }
            ans = testList(list) ? ans : ans + 1;
        }
        inReader.close();

        System.out.printf("P1 answer: %d%n", ans);

        exReader = new BufferedReader(new FileReader(example));
        inReader = new BufferedReader(new FileReader(input));

        ansEx = 0;
        while ((line = exReader.readLine()) != null) {
            lineElements = line.split(" ");
            list.clear();
            for (String string : lineElements) {
                list.add(Integer.parseInt(string));
            }
            if (testList(list)) {
                for (int i = 0; i < list.size(); i++) {
                    ArrayList<Integer> newList = new ArrayList<>(list);
                    newList.remove(i);
                    if (!testList(newList)) {
                        ansEx += 1;
                        break;
                    }
                }
            } else {
                ansEx += 1;
            }
        }
        exReader.close();

        System.out.printf("P2 example answer: %d%n", ansEx);

        ans = 0;
        while ((line = inReader.readLine()) != null) {
            lineElements = line.split(" ");
            list.clear();
            for (String string : lineElements) {
                list.add(Integer.parseInt(string));
            }
            if (testList(list)) {
                for (int i = 0; i < list.size(); i++) {
                    ArrayList<Integer> newList = new ArrayList<>(list);
                    newList.remove(i);
                    if (!testList(newList)) {
                        ans += 1;
                        break;
                    }
                }
            } else {
                ans += 1;
            }
        }
        inReader.close();

        System.out.printf("P2 example answer: %d%n", ans);

    }
}
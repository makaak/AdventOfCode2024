package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class solution {

    static boolean[][] rules = new boolean[100][100];

    static void initRules(int a, int b) {
        rules[a][b] = true;
    }

    public static void main(String[] args) throws Exception {
        File example = new File("day5/example.txt");
        File input = new File("day5/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        File example_rules = new File("day5/example_rules.txt");
        File rulesFile = new File("day5/rules.txt");
        BufferedReader example_rulesReader = new BufferedReader(new FileReader(example_rules));
        BufferedReader rulesReader = new BufferedReader(new FileReader(rulesFile));
        String line;

        while ((line = rulesReader.readLine()) != null) {
            initRules(Integer.parseInt(line.split("\\|")[0]), Integer.parseInt(line.split("\\|")[1]));
        }
        rulesReader.close();
        example_rulesReader.close();

        String[] data;
        ArrayList<Integer> pages;
        boolean failed = false;
        int ans = 0;
        while ((line = inReader.readLine()) != null) {
            data = line.split(",");
            pages = new ArrayList<>();
            for (int i = 0; i < data.length; i++) {
                pages.add(Integer.parseInt(data[i]));
            }

            for (int j = pages.size() - 1; j > -1 && !failed; j--) {
                for (int i = 0; i < j && !failed; i++) {
                    if (rules[pages.get(j)][pages.get(i)]) {
                        failed = true;
                    }
                }
            }
            if (!failed) {
                ans += pages.get(pages.size() / 2);
            }
            failed = false;
        }
        inReader.close();
        exReader.close();
        System.out.printf("P1 answer: %d%n", ans);

        exReader = new BufferedReader(new FileReader(example));
        inReader = new BufferedReader(new FileReader(input));
        ans = 0;

        while ((line = inReader.readLine()) != null) {
            data = line.split(",");
            pages = new ArrayList<>();
            for (int i = 0; i < data.length; i++) {
                pages.add(Integer.parseInt(data[i]));
            }

            for (int j = pages.size() - 1; j > -1; j--) {
                for (int i = 0; i < j; i++) {
                    if (rules[pages.get(j)][pages.get(i)]) {
                        failed = true;
                        pages.add(i, pages.remove(j));
                        j++;
                        break;
                    }
                }
            }
            if (failed) {
                ans += pages.get(pages.size() / 2);
            }
            failed = false;
        }
        inReader.close();
        exReader.close();
        System.out.printf("P2 answer: %d%n", ans);

    }
}
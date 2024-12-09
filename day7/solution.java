package day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day7/example.txt");
        File input = new File("day7/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        long ans = 0, value, calculated;
        String[] numbers;
        int[] elements;
        while ((line = inReader.readLine()) != null) {
            value = Long.parseLong(line.split(": ")[0]);
            numbers = line.split(": ")[1].split(" ");
            elements = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                elements[i] = Integer.parseInt(numbers[i]);
            }

            ans += check1(elements, value);
        }

        exReader.close();
        inReader.close();
        System.out.printf("P1 answer: %d%n", ans);

        exReader = new BufferedReader(new FileReader(example));
        inReader = new BufferedReader(new FileReader(input));

        ans = 0;

        while ((line = inReader.readLine()) != null) {
            value = Long.parseLong(line.split(": ")[0]);
            numbers = line.split(": ")[1].split(" ");
            elements = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                elements[i] = Integer.parseInt(numbers[i]);
            }

            ans += check2(elements, value);
        }
        exReader.close();
        inReader.close();

        System.out.printf("P2 answer: %d%n", ans);
    }

    static long check1(int[] elements, long value) {
        long calculated;
        for (int i = 0; i < Math.pow(2, elements.length - 1); i++) {

            calculated = elements[0];
            for (int j = 0; j < elements.length - 1; j++) {
                calculated = ((i >> j) & 1) == 0 ? calculated + elements[j + 1] : calculated * elements[j + 1];

            }
            if (calculated == value) {
                return calculated;
            }
        }

        return 0;
    }

    static long check2(int[] elements, long value) {
        long calculated;
        for (int i = 0; i < Math.pow(2, elements.length - 1); i++) {
            //inefficent... calculates for a minute....
            for (int k = 0; k < Math.pow(2, elements.length - 1); k++) {

                calculated = elements[0];
                for (int j = 0; j < elements.length - 1; j++) {
                    calculated = ((k >> j) & 1) == 1
                            ? Long.parseLong(Long.toString(calculated) + Long.toString(elements[j + 1]))
                            : ((i >> j) & 1) == 0 ? calculated + elements[j + 1] : calculated * elements[j + 1];

                }
                if (calculated == value) {
                    return calculated;
                }
            }
        }
        return 0;
    }
}

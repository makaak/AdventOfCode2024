package day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day9/example.txt");
        File input = new File("day9/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        int cursorForward = 0, cursorBackward, memPos = 0, idForward = 0, idBackward, min;
        boolean cursorAtFile = true;
        char[] chars;
        ArrayList<Integer> data = new ArrayList<>();
        long ans = 0;
        ArrayList<Integer> ids = new ArrayList<>();
        while ((line = inReader.readLine()) != null) {
            chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                data.add(Character.getNumericValue(chars[i]));
            }
            cursorBackward = data.size() - 1;
            idBackward = cursorBackward / 2;
            while (!(cursorForward > cursorBackward)) {
                if (cursorAtFile) {
                    for (int i = 0; i < data.get(cursorForward); i++) {
                        ans += memPos * idForward;
                        memPos++;
                    }
                    cursorForward++;
                    cursorAtFile = !cursorAtFile;
                } else {
                    min = Math.min(data.get(cursorForward), data.get(cursorBackward));
                    for (int i = 0; i < min; i++) {
                        ans += memPos * idBackward;
                        memPos++;
                    }
                    data.set(cursorForward, data.get(cursorForward) - min);
                    data.set(cursorBackward, data.get(cursorBackward) - min);
                    if (data.get(cursorForward) == 0) {
                        cursorForward++;
                        idForward++;
                        cursorAtFile = !cursorAtFile;
                    }
                    if (data.get(cursorBackward) == 0) {
                        cursorBackward -= 2;
                        idBackward--;
                    }
                }
            }

            System.out.printf("P1 answer: %d%n", ans);
            data.clear();

            for (int i = 0; i < chars.length; i++) {
                data.add(Character.getNumericValue(chars[i]));
                if (i % 2 == 0) {
                    ids.add(i / 2);
                }

            }
            data.addLast(0);
            ans = 0;
            memPos = 0;

            for (int i = data.size() - 2; i > 0; i = i - 2) {
                for (int j = 1; j < data.size() - 1 && j < i; j = j + 2) {
                    if (data.get(j) >= data.get(i)) {
                        data.set(j, data.get(j) - data.get(i));
                        data.set(i - 1, data.get(i - 1) + data.get(i));
                        data.set(i - 1, data.get(i - 1) + data.remove(i + 1));
                        data.add(j, data.remove(i));
                        data.add(j, 0);
                        ids.add((j + 1) / 2, ids.remove(i / 2));
                        j = -1;
                    }
                }
            }

            for (int i = 0; i < data.size(); i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < data.get(i); j++) {
                        ans += memPos * ids.get(i / 2);
                        memPos++;
                    }
                } else {
                    memPos += data.get(i);
                }
            }
        }

        System.out.printf("P2 answer: %d%n", ans);

    }
}
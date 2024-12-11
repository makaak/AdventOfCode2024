package day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day8/example.txt");
        File input = new File("day8/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        boolean[][] antiNodes;
        HashMap<String, ArrayList<int[]>> antennas = new HashMap<>();
        Pattern antenna = Pattern.compile("[a-zA-Z0-9]");
        Matcher matcher;
        int length = 0, width = 0, ans = 0;

        while ((line = inReader.readLine()) != null) {
            width = line.length();
            matcher = antenna.matcher(line);
            while (matcher.find()) {
                if (!antennas.containsKey(matcher.group()))
                    antennas.put(matcher.group(), new ArrayList<int[]>());
                antennas.get(matcher.group()).add(new int[] { matcher.start(), length });
            }
            length++;
        }

        antiNodes = new boolean[width][length];
        int x1, y1, x2, y2;
        for (String s : antennas.keySet()) {
            for (int j = 0; j < antennas.get(s).size() - 1; j++) {
                for (int k = j + 1; k < antennas.get(s).size(); k++) {
                    x1 = antennas.get(s).get(j)[0];
                    y1 = antennas.get(s).get(j)[1];
                    x2 = antennas.get(s).get(k)[0];
                    y2 = antennas.get(s).get(k)[1];
                    for (int l = 0; l < 2; l++) {
                        try {
                            ans = antiNodes[2 * x1 - x2 + l * (3 * x2 - 3 * x1)][2 * y1 - y2 + l * (3 * y2 - 3 * y1)]
                                    ? ans
                                    : ans + 1;
                            antiNodes[2 * x1 - x2 + l * (3 * x2 - 3 * x1)][2 * y1 - y2 + l * (3 * y2 - 3 * y1)] = true;

                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                }
            }
        }

        exReader.close();
        inReader.close();
        System.out.printf("P1 answer: %d%n", ans);

        antiNodes = new boolean[width][length];
        ans = 0;
        int dx, dy;
        for (String s : antennas.keySet()) {
            for (int i = 0; i < antennas.get(s).size(); i++) {
                for (int j = 0; j < antennas.get(s).size(); j++) {
                    if (i != j) {
                        x1 = antennas.get(s).get(i)[0];
                        y1 = antennas.get(s).get(i)[1];
                        x2 = antennas.get(s).get(j)[0];
                        y2 = antennas.get(s).get(j)[1];
                        dx = x2 - x1;
                        dy = y2 - y1;

                        while (true) {
                            try {
                                x2 -= dx;
                                y2 -= dy;
                                if (!antiNodes[x2][y2]) {
                                    ans++;
                                    antiNodes[x2][y2] = true;
                                }
                            } catch (Exception e) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("P2 answer: %d%n", ans);
    }
}
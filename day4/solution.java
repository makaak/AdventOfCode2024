package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day4/example.txt");
        File input = new File("day4/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        ArrayList<String> data = new ArrayList<>();
        while ((line = inReader.readLine()) != null) {
            data.add(line);
        }

        char[][] chars = new char[data.size()][data.getFirst().length()];
        for (int i = 0; i < data.size(); i++) {
            chars[i] = data.get(i).toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == 'X') {
                    try {
                        if (chars[i][j + 1] == 'M' && chars[i][j + 2] == 'A' && chars[i][j + 3] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i][j - 1] == 'M' && chars[i][j - 2] == 'A' && chars[i][j - 3] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i - 1][j] == 'M' && chars[i - 2][j] == 'A' && chars[i - 3][j] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i + 1][j] == 'M' && chars[i + 2][j] == 'A' && chars[i + 3][j] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i + 1][j + 1] == 'M' && chars[i + 2][j + 2] == 'A'
                                && chars[i + 3][j + 3] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i - 1][j + 1] == 'M' && chars[i - 2][j + 2] == 'A'
                                && chars[i - 3][j + 3] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i - 1][j - 1] == 'M' && chars[i - 2][j - 2] == 'A'
                                && chars[i - 3][j - 3] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i + 1][j - 1] == 'M' && chars[i + 2][j - 2] == 'A'
                                && chars[i + 3][j - 3] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                }
            }
        }

        inReader.close();
        exReader.close();
        System.out.printf("P1 answer: %d%n", ans);

        exReader = new BufferedReader(new FileReader(example));
        inReader = new BufferedReader(new FileReader(input));

        data.clear();
        while ((line = inReader.readLine()) != null) {
            data.add(line);
        }

        chars = new char[data.size()][data.getFirst().length()];
        for (int i = 0; i < data.size(); i++) {
            chars[i] = data.get(i).toCharArray();
        }
        ans = 0;

        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars.length; k++) {
                if (chars[i][k] == 'A') {
                    try {
                        if (chars[i - 1][k - 1] == 'M' && chars[i + 1][k + 1] == 'S' && chars[i - 1][k + 1] == 'M'
                                && chars[i + 1][k - 1] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i - 1][k - 1] == 'M' && chars[i + 1][k + 1] == 'S' && chars[i + 1][k - 1] == 'M'
                                && chars[i - 1][k + 1] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i - 1][k - 1] == 'S' && chars[i + 1][k + 1] == 'M' && chars[i - 1][k + 1] == 'M'
                                && chars[i + 1][k - 1] == 'S') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    try {
                        if (chars[i - 1][k - 1] == 'S' && chars[i + 1][k + 1] == 'M' && chars[i - 1][k + 1] == 'S'
                                && chars[i + 1][k - 1] == 'M') {
                            ans += 1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        }

        inReader.close();
        exReader.close();
        System.out.printf("P2 answer: %d%n", ans);

    }
}

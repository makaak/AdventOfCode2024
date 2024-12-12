package day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class solution {

    static int[][] map;
    static boolean[][] visited;

    static int checkP1(int x, int y, int seen) {

        if (map[y][x] == 9) {
            visited[y][x] = true;
            return seen + 1;
        }

        try {
            if (map[y][x - 1] - map[y][x] == 1 && !visited[y][x - 1]) {
                visited[y][x] = true;
                seen = checkP1(x - 1, y, seen);
            }
        } catch (Exception e) {
        }

        try {
            if (map[y + 1][x] - map[y][x] == 1 && !visited[y + 1][x]) {
                visited[y][x] = true;
                seen = checkP1(x, y + 1, seen);
            }
        } catch (Exception e) {
        }

        try {
            if (map[y][x + 1] - map[y][x] == 1 && !visited[y][x + 1]) {
                visited[y][x] = true;
                seen = checkP1(x + 1, y, seen);
            }
        } catch (Exception e) {
        }

        try {
            if (map[y - 1][x] - map[y][x] == 1 && !visited[y - 1][x]) {
                visited[y][x] = true;
                seen = checkP1(x, y - 1, seen);
            }
        } catch (Exception e) {
        }
        return seen;
    }

    static int checkP2(int x, int y, int seen) {

        if (map[y][x] == 9) {
            
            return seen + 1;
        }

        try {
            if (map[y][x - 1] - map[y][x] == 1) {
                seen = checkP2(x - 1, y, seen);
            }
        } catch (Exception e) {
        }

        try {
            if (map[y + 1][x] - map[y][x] == 1) {
                                seen = checkP2(x, y + 1, seen);
            }
        } catch (Exception e) {
        }

        try {
            if (map[y][x + 1] - map[y][x] == 1) {
                seen = checkP2(x + 1, y, seen);
            }
        } catch (Exception e) {
        }

        try {
            if (map[y - 1][x] - map[y][x] == 1) {
                seen = checkP2(x, y - 1, seen);
            }
        } catch (Exception e) {
        }
        return seen;
    }

    public static void main(String[] args) throws Exception {
        File example = new File("day10/example.txt");
        File input = new File("day10/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        ArrayList<String> data = new ArrayList<>();
        while ((line = inReader.readLine()) != null) {
            data.add(line);
        }
        map = new int[data.size()][data.get(0).length()];

        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length(); j++) {
                map[i][j] = Integer.parseInt(data.get(i).substring(j, j + 1));
            }
        }

        int ans = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    visited = new boolean[map.length][map[0].length];
                    ans += checkP1(j, i, 0);
                }
            }
        }

        System.out.printf("P1 answer: %d%n", ans);

        ans = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    ans += checkP2(j, i, 0);
                }
            }
        }

        System.out.printf("P2 answer: %d%n", ans);
    }
}
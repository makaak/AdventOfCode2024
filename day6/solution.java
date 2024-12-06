package day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

public class solution {

    enum Direction {
        UP(0, -1),
        RIGHT(1, 0),
        DOWN(0, 1),
        LEFT(-1, 0);

        int x;
        int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception {
        File example = new File("day6/example.txt");
        File input = new File("day6/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        ArrayList<String> data = new ArrayList<>();
        int[] location = new int[2];
        int[] startingLocation = new int[2];
        while ((line = inReader.readLine()) != null) {
            data.add(line);
            if (line.contains("^")) {
                location[1] = data.size() - 1;
                location[0] = line.indexOf("^");
                startingLocation[0] = location[0];
                startingLocation[1] = location[1];
            }
        }

        char[][] chars = new char[data.size()][data.getFirst().length()];
        for (int i = 0; i < data.size(); i++) {
            chars[i] = data.get(i).toCharArray();
        }

        int ans = 0;
        Iterator<Direction> dirs = EnumSet.allOf(Direction.class).iterator();

        Direction current = dirs.next();
        while (true) {
            try {
                if (chars[location[1] + current.y][location[0] + current.x] != '#') {
                    chars[location[1]][location[0]] = 'X';
                    location[0] += current.x;
                    location[1] += current.y;
                } else {
                    if (dirs.hasNext()) {
                        current = dirs.next();
                    } else {
                        dirs = EnumSet.allOf(Direction.class).iterator();
                        current = dirs.next();
                    }
                }
            } catch (Exception e) {
                chars[location[1]][location[0]] = 'X';
                break;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                ans += chars[i][j] == 'X' ? 1 : 0;
            }
        }
        System.out.printf("P1 answer: %d%n", ans);

        ans = 0;
        boolean[][][] seen;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == 'X' && !(i == startingLocation[1] && j == startingLocation[0])) {
                    chars[i][j] = '#';

                    location[0] = startingLocation[0];
                    location[1] = startingLocation[1];

                    dirs = EnumSet.allOf(Direction.class).iterator();
                    current = dirs.next();
                    seen = new boolean[chars.length][chars[0].length][5];
                    seen[location[1]][location[0]][0] = true;
                    seen[location[1]][location[0]][current.ordinal() + 1] = true;
                    while (true) {
                        try {
                            if (chars[location[1] + current.y][location[0] + current.x] != '#') {
                                location[0] += current.x;
                                location[1] += current.y;
                            } else {
                                if (dirs.hasNext()) {
                                    current = dirs.next();
                                } else {
                                    dirs = EnumSet.allOf(Direction.class).iterator();
                                    current = dirs.next();
                                }
                            }
                            if (seen[location[1]][location[0]][0]
                                    && seen[location[1]][location[0]][current.ordinal() + 1]) {
                                ans = ans + 1;
                                break;
                            }
                            seen[location[1]][location[0]][0] = true;
                            seen[location[1]][location[0]][current.ordinal() + 1] = true;
                        } catch (Exception e) {
                            break;
                        }
                    }
                    chars[i][j] = '.';
                }
            }
        }
        System.out.printf("P2 answer: %d%n", ans);
    }
}
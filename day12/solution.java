package day12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class solution {

    static boolean[][] visited;
    static char[][] garden;

    public static void main(String[] args) throws Exception {
        File example = new File("day12/example.txt");
        File input = new File("day12/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;

        ArrayList<String> data = new ArrayList<>();
        while ((line = inReader.readLine()) != null) {
            data.add(line);
        }
        garden = new char[data.size()][data.get(0).length()];
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                garden[i][j] = data.get(i).charAt(j);
            }
        }
        visited = new boolean[garden.length][garden[0].length];
        int[] props;
        int ans = 0;
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                if (!visited[i][j]) {
                    props = propertiesP2(j, i, new int[2]);
                    System.out.printf("Area %c has area %d and perimeter %d%n", garden[i][j], props[0], props[1]);
                    ans += props[0] * props[1];
                }
            }
        }
        System.out.println(ans);
    }

    static int[] propertiesP1(int x, int y, int[] p) {
        if (visited[y][x]) {
            return p;
        }
        p[0]++;
        visited[y][x] = true;

        try {
            if (garden[y][x + 1] == garden[y][x]) {
                p = propertiesP1(x + 1, y, p);
            } else {
                p[1]++;
            }
        } catch (Exception e) {
            p[1]++;
        }

        try {
            if (garden[y][x - 1] == garden[y][x]) {
                p = propertiesP1(x - 1, y, p);
            } else {
                p[1]++;
            }
        } catch (Exception e) {
            p[1]++;
        }

        try {
            if (garden[y + 1][x] == garden[y][x]) {
                p = propertiesP1(x, y + 1, p);
            } else {
                p[1]++;
            }
        } catch (Exception e) {
            p[1]++;
        }

        try {
            if (garden[y - 1][x] == garden[y][x]) {
                p = propertiesP1(x, y - 1, p);
            } else {
                p[1]++;
            }
        } catch (Exception e) {
            p[1]++;
        }

        return p;
    }

    static int[] propertiesP2(int x, int y, int[] p) {
        if (visited[y][x]) {
            return p;
        }
        p[0]++;
        visited[y][x] = true;

        try {
            if (garden[y][x + 1] != garden[y][x]) {
                try {
                    if (garden[y - 1][x] != garden[y][x]) {
                        p[1]++;
                    }
                } catch (Exception e) {
                    p[1]++;
                }
                try {
                    if (garden[y + 1][x] != garden[y][x]) {
                        p[1]++;
                    }
                } catch (Exception e) {
                    p[1]++;
                }
            } else {
                try {
                    if (garden[y - 1][x] == garden[y][x] && garden[y - 1][x + 1] != garden[y][x]) {
                        p[1]++;
                    }
                } catch (Exception e) {

                }
                try {
                    if (garden[y + 1][x] == garden[y][x] && garden[y + 1][x + 1] != garden[y][x]) {
                        p[1]++;
                    }
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {
            try {
                if (garden[y - 1][x] != garden[y][x]) {
                    p[1]++;
                }
            } catch (Exception e1) {
                p[1]++;
            }
            try {
                if (garden[y + 1][x] != garden[y][x]) {
                    p[1]++;
                }
            } catch (Exception e1) {
                p[1]++;
            }
        }

        try {
            if (garden[y][x - 1] != garden[y][x]) {
                try {
                    if (garden[y - 1][x] != garden[y][x]) {
                        p[1]++;
                    }
                } catch (Exception e) {
                    p[1]++;
                }
                try {
                    if (garden[y + 1][x] != garden[y][x]) {
                        p[1]++;
                    }
                } catch (Exception e) {
                    p[1]++;
                }
            } else {
                try {
                    if (garden[y - 1][x] == garden[y][x] && garden[y - 1][x - 1] != garden[y][x]) {
                        p[1]++;
                    }
                } catch (Exception e) {

                }
                try {
                    if (garden[y + 1][x] == garden[y][x] && garden[y + 1][x - 1] != garden[y][x]) {
                        p[1]++;
                    }
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {
            try {
                if (garden[y - 1][x] != garden[y][x]) {
                    p[1]++;
                }
            } catch (Exception e1) {
                p[1]++;
            }
            try {
                if (garden[y + 1][x] != garden[y][x]) {
                    p[1]++;
                }
            } catch (Exception e1) {
                p[1]++;
            }
        }

        try {
            if (garden[y][x + 1] == garden[y][x]) {
                p = propertiesP2(x + 1, y, p);
            }
        } catch (Exception e) {
        }

        try {
            if (garden[y][x - 1] == garden[y][x]) {
                p = propertiesP2(x - 1, y, p);
            }
        } catch (Exception e) {
        }

        try {
            if (garden[y + 1][x] == garden[y][x]) {
                p = propertiesP2(x, y + 1, p);
            }
        } catch (Exception e) {
        }

        try {
            if (garden[y - 1][x] == garden[y][x]) {
                p = propertiesP2(x, y - 1, p);
            }
        } catch (Exception e) {
        }

        return p;
    }
}
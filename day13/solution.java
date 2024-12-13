package day13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day13/example.txt");
        File input = new File("day13/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        Long[] coords = null;
        ArrayList<Long[]> data = new ArrayList<>();
        while ((line = inReader.readLine()) != null) {
            switch (line.split(": ")[0]) {
                case "Button A":
                    coords = new Long[6];
                    coords[0] = Long.parseLong(line.split(": ")[1].split(", ")[0].split("\\+")[1]);// ax
                    coords[1] = Long.parseLong(line.split(": ")[1].split(", ")[1].split("\\+")[1]);// ay
                    break;
                case "Button B":
                    coords[2] = Long.parseLong(line.split(": ")[1].split(", ")[0].split("\\+")[1]);// bx
                    coords[3] = Long.parseLong(line.split(": ")[1].split(", ")[1].split("\\+")[1]);// by
                    break;
                case "Prize":
                    coords[4] = Long.parseLong(line.split(": ")[1].split(", ")[0].split("=")[1]) + 10000000000000l;// px
                    coords[5] = Long.parseLong(line.split(": ")[1].split(", ")[1].split("=")[1]) + 10000000000000l;// py
                    data.add(coords);
                    break;
            }
        }
        inReader.close();
        exReader.close();
        long ans = 0;
        long num, dom;
        long a, b;
        for (Long[] l : data) {
            num = l[5] * l[0] - l[4] * l[1];
            dom = l[3] * l[0] - l[2] * l[1];
            if ((num) % (dom) == 0) {
                b = num / dom;
                if ((l[4] - b * l[2]) % l[0] == 0) {
                    a = (l[4] - b * l[2]) / l[0];

                    System.out.printf("B = %d, A = %d for prize %d %d, ax - %d, ay - %d, bx - %d, by - %d%n", b, a,
                            l[4], l[5], l[0], l[1], l[2], l[3]);
                    ans += 3 * a + b;
                }
            }
        }
        System.out.println(ans);
    }
}
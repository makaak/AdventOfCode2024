package day14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day14/example.txt");
        File input = new File("day14/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        int width = 101, height = 103;
        int x, y, vx, vy, x2, y2, q1 = 0, q2 = 0, q3 = 0, q4 = 0;

        while ((line = inReader.readLine()) != null) {
            x = Integer.parseInt(line.split(" ")[0].split("p=")[1].split(",")[0]);
            y = Integer.parseInt(line.split(" ")[0].split("p=")[1].split(",")[1]);
            vx = Integer.parseInt(line.split(" ")[1].split("v=")[1].split(",")[0]);
            vy = Integer.parseInt(line.split(" ")[1].split("v=")[1].split(",")[1]);
            x2 = ((x + vx * 100) % width) < 0 ? width + ((x + vx * 100) % width) : ((x + vx * 100) % width);
            y2 = ((y + vy * 100) % height) < 0 ? height + ((y + vy * 100) % height) : ((y + vy * 100) % height);
            q1 = x2 < width/2 && y2 < height/2 ? q1 + 1 : q1;
            q2 = x2 > width/2 && y2 < height/2 ? q2 + 1 : q2;
            q3 = x2 < width/2 && y2 > height/2 ? q3 + 1 : q3;
            q4 = x2 > width/2 && y2 > height/2 ? q4 + 1 : q4;
        }
        System.out.println(q1*q2*q3*q4);
    }
}
package day11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day11/example.txt");
        File input = new File("day11/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line;
        ArrayList<ArrayList<ArrayList<Long>>> data = new ArrayList<>();
        long time;
        
        while ((line = exReader.readLine()) != null) {
            for (int i = 0; i < line.split(" ").length; i++) {  
                data.add(new ArrayList<>());
                data.get(i).add(new ArrayList<>());
                data.get(i).get(0).add(Long.parseLong(line.split(" ")[i]));
            }
        }
        long left, right, ans = 0;        
        ArrayList<Long> arrayList;
        for (ArrayList<ArrayList<Long>> e : data) {
            
        
            for (int i = 0; i < 75; i++) {
                e.add(new ArrayList<>());
                arrayList = e.get(i);
                time = System.currentTimeMillis();
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j) == 0) {
                        // System.out.printf("Found 0 at position %d%n",j);
                        e.get(i + 1).add(1l);
                        continue;
                    }
                    if (arrayList.get(j).toString().length() % 2 == 0) {
                        // System.out.printf("Found mod2 digits at position %d%n",j);
                        left = arrayList.get(j) / (long) Math.pow(10, arrayList.get(j).toString().length() / 2);
                        right = arrayList.get(j) - left * (long) Math.pow(10, arrayList.get(j).toString().length() / 2);
                        e.get(i + 1).add(left);
                        e.get(i + 1).add(right);
                        
                        // System.out.printf("Left: %s, Right: %s, new index: %d%n",left,right,j);
                        continue;
                    }
                    // System.out.printf("Times 2024 at position %d%n", j);
                    e.get(i + 1).add(arrayList.get(j) * 2024);
                }
                // System.out.println(arrayList);
                System.out.printf("Iteration: %d, %d elements, took %d ms%n", i, arrayList.size(),
                        System.currentTimeMillis() - time);
            }}
        
            for (ArrayList<ArrayList<Long>> e : data) {
                ans += e.getLast().size();
            }
            System.out.println(ans);
    }
}
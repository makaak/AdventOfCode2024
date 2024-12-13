
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day11/example.txt");
        File input = new File("day11/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        String line, left, right;
        HashMap<String, Long> data = new HashMap<>();
        HashMap<String, Long> processed = new HashMap<>();
        while ((line = inReader.readLine()) != null) {
            for (int i = 0; i < line.split(" ").length; i++) {
                data.put(line.split(" ")[i], 1l);
            }
        }
        long ans = 0, time;

        for (int i = 0; i < 75; i++) {
            time = System.currentTimeMillis();
            for (String s : data.keySet()) {

                if (s.equals("0")) {
                    if (processed.containsKey("1")) {
                        processed.put("1", processed.get("1") + data.get(s));
                    } else {
                        processed.put("1", data.get(s));
                    }

                    continue;
                }
                if (s.length() % 2 == 0) {
                    left = s.substring(0, s.length() / 2);
                    right = Long.toString(Long.parseLong(s.substring(s.length() / 2)));

                    if (processed.containsKey(left)) {
                        processed.put(left, data.get(s) + processed.get(left));
                    } else {
                        processed.put(left, data.get(s));
                    }

                    if (processed.containsKey(right)) {
                        processed.put(right, data.get(s) + processed.get(right));
                    } else {
                        processed.put(right, data.get(s));
                    }

                    continue;
                }
                if (processed.containsKey(Long.toString(Long.parseLong(s) * 2024))) {
                    processed.put(Long.toString(Long.parseLong(s) * 2024),
                            data.get(s) + processed.get(Long.toString(Long.parseLong(s) * 2024)));
                } else {
                    processed.put(Long.toString(Long.parseLong(s) * 2024), data.get(s));
                }
            }
            data = new HashMap<>(processed);
            processed.clear();
            System.out.printf("Iteration: %d, took %d ms%n", i, System.currentTimeMillis() - time);
        }

        for (String s : data.keySet()) {
            ans += data.get(s);
        }
        System.out.println(ans);
    }
}
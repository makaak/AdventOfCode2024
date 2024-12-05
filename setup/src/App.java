import java.io.File;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 26; i++) {
            File folder = new File("day" + i);

            folder.mkdirs();
            File input = new File(folder, "input.txt");
            File example = new File(folder, "example.txt");
            File solution = new File(folder, "solution.java");
            input.createNewFile();
            example.createNewFile();
            solution.createNewFile();
            FileWriter fw = new FileWriter(solution);

            fw.write("package day" + i + ";\r\n" + //
                    "\r\n" + //
                    "import java.io.BufferedReader;\r\n" + //
                    "import java.io.File;\r\n" + //
                    "import java.io.FileReader;\r\n" + //
                    "\r\n" + //
                    "public class solution {\r\n" + //
                    "    public static void main(String[] args) throws Exception {\r\n" + //
                    "        File example = new File(\"day" + i + "/example.txt\");\r\n" + //
                    "        File input = new File(\"day" + i + "/input.txt\");\r\n" + //
                    "        BufferedReader exReader = new BufferedReader(new FileReader(example));\r\n" + //
                    "        BufferedReader inReader = new BufferedReader(new FileReader(input));\r\n" + //
                    "        String line;\r\n" + //
                    "        while((line = exReader.readLine()) != null){\r\n" + //
                    "    	 }\r\n" + //
                    "    }\r\n" + //
                    "}");
            fw.close();
        }
    }
}

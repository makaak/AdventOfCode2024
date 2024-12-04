import java.io.File;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 26; i++) {
            File folder = new File("day" + i);

            for (int j = 1; j < 3; j++) {
                File innerFolder = new File(folder, "puzzle" + j);
                innerFolder.mkdirs();
                File input = new File(innerFolder, "input.txt");
                File example = new File(innerFolder, "example.txt");
                File solution = new File(innerFolder, "solution.java");
                input.createNewFile();
                example.createNewFile();
                solution.createNewFile();
                FileWriter fw = new FileWriter(solution);

                fw.write("package day" + i + ".puzzle" + j + ";\r\n" + //
                        "\r\n" + //
                        "import java.io.BufferedReader;\r\n" + //
                        "import java.io.File;\r\n" + //
                        "import java.io.FileReader;\r\n" + //
                        "\r\n" + //
                        "public class solution {\r\n" + //
                        "    public static void main(String[] args) throws Exception {\r\n" + //
                        "        File example = new File(\"example.txt\");\r\n" + //
                        "        File input = new File(\"input\");\r\n" + //
                        "        BufferedReader exReader = new BufferedReader(new FileReader(example));\r\n" + //
                        "        BufferedReader inReader = new BufferedReader(new FileReader(input));\r\n" + //
                        "    }\r\n" + //
                        "}");
                        fw.close();
            }
        }
    }
}

package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class solution {
    public static void main(String[] args) throws Exception {
        File example = new File("day3/example.txt");
        File input = new File("day3/input.txt");
        BufferedReader exReader = new BufferedReader(new FileReader(example));
        BufferedReader inReader = new BufferedReader(new FileReader(input));
        Pattern mulInstruction = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
        Pattern doInstruction = Pattern.compile("do\\(\\)");
        Pattern dontInstruction = Pattern.compile("don't\\(\\)");
        Pattern digits = Pattern.compile("\\d{1,3}");
        Matcher matcherMul, matcherMulDoDont, digitsMatcher;
        String line, match;
        int ansEx = 0;
        int x;
        int y;
        while ((line = exReader.readLine()) != null) {
            matcherMul = mulInstruction.matcher(line);
            while (!matcherMul.hitEnd()) {
                matcherMul.find();
                match = matcherMul.hasMatch() ? matcherMul.group() : null;
                if (match != null) {
                    digitsMatcher = digits.matcher(match);
                    digitsMatcher.find();
                    x = Integer.parseInt(digitsMatcher.group());
                    digitsMatcher.find();
                    y = Integer.parseInt(digitsMatcher.group());
                    ansEx += x * y;
                }
            }
        }
        exReader.close();
        System.out.printf("P1 example answer: %d%n", ansEx);

        int ans = 0;
        while ((line = inReader.readLine()) != null) {
            matcherMul = mulInstruction.matcher(line);
            while (!matcherMul.hitEnd()) {
                matcherMul.find();
                match = matcherMul.hasMatch() ? matcherMul.group() : null;
                if (match != null) {
                    digitsMatcher = digits.matcher(match);
                    digitsMatcher.find();
                    x = Integer.parseInt(digitsMatcher.group());
                    digitsMatcher.find();
                    y = Integer.parseInt(digitsMatcher.group());
                    ans += x * y;
                }
            }
        }
        inReader.close();
        System.out.printf("P1 answer: %d%n", ans);

        exReader = new BufferedReader(new FileReader(example));
        inReader = new BufferedReader(new FileReader(input));

        Pattern mul_do_dont = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)");

        ansEx = 0;
        boolean mulAllowed = true;
        while ((line = exReader.readLine()) != null) {
            matcherMulDoDont = mul_do_dont.matcher(line);
            while (!matcherMulDoDont.hitEnd()) {
                matcherMulDoDont.find();
                if (matcherMulDoDont.hasMatch()) {
                    switch (match = matcherMulDoDont.group()) {
                        case "do()":
                            mulAllowed = true;
                            break;
                        case "don't()":
                            mulAllowed = false;
                            break;
                        default:
                            if (mulAllowed) {
                                digitsMatcher = digits.matcher(match);
                                digitsMatcher.find();
                                x = Integer.parseInt(digitsMatcher.group());
                                digitsMatcher.find();
                                y = Integer.parseInt(digitsMatcher.group());
                                ansEx += x * y;
                            }
                    }
                }
            }
        }
        exReader.close();
        System.out.printf("P2 example answer: %d%n", ansEx);

        ans = 0;
        mulAllowed = true;
        while ((line = inReader.readLine()) != null) {
            matcherMulDoDont = mul_do_dont.matcher(line);
            while (!matcherMulDoDont.hitEnd()) {
                matcherMulDoDont.find();
                if (matcherMulDoDont.hasMatch()) {
                    switch (match = matcherMulDoDont.group()) {
                        case "do()":
                            mulAllowed = true;
                            break;
                        case "don't()":
                            mulAllowed = false;
                            break;
                        default:
                            if (mulAllowed) {
                                digitsMatcher = digits.matcher(match);
                                digitsMatcher.find();
                                x = Integer.parseInt(digitsMatcher.group());
                                digitsMatcher.find();
                                y = Integer.parseInt(digitsMatcher.group());
                                ans += x * y;
                            }
                    }
                }
            }
        }
        inReader.close();
        System.out.printf("P2 answer: %d%n", ans);
    }
}
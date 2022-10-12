package LexicalAnalyzer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

    public static void main(String[] args) {

        String keywords[] = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
                "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null" };
        String operators[] = { "+", "-", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!",
                "&", "|", "^", "~", "<<", ">>", ">>>", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=",
                "<<=", ">>=", ">>>=" };
        String separators[] = { ",", ";", "(", ")", "{", "}", "[", "]" };
        Pattern identifiers = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*");
        Pattern numbers = Pattern.compile("[0-9]+");

        int count = 1;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the code: ");
            String line = "";

            while (scan.hasNext()) {
                line += scan.nextLine() + "\n";

                if (line.contains("end")) {
                    break;
                }
            }

            System.out.println("        ");
            String tksept[] = line.split(" ");

            for (int i = 0; i < tksept.length - 1; i++) {
                System.out.println(tksept[i]);
            }
            System.out.println("\n");

            for (int i = 0; i < tksept.length - 1; i++) {
                int flag = 0;

                for (int j = 0; j < keywords.length; j++) {
                    if (tksept[i].equals(keywords[j])) {
                        System.out.println(tksept[i] + " is a keyword");
                        count++;
                        flag = 1;
                        break;
                    }
                }

                if (flag != 1) {

                    for (int j = 0; j < operators.length; j++) {

                        if (tksept[i].equals(operators[j])) {
                            System.out.println(tksept[i] + " is an operator");
                            count++;
                            flag = 1;
                            break;
                        }
                    }
                }

                if (flag != 1) {

                    for (int j = 0; j < separators.length; j++) {

                        if (tksept[i].equals(separators[j])) {
                            System.out.println(tksept[i] + " is a separator");
                            count++;
                            flag = 1;
                            break;
                        }
                    }
                }

                if (flag != 1) {
                    Matcher match = identifiers.matcher(tksept[i]);

                    if (match.matches()) {
                        System.out.println(tksept[i] + " is an identifier");
                        count++;
                    }
                }

                if (flag != 1) {
                    Matcher match = numbers.matcher(tksept[i]);

                    if (match.matches()) {
                        System.out.println(tksept[i] + " is a number");
                        count++;
                    }
                }
            }
        }
        System.out.println("Total number of tokens: " + count);
    }
}

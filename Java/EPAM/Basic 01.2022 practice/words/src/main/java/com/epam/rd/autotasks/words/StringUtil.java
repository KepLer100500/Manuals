package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {
    private static boolean checkEmptyInput(String str) {
        return str != null && !str.equals("");
    }

    private static boolean checkEmptyInput(String[] str) {
        return str != null && str.length > 0;
    }

    private static boolean checkExpression(String str, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.lookingAt();
    }

    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (!checkEmptyInput(words) || sample == null) {
            return 0;
        }
        return Arrays.stream(words).
                filter(word -> word.trim().equalsIgnoreCase(sample.trim())).
                toArray().length;
    }

    public static String[] splitWords(String text) {
        if (!checkEmptyInput(text)) {
            return null;
        }
        String[] solution = Arrays.stream(text.split(",|\\.|\\;|\\:|\\s|\\?|\\!")).
                filter(i -> !i.isEmpty()).
                toArray(String[]::new);
        return solution.length == 0 ? null : solution;
    }

    public static String convertPath(String path, boolean toWin) {
        // ^(C:\\|\\|\.\\|\.\.\\|\w+\.*\w*|\.)(?!.*C:)(?!.*\/)(?!.*\~) - Windows pattern
        // ^(C:\\|\\|\.\\|\.\.\\|\w+\.*\w*|\.) -> begin with C: or \ or .\ or ..\ or file or file.txt
        // (?!.*C:)(?!.*\/)(?!.*\~) -> not contain in middle C: or / or ~
        // ^(\~|\/|\.\/|\.\.\/|\w+\.+\w*|\w+\/|\.)(?!.*\~)(?!.*\\)(?!.*C:) - Unix pattern
        if (!checkEmptyInput(path)) {
            return null;
        }
        String regWinPattern = "^(C:\\\\|\\\\|\\.\\\\|\\.\\.\\\\|\\w+\\.*\\w*|\\.)(?!.*C:)(?!.*\\/)(?!.*\\~)";
        String regUnixPattern = "^(\\~|\\/|\\.\\/|\\.\\.\\/|\\w+\\.+\\w*|\\w+\\/|\\.)(?!.*\\~)(?!.*\\\\)(?!.*C:)";
        if (checkExpression(path, regWinPattern)) { // if windows path
            if (toWin) {
                return path;
            } else {
                return path.
                        replace("C:\\User", "~").
                        replace("C:\\", "/").
                        replace("\\", "/");
            }
        }
        if (checkExpression(path, regUnixPattern)) {
            if (!toWin) { // if unix path
                return path;
            } else {
                return path.
                        replaceAll("^/", "C:\\\\").
                        replace("~", "C:\\User").
                        replace("/", "\\");
            }
        }
        return null;
    }

    public static String joinWords(String[] words) {
        if (!checkEmptyInput(words) || Arrays.stream(words).filter(word -> !word.equals("")).toArray().length == 0) {
            return null;
        }
        return "[" +
                String.join(", ",
                        Arrays.stream(words).filter(word -> !word.equals("")).toArray(String[]::new)) +
                "]";
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}
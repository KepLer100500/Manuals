import java.util.regex.*;
import java.util.*;


class RegularExpression {
    private static void fullMatch(Pattern pat, Matcher mat) {
        boolean found;
        pat = Pattern.compile("^Some text(.+)a$");
        String sourceStr = "Some texttttttttttta";
        mat = pat.matcher(sourceStr);
        found = mat.matches();
        System.out.println("Founded: " + found);
    }

    private static void allMatch(Pattern pat, Matcher mat) {
        boolean found;
        pat = Pattern.compile("Some text");
        String sourceStr = "Some text www Some text fff Some text";
        mat = pat.matcher(sourceStr);
        found = mat.find();
        System.out.println("Founded: " + found);
    }

    private static void findAllMatches(Pattern pat, Matcher mat) {
        pat = Pattern.compile("Some text");
        String sourceStr = "Some text www Some text fff Some text";
        mat = pat.matcher(sourceStr);
        while(mat.find()) {
            System.out.println("Founded in indexes: start: " + mat.start() + " end: " + mat.end());
        }
    }

    private static void findGroupsMatches(Pattern pat, Matcher mat) {
        pat = Pattern.compile("W+");
        String sourceStr = "W WW WWW";
        mat = pat.matcher(sourceStr);
        while(mat.find()) {
            System.out.println("Founded: " + mat.group());
        }
    }

    private static void replaceMatches(Pattern pat, Matcher mat) {
        pat = Pattern.compile("[a-zA-Z]");
        String sourceStr = "123Some123text123";
        mat = pat.matcher(sourceStr);
        String replStr = mat.replaceAll("w"); // anymatch
        System.out.println("str original: " + sourceStr);
        System.out.println("str replaced: " + replStr);
    }

    private static void splitMatches(Pattern pat, Matcher mat) {
        pat = Pattern.compile("[ .,!]");
        String sourceStr = "one two,three.four!five";
        String[] pices = pat.split(sourceStr);
        Arrays.stream(pices).forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("===Run===");
        Pattern pat = null;
        Matcher mat = null;

        fullMatch(pat, mat);
        allMatch(pat, mat);
        findAllMatches(pat, mat);
        findGroupsMatches(pat, mat);
        replaceMatches(pat, mat);
        splitMatches(pat, mat);
    }
}
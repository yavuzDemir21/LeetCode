package PalantirPrep;

import java.util.ArrayList;
import java.util.HashSet;

public class TypoSquating {
    public static void main(String[] args) {

        String[] strings = {"googl", "gooogle", "ogogle", "gookle", "google", "ggle"};
        String target = "google";


        findLevDist("google", "ogogle");
        //generateTypoSquats(target);

        //System.out.println(target.substring(0,5));

        //findTypoSquats(strings, target);

    }


    private static void findTypoSquats(String[] strings, String target) {
        for (String s : strings) {
            System.out.println(checkStringsTypoSquat(s, target));
        }

    }

    private static boolean checkStringsTypoSquat(String s1, String s2) {

        if (Math.abs(s1.length() - s2.length()) > 1) return false;
        boolean result = false;
        switch (s1.length() - s2.length()) {
            case 1:
                result = caseOne(s1, s2);
                break;
            case 0:
                result = caseEqual(s1, s2);
                break;
            case -1:
                result = caseOne(s2, s1);
                break;
        }

        return result;

    }

    private static boolean caseOne(String s1, String s2) {

        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (j < s2.length() && s1.charAt(i) != s2.charAt(j)) {
                j--;
                if (i - j > 1) return false;
            }
            j++;
        }

        return true;
    }


    private static boolean caseEqual(String s1, String s2) {

        int found = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (found == -1) {
                    found = i;
                } else {
                    if (found != i - 1) return false;
                    else {
                        if (!(s1.charAt(i - 1) == s2.charAt(i) && s1.charAt(i) == s2.charAt(i - 1))) return false;
                    }
                }
            }
        }
        return found != -1;

    }


    private static void generateTypoSquats(String word) {
        ArrayList<String> typos = new ArrayList<>();

        findMissings(word, typos);
        findExtras(word, typos);
        findSwitches(word, typos);
        findMistakes(word, typos);

        HashSet<String> set = new HashSet<>(typos);

        System.out.println(set.size() + "  " + typos.size());

        //typos.forEach(System.out::println);

    }

    private static void findMissings(String word, ArrayList<String> typo) {
        for (int i = 0; i < word.length(); i++) {
            if (i == 0 || word.charAt(i) != word.charAt(i - 1)) {
                typo.add(word.substring(0, i) + word.substring(i + 1));
            }
        }
    }

    private static void findExtras(String word, ArrayList<String> typos) {
        for (int i = 0; i <= word.length(); i++) {
            for (int k = 0; k < 26; k++) {
                if (i == 0 || word.charAt(i - 1) != (char) ('a' + k))
                    typos.add(word.substring(0, i) + (char) ('a' + k) + word.substring(i));
            }
        }
    }

    private static void findSwitches(String word, ArrayList<String> typos) {
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(i - 1)) {
                typos.add(word.substring(0, i - 1) + word.charAt(i) + word.charAt(i - 1) + word.substring(i + 1));
            }

        }
    }

    private static void findMistakes(String word, ArrayList<String> typos) {
        for (int i = 0; i < word.length(); i++) {
            for (int k = 0; k < 26; k++) {
                if ('a' + k != word.charAt(i)) {
                    typos.add(word.substring(0, i) + (char) ('a' + k) + word.substring(i + 1));
                }
            }
        }
    }

    private static int customMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private static void findLevDist(String s1, String s2) {

        int[][] m = new int[s1.length() + 1][s2.length() + 1];


        for (int i = 0; i < m.length; i++) {
            m[i][0] = i;
        }
        for (int i = 0; i < m[0].length; i++) {
            m[0][i] = i;
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {

                m[i][j] = customMin(m[i][j - 1] + 1,
                        m[i - 1][j] + 1,
                        m[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 :
                                i > 1 && j > 1 && s1.charAt(i - 2) == s2.charAt(j - 1) && s1.charAt(i - 1) == s2.charAt(j - 2) ?
                                        0 : 1));


            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }


    }

}

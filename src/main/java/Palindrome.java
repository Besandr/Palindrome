import java.util.ArrayList;
import java.util.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        long maxPalindrome = 0;
        long palindromeCandidate;
        long firstMaxMultiplier = 0;
        long secondMaxMultiplier = 0;
        ArrayList<Integer> prestoFiveDigitNumbers = simpleNumbersFinderFromTo(10000, 99999);

        long startTime = System.currentTimeMillis();

        for (int i = prestoFiveDigitNumbers.size() - 1; i >= 0 ; i--) {
            for (int j = i - 1; j >= 0 ; j--) {
                palindromeCandidate = (long) prestoFiveDigitNumbers.get(i) * prestoFiveDigitNumbers.get(j);
                if (palindromeCandidate > maxPalindrome) {
                    if (isPalindrome(String.valueOf(palindromeCandidate))) {
                        maxPalindrome = palindromeCandidate;
                        firstMaxMultiplier = prestoFiveDigitNumbers.get(i);
                        secondMaxMultiplier = prestoFiveDigitNumbers.get(j);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(maxPalindrome);
        System.out.println(firstMaxMultiplier);
        System.out.println(secondMaxMultiplier);
    }

    public static ArrayList<Integer> simpleNumbersFinderFromTo(int from, int to) {

        ArrayList<Integer> list = new ArrayList<>();
        boolean[] presto = new boolean[to + 1];
        Arrays.fill(presto, true);
        presto[0] = false;
        presto[1] = false;
        for (int i = 2; i * i <= to; i++) {
            if (presto[i]) {
                for (int j = i * i; j <= to; j += i) {
                    presto[j] = false;
                }
            }
        }
        for (int i = from; i <= to; i++) {
            if (presto[i]) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isPalindrome(String palindromeCandidate) {
        if (palindromeCandidate.length() == 1 || palindromeCandidate.length() == 0) {
            return true;
        } else if (palindromeCandidate.charAt(0) == palindromeCandidate.charAt(palindromeCandidate.length() - 1)) {
            return isPalindrome(palindromeCandidate.substring(1, palindromeCandidate.length() - 1));
        } else {
            return false;
        }
    }
}

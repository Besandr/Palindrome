import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PalindromeTest {
    @Test
    public void isPalindromeTest() {
        Assert.assertTrue(Palindrome.isPalindrome("332233"));
    }

    @Test
    public void testSimpleNumbersSeeker() {
        ArrayList<Integer> list = Palindrome.simpleNumbersFinderFromTo(10000, 99999);
        Assert.assertTrue(list.get(0) == 10007
                && list.get(list.size() - 1) == 99991);
    }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PalindromeTest {
    Palindrome testPal;

    @Before
    public void setUp() {
        testPal = new Palindrome();
    }

    @Test
    public void isPalindromeTest() {
        Assert.assertTrue(testPal.isPalindrome("332212233"));
    }

    @Test
    public void isPalindromeFalseTest() {
        Assert.assertFalse(testPal.isPalindrome("9998200081"));
    }

    @Test
    public void testSimpleNumbersSeeker() {
        ArrayList<Integer> list = testPal.simpleNumbersFinderFromTo(10000, 99999);
        Assert.assertTrue(list.get(0) == 10007
                && list.get(list.size() - 1) == 99991);
    }
}

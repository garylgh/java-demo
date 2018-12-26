package in.ghlin.leetcode;

import com.ghlin.leetcode.LongestSubstring;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * LongestSubstring Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11/30/2018</pre>
 */
public class LongestSubstringTest extends TestCase {
    public LongestSubstringTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }


    public static Test suite() {
        return new TestSuite(LongestSubstringTest.class);
    }

    @org.junit.Test
    public void testLengthOfLongestSubstring() {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        Assert.assertTrue(LongestSubstring.lengthOfLongestSubstring(s1) == 3);
        Assert.assertTrue(LongestSubstring.lengthOfLongestSubstring(s2) == 1);
        Assert.assertTrue(LongestSubstring.lengthOfLongestSubstring(s3) == 3);
    }

    @org.junit.Test
    public void testLengthOfLongestSubstringWithWhile() throws Exception {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        Assert.assertTrue(LongestSubstring.lengthOfLongestSubstringWithWhile(s1) == 3);
        Assert.assertTrue(LongestSubstring.lengthOfLongestSubstringWithWhile(s2) == 1);
        Assert.assertTrue(LongestSubstring.lengthOfLongestSubstringWithWhile(s3) == 3);
    }

} 

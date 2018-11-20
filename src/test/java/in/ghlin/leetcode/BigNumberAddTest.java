package in.ghlin.leetcode;

import com.ghlin.leetcode.BigNumberAdd;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * BigNumberAdd Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十一月 15, 2018</pre>
 */
public class BigNumberAddTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(String s1, String s2)
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println(BigNumberAdd.add("12222", "8833"));
//        Assert.assertTrue(BigNumberAdd.add("22222222222222", "33333333333333").equals("55555555555555"));
    }

    /**
     * Method: stringContainNAN(String s)
     */
    @Test
    public void testtringIsNotInt() throws Exception {
        Assert.assertTrue(BigNumberAdd.stringIsNotInt("123123123S"));
        Assert.assertTrue(BigNumberAdd.stringIsNotInt(" 123123123"));
        Assert.assertTrue(BigNumberAdd.stringIsNotInt("12s3123123S"));
        Assert.assertFalse(BigNumberAdd.stringIsNotInt("123"));
        Assert.assertTrue(BigNumberAdd.stringIsNotInt(""));
        Assert.assertTrue("123.123123不是整数", BigNumberAdd.stringIsNotInt("123.123123"));
    }

    @Test
    public void testReverseArray() {
//        char[] chs1 = "abcdef".toCharArray();
//        String t1 = "fedcba";
//        BigNumberAdd.reverseArray(chs1);
//        String reverseStr = String.valueOf(chs1);
//        Assert.assertTrue(reverseStr.equals(t1));


        char[] chs2 = "xyza".toCharArray();
        String t2 = "azyx";
        BigNumberAdd.reverseArray(chs2);
        String reverseStr2 = String.valueOf(chs2);
        Assert.assertTrue(reverseStr2.equals(t2));
    }

}

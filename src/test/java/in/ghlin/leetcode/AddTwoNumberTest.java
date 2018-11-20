package in.ghlin.leetcode;

import com.ghlin.leetcode.AddTwoNumber;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* AddTwoNumber Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 20, 2018</pre> 
* @version 1.0 
*/ 
public class AddTwoNumberTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addTwoNumbers(ListNode l1, ListNode l2) 
* 
*/ 
@Test
public void testAddTwoNumbers() throws Exception {
    AddTwoNumber.ListNode l3 = AddTwoNumber.buildList(new int[] {1, 2, 3});
    AddTwoNumber.ListNode l4 = AddTwoNumber.buildList(new int[] {4, 5, 7, 7});

    AddTwoNumber.ListNode currNode = AddTwoNumber.addTwoNumbers(l3, l4);

    while (currNode != null) {
        System.out.println(currNode.getVal());
        currNode = currNode.getNext();
    }
} 

/** 
* 
* Method: buildList(int[] nums) 
* 
*/ 
@Test
public void testBuildList() throws Exception {
    AddTwoNumber.ListNode listNode = AddTwoNumber.buildList(new int[]{1, 2, 3});
    AddTwoNumber.ListNode currNode = listNode;
    while (currNode != null) {
        System.out.println(currNode.getVal());
        currNode = currNode.getNext();
    }
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


} 

package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {

    @Test
    public void canAddTwoNumbers() {
        int x = 2;
        int y = 3;

        int sum = x + y;

//        assertTrue(sum==5);
//        assertFalse(sum<0);

    }

    @Test
    public void checkIfStringContainsSubstring(){
        String s1 = "Ana are mere";
        String s2 = "mere";

//        assertTrue(s1.contains(s2));
        assertEquals(s1,s2);


    }
}

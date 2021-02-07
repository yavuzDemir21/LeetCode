package CTCI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestDifferenceTest {

    Smallest_Difference sd = new Smallest_Difference();

    @Test
    public void findDifferenceTest(){

        int[] arr1 = {1, 3, 15, 11, 2};
        int[] arr2 = {23, 127,235, 19, 8};

        int result = sd.findSmallestDifference(arr1, arr2);

        assertEquals(3, result);

    }

    @Test
    public void findDifferenceTest2(){

        int[] arr1 = {1, 3, 15, 11, 2};
        int[] arr2 = {23, 127,235, 19};

        int result = sd.findSmallestDifference(arr1, arr2);

        assertEquals(4, result);

    }

    @Test
    public void findDifferenceTest3(){

        int[] arr1 = {1, 3, 15, 11, 2, 19};
        int[] arr2 = {23, 127,235, 19};

        int result = sd.findSmallestDifference(arr1, arr2);

        assertEquals(0, result);

    }


}
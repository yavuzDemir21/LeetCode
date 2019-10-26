package Medium;

import java.util.*;

public class Gray_Code {
    public static void main(String[] args) {

        System.out.println(grayCode(3));
    }

    private static List<Integer> grayCode(int n) {

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;

    }
}

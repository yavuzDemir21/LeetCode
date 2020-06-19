package DailyChallenges;

/*

Input: [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.

8 7 4 2 1 1

1 4 2 1 1

4 2 1 1 1


5 4 3 2 2 2

3 2 1 2 2
1 1 2 2

 */



public class Last_Stone_Weight {
    public static void main(String[] args) {
        int[] arr = {8,7,4,2,1,1,1,1};

        System.out.println(lastStoneWeight(arr));

    }

    public static int lastStoneWeight(int[] stones) {

        int[] buckets = new int[1001];
        for (int i = 0; i < stones.length; i++) {
            buckets[stones[i]]++;
        }

        int slow = buckets.length - 1;   //start from the big to small
        while (slow > 0) {
            // If the number of stones with the same size is even or zero,
            // these stones can be totally destroyed pair by pair or there is no such size stone existing,
            // we can just ignore this situation.

            // When the number of stones with the same size is odd,
            // there should leave one stone which is to smash with the smaller size one.
            if (buckets[slow]%2 != 0) {
                int fast = slow - 1;
                while (fast > 0 && buckets[fast] == 0) {
                    fast--;
                }
                if (fast == 0) break;
                buckets[fast]--;
                buckets[slow - fast]++;
            }
            slow--;
        }
        return slow;

    }
}

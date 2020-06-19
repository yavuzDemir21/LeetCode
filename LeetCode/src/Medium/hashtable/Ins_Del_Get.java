package Medium.hashtable;

import java.util.HashSet;
import java.util.Random;

class RandomizedSet {

    /** Initialize your data structure here. */
    HashSet<Integer> randomizedSet;
    public RandomizedSet() {

        randomizedSet = new HashSet<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return this.randomizedSet.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return this.randomizedSet.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int random = rand.nextInt(this.randomizedSet.size());
        return (int)this.randomizedSet.toArray()[random];
    }
}


public class Ins_Del_Get {
    public static void main(String[] args) {

        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

// Returns false as 2 does not exist in the set.
        randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());

// Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

// 2 was already in the set, so return false.
        randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
        System.out.print(randomSet.getRandom());

    }
}

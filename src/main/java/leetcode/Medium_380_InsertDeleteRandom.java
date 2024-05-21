package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class Medium_380_InsertDeleteRandom {

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();

        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        int random = randomizedSet.getRandom();// Since 2 is the only number in the set, getRandom() will always return 2.
        System.out.println(random == 2);
    }

    static class RandomizedSet {

        private static final int BUCKET_SIZE = 1000;

        private Random random = new Random();

        private Map<Integer, List<Integer>> buckets;

        public RandomizedSet() {
            this.buckets = new HashMap<>();
        }

        public boolean insert(int val) {
            int bucket = val % BUCKET_SIZE;
            List<Integer> values = buckets.get(bucket);
            if (values == null) {
                buckets.put(bucket, new ArrayList<>(List.of(val)));
                return true;
            }
            for (Integer existed : values) {
                if (existed.equals(val)) {
                    return false;
                }
            }
            values.add(val);
            return true;
        }

        public boolean remove(int val) {
            int bucket = val % BUCKET_SIZE;
            List<Integer> values = buckets.get(bucket);
            if (values == null) {
                return false;
            }
            for (int i = 0; i < values.size(); i++) {
                Integer existed = values.get(i);
                if (existed.equals(val)) {
                    if (values.size() == 1) {
                        buckets.remove(bucket);
                        return true;
                    }
                    int lastIndex = values.size() - 1;
                    values.set(i, values.get(lastIndex));
                    values.remove(lastIndex);
                    return true;
                }
            }
            return false;
        }

        public int getRandom() {
            int randomBucket = random.nextInt(buckets.size());
            List<Integer> values = buckets.get(buckets.keySet().toArray()[randomBucket]);
            return values.get(random.nextInt(values.size()));
        }
    }
}

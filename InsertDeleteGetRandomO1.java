/**
 * LeetCode 380 Insert Delete GetRandom O(1)
 */
class RandomizedSet {

    private Map<Integer,Integer> container;

    private List<Integer> list;

    private int cur;

    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        container = new HashMap<>();
        list = new ArrayList<>();
        cur = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (container.containsKey(val)) {
            return false;
        }

        list.add(val);
        container.put(val,cur);
        cur++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!container.containsKey(val)) {
            return false;
        }

        int tempC = list.get(cur - 1);
        int index = container.get(val);
        list.set(index,tempC);
        list.remove(cur - 1);
        container.put(tempC,index);
        container.remove(val);
        cur--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(cur);
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

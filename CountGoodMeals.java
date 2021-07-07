/**
 * LeetCode 1711 Count Good Meals
 */
class Solution {
    int mod = (int) 1e9 + 7;
    int max = 1 << 22;

    public int countPairs(int[] deliciousness) {
        if (deliciousness == null || deliciousness.length == 0) {
            return 0;
        }
        Map<Integer,Integer> container = new HashMap<>();
        for (int i : deliciousness) {
            container.put(i,container.getOrDefault(i,0) + 1);
        }
        long res = 0;
        for (Integer key : container.keySet()) {
            for (int i = 1;i < max; i <<= 1) {
                if (i < key) {
                    continue;
                }
                int curDiff = i - key;
                if (container.containsKey(curDiff)) {
                    if (curDiff == key) {
                        res += (container.get(curDiff) - 1) * 1L * container.get(curDiff);
                    } else {
                        res += container.get(key) * 1L * container.get(curDiff);
                    }
                }
            }
        }
        res >>= 1;
        return (int) (res % mod);
    }
}

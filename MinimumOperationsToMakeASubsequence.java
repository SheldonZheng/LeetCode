/**
 * LeetCode 1713 Minimum Operations to Make a Subsequence
 */
class Solution {
    public int minOperations(int[] target,int[] arr) {
        if (target == null || target.length == 0 || arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            container.put(target[i],i);
        }
        List<Integer> maxLen = new ArrayList<>();
        for (int j : arr) {
            if (container.containsKey(j)) {
                int curVal = container.get(j);
                if (maxLen.size() == 0 || maxLen.get(maxLen.size() - 1) < curVal) {
                    maxLen.add(curVal);
                    continue;
                }
                int nextPos = binarySearch(maxLen,curVal);
                maxLen.set(nextPos,curVal);

            }
        }
        return target.length - maxLen.size();

    }

    public int binarySearch(List<Integer> maxLen,int target) {
        int l = 0,r = maxLen.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (maxLen.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

/**
 * LeetCode 118 Pascal's Triangle
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) {
            return res;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(cur);
        }
        return res;
    }
}

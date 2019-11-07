/**
 * LeetCode 118 Pascal's Triangle
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }

        //init
        List<Integer> rowOne = new ArrayList<>();
        rowOne.add(1);
        res.add(rowOne);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> pre = res.get(i - 1);

            cur.add(1);

            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}

/**
 * LeetCode 119 Pascal's Triangle II
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        //init
        List<Integer> rowOne = new ArrayList<>();
        rowOne.add(1);
        res.add(rowOne);
        if (rowIndex < 1) {
            return rowOne;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> pre = res.get(i - 1);

            cur.add(1);

            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res.get(rowIndex);
    }
}

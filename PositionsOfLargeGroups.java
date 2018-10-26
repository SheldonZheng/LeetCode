//LeetCode 830
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length() == 0 || S.length() < 3) {
            return res;
        }
        char[] list = S.toCharArray();
        char p = list[0];
        int s = 0;
        int c = 0;
        for (int i = 0; i < list.length; i++) {
            if (p == list[i]) {
                c++;
            } else {
                p = list[i];
                if (c >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(s);
                    temp.add(i - 1);
                    res.add(temp);
                }
                c = 1;
                s = i;
            }
        }
        if (c >= 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(s);
            temp.add(list.length - 1);
            res.add(temp);
        }
        return res;
    }
}

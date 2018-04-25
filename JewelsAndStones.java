//https://leetcode-cn.com/problems/jewels-and-stones/description/
class Solution {
      public int numJewelsInStones(String J, String S) {
        if (J == null || S == null)
            return 0;
        int count = 0;
        for (char s : S.toCharArray()) {
            for (char c : J.toCharArray()) {
                if (s == c)
                    count++;
            }
        }
        return count;

    }
}

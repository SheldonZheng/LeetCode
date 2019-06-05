//LeetCode 522
class Solution {
    public int findLUSlength(String[] strs) {
        int result = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isSub = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSub(strs[i],strs[j])) {
                    isSub = false;
                    break;
                }
            }
            if (isSub) {
                result = Math.max(result,strs[i].length());
            }
        }
        return result;
    }

    public boolean isSub(String a ,String b) {
        if (a.length() > b.length()) {
            return false;
        }
        if (a.equals(b)) {
            return true;
        }

        int pos = 0;
        for (int i = 0; i < b.length(); i++) {
            if (pos == a.length()) {
                break;
            }
            if (a.charAt(pos) == b.charAt(i)) {
                pos++;
            }
        }

        return pos == a.length();
    }
}

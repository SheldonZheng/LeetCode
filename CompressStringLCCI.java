/**
 * LeetCode Interview 01.06 Compress String LCCI
 */
class Solution {
    public String compressString(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Character c = null;
        for (Character s : S.toCharArray()) {
            if (c == null) {
                c = s;
                count++;
                continue;
            }
            if (c == s) {
                count++;
                continue;
            }
            sb.append(c);
            sb.append(count);
            c = s;
            count = 1;
        }
        sb.append(c);
        sb.append(count);
        if (sb.length() >= S.length()) {
            return S;
        } else {
            return sb.toString();
        }
    }
}

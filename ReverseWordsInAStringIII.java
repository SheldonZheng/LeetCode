//LeetCode 557
class Solution {
     public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String []splited = s.split(" ");
        for (String s1 : splited) {
            String reverse = "";
            for (int i = s1.toCharArray().length - 1; i >= 0; i--) {
                reverse = reverse + s1.charAt(i);
            }
            sb.append(reverse);
            sb.append(" ");
        }
        sb.delete(sb.length() - 1,sb.length());
        return sb.toString();
    }
}

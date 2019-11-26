/**
 * LeetCode 76 Minimum Window Substring
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> tContainer = new HashMap<>();

        char[] ta = t.toCharArray();

        for (int i = 0; i < ta.length; i++) {
            int count = tContainer.getOrDefault(ta[i], 0);
            tContainer.put(ta[i], count + 1);
        }

        int req = tContainer.size();

        int l = 0;
        int r = 0;

        int minLength = -1;
        int lastL = 0;
        int lastR = 0;

        int curLength = 0;

        HashMap<Character, Integer> windowsContainer = new HashMap<>();
        char[] sa = s.toCharArray();
        while (r < sa.length) {
            char c = sa[r];
            int count = windowsContainer.getOrDefault(c, 0);
            windowsContainer.put(c, count + 1);

            if (tContainer.containsKey(c) && windowsContainer.get(c).equals(tContainer.get(c))) {
                curLength++;
            }

            while (l <= r && curLength == req) {
                if (minLength == -1 || (r - l + 1) < minLength) {
                    minLength = r - l + 1;
                    lastL = l;
                    lastR = r;
                }

                c = sa[l];
                windowsContainer.put(c, windowsContainer.get(c) - 1);
                if (tContainer.containsKey(c) && windowsContainer.get(c).compareTo(tContainer.get(c)) < 0) {
                    curLength--;
                }
                l++;
            }

            r++;

        }
        return minLength == -1 ? "" : s.substring(lastL, lastR + 1);
    }
}

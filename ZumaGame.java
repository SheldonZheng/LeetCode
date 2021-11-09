/**
 * LeetCode 488 Zuma Game
 */
class Solution {
    private Map<Character,Integer> container = new HashMap<>();

    char[] colors = {'R','Y','B','G','W'};


    public int findMinStep(String board, String hand) {
        if (board == null || hand == null) {
            return 0;
        }
        for (char c : hand.toCharArray()) {
            container.put(c,container.getOrDefault(c,0) + 1);
        }
        return dfs(board);
    }

    private int dfs(String s) {
        if ("".equals(s)) {
            return 0;
        }
        int res = 2 * s.length() + 1;
        for (int i = 0; i < s.length();) {
            char cur = s.charAt(i);
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == cur) {
                j++;
            }
            int num = 3 - (j - i);
            Integer cnt = container.get(cur);
            if (cnt != null && cnt >= num) {
                String newStr = eliminate(s.substring(0,i) + s.substring(j));
                container.put(cur,cnt - num);
                int r = dfs(newStr);
                container.put(cur,container.get(cur) + num);
                if (r != -1) {
                    res = Math.min(res,r + num);
                }

            }
            if ((j - i) == 2) {
                for (char color : colors) {
                    if (cur == color) {
                        continue;
                    }
                    if (container.getOrDefault(color,0) > 0) {
                        String newStr = eliminate(s.substring(0,i + 1) + color + s.substring(i + 1));
                        container.put(color,container.get(color) - 1);
                        int r = dfs(newStr);
                        container.put(color,container.get(color) + 1);
                        if (r != -1) {
                            res = Math.min(res,r + 1);
                        }
                    }
                }
            }
            i = j;
        }

        return res == 2 * s.length() + 1 ? -1 : res;
    }

    private String eliminate(String s) {
        for (int i = 0; i < s.length();) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                s = s.substring(0,i) + s.substring(j);
                i = 0;
            } else {
                i++;
            }
        }
        return s;
    }
}

/**
 * LeetCode 1160 Find Words That Can Be Formed by Characters
 */
class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> container = new HashMap<>();
        for (char c : chars.toCharArray()) {
            container.put(c,container.getOrDefault(c,0) + 1);
        }
        int res = 0;
        for (String word : words) {
            Map<Character,Integer> temp = new HashMap<>();
            temp.putAll(container);
            if (containes(temp,word)) {
                res += word.length();
            }
        }
        return res;
    }

    public boolean containes(Map<Character,Integer> container, String word) {
        for (char c : word.toCharArray()) {
            if (container.getOrDefault(c,0) == 0) {
                return false;
            } else {
                container.put(c,container.get(c) - 1);
            }
        }
        return true;
    }
}

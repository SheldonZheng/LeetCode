/**
 * LeetCode 451 Sort Characters By Frequency
 */
class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Map<Character,Integer> container = new TreeMap<>();
        for (char c : s.toCharArray()) {
            Integer count = container.getOrDefault(c, 0);
            container.put(c,count + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(container.entrySet());
        Collections.sort(list,Comparator.comparing(Map.Entry::getValue));
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (Integer i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}

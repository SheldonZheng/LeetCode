// leetcode 500
class Solution {
  public String[] findWords(String[] words) {
        int length = words.length;
        List<String> results = new ArrayList<String>(); 
        char[] row1 = new char[]{'q','w','e','r','t','y','u','i','o','p'};  
        char[] row2 = new char[]{'a','s','d','f','g','h','j','k','l'};  
        char[] row3 = new char[]{'z','x','c','v','b','n','m'};
        Map<Character, Integer>map = new HashMap<Character, Integer>();
        for (int i = 0; i < 10; i++)
            map.put(row1[i], 1);
        for (int i = 0; i < 9; i++)
            map.put(row2[i], 2);
        for (int i = 0; i < 7; i++)
            map.put(row3[i], 3);
        int row = 0;
        for (int i = 0; i < length; i++) {
            String word = words[i].toLowerCase();
            int len = word.length(), j = 0, flag = 0;
            for (; j < len; j++) {
                if (flag == 0) {
                    row = map.get(word.charAt(j));
                    flag = 1;
                }
                else {
                    if (map.get(word.charAt(j)) != row) {
                        break;
                    }
                }
            }
            if (j == len) 
                results.add(words[i]);
        }
        int size = results.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) 
            result[i] = results.get(i);
        return result;
    }
}

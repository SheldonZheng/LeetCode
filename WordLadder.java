/**
 * LeetCode 127 Word Ladder
 */
import javafx.util.Pair;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }
        int l = endWord.length();

        Map<String,List<String>> container = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0,i).concat("*").concat(word.substring(i + 1,l));
                List<String> mayStrs = container.getOrDefault(newWord,new ArrayList<>());
                mayStrs.add(word);
                container.put(newWord,mayStrs);
            }
        }

        //integer for level
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord,1));

       Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String,Integer> cur = queue.poll();
            String word = cur.getKey();
            int level = cur.getValue();

            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0,i).concat("*").concat(word.substring(i + 1,l));
                List<String> canReachStrs = container.get(newWord);
                if (canReachStrs == null || canReachStrs.size() == 0) {
                    continue;
                }
                for (String canReachStr : canReachStrs) {
                    if (canReachStr.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.contains(canReachStr)) {
                        visited.add(canReachStr);
                        queue.add(new Pair<>(canReachStr,level + 1));
                    }
                }
            }
        }
        return 0;
    }
}

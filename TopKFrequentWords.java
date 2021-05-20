/**
 * LeetCode 692 Top K Frequent Words
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || words.length < k) {
            return null;
        }
        List<Map.Entry<String, Long>> collect = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < collect.size() && i < k; i++) {
            result.add(collect.get(i).getKey());
        }
        return result;
    }
}

/** 
 * LeetCode 229 Majority Element II
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int size = nums.length / 3;
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > size)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }
}

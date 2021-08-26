/**
 * LeetCode 881 Boats to Save People
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }
        int res = 0;
        Arrays.sort(people);
        int left = 0,right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            res++;
        }
        return res;
    }
}

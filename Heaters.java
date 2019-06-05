//LeetCode 475
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || heaters == null) {
            return 0;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int r = 0;
        int j = 0;
        for (int house : houses) {
            while (j < heaters.length - 1 && Math.abs(heaters[j + 1] - house) <= Math.abs(heaters[j] - house)) {
                j++;
            }
            r = Math.max(r,Math.abs(heaters[j] - house));
        }
        return r;

    }
}

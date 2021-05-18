/**
 * LeetCode 1109 Corporate Flight Bookings
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if (bookings == null || bookings.length == 0 || n == 0) {
            return null;
        }
        int[] answer = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            answer[bookings[i][0] - 1] += bookings[i][2];
            if (bookings[i][1] < n) {
                answer[bookings[i][1]] -= bookings[i][2];
            }
        }
        for (int i = 1; i < answer.length; i++) {
            answer[i] += answer[i - 1];
        }
        return answer;
    }
}

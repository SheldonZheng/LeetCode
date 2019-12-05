/**
 * LeetCode 207 Course Schedule
 */
class Solution {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return true;
        }
        int[][] adjacency = new int[numCourses][numCourses];
        //canReach?
        for (int[] couple : prerequisites) {
            adjacency[couple[1]][couple[0]] = 1;
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(numCourses,adjacency,flags,i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int numCourses,int[][] adjacency,int[] flags,int i) {
        if (flags[i] == -1) {
            return true;
        }
        if (flags[i] == 1) {
            return false;
        }

        flags[i] = 1;
        for (int j = 0; j < adjacency.length; j++) {
            if (adjacency[i][j] == 1 && ! dfs(numCourses, adjacency, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}

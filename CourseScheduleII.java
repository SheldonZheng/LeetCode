/**
 * LeetCode 210 Course Schedule II
 */
class Solution {
    private Stack<Integer> container;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) {
            return new int[0];
        }
        container = new Stack<Integer>();
        int[][] adjacency = new int[numCourses][numCourses];
        //canReach?
        for (int[] couple : prerequisites) {
            adjacency[couple[1]][couple[0]] = 1;
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(numCourses,adjacency,flags,i)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = container.pop();
        }
        return result;
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
        container.add(i);
        return true;
    }
}

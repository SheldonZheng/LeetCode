//LeetCode 207
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return false;
        }

        int []vis = new int[numCourses];

        //初始化 存放 前置条件的地方
        //将访问某个数的先决条件放到这里来
        Map<Integer,ArrayList<Integer>> container = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (container.containsKey(prerequisites[i][1])) {
                container.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(prerequisites[i][0]);
                container.put(prerequisites[i][1],t);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            //如果访问某个数的时候，发现它的先决条件已经被访问过了 就是有环
            if (!dfs(container,vis,i)) {
                return false;
            }
        }
        return true;

    }

    private boolean dfs(Map<Integer,ArrayList<Integer>> container,int []vis ,int i) {
        //还没访问结束
        if (vis[i] == -1) {
            return false;
        }
        //访问结束
        if (vis[i] == 1) {
            return true;
        }

        //开始访问 (进入递归链)
        vis[i] = -1;
        //如果有值没有任何先决条件，就不会走到这里的if里面
        if (container.containsKey(i)) {
            ArrayList<Integer> t = container.get(i);
            for (Integer integer : t) {
                if (!dfs(container,vis,integer)) {
                    return false;
                }
            }
        }

        //访问结束
        vis[i] = 1;
        return true;
    }
}

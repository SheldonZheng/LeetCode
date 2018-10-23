//LeetCode 207
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return false;
        }

        int []vis = new int[numCourses];

        //��ʼ�� ��� ǰ�������ĵط�
        //������ĳ�������Ⱦ������ŵ�������
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
            //�������ĳ������ʱ�򣬷��������Ⱦ������Ѿ������ʹ��� �����л�
            if (!dfs(container,vis,i)) {
                return false;
            }
        }
        return true;

    }

    private boolean dfs(Map<Integer,ArrayList<Integer>> container,int []vis ,int i) {
        //��û���ʽ���
        if (vis[i] == -1) {
            return false;
        }
        //���ʽ���
        if (vis[i] == 1) {
            return true;
        }

        //��ʼ���� (����ݹ���)
        vis[i] = -1;
        //�����ֵû���κ��Ⱦ��������Ͳ����ߵ������if����
        if (container.containsKey(i)) {
            ArrayList<Integer> t = container.get(i);
            for (Integer integer : t) {
                if (!dfs(container,vis,integer)) {
                    return false;
                }
            }
        }

        //���ʽ���
        vis[i] = 1;
        return true;
    }
}

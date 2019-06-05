//LeetCode 842
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        dfs(S,res,0);
        return res;

    }

    private boolean dfs(String S,List<Integer> res,int index) {
        //���н⣬���Է�����
        if (S.length() == index && res.size() >= 3) {
            return true;
        }
        for (int i = index; i < S.length(); i++) {
            if (S.charAt(index) == '0' && i > index) {
                return false;
            }
            Long num = Long.parseLong(S.substring(index,i + 1));
            //������Χ��
            if (num > Integer.MAX_VALUE) {
                return false;
            }

            //���������������ϵ������ж�������ܲ��ܷ���Ҫ��
            if (res.size() >= 2 && (num > res.get(res.size() - 1) + res.get(res.size() - 2))) {
                return false;
            }

            //�����������������߷���Ҫ����ӽ�ȥ��������ǰ��
            if (res.size() < 2 || (num == res.get(res.size() - 1) + res.get(res.size() - 2))) {
                res.add(num.intValue());
                if (dfs(S,res,i + 1)) {
                    return true;
                }
                //ɾ���ռӽ�ȥ�ģ���ͷ
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}

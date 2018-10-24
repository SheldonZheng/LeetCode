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
        //已有解，可以返回了
        if (S.length() == index && res.size() >= 3) {
            return true;
        }
        for (int i = index; i < S.length(); i++) {
            if (S.charAt(index) == '0' && i > index) {
                return false;
            }
            Long num = Long.parseLong(S.substring(index,i + 1));
            //超出范围了
            if (num > Integer.MAX_VALUE) {
                return false;
            }

            //数组里有两个以上的数，判断这个数能不能符合要求
            if (res.size() >= 2 && (num > res.get(res.size() - 1) + res.get(res.size() - 2))) {
                return false;
            }

            //还不到两个数，或者符合要求，添加进去，继续往前走
            if (res.size() < 2 || (num == res.get(res.size() - 1) + res.get(res.size() - 2))) {
                res.add(num.intValue());
                if (dfs(S,res,i + 1)) {
                    return true;
                }
                //删除刚加进去的，回头
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}

/**
 * LeetCode 71 Simplify Path
 */

public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        //clear
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

        String[] splited = path.split("/");
        for (int i = 0; i < splited.length; i++) {
            if (splited[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(splited[i])) {
                stack.push(splited[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String result = "";
        for (String s : stack) {
            result = "/" + s + result;
        }
        return result;
    }

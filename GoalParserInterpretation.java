/**
 * LeetCode 1678 Goal Parser Interpretation
 */
class Solution {
    public String interpret(String command) {
		command = command.replace("()", "o");
		command = command.replace("(al)", "al");
		return command;
	}
}

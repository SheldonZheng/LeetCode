/**
 * @author Baiye
 * @since 2017-03-14
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < maxLen; i++) {
            int tempA = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
            int tempB = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;
            sb.insert(0, (tempA + tempB + carry) % 2);
            carry = tempA + tempB + carry > 1 ? 1 : 0;
        }
        if (carry == 1) sb.insert(0, 1);
        return sb.toString();
    }
}

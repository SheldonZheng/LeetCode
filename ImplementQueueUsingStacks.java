import java.util.Deque;
import java.util.Stack;

/**
 * Created by Baiye on 2016/11/25.
 */

/**
 * LeetCode.232 用Stack来实现一个Queue
 */
public class ImplementQueueUsingStacks {

    Stack<Integer> in = new Stack<Integer>();

    Stack<Integer> out = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    public void move()
    {
        while(!in.empty())
        {
            int x = in.pop();
            out.push(x);
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(out.empty())
            move();
        if(!out.empty())
            out.pop();
    }

    // Get the front element.
    public int peek() {
        if(out.empty())
            move();
        if(!out.empty())
            return out.peek();

        return 0;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.empty() && out.empty();
    }
}

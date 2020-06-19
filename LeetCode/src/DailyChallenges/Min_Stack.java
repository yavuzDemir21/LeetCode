package DailyChallenges;


import javafx.util.Pair;

import java.util.EmptyStackException;
import java.util.Stack;

class Elem{
    int val;
    int min;
    public Elem(int val, int min){
        this.val = val;
        this.min = min;
    }
}

class MinStack {

    /** initialize your data structure here. */

    Stack<Elem> st;
    public MinStack() {

        st = new Stack<>();

    }

    public void push(int x) {
        try {
            Elem peek = st.peek();
            st.push(new Elem(x, Math.min(x, peek.min)));
        }catch (EmptyStackException e){
            st.push(new Elem(x, x));
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().val;
    }

    public int getMin() {
        return st.peek().min;
    }
}

public class Min_Stack {
    public static void main(String[] args) {
        /**
         * Your MinStack object will be instantiated and called as such:
         * MinStack obj = new MinStack();
         * obj.push(x);
         * obj.pop();
         * int param_3 = obj.top();
         * int param_4 = obj.getMin();
         */

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

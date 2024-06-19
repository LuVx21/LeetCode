/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */
class MinStack {
    int            min   = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public MinStack() {
    }

    /**
     * 栈中最小的前一个是第二小的
     */
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    /**
     * 出栈的是最小的则再出栈一次, 将第二小的取出来
     */
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


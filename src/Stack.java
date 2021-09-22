package zlc;

public class Stack<E> {
    E[] a;
    int cnt;
    int top;

    public Stack() {
        cnt = 1010;
        top = 0;
        a = (E[]) new Object[cnt];
    }

    public int getSize() {
        return top;
    }

    public E peek() {
        return a[top - 1];
    }

    public void push(E x) {
        if (top == cnt) {
            E[] b = (E[]) new Object[cnt << 1];
            for (int i = 0; i < cnt; i++) b[i] = a[i];
            top = 0;
        }
        a[top++] = x;
    }

    public E pop() {
        E x = a[top - 1];
        top--;
        return x;
    }

    public boolean isEmpty() {
        return top == 0 ? true : false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack<String> st = new Stack<>();
        st.push("1");
        System.out.println(st.peek());
    }

}
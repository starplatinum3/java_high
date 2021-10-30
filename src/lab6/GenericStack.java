package lab6;

import java.io.IOException;

public class GenericStack<E> {
    E[] data;
    int length;
    int top;

    public GenericStack() {
        length = 3;
        top = 0;
        data = (E[]) new Object[length];
    }

    public int getSize() {
        return top;
    }

    public E peek() {
        return data[top - 1];
    }

    public void push(E var) {
        if (top == length) {
            E[] doubleSizedArray = (E[]) new Object[length * 2];
            if (length >= 0) System.arraycopy(data, 0, doubleSizedArray, 0, length);
            data = doubleSizedArray;
            length *= 2;

        }
        data[top++] = var;
    }

    public E pop() {
        return data[--top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public static void main(String[] args) throws IOException {
        GenericStack<String> st = new GenericStack<>();
        for (int i = 0; i < 10; i++) {
            st.push("" + i);
        }

        for (int i = 0; i < 10; i++) {
//            System.out.println(st.peek());
            System.out.println(st.pop());
//                fileWriter.write(st.pop()+"\n");
//                fileWriter.write(st.pop() + "\n");
//                fileWriter
        }


//        https://blog.csdn.net/weixin_45739720/article/details/103714427
//        try (FileWriter fileWriter = new FileWriter("pop.log")) {
//            for (int i = 0; i < 10; i++) {
////            System.out.println(st.peek());
//                System.out.println(st.pop());
////                fileWriter.write(st.pop()+"\n");
////                fileWriter.write(st.pop() + "\n");
////                fileWriter
//            }
//        }


        st.push("2");
        st.push("1");
        st.push("1");
        st.push("1");
        st.push("1");
        st.push("1");
        st.push("1");
    }

}
package leetcode.editor.topfeq;

import java.util.Stack;

public class Offer09 {



    class CQueue {

        /**
         * 两个栈 ：一个用来出队列 一个入队列
         *
         */

        private Stack<Integer> in;

        private Stack<Integer> out;

        public CQueue() {

            in=new Stack<>();
            out=new Stack<>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {

            if (!out.empty()){
              int  res =out.pop();
              return  res;
            }else {
                if (!in.empty()){
                    //将in队列放入 out队列
                    while (!in.empty()){
                        out.push(in.pop());
                    }
                    return out.pop();
                }else {
                    return -1;
                }

            }

        }
    }
}

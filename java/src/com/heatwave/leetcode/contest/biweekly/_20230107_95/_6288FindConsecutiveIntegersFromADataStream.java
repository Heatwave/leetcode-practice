package com.heatwave.leetcode.contest.biweekly._20230107_95;

import java.util.ArrayDeque;
import java.util.Deque;

public class _6288FindConsecutiveIntegersFromADataStream {

    /**
     * Your DataStream object will be instantiated and called as such:
     * DataStream obj = new DataStream(value, k);
     * boolean param_1 = obj.consec(num);
     */
    static class DataStream {

        int val = 0;
        int limit = 0;
        int diffToRemove = 0;
        Deque<Integer> deque;

        public DataStream(int value, int k) {
            this.val = value;
            this.limit = k;
            this.deque = new ArrayDeque<>(k);
        }

        public boolean consec(int num) {
            diffToRemove = diffToRemove > 0 ? diffToRemove - 1 : 0;
            if (deque.size() > limit) {
                deque.removeFirst();
            }
            deque.addLast(num);
            if (num != val) {
                diffToRemove = limit;
                return false;
            }
            if (deque.size() < limit) {
                return false;
            }
            if (diffToRemove == 0) {
                return true;
            }
            return false;
        }
    }
}

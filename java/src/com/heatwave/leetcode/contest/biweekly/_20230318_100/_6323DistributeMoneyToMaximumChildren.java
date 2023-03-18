package com.heatwave.leetcode.contest.biweekly._20230318_100;

public class _6323DistributeMoneyToMaximumChildren {
    class Solution {
        public int distMoney(int money, int children) {
            if (money < children) {
                return -1;
            }

            int ans = children;

            while (ans > 0) {
                int leftMoney = money - ans * 8;
                int leftChild = children - ans;
                if (leftMoney < 0) {
                    ans--;
                    continue;
                } else if (leftMoney == 0) {
                    if (leftChild == 0) {
                        return ans;
                    }
                    ans--;
                    continue;
                } else {
                    if (leftChild == 0) {
                        ans--;
                        continue;
                    }
                    if (leftMoney < leftChild) {
                        ans--;
                        continue;
                    }
                    if (leftMoney == 4 && leftChild == 1) {
                        ans--;
                        continue;
                    }
                    return ans;
                }
            }

            return ans;
        }
    }
}

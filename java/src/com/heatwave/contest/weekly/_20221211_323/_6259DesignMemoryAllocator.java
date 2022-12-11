package com.heatwave.contest.weekly._20221211_323;

public class _6259DesignMemoryAllocator {
    /**
     * Your Allocator object will be instantiated and called as such:
     * Allocator obj = new Allocator(n);
     * int param_1 = obj.allocate(size,mID);
     * int param_2 = obj.free(mID);
     */
    static class Allocator {
        int[] mem;
        int len;

        public Allocator(int n) {
            mem = new int[n];
            len = n;
        }

        public int allocate(int size, int mID) {
            int start = 0, index = 0, count = 0;
            boolean found = false;
            while (index < len) {
                if (mem[index] == 0) {
                    count++;
                } else {
                    start = index + 1;
                    count = 0;
                }

                if (count == size) {
                    found = true;
                    break;
                }
                index += 1;
            }

            if (!found) {
                return -1;
            }

            for (int i = start, j = 0; i < len && j < count; i++, j++) {
                mem[i] = mID;
            }
            return start;
        }

        public int free(int mID) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (mem[i] == mID) {
                    mem[i] = 0;
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Allocator allocator = new Allocator(50);
        System.out.println(allocator.allocate(12, 6));
        System.out.println(allocator.allocate(28, 16));
        System.out.println(allocator.allocate(17, 23));
        System.out.println(allocator.allocate(50, 23));
        System.out.println(allocator.free(6));
        System.out.println(allocator.free(10));
        System.out.println(allocator.free(10));
        System.out.println(allocator.allocate(16, 8));
    }
}

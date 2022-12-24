package com.heatwave.leetcode.contest.biweekly._20221224_94;

import java.util.*;

public class _6274RewardTopKStudents {
    static class Solution {
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
            Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
            Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));

            PriorityQueue<Solution.Student> priorityQueue = new PriorityQueue<>(student_id.length, (o1, o2) -> {
                if (o1.feedback == o2.feedback) {
                    return o1.id - o2.id;
                }
                return o2.feedback - o1.feedback;
            });

            for (int i = 0; i < report.length; i++) {
                int studentFeedback = 0;
                for (String word : report[i].split(" ")) {
                    if (positive.contains(word)) {
                        studentFeedback += 3;
                        continue;
                    }
                    if (negative.contains(word)) {
                        studentFeedback -= 1;
                        continue;
                    }
                }
                Student student = new Student(student_id[i], studentFeedback);
                priorityQueue.add(student);
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                Student s = priorityQueue.poll();
                ans.add(s.id);
            }

            return ans;
        }

        static class Student {
            int id;
            int feedback;

            Student(int id, int feedback) {
                this.id = id;
                this.feedback = feedback;
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Solution.Student> priorityQueue = new PriorityQueue<>(3, (o1, o2) -> {
            if (o1.feedback == o2.feedback) {
                return o1.id - o2.id;
            }
            return o2.feedback - o1.feedback;
        });
        Solution.Student student0 = new Solution.Student(1, 3);
        Solution.Student student1 = new Solution.Student(2, 2);
        Solution.Student student2 = new Solution.Student(3, 5);
        priorityQueue.add(student1);
        priorityQueue.add(student0);
        priorityQueue.add(student2);
        for (int i = 0; i < 3; i++) {
            System.out.println(priorityQueue.poll().id);
        }
    }
}

package com.heatwave.leetcode.problems;

import java.util.*;

public class _0037SudokuSolver {
    public static void solveSudoku(char[][] board) {
        Stack<Integer> baseStack = new Stack<>();
        for (int i = 9; i > 0; i--) {
            baseStack.push(i);
        }

        Map<Integer, List<Pair<Integer, Integer>>> cubeMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            cubeMap.put(i, list);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Pair<Integer, Integer> pair = new Pair<>(i, j);
                cubeMap.get(i / 3 * 3 + j / 3).add(pair);
            }
        }

        Stack<Pair<Integer, Integer>> posStack = new Stack<>();
        Stack<Pair<Integer, Integer>> popStack = new Stack<>();
        for (int i = 8; i >= 0; i--) {
            for (int j = 8; j >= 0; j--) {
                if (board[i][j] == '.') {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    posStack.push(pair);
                }
            }
        }

        Map<Integer, Stack<Integer>> posMap = new HashMap<>();

        while (posStack.size() > 0) {
            Pair<Integer, Integer> pair = posStack.pop();
            popStack.push(pair);
            int i = pair.getKey();
            int j = pair.getValue();

            int fixedPos = i * 9 + j;
            posMap.putIfAbsent(fixedPos, (Stack<Integer>) baseStack.clone());
            Stack<Integer> stack = posMap.get(fixedPos);

            boolean isValid = false;
            while (stack.size() > 0) {
                isValid = true;

                char c = Character.forDigit(stack.pop(), 10);
                board[i][j] = c;

                List<Pair<Integer, Integer>> list = cubeMap.get(i / 3 * 3 + j / 3);

                for (int k = 0; k < 9; k++) {
                    if (k != i && board[k][j] == c) {
                        isValid = false;
                        break;
                    }
                    if (k != j && board[i][k] == c) {
                        isValid = false;
                        break;
                    }
                    Pair<Integer, Integer> cubePair = list.get(k);
                    if (cubePair.getKey() == i && cubePair.getValue() == j) {
                        continue;
                    }
                    if (board[cubePair.getKey()][cubePair.getValue()] == board[i][j]) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    break;
                }
            }
            if (isValid) {
                continue;
            }

            board[i][j] = '.';
            posMap.remove(fixedPos);
            posStack.push(popStack.pop());
            posStack.push(popStack.pop());
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        printBoard(board);
        System.out.println();
        solveSudoku(board);
        printBoard(board);
    }

    private static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getKey() {
            return first;
        }

        public U getValue() {
            return second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}

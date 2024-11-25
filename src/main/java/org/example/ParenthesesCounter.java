package org.example;

import java.util.LinkedList;
import java.util.Queue;

class ParenthesesCounter {

    //class to save the current state
    private static class Node {
        String combination;
        int open;
        int close;

        Node(String combination, int open, int close) {
            this.combination = combination;
            this.open = open;
            this.close = close;
        }
    }

    //method for counting valid parenthesis combinations
    //using the iterative BFS approach
    public int counterValidCombination(int n) {
        if (n <= 0) {
            return 0;
        }

        int counter = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("", 0, 0));

        //take the element with the current state from the queue,
        // add an opening bracket ( (if open < n),
        // a closing bracket ) (if close < open),
        //add new combinations to the queue
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            //if the parenthesized expression is complete, increment the counter
            if (current.open == n && current.close == n) {
                counter++;
            }

            //add an opening bracket if their number is less than n
            if (current.open < n) {
                queue.add(new Node(current.combination + "(", current.open + 1, current.close));
            }

            //add a closing bracket if their number is less than the number of opening brackets
            if (current.close < current.open) {
                queue.add(new Node(current.combination + ")", current.open, current.close + 1));
            }
        }

        return counter;
    }
}
package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement:
 * Implement the "put" and "contains" methods.
 * Fix the "inOrderTraversal" method.
 */
public class FixBST {

    static class BST {

        private static class Node {
            Integer val;
            Node left;
            Node right;

            Node(int val) {
                this.val = val;
            }
        }

        private Node root;

        public BST() {
            this.root = null;
        }

        public void put(int value) {
            root = put(root, value);
        }

        private Node put(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }
            if (value > node.val) {
                node.right = put(node.right, value);
            } else {
                node.left = put(node.left, value);
            }
            return node;
        }

        public boolean contains(int value) {
            Node node = this.root;
            while (node != null) {
                if (node.val == value) {
                    return true;
                } else if (value > node.val) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
            return false;
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left, acc);
            acc.add(node.val);
            inOrderTraversal(node.right, acc);
        }

    }

    public static void testBST() {
        final BST searchTree = new BST();
        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);
        assertFalse(searchTree.contains(0));
        assertTrue(searchTree.contains(1));
        assertTrue(searchTree.contains(5));
        assertFalse(searchTree.contains(6));
        assertEquals(Arrays.asList(1, 2, 3, 5), searchTree.inOrderTraversal());
    }

    private static void assertFalse(boolean rez) {
        if (rez) {
            throw new RuntimeException("Test failed");
        } else {
            System.out.println("Test passed");
        }
    }

    private static void assertTrue(boolean rez) {
        if (!rez) {
            throw new RuntimeException("Test failed");
        } else {
            System.out.println("Test passed");
        }
    }

    private static void assertEquals(List<Integer> expected, List<Integer> result) {
        if (!expected.equals(result)) {
            System.out.printf("Test failed \"%s\" not equals to \"%s\"%n", expected, result);
        } else {
            System.out.println("Test passed");
        }
    }

    public static void main(String[] args) {
        testBST();
    }

}

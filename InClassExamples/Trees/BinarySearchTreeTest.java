//----------------------------------------------------------------------------------------------------------------------
//  BinarySearchTreeTest.java               Author: Brian Salchert
//
//  Class for testing the binary search tree implementation in Java.
//----------------------------------------------------------------------------------------------------------------------

package Trees;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        LinkedBinarySearchTree<Integer> binarySearchTree = new LinkedBinarySearchTree<Integer>(8);

        binarySearchTree.addElement(5);
        binarySearchTree.addElement(11);
        binarySearchTree.addElement(2);
        binarySearchTree.addElement(6);
        binarySearchTree.addElement(10);
        binarySearchTree.addElement(12);
        binarySearchTree.addElement(4);
        binarySearchTree.addElement(7);
        binarySearchTree.addElement(9);
        binarySearchTree.addElement(14);
        binarySearchTree.addElement(13);

        System.out.println(binarySearchTree.search(13));
        System.out.println(binarySearchTree.search(4));
        System.out.println(binarySearchTree.search(24));

        for (Integer integer: binarySearchTree) {
            System.out.println(integer);
        }
    }
}

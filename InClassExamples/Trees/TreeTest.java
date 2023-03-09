//----------------------------------------------------------------------------------------------------------------------
//  TreeTest.java               Author: Brian Salchert
//
//  Class for testing the tree interface and functions in java.
//----------------------------------------------------------------------------------------------------------------------

package Trees;

public class TreeTest {
    public static void main(String[] args) {
        LinkedTree<Integer> tree = new LinkedTree<Integer>(1);
        LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<Integer>(8);
        ArrayBinaryTree<Integer> arrayBinaryTree = new ArrayBinaryTree<Integer>(8);

        System.out.println(tree.isRoot(tree.root()));

        tree.addChild(tree.root(), 2);
        tree.addChild(tree.root(), 5);
        tree.addChild(tree.getChild(tree.root(), 0), 3);
        tree.addChild(tree.getChild(tree.root(), 0), 4);

        for (Integer integer : tree) {
            System.out.println(integer);
        }

        System.out.println(linkedBinaryTree.isRoot(linkedBinaryTree.root()));

        // Create binary search tree (without binary search tree functionality)
        Position<Integer> A = linkedBinaryTree.addLeftChild(linkedBinaryTree.root(), 5);
        Position<Integer> B = linkedBinaryTree.addRightChild(linkedBinaryTree.root(), 11);
        Position<Integer> C = linkedBinaryTree.addLeftChild(A, 2);
        Position<Integer> D = linkedBinaryTree.addRightChild(A, 6);
        Position<Integer> E = linkedBinaryTree.addLeftChild(C, 4);
        Position<Integer> F = linkedBinaryTree.addLeftChild(D, 7);
        Position<Integer> G = linkedBinaryTree.addLeftChild(B, 10);
        Position<Integer> H = linkedBinaryTree.addRightChild(B, 12);
        Position<Integer> I = linkedBinaryTree.addLeftChild(G, 9);
        Position<Integer> J = linkedBinaryTree.addLeftChild(H, 14);
        Position<Integer> K = linkedBinaryTree.addLeftChild(J, 13);

        for (Integer integer : linkedBinaryTree) {
            System.out.println(integer);
        }

        System.out.println("Size of linked binary tree: " + linkedBinaryTree.size());

        Position<Integer> arrA = arrayBinaryTree.addLeftChild(arrayBinaryTree.root(), 5);
        Position<Integer> arrB = arrayBinaryTree.addRightChild(arrayBinaryTree.root(), 11);
        Position<Integer> arrC = arrayBinaryTree.addLeftChild(arrA, 2);

        for (Integer integer : arrayBinaryTree) {
            System.out.println(integer);
        }

        System.out.println("Size of array binary tree: " + arrayBinaryTree.size());
    }
}

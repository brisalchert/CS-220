//----------------------------------------------------------------------------------------------------------------------
//  TreeTest.java               Author: Brian Salchert
//
//  Class for testing the tree interface and functions in java.
//----------------------------------------------------------------------------------------------------------------------

package TreeTest;

public class TreeTest {
    public static void main(String[] args) {
        LinkedTree<Integer> tree = new LinkedTree<Integer>(1);
        LinkedBinaryTree<Integer> binaryTree = new LinkedBinaryTree<Integer>(8);

        System.out.println(tree.isRoot(tree.root()));

        tree.addChild(tree.root(), 2);
        tree.addChild(tree.root(), 5);
        tree.addChild(tree.getChild(tree.root(), 0), 3);
        tree.addChild(tree.getChild(tree.root(), 0), 4);

        for (Integer integer : tree) {
            System.out.println(integer);
        }

        System.out.println(binaryTree.isRoot(binaryTree.root()));

        // Create binary search tree (without binary search tree functionality)
        Position<Integer> A = binaryTree.addLeftChild(binaryTree.root(), 5);
        Position<Integer> B = binaryTree.addRightChild(binaryTree.root(), 11);
        Position<Integer> C = binaryTree.addLeftChild(A, 2);
        Position<Integer> D = binaryTree.addRightChild(A, 6);
        Position<Integer> E = binaryTree.addLeftChild(C, 4);
        Position<Integer> F = binaryTree.addLeftChild(D, 7);
        Position<Integer> G = binaryTree.addLeftChild(B, 10);
        Position<Integer> H = binaryTree.addRightChild(B, 12);
        Position<Integer> I = binaryTree.addLeftChild(G, 9);
        Position<Integer> J = binaryTree.addLeftChild(H, 14);
        Position<Integer> K = binaryTree.addLeftChild(J, 13);

        for (Integer integer : binaryTree) {
            System.out.println(integer);
        }

        System.out.println("Size of binary tree: " + binaryTree.size());
    }
}

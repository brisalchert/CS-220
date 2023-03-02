//----------------------------------------------------------------------------------------------------------------------
//  TreeTest.java               Author: Brian Salchert
//
//  Class for testing the tree interface and functions in java.
//----------------------------------------------------------------------------------------------------------------------

package TreeTest;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TreeTest {
    public static void main(String[] args) {
        LinkedTree<Integer> tree = new LinkedTree<Integer>(1);

        System.out.println(tree.isRoot(tree.root()));

        tree.addChild(tree.root(), 2);
        tree.addChild(tree.root(), 5);
        tree.addChild(tree.getChild(tree.root(), 0), 3);
        tree.addChild(tree.getChild(tree.root(), 0), 4);

        for (Integer integer : tree) {
            System.out.println(integer);
        }
    }
}

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
        ArrayList<Position<Integer>> rootChildren = new ArrayList<Position<Integer>>();
        int index;

        System.out.println(tree.isRoot(tree.root()));
        tree.addChild(tree.root(), 2);
        tree.addChild(tree.root(), 5);

        Iterable<Position<Integer>> rootChildrenList = tree.children(tree.root());

        index = 0;

        for (Position<Integer> child : rootChildrenList) {
            rootChildren.add(child);
            index++;
        }

        tree.addChild(rootChildren.get(0), 3);
        tree.addChild(rootChildren.get(0), 4);

        for (Integer integer : tree) {
            System.out.println(integer);
        }
    }
}

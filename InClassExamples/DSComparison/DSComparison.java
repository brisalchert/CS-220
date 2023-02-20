/*
Written by sarker.
Written at 8/22/21.
*/

import java.util.ArrayList;
import java.util.HashSet;

public class DSComparison {

    // list or arraylist
    ArrayList<String> tshirtAList;

    // hashing
    HashSet<String> tshirtHashSet;

    private void compareRuntime(String searchFor) {
        // search in array list
        long startTimeForAList = System.nanoTime();
        tshirtAList.contains(searchFor);
        long endTimeForAList = System.nanoTime();
        long totalTimeForAList = endTimeForAList - startTimeForAList;
        System.out.println("Time to search in arraylist: " + totalTimeForAList);

        // search in hashset
        long startTimeForHashSet = System.nanoTime();
        tshirtHashSet.contains(searchFor);
        long endTimeForHashSet = System.nanoTime();
        long totalTimeForHashSet = endTimeForHashSet - startTimeForHashSet;
        System.out.println("Time to search in hashSet: " + totalTimeForHashSet);
    }

    private void storeInfo(long totalTShirt) {
        // list or arraylist
        tshirtAList = new ArrayList<>();

        // hashing
        tshirtHashSet = new HashSet<>();

        // insert into storage
        for (int i = 0; i < totalTShirt; i++) {
            tshirtAList.add("tshirt-" + i);
            tshirtHashSet.add("tshirt-" + i);
        }

        System.out.println("tshirtAList size: " + tshirtAList.size());
        System.out.println("tshirtHashSet size: " + tshirtHashSet.size());
    }

    public static void main(String[] args) {

        // amazon product list for clothes
        // 10,000,000 t-shirt
        // numbered as tshirt-1, tshirt-2, tshirt-n, ....
        // we will look for tshirt-99990 exists or not

        DSComparison dsComparison = new DSComparison();

        dsComparison.storeInfo(100000);

        // how the time compares?
        dsComparison.compareRuntime("tshirt-99990");
    }
}

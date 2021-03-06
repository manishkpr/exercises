package problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DinnerParty {

    int stackCount=0;

    @Test
    public void test() {
        List<String> friends = Arrays.asList("1","2","3","4");
        dinnertable(friends,3);
    }

    void dinnertable(List<String> friends, int tableSize) {
        List<List<String>> all = new LinkedList<>();
        recursion(friends, all , new LinkedList<>(), tableSize, 0);

        // print
        for (List<String> strings : all) {
            System.out.println(strings);
        }

        System.out.println(stackCount);

    }

    void recursion(List<String> friends, List<List<String>> all, List<String> temp, int tablesize, int idx) {
        stackCount++;
        if (temp.size() == tablesize) {
            all.add(new ArrayList<>(temp));
        }
        else if(idx<friends.size() && (temp.size()+(friends.size()-idx)>=tablesize)) {

             // add
             temp.add(friends.get(idx));
             recursion(friends, all, temp, tablesize, idx + 1);
             temp.remove(temp.size()-1);

             // don’t add
             recursion(friends, all, temp, tablesize, idx + 1);
         }

    }

}

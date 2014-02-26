/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Thilina
 */
public class MergeSort {
    // Mergesort returns a ArrayList and inputs  a integer ArrayList as parameter
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> a) {
        if (a.size() <= 1) {
            return a;
        }
        // divide the arrray by 2 inorder to sort
        ArrayList<Integer> firstHalf = new ArrayList<>();
        ArrayList<Integer> secondHalf = new ArrayList<>();
        for (int i = 0; i < a.size() / 2; i++) {
            firstHalf.add(a.get(i));
        }
        for (int i = a.size() / 2; i < a.size(); i++) {
            secondHalf.add(a.get(i));
        }
        return merge(mergeSort(firstHalf), mergeSort(secondHalf));
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        if (l1.isEmpty()) {
            return l2;
        }
        if (l2.isEmpty()) {
            return l1;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int nextElement;
        if (l1.get(0) > l2.get(0)) {
            nextElement = l2.get(0);
            l2.remove(0);
        } else {
            nextElement = l1.get(0);
            l1.remove(0);
        }
        result.add(nextElement);
        result.addAll(merge(l1, l2));
        return result;
    }
}

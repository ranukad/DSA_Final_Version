/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author Thilina
 */
public class BinarySearch {

    public static final int NOT_FOUND = -1;

    public static int binarySearch(int[] numbers, int key) {
        int low = 0;
        int high = numbers.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid > key) {
                high = mid - 1;
            } else if (mid < key) {
                low = mid + 1;
            } else {
                return numbers[mid];
            }
        }
        return NOT_FOUND;
    }
}

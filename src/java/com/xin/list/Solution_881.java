package com.xin.list;

/**
 * @Classname Solution_881
 * @Description 救生艇
 * @Date 2021/9/2 16:33
 * @Created by xinjiakun
 */
public class Solution_881 {
    public static void quickSort(int[] array, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = partSort(array, head, tail);
        quickSort(array, head, mid - 1);
        quickSort(array, mid + 1, tail);
    }

    private static int partSort(int[] array, int left, int right) {
        int key = array[left];
        int start = left;
        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            while (left < right && array[left] <= key) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, start, right);
        return left;
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public int numRescueBoats(int[] people, int limit) {
        quickSort(people, 0, people.length - 1);
        int num = 0;
        int start = 0;
        for (int i = people.length - 1; i >= start && start <= people.length; i--) {
            num++;
            if (start>=i){
                break;
            }
            if (people[start] + people[i] <= limit) {
                start++;
            }

        }
        return num;
    }
}

package com.xin.sort;

public class QuickSort {
	public static void quickSort(int []array, int head, int tail) {
		if (head >= tail) {
			return;
		}
		int mid =partSort(array, head, tail);
		quickSort(array, head, mid-1);
		quickSort(array, mid+1, tail);
	}
	private static int partSort(int []array, int left, int right) {
		int key = array[left];
		int start = left;
		while(left < right) {
			while(left < right && array[right] >= key) {
				right--;
			}
			while(left < right && array[left] <= key) {
				left++;
			}
			swap(array, left, right);
		}
		swap(array, start, right);
		return left;
	}
	public static void swap(int []array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	public static void main(String[] args) {
		int []array = {6,7,8,9,0,4,3,37,8,9,0,32,2,22,2,6,6,7,8};
		quickSort(array, 0, array.length-1);
		for(int next :array) {
			System.out.println(next);
		}
	}
}

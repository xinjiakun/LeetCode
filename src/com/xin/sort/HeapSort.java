package com.xin.sort;

public class HeapSort {
	public static void heapAdjust(int []array, int start, int length) {
		int temp = array[start];
		int child = 2*start+1;
		while (child < length) {
			if(child+1 < length && array[child+1] > array[child]) {
				child++;
			}
			if(array[start] < array[child]) {
				array[start] = array[child];
				array[child] = temp;
				start = child;
				child = 2*child+1;
			}else {
				break;
			}
		}
	}
	public static void buildingHeap(int []array, int length) {
		for (int i = (array.length-1)/2; i >= 0; i--) {
			heapAdjust(array, i, length);
		}
	}
	public static void heapSort(int []array,int length) {
		buildingHeap(array, length);
		for(int i = length-1; i > 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapAdjust(array, 0, i);
		}
	}
	public static void main(String[] args) {
		int array[] = {4,5,2,16,9,8,854,22,1,783,8832,7,44,810};
		heapSort(array, array.length);
		for(int next: array) {
			System.out.println(next);
		}
	}
}

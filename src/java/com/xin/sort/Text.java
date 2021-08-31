package com.xin.sort;

public class Text {
	public static void quick(int []array, int left, int right) {
		if(left >= right) {
			return;
		}
		int mid = partsort(array, left, right);
		quick(array, left, mid-1);
		quick(array, mid+1, right);
	}
	private static int partsort(int []array, int left,int right) {
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
	private static void swap(int []array ,int left ,int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		
		//位运算 交换
		
//		array[left] = array[left] ^ array[right];
//		array[right] = array[right] ^ array[left];
//		array[left] = array[left] ^ array[right];
	}
	public static void main(String[] args) {
		int []array = {6,7,8,9,0,4,3,37,8,9,0,32,2,22,2,6,6,7,8};
		quick(array, 0, array.length-1);
		for(int next :array) {
			System.out.println(next);
		}
	}
}

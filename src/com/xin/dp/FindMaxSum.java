package com.xin.dp;
/**
 * 
    * @ClassName: FindMaxSum
    * @Description: TODO 动态规划 连续子数组的最大和  	  sum[i] = max(sum[i-1] + a[i], a[i])
 *     * 												=>sum[i-1] > 0
    * @author xinjiakun
    *
 */
public class FindMaxSum {
	public static int find(int[]array,int length) {
		int sum = array[0];
		int max = array[0];
		for(int i = 0 ; i < length; i++) {
			sum = getMax(sum+array[i], array[i]);
			if(sum > max) {
				max = sum;
			}
		}
		return max;
	}
	public static int find2(int[]array,int length) {
		int sum = array[0];
		int max = array[0];
		for(int i = 0 ; i < length; i++) {
			if(sum < 0) {
				sum = array[i];
			}else {
				sum += array[i];
			}
			if(sum > max) {
				max = sum;
			}
		}
		return max;
	}
	public static int getMax(int left, int right) {	
		return left > right ? left: right;
	}
	public static void main(String[] args) {
		int [] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(find(array, array.length));
		System.out.println(find2(array, array.length));
		
	}
}

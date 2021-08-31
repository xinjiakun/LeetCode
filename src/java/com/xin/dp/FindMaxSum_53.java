package com.xin.dp;
/**
 * 
    * @ClassName: FindMaxSum_53
    * @Description: TODO 动态规划 连续子数组的最大和  	  sum[i] = max(sum[i-1] + a[i], a[i])
 *     * 												=>sum[i-1] > 0
    * @author xinjiakun
    *
 */
public class FindMaxSum_53 {
	public static int find(int[]array,int length) {
		if (length == 1) {
			return array[0];
		}//长度为1直接返回提高效率
		if(length == 0){
			return 0;
		}//空数组直接返回
		int sum = 0;//初始为0
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

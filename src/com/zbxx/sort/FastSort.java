package com.zbxx.sort;

import com.zbxx.util.ArrayUtils;

import java.util.Arrays;

public class FastSort {


	/**
	 * 算法导论中的快排思想实现
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void fastSort(int arr[],int left,int right){
		if(left<right){
			int l = left;
			int r= l+1;
			int temp = arr[l];
			for (; r <=right ; r++) {
				if(arr[r]<temp){
					ArrayUtils.swap(arr,++l,r);
				}
			}
			ArrayUtils.swap(arr,l,left);
			fastSort(arr,left,l-1);
			fastSort(arr,l+1,right);
		}
	}


	/*public static void fastSort(int arr[], int left, int right) {
		if (left < right) {
			int le = left;
			int ri = right;
			int temp = arr[le];
			while (le < ri) {
				while (ri > le && arr[ri] >= temp) {
					ri--;
				}
				if (le < ri) {
					arr[le++] = arr[ri];
				}
				while (le < ri && arr[le] <= temp) {
					le++;
				}
				if (ri > le) {
					arr[ri--] = arr[le];
				}
			}
			if (le == ri) {
				arr[le] = temp;
			}
			fastSort(arr, left, le - 1);
			fastSort(arr, le + 1, right);
		}


	}*/


	public static void main(String[] args) {
		int arr[] = {9, 2, 32, 3, 8, 4, 6, 3, 2, 9, 0};
		fastSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}

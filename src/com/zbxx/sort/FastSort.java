package src.com.zbxx.sort;

import java.util.Arrays;

public class FastSort {


	public static void fastSort(int arr[], int left, int right) {
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


	}


	public static void main(String[] args) {
		int arr[] = {1, 2, 32, 3, 8, 4, 6};
		fastSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}

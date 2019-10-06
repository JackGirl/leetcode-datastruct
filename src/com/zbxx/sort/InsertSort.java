package src.com.zbxx.sort;

import java.util.Arrays;

public class InsertSort {


	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				int temp = arr[i];
				int j = i - 1;
				//将小的全部往后挪
				while (j > 0 && temp < arr[j]) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 32, 3, 8, 4, 6};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}

package src.com.zbxx.sort;

import java.util.Arrays;


public class BubbleSort {

    private static void bubbleSort(int[] array){
        int temp;
        for(int i = 0; i<array.length-1; i++){
            for(int j = array.length-1; j >i ; j--){
                if(array[j]<array[j-1]){
                 temp = array[j];
                 array[j] = array[j-1];
                 array[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] array = {5,3,9,1,56,23};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}

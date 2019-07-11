package src.com.zbxx.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author 万仁杰
 * @date 2019/06/25
 */
public class SelectSort {

    private static void selectSort(int [] array){
        int temp ;
        int min ;
        for (int i = 0; i < array.length-1;i++){
            min = i;
            for(int j = i+1 ; j<array.length;j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            if(min!=i){
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int [] array = {5,3,9,1,56,23};
        System.out.println(Arrays.toString(array));
        selectSort(array);
       System.out.println(Arrays.toString(array));
    }


}

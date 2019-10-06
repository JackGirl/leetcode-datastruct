package src.com.zbxx.search;

/**
 *  二分法查找
 *  <remark>
 *      元素必须已经有序 否则干不了
 *       先从中间找   再判断区间 重复 以上步骤
 *  </remark>
 * @date 2019/06/24
 */
public class BinarySearch {

    private static int binarySearch(int key,int [] array,int le ,int ri){
        int midIndex = (le+ri)/2;
        if (le<=ri){
            if(array[midIndex]>key){
                return binarySearch(key,array,le,midIndex-1);
            }
            else if (array[midIndex]<key){
                return binarySearch(key,array,midIndex+1,ri);
            }else{
                return midIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] testArray = {1,2,7,9,15,25};
        int result = binarySearch(15,testArray,0,testArray.length-1);
        System.out.println(result==-1?"不存在此元素":"元素下标为"+result);
    }

}

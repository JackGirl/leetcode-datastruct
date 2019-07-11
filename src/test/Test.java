package src.test;

import src.com.zbxx.datastructure.MyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("aaaaa1");
        test.add("bbbbb1");
        test.add("cccccc1");
        //分别传参 返回 list结果
        List<String> a =  test.stream().map(s -> getObject("网页点击量",s)).collect(Collectors.toList());
        //分别传参 调用方法 foreach 无返回值
        test.forEach(t->getObject("网页点击量",t));

    }

    public static String  getObject(String a,String param){
        return "33333";
    }

}

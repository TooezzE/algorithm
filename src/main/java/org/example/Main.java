package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IntegerList integerList = new IntegerList();

        integerList.add(10);
        integerList.add(34);
        integerList.add(2);
        integerList.add(1000);
        integerList.add(19);
        integerList.add(100);

        System.out.println(Arrays.toString(integerList.toPrimitiveArray()));
        integerList.quickSort(integerList.toPrimitiveArray(), 0, integerList.size() - 1);
        System.out.println(Arrays.toString(integerList.toObjectArray()));


    }
}
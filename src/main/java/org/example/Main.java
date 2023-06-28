package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringList();

        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        stringList.add("ddd");

        stringList.remove(1);
        stringList.set(2, "zzz");
        System.out.println(stringList.isEmpty());
        System.out.println(stringList.size());
        System.out.println(Arrays.toString(stringList.toArray()));
    }
}
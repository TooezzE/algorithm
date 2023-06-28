package org.example;

import java.util.Arrays;

public class StringList {
    private String[] list = new String[0];
    private int size = 0;

    public String add(String item) {
        String[] newList = Arrays.copyOf(list, size+1);
        if(isEmpty()){
            newList[0] = item;
        } else {
            newList[newList.length - 1] = item;
        }
        list = newList;
        size++;
        return item;
    }

    public String add(int index, String item) {
        if(index > size - 1){
            throw new IllegalArgumentException();
        }

        String[] newList = Arrays.copyOf(list, size+1);
        for (int i = list.length; i > index; i--) {
            newList[i] = newList[i-1];
        }
        newList[index] = item;
        list = newList;
        size++;
        return item;
    }

    public String set(int index, String item){
        if(index > size - 1){
            throw new IllegalArgumentException();
        }
        list[index] = item;
        return item;
    }

    public String remove(String item){
        boolean isFinded = false;
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals(item)){
                isFinded = true;
                index = i;
            }
        }
        for (int j = index; j < list.length - 1; j++) {
            list[j] = list[j+1];
        }
        String[] newList = Arrays.copyOf(list, list.length - 1);
        list = newList;
        size--;
        if(!isFinded){
            throw new IllegalArgumentException();
        }
        return item;
    }
    public String remove(int index){
        if (index > size - 1){
            throw new IllegalArgumentException();
        }
        String temp = list[index];
        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i+1];
        }
        String[] newList = Arrays.copyOf(list, size - 1);
        list = newList;
        size--;
        return temp;
    }

    public boolean contains(String item){
        for (String s : list) {
            if (s.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String item){
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String item){
        int index = list.length - 1;
        for (int i = list.length - 1; i >= 0; i--) {
            if(list[i].equals(item)){
                return index;
            }
            index--;
        }
        return -1;
    }

    public String get(int index){
        if(index > size - 1){
            throw new IllegalArgumentException();
        }
        return list[index];
    }

    public boolean equals(StringList otherStringList){
        if(otherStringList == null){
            throw new IllegalArgumentException();
        }
        if(this.size != otherStringList.size){
            return false;
        }
        for (int i = 0; i < otherStringList.size; i++){
            if(!this.get(i).equals(otherStringList.get(i))){
                return false;
            }
        }
        return true;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        int temp = 0;
        for (int i = 0; i < list.length; i++) {
            if(list[i] == null){
                temp++;
            }
        }
        if(temp == size){
            return true;
        }
        return false;
    }

    public void clear(){
        list = new String[0];
        size = 0;
    }

    public String[] toArray(){
        String[] newList = Arrays.copyOf(list, size);
        return newList;
    }
}

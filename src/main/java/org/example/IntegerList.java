package org.example;

import java.util.Arrays;

public class IntegerList {
    private Integer[] list = new Integer[0];
    private int size = 0;

    public Integer add(Integer item) {
        Integer[] newList = Arrays.copyOf(list, size+1);
        if(item == null) {
            throw new IllegalArgumentException();
        }
        if(isEmpty()){
            newList[0] = item;
        } else {
            newList[newList.length - 1] = item;
        }
        list = newList;
        size++;
        return item;
    }

    public Integer add(int index, Integer item) {
        if(index > size - 1 || item == null){
            throw new IllegalArgumentException();
        }

        Integer[] newList = Arrays.copyOf(list, size+1);
        for (int i = list.length; i > index; i--) {
            newList[i] = newList[i-1];
        }
        newList[index] = item;
        list = newList;
        size++;
        return item;
    }

    public Integer set(int index, Integer item){
        if(index > size - 1 || item == null){
            throw new IllegalArgumentException();
        }
        list[index] = item;
        return item;
    }

    public Integer remove(Integer item){
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
        Integer[] newList = Arrays.copyOf(list, list.length - 1);
        list = newList;
        size--;
        if(!isFinded){
            throw new IllegalArgumentException();
        }
        return item;
    }
    public Integer remove(int index){
        if (index > size - 1){
            throw new IllegalArgumentException();
        }
        Integer temp = list[index];
        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i+1];
        }
        Integer[] newList = Arrays.copyOf(list, size - 1);
        list = newList;
        size--;
        return temp;
    }
    public IntegerList sort(IntegerList integerList) {
        int currSize = integerList.size() - 1;
        int max = integerList.get(0);
        int indx = 0;
        for (int i = 0; i < integerList.size(); i++) {
            for (int j = 0; j <= currSize; j++) {
                if (integerList.get(j) > max) {
                    max = integerList.get(j);
                    indx = j;
                }
            }
            int tmp = integerList.get(currSize);
            integerList.set(currSize, max);
            integerList.set(indx, tmp);
            currSize--;
            max = 0;
        }
        return integerList;
    }

    private Integer binarySearch(Integer item) {
        sort(this);
        int index = -1;
        int high = list.length - 1, low = 0;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if(list[mid] < item) {
                low = mid + 1;
            } else if(list[mid] > item) {
                high = mid - 1;
            } else if(list[mid].equals(item)) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public boolean contains(Integer item){
        return binarySearch(item) != -1;
    }

    public int indexOf(Integer item){
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item){
        int index = list.length - 1;
        for (int i = list.length - 1; i >= 0; i--) {
            if(list[i].equals(item)){
                return index;
            }
            index--;
        }
        return -1;
    }

    public Integer get(int index){
        if(index > size - 1){
            throw new IllegalArgumentException();
        }
        return list[index];
    }

    public boolean equals(IntegerList otherIntegerList){
        if(otherIntegerList == null){
            throw new IllegalArgumentException();
        }
        if(this.size != otherIntegerList.size){
            return false;
        }
        for (int i = 0; i < otherIntegerList.size; i++){
            if(!this.get(i).equals(otherIntegerList.get(i))){
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
        for (Integer integer : list) {
            if (integer == null) {
                temp++;
            }
        }
        return temp == size;
    }

    public void clear(){
        list = new Integer[0];
        size = 0;
    }

    public Integer[] toArray(){
        return Arrays.copyOf(list, size);
    }
}


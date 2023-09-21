package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntegerList {
    private Integer[] list = new Integer[5];
    private int elemCount = 0;

    public Integer add(Integer item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        if(isEmpty()){
            grow();
            list[0] = item;
        } else if(list[elemCount - 1] != null) {
            list[elemCount] = item;
        } else if(list[elemCount - 1] != null && list[list.length - 1] != null) {
            grow();
            list[elemCount] = item;
        }
        elemCount++;
        return item;
    }

    public Integer add(int index, Integer item) {
        if(index > elemCount - 1 || item == null){
            throw new IllegalArgumentException();
        }

        if(list.length == elemCount) {
            grow();
        }
        for (int i = list.length - 1; i > index; i--) {
            list[i] = list[i-1];
        }
        list[index] = item;
        elemCount++;
        return item;
    }

    private void grow() {
        int newLength = list.length + list.length/2;
        list = Arrays.copyOf(list, newLength);
    }

    public Integer set(int index, Integer item){
        if(index > elemCount - 1 || item == null){
            throw new IllegalArgumentException();
        }
        list[index] = item;
        return item;
    }

    public Integer remove(Integer item){
        boolean isFinded = false;
        int index = 0;
        for (int i = 0; i < list.length - 1; i++) {
            if(list[i].equals(item)){
                isFinded = true;
                index = i;
            }
        }
        for (int j = index; j < list.length - 1; j++) {
            list[j] = list[j+1];
        }
        list = Arrays.copyOf(list, list.length - 1);
        elemCount--;
        if(!isFinded){
            throw new IllegalArgumentException();
        }
        return item;
    }
    public Integer remove(int index){
        if (index > elemCount - 1){
            throw new IllegalArgumentException();
        }
        Integer temp = list[index];
        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i+1];
        }
        list = Arrays.copyOf(list, elemCount - 1);
        elemCount--;
        return temp;
    }
    public IntegerList sort() {
        int currSize = this.size() - 1;
        int max = this.get(0);
        int indx = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j <= currSize; j++) {
                if (this.get(j) > max) {
                    max = this.get(j);
                    indx = j;
                }
            }
            int tmp = this.get(currSize);
            this.set(currSize, max);
            this.set(indx, tmp);
            currSize--;
            max = 0;
        }
        return this;
    }

    public IntegerList quickSort(int[] arr, int low, int high) {
        if(arr.length == 0) {
            return this;
        }
        if(low >= high) {
            return this;
        }

        int middleIndex = low + (high - low) / 2;
        int pivot = arr[middleIndex];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while(arr[j] > pivot) {
                j--;
            }

            if(i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if(low < j) {
            quickSort(arr, low, j);
        }
        if(high > i) {
            quickSort(arr, i, high);
        }

        list = Arrays.copyOf(IntStream.of(arr).boxed().toArray(Integer []::new), elemCount);
        return this;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private Integer binarySearch(Integer item) {
        sort();
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
        if(index > elemCount - 1){
            throw new IllegalArgumentException();
        }
        return list[index];
    }

    public boolean equals(IntegerList otherIntegerList){
        if(otherIntegerList == null){
            throw new IllegalArgumentException();
        }
        if(this.elemCount != otherIntegerList.elemCount){
            return false;
        }
        for (int i = 0; i < otherIntegerList.elemCount; i++){
            if(!this.get(i).equals(otherIntegerList.get(i))){
                return false;
            }
        }
        return true;
    }

    public int size(){
        return elemCount;
    }

    public int getListLength() {
        return list.length;
    }

    public boolean isEmpty(){
        if(elemCount == 0){
            return true;
        }
        int temp = 0;
        for (Integer integer : list) {
            if (integer == null) {
                temp++;
            }
        }
        return temp == elemCount;
    }

    public void clear(){
        list = new Integer[0];
        elemCount = 0;
    }

    public Integer[] toObjectArray() {
        return Arrays.copyOf(list, elemCount);
    }

    public int[] toPrimitiveArray() {
        Integer[] result = Arrays.copyOf(list, elemCount);
        return Arrays.stream(result).mapToInt(i->i).toArray();
    }

}


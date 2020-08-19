package library;

import javax.swing.plaf.TreeUI;
import java.util.Arrays;

public class Alist implements IList{

    int[] values;

    public Alist() {
        values= new int[10];
    }

    public Alist(int capacity) {
        this.values = new int[capacity];
    }

    public Alist(int[] values) {
        this.values = values;
    }

    @Override
    public void clear() {
        values= new int[10];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public int get(int index) {
        return values[index];
    }

    @Override
    public boolean add(int value) {

        int[] tmpArr= new int[values.length+1];

        for (int i=0;i<values.length;i++){
            tmpArr[i]=values[i];
        }

        tmpArr[values.length+1]=value;
        values=tmpArr;
        return true;
    }

    @Override
    public boolean add(int index, int value) {
        if (index>values.length){
            return  false;
        }

        if (index<0){
            return false;
        }
        int[] tmpArr= new int[values.length+1];

        for (int i=0;i<index;i++){
            tmpArr[i] = values[i];
        }

        tmpArr[index] = value;

        for (int i=index;i<values.length;i++){
                tmpArr[i] = values[i];
        }
        values=tmpArr;
        return true;
    }

    @Override
    public int remove(int number) {
        int countRemoved=0;
        int[] tmpArr= new int[values.length];

        for (int i=0, j=0;i<values.length;i++){
            int currentNumber= values[i];
            if (currentNumber==number){
                countRemoved++;
                continue;
            }

            tmpArr[i] = values[j++];
        }

        if (countRemoved==0){
            return  0;
        }

        int newSize=values.length-countRemoved;
        int[] tmpArr1 = new int[newSize];

        for (int i=0;i<newSize;i++){
            tmpArr1[i]=tmpArr[i];
        }

        values= tmpArr1;
        return countRemoved;
    }

    @Override
    public int removeByIndex(int index) {
        if (index>values.length-1){
            return  0;
        }

        if (index<0){
            return 0;
        }
        int[] tmpArr= new int[values.length-1];

        for (int i=0;i<index;i++){
            tmpArr[i] = values[i];
        }

        for (int i=index+1;i<values.length;i++){
            tmpArr[i] = values[i-1];
        }

        values=tmpArr;

        return 1;
    }

    @Override
    public boolean contains(int value) {
        for(int i=0;i< values.length;i++){
            if (values[i]==value){
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
        if (index>values.length-1){
            return  false;
        }

        if (index<0){
            return false;
        }

        values[index]=value;

        return true;
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(values));
    }

    @Override
    public int[] toArray() {
        return values;
    }

    @Override
    public boolean removeAll() {
        values= new int[10];
        return true;
    }
}

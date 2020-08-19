package com.company;

import library.Alist;
import library.IList;

public class Main {

    public static void main(String[] args) {

        IList list= new Alist(new int[]{0,1,2,3});
        list.add(9,11);
        list.print();
        System.out.print(list.size());
    }
}

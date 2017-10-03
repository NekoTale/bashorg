package com.dimon.bashorg;

import com.dimon.bashorg.core.MyLinkedList;
import com.dimon.bashorg.core.Node;

import java.util.Scanner;

/**
 * Created by mds on 03.10.17.
 */
public class test {
    public static void main(String[] args) {
        MyLinkedList<String> testList = new MyLinkedList<String>();
        Scanner hello = new Scanner(System.in);
        System.out.println("введите количество элементов");
        int kil = hello.nextInt();
        System.out.println("введите СЛОВa");
        hello.nextLine();
        for (int i = 0; i < kil; i++) {
            testList.add(hello.nextLine());
        }
        System.out.println("введите номер элемента для получения");
        System.out.println(testList.get(hello.nextInt()));
        System.out.println("введите номер элемента для удаления");
        testList.delete(hello.nextInt());
        System.out.println("длина получившегося массива равна " + testList.length());
        System.out.println("введите сначала элемент а затем номер для добавления");
        String buffer = hello.nextLine();
        int position = hello.nextInt();

        testList.addToPosition(buffer, position);
        System.out.println("длина получившегося массива равна " + testList.length());

        for (int i = 0; i < testList.length(); i++) {
            System.out.println(testList.get(i));
        }
        testList.get(100);
        System.out.println("длина получившегося массива равна " + testList.length());

    }

}

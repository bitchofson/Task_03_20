package com.metanit;

// Это реализация с использованием MyStack и MyQueue.


import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class MainCustom {

    public static void printResultQueue(LinkedList<String> resultQueue) {
        System.out.println(resultQueue.toString());
    }

    public static void printResultStack(LinkedList<String> resultStack) {
        System.out.println(resultStack.toString());
    }

    public static void searchFilesQueue(File dir, String mask, LinkedList<String> resultQueue) {

        MyQueue<File> que = new MyQueue<>();
        que.add(dir);

        while (!que.isEmpty()) {
            File directory = que.remove();
            for(File file : directory.listFiles())
            {
                if(file.isDirectory())
                    que.add(file);
                else {
                    if (file.getName().endsWith(mask)) {
                        resultQueue.add(file.getName());
                    }
                }
            }
        }
    }

    public static void searchFilesStack(File dir, String mask, LinkedList<String> resultStack) {

        MyStack<File> stack = new MyStack<>();
        stack.push(dir);

        while (!stack.isEmpty()) {
            File directory = stack.pop();
            for(File file : directory.listFiles())
            {
                if(file.isDirectory())
                    stack.push(file);
                else {
                    if (file.getName().endsWith(mask)) {
                        resultStack.add(file.getName());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String ext, path;
        System.out.print("Enter path to folder: ");
        path = input.next();
        System.out.print("Enter file extension: ");
        ext = input.next();

        // C:\Users\GoldStump\Documents\Test_Task_3

        LinkedList<String> resultQueue = new LinkedList<>();
        LinkedList<String> resultStack = new LinkedList<>();

        // Создаем объект File
        File dir = new File(path);
        // Вызов пользовательского метода печати
        searchFilesQueue(dir, ext, resultQueue);
        searchFilesStack(dir, ext, resultStack);

        // Вывод содержания списка
        System.out.print("Queue: ");
        printResultQueue(resultQueue);
        System.out.print("Stack: ");
        printResultStack(resultStack);

    }
}

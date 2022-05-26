package com.metanit;

import java.io.File;
import java.util.*;

/*
20.     Найти все файлы с заданным расширением в папке и ее подпапках. Для чтения набора
    файлов и подпапок в папке использовать класс java.io.File (метод listFiles()). Реализация
    с использованием очереди. Вначале в очередь помещается папка, в которой ищем файлы.
    Затем, в цикле, пока в очереди есть элементы, выбираем из очереди элемент (папку). Для
    данной папки находим все вложенные элементы: если это нужный файл, помещаем его в
    итоговый список, если это папка, то добавляем ее в очередь. Заменить в реализации
    очередь на стек, объяснить, каким образом и почему изменится порядок найденных
    файлов.
 */

// Это реализация с использованием встроенных инструментов java.


public class Main {

    public static void printResultQueue(LinkedList<String> resultQueue) {
        System.out.println(resultQueue.toString());
    }

    public static void printResultStack(LinkedList<String> resultStack) {
        System.out.println(resultStack.toString());
    }

    public static void searchFilesQueue(File dir, String mask, LinkedList<String> resultQueue) {

        Queue<File> que = new ArrayDeque<>();
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

        Stack<File> stack = new Stack<>();
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
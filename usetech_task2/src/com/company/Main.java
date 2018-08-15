package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args) throws IOException {

            create();
            sorting_up(read("note.txt"));
            sorting_down(read("note.txt"));

    }

    public static void create()
    {
        int[] array = new int[20];
        File file=new File("note.txt");
        try (FileWriter writer = new FileWriter(file, false)) {
            for (int i = 0; i < 20; i++) {
                array[i] = 0 + (int) (Math.random() * 20);
                String s = Integer.toString(array[i]);
                System.out.println(s);
                writer.write(s);
                if (i <= 19) {
                    writer.append(',');
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static String read(String fileName) throws IOException
    {   String data=null;
        try {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        data = scanner.next();
        scanner.close();

    } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
        return data;
    }

    static void sorting_up(String s) throws IOException
    {
        int[] numArr = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numArr);
        System.out.print("\nAscending Order is  : ");
        for (Integer i : numArr) {
            System.out.print(i.intValue() + " ");
        }

    }

    public static void sorting_down(String s) throws IOException
    {
        int[] numArr = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numArr.length - 1; i++)
            for (int j = 0; j < numArr.length - i - 1; j++)
                if (numArr[j] < numArr[j + 1]) {
                    int temp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = temp;
                }
        System.out.print("\nDecreasing Order is : ");
        for (int j=0;j<20;j++)
        {
            System.out.printf(numArr[j]+" ");
        }
    }

}



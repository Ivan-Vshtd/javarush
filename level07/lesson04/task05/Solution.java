package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] Massiv = new int[20];
        int[] massiv1 = new int[10];
        int[] massiv2 = new int[10];
        for(int i = 0;i<Massiv.length;i++)
        {
            String s = reader.readLine();
            Massiv[i]= Integer.parseInt(s);
        }
        for(int k=0;k<massiv1.length;k++)
        {
            massiv1[k] = Massiv[k];//напишите тут ваш код
        }
        for(int m=0;m<massiv2.length;m++)
        {
            massiv2[m]=Massiv[m+10];
        }
        for(int n=0; n<massiv2.length;n++)
        {
            System.out.println(massiv2[n]);
        }

    }
}

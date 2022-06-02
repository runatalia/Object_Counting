/*Написать функции, которые:

на вход принимают файл;
считают количество соответствий со словом, которое принимается с консоли;
выводит в консоль содержимое файла и колличество вхождений влова.*/
package Object_Counting;

import java.util.Scanner;

public class Count {

    public static void main(String[] args) {
        System.out.println("enter a word: ");
        InputObject inputObject = new InputObject();
        String word = new Scanner(System.in).next();
        String text = inputObject.read();
        System.out.println("\nText from file: ");
        System.out.println(text+"\n");
        System.out.println(text+" found in text " + inputObject.count(word, text));

    }

}

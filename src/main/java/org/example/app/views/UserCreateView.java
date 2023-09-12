package org.example.app.views;

import java.util.Scanner;

public class UserCreateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter name: ";
        System.out.print(title);
        String name = scanner.nextLine();

        title = "Enter phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        String phone = scanner.nextLine();

        title = "Enter email in format example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine();

        return new String[]{name, phone, email};
    }


    public void getOutput(String output) {
        System.out.println(output);
    }
}



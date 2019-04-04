package com;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        while(true) {
            System.out.println("enter an allocation scheme: ");
            System.out.println("1)contigous" +
                    "2)linked" +
                    "3)indexed");
            Scanner SC = new Scanner(System.in);
            int input = SC.nextInt();
            if (input == 1) {
                while(true)
                {
                    //Contiguous allocation commands go here
                    break;
                }
            } else if (input == 2) {
                while(true)
                {
                    //linked allocation commands go here
                    break;
                }
            } else if (input == 3) {
                while(true)
                {
                    //indexed allocation commands go here
                    break;
                }
            } else {
                System.out.println("please enter a valid scheme input.");
            }
        }
    }


}

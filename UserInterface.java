package com;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
//        while(true) {
//            System.out.println("enter an allocation scheme: ");
//            System.out.println("1)contigous" +
//                    "2)linked" +
//                    "3)indexed");
//            Scanner SC = new Scanner(System.in);
//            int input = SC.nextInt();
//            if (input == 1) {
//                while(true)
//                {
//                    //Contiguous allocation commands go here
//                    break;
//                }
//            } else if (input == 2) {
//                while(true)
//                {
//                    //linked allocation commands go here
//                    break;
//                }
//            } else if (input == 3) {
//                while(true)
//                {
//                    //indexed allocation commands go here
//                    break;
//                }
//            } else {
//                System.out.println("please enter a valid scheme input.");
//            }
//        }

        LinkedAllocation l=new LinkedAllocation();
        while (true)
        {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your command: ");
        String commands [] = input.nextLine().split(" ");
        int length = commands.length;
        if(commands.length == 1)
        {
            if(commands[0].equals("DisplayDiskStatus"))
            {
                l.displayDiskStatus();
            }
            else if(commands[0].equals("DisplayDiskStructure"))
            {
               l.displayDiskStructure(l.root,"");
            }
            else
            {
                System.out.println("Invalid command");
            }
        }
        else
        {
            String function = commands[0];
            String path [] = commands[1].split("/");
            if(function.equals("CreateFile"))
            {
                int size = Integer.valueOf(commands[length-1]);

                l.createFile(size,path,path.length);
            }
            else if ( (commands.length ==2) && (function.equals("CreateFolder") ) )
            {
                l.createFolder(path,path.length);
            }
            else
            {
                System.out.println("Invalid command");
            }
        }
    }
    }
}
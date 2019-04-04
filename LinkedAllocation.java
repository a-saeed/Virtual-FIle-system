package com;

import java.util.ArrayList;

public class LinkedAllocation implements  ICommands {


    ArrayList<Boolean> blocks;
    Directory root;


    boolean isBlockFree(int bIndex)
    {
        return blocks.get(bIndex);
    }
    LinkedAllocation()
    {
        blocks= new ArrayList<Boolean>(100);
        root=new Directory("root");
    }
    @Override
    public void createFile(int size, String[] path, int pLength) {
        Directory temp = root;
        String filename=path[pLength-1];
        boolean exists = false;
        for (int i =1 ; i<pLength-1 ; i++)
        {
            exists = false;
            for(int t=0;t<temp.subdirectories.size(); t++)
            {
                if(temp.subdirectories.get(t).Dname.equals(path[i])) ///if the path given exists in the structure.
                {
                    temp = temp.subdirectories.get(t);///change the current root to temp...
                    exists=true;
                }

            }

        }

        if(temp==root)
        {
            for (int i = 0 ; i<temp.files.size() ; i++)
            {
                if(root.files.get(i).fName.equals(filename))
                {
                    System.out.println("file already exists");
                    return;
                }

            }

            File newFile=new File();
            newFile.fName=filename;
            newFile.size=size;
            System.out.println(filename);
            root.files.add(newFile);
            System.out.println("file added success");
        }
        if(exists)
        {
            for (int i = 0 ; i<temp.files.size() ; i++)
            {
                if(temp.files.get(i).fName.equals(filename))
                {
                    System.out.println("file already exists");
                    return;
                }

            }
            File newFile=new File();
            newFile.fName=filename;
            newFile.size=size;
            System.out.println(filename);
            temp.files.add(newFile);
            System.out.println("file added success");
        }
    }

    @Override
    public void createFolder(String[] path, int pLength) {
        Directory temp = root;
        String dName=path[pLength-1];
        boolean exists = false;
        for (int i =1 ; i<pLength-1 ; i++)
        {
            exists = false;
            for(int t=0;t<temp.subdirectories.size(); t++)
            {
                if(temp.subdirectories.get(t).Dname.equals(path[i])) ///if the path given exists in the structure.
                {
                    temp = temp.subdirectories.get(t);///change the current root to temp...
                    exists=true;
                }

            }

        }

        if(temp==root)
        {
            for (int i = 0 ; i<temp.subdirectories.size() ; i++)
            {
                if(root.subdirectories.get(i).Dname.equals(dName))
                {
                    System.out.println("file already exists");
                    return;
                }

            }

            Directory d = new Directory(dName);
            root.subdirectories.add(d);
            System.out.println("Folder added success");
        }
        if(exists)
        {
            for (int i = 0 ; i<temp.subdirectories.size() ; i++)
            {
                if(temp.subdirectories.get(i).Dname.equals(dName))
                {
                    System.out.println("file already exists");
                    return;
                }
            }
            Directory d = new Directory(dName);
            root.subdirectories.add(d);
            System.out.println("Folder added success");
        }
    }

    @Override
    public void deleteFile(String[] path, int pLength) {

    }

    @Override
    public void deleteFolder(String[] path, int pLength) {

    }

    @Override
    public void displayDiskStatus(Directory root) {

    }

    @Override
    public void displayDiskStructure(Directory root) {

    }
}

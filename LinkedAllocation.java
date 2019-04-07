package com;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedAllocation implements  ICommands {


    ArrayList<Boolean> blocks;
    //ArrayList<Integer> linked;
    LinkedList<Integer> linked ;
    int numberOfAllocated;
    Directory root;


    boolean isBlockFree(int bIndex)
    {
        return blocks.get(bIndex);
    }
    LinkedAllocation()
    {
        blocks= new ArrayList<>(100);
        numberOfAllocated = 0;
        linked = new LinkedList<>();
        for(int i=0;i<100;i++)
        {
            blocks.add(true);
        }
        root=new Directory("root");
    }
    @Override
    public void createFile(int size, String[] path, int pLength)
    {
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
            if (!checkAllAvail(size,newFile)) {
                System.out.println("Not avail Blocks");
                return;
            }
            newFile.fName=filename;
            newFile.size=size;
            System.out.println(filename);
            root.files.add(newFile);
            int newIndex = root.files.indexOf(newFile);
            System.out.println(root.files.get(newIndex).allocatedBlocks);

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
            if (!checkAllAvail(size,newFile))
            {
                System.out.println("Not avail Blocks");
                return;
            }
            newFile.fName=filename;
            newFile.size=size;
            System.out.println(filename);
            temp.files.add(newFile);
            System.out.println("file added success");
        }
    }

    private boolean checkAllAvail(int size,File file)
    {
        if (numberOfAllocated+size>100)
        {
            return false;
        }
        for(int i=0;i<size;i++)
        {
            int random = (int )(Math.random() * 99 + 0);
            if(isBlockFree(random))
            {
                blocks.set(random,false);
                numberOfAllocated++;
                linked.add(random);
                file.allocatedBlocks.add(random);
            }
            else
            {
                i--;
            }
        }
        linked.add(-1);
        return true;
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
    public void displayDiskStatus()
    {
        System.out.println("Number of allocated blocks: " + numberOfAllocated);
        System.out.println("Number of free blocks: " + (100-numberOfAllocated));
        for(int i=0;i<100;i++)
        {
            if(blocks.get(i))
                System.out.print("("+i+"f)");
            else
                System.out.print("("+i+"a)");
            if(i%10==0 && i!=0)
                System.out.println(" ");
        }
    }

    @Override
    public void displayDiskStructure(Directory root, String indent)
    {
        System.out.println(indent + root.Dname);
        indent += "\t";
        for (int i = 0; i< root.files.size() ; i++)
            System.out.println(indent + root.files.get(i).fName);
        for(int i=0; i<root.subdirectories.size();i++)
            displayDiskStructure(root.subdirectories.get(i), indent);
    }
}
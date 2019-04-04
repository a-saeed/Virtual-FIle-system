package com;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ContiguousAllocation implements ICommands {

    ArrayList<Boolean> blocks;
    Directory root;
    PriorityQueue<>


    ContiguousAllocation()
    {
        blocks= new ArrayList<Boolean>(100);
        root=new Directory("root");
    }



    @Override
    public void createFile(int size, String[] path, int pLength) {

    }

    @Override
    public void createFolder(String[] path, int pLength) {

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

package com;

import java.util.ArrayList;

public class File
{
    public String fName;
    public ArrayList<Integer> allocatedBlocks;
    public  int size;
    File()
    {
        allocatedBlocks = new ArrayList<>();
    }

}

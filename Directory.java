package com;

import java.util.ArrayList;

public class Directory {
    private String Dname;
    private ArrayList<File> files;
    private  ArrayList<Directory> subdirectories;

    public Directory(String root) {
        Dname=root;
    }
}

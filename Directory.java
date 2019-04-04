package com;

import java.util.ArrayList;

public class Directory {
    public String Dname;
    public ArrayList<File> files;
    public  ArrayList<Directory> subdirectories;

    public Directory(String root) {
        Dname=root;
        files = new ArrayList<>();
        subdirectories = new ArrayList<>();
    }
}

package com;

public interface ICommands {

    void createFile(int size , String path[] , int pLength);
    void createFolder( String path[] , int pLength);
    void deleteFile( String path[] , int pLength);
    void deleteFolder( String path[] , int pLength);
    void displayDiskStatus(Directory root);
    void displayDiskStructure(Directory root);



}

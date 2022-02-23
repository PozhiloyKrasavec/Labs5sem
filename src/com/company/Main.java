package com.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        File sDir = new File("D:\\Горный");
        Vector<String> BackPaths = new Vector<>();
        Vector<String> FilePaths = createFilePaths(sDir);
        System.out.println("Current directory"+sDir.getPath());
        dirOut(sDir);
        BackPaths.add(sDir.getAbsolutePath());
        System.out.println("Command list: 1 - Move next, 2 - Move Back, 3 - Configuration out, 4 - Delete file, 5 - Create File, 6 - Create Dir, 7 - Read file, 8 - exit");
        int comm = in.nextInt();
        while(comm!=8)
        {
            switch (comm)
            {
                case 1:{
                    System.out.println("Enter a directory num");
                    int dirNum = in.nextInt();
                    File cDir = new File(FilePaths.get(dirNum-1));
                    System.out.println("Current directory"+cDir.getPath());
                    dirOut(cDir);
                    FilePaths.clear();
                    FilePaths = createFilePaths(cDir);
                    BackPaths.add(cDir.getParent());
                    break;
                }
                case 2:{
                    File cDir = new File(BackPaths.lastElement());
                    System.out.println("Current directory"+cDir.getPath());
                    dirOut(cDir);
                    FilePaths.clear();
                    FilePaths = createFilePaths(cDir);
                    BackPaths.remove(BackPaths.lastElement());
                    break;
                }
                case 3:{
                    for (int i=0;i<FilePaths.size();i++)
                    {
                        File ftemp = new File(FilePaths.get(i));
                        if(ftemp.isDirectory())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - directory");
                        }
                        else if(ftemp.isFile())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - file");
                        }
                    }
                    System.out.println("Enter a element num");
                    int elemNum = in.nextInt();
                    File cDir = new File(FilePaths.get(elemNum-1));
                    if (cDir.isFile())
                    {
                        System.out.println("File - " + cDir.getName());
                        if (cDir.canWrite()) System.out.println("Available to write");
                        else System.out.println("No available to write");
                        if (cDir.canRead()) System.out.println("Available to read");
                        else System.out.println("No available to read");
                        if (cDir.isHidden()) System.out.println("File is hidden");
                        else System.out.println("File isn't hidden");
                        System.out.println("Path - " + cDir.getPath());
                        System.out.println("size - " + cDir.length());
                    }
                    else if(cDir.isDirectory())
                    {
                        System.out.println("Directory - " + cDir.getName());
                        if (cDir.isHidden()) System.out.println("Directory is hidden");
                        else System.out.println("Directory isn't hidden");
                        System.out.println("Path - " + cDir.getPath());
                        System.out.println("size - " + cDir.length());
                    }
                    break;
                }
                case 4:{
                    for (int i=0;i<FilePaths.size();i++)
                    {
                        File ftemp = new File(FilePaths.get(i));
                        if(ftemp.isDirectory())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - directory");
                        }
                        else if(ftemp.isFile())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - file");
                        }
                    }
                    System.out.println("Enter a file num");
                    int fileNum = in.nextInt();
                    File cDir = new File(FilePaths.get(fileNum-1));
                    cDir.delete();
                    FilePaths.remove(fileNum-1);
                    break;
                }
                case 5:{
                    for (int i=0;i<FilePaths.size();i++)
                    {
                        File ftemp = new File(FilePaths.get(i));
                        if(ftemp.isDirectory())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - directory");
                        }
                        else if(ftemp.isFile())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - file");
                        }
                    }
                    String stemp = in.nextLine();
                    File cDir = new File(BackPaths.lastElement(),stemp+".txt");
                    cDir.createNewFile();
                    FilePaths.add(cDir.getPath());
                    break;
                }
                case 6:{
                    for (int i=0;i<FilePaths.size();i++)
                    {
                        File ftemp = new File(FilePaths.get(i));
                        if(ftemp.isDirectory())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - directory");
                        }
                        else if(ftemp.isFile())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - file");
                        }
                    }
                    String stemp = in.nextLine();
                    File cDir = new File(BackPaths.lastElement()+"\\"+stemp);
                    if(cDir.mkdir()) FilePaths.add(cDir.getPath());
                    else System.out.println("directory not created");
                    break;
                }
                case 7:{
                    for (int i=0;i<FilePaths.size();i++)
                    {
                        File ftemp = new File(FilePaths.get(i));
                        if(ftemp.isDirectory())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - directory");
                        }
                        else if(ftemp.isFile())
                        {
                            System.out.println(i+1+"\t"+ftemp.getName()+" - file");
                        }
                    }
                    System.out.println("Enter a file num");
                    int fileNum = in.nextInt();
                    File cDir = new File(FilePaths.get(fileNum));
                    Desktop.getDesktop().edit(cDir);
                    break;
                }
                default:{
                    System.out.println("WRONG COMMAND");
                    break;
                }
            }
            System.out.println("Command list: 1 - Move next, 2 - Move Back, 3 - Configuration out, 4 - Delete file, 5 - Create File, 6 - Create Dir, 7 - Read file, 8 - exit");
            comm = in.nextInt();
        }
    }
    public  static void dirOut(File sDir)
    {
        if(sDir.isDirectory())
        {
            for (int i=0;i<sDir.listFiles().length;i++)
            {
                if(sDir.listFiles()[i].isDirectory()) System.out.println(i+1+" -\t"+sDir.listFiles()[i].getName() + "- directory");
                else if(sDir.listFiles()[i].isFile()) System.out.println(i+1+" -\t"+sDir.listFiles()[i].getName() + "- file");
            }
        }
    }
    public static Vector<String> createFilePaths(File sDir)
    {
        Vector <String> vector = new Vector<>();
        if (sDir.isDirectory())
        {
            for (File item:
                    sDir.listFiles()) {
                vector.add(item.getAbsolutePath());
            }
        }
        return vector;
    }



}


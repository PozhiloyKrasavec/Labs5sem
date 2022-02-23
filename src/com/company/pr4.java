package com.company;

import java.awt.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

public class pr4 {
    private static File sDir;
    public pr4()
    {
        sDir = new File("D:\\Горный");
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        pr4_1 pr4s = new pr4_1();
        System.out.println("Current directory"+sDir.getPath());
        dirOut(sDir);
        System.out.println("Command list: 1 - Move next, 2 - Move Back, 3 - Configuration out, 4 - Delete file, 5 - Create File, 6 - Create Dir, 7 - Read file, 8 - exit, 9 - Current DirOut");
        int comm = in.nextInt();
        while(comm!=8)
        {
            switch (comm)
            {
                case 1:{
                    System.out.println("Enter a directory num");
                    int dirNum = in.nextInt();
                    File cDir = new File(sDir.listFiles()[dirNum-1].getPath());
                    System.out.println("Current directory"+cDir.getPath());
                    dirOut(cDir);
                    sDir = cDir;
                    break;
                }
                case 2:{
                    File cDir = new File(sDir.getParent());
                    System.out.println("Current directory"+cDir.getPath());
                    dirOut(cDir);
                    sDir = cDir;
                    break;
                }
                case 3:{
                    System.out.println("Enter a element num");
                    int elemNum = in.nextInt();
                    File cDir = new File(sDir.listFiles()[elemNum-1].getPath());
                    System.out.println("Current directory"+cDir.getParent());
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
                        System.out.println("LastModif - " + new Date(cDir.lastModified()));
                    }
                    else if(cDir.isDirectory())
                    {
                        System.out.println("Directory - " + cDir.getName());
                        if (cDir.isHidden()) System.out.println("Directory is hidden");
                        else System.out.println("Directory isn't hidden");
                        System.out.println("Path - " + cDir.getPath());
                        System.out.println("size - " + cDir.length());
                        System.out.println("LastModif - " + new Date(cDir.lastModified()));
                    }
                    break;
                }
                case 4:{
                    System.out.println("Enter a file num");
                    int fileNum = in.nextInt();
                    File cDir = new File(sDir.listFiles()[fileNum-1].getPath());
                    System.out.println("Current directory"+cDir.getParent());
                    cDir.delete();
                    break;
                }
                case 5:{
                    in.nextLine();
                    System.out.println("enter file name1");
                    String stemp = in.nextLine();
                    File cDir = new File(sDir.getPath(),stemp+".txt");
                    System.out.println("Current directory"+cDir.getParent());
                    if(cDir.createNewFile()) System.out.println("File create");
                    else System.out.println("Not create");
                    break;
                }
                case 6:{
                    in.nextLine();
                    System.out.println("enter dir name");
                    String stemp = in.nextLine();
                    File cDir = new File(sDir.getPath()+"\\"+stemp);//for win \\
                    System.out.println("Current directory "+cDir.getPath());
                    if(cDir.mkdir()) sDir = cDir ;
                    else System.out.println("directory not created");
                    break;
                }
                case 7:{
                    System.out.println("Enter a file num");
                    int fileNum = in.nextInt();
                    File cDir = new File(sDir.listFiles()[fileNum-1].getPath());
                    System.out.println("Current directory"+cDir.getParent());
                    Desktop.getDesktop().edit(cDir);
                    break;
                }
                case 9:{
                    dirOut(sDir);
                    break;
                }
                default:{
                    System.out.println("WRONG COMMAND");
                    break;
                }
            }
            System.out.println("Command list: 1 - Move next, 2 - Move Back, 3 - Configuration out, 4 - Delete file, 5 - Create File, 6 - Create Dir, 7 - Read file, 8 - exit, 9 - Current DirOut");
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
}

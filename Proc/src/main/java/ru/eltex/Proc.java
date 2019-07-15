package ru.eltex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


class Proc
{
    public void temp() /*throws FileNotFoundException, IOException */{
        for (Integer i = 0; i < 65536; i++)
        {
            File procTemp = new File("/proc/" + i + "/");
            if (procTemp.exists()) {
                try {
                    FileReader proc = new FileReader("/proc/" + i + "/stat");
                    Scanner sc = new Scanner(proc);
                    String tempStr = sc.nextLine();
                    String[] temp = tempStr.split(" \\(");
                    String[] temp2 = temp[1].split("\\)");
                    proc.close();

                    System.out.println(temp2[0] + "\t\t" + i.toString());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }
    }
}
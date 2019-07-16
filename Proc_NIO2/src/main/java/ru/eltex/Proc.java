package ru.eltex;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;

class Proc
{
    public void listProc()
    {
        Path files = Paths.get("/home/user/Загрузки/");
        String input;
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(files);
            String file;
            System.out.println("Список всех файлов в:" + files);
            for (Path dir : stream) {
                file = dir.getFileName().toString();
                System.out.println(file);
            }
            System.out.println("Введите файл, который хотите удалить: ");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            File delFile = new File(files + "/" +  input);
            System.out.println(delFile);
            if (delFile.delete())
            {
                System.out.println("Файл " + input + " был удален");
            } else
            {
                System.out.println("Этот файл невозможно удалить");
            }
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
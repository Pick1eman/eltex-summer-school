package ru.eltex;

import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Stream;

class Proc
{
    public void listProc()
    {
        Path files = Paths.get("/proc/");
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(files);
            for(Path dir:stream)
            {
                String proc = dir.getFileName().toString();
                if (Integer.parseInt(proc) >= 0 && Integer.parseInt(proc) < 65536)
                {
                    
                }
                System.out.println(proc);
            }
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
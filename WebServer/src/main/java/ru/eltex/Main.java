package ru.eltex;


import java.io.*;
import java.net.*;
import java.util.*;

class Main
{
    public static void main(String[] args) {
        try(ServerSocket s = new ServerSocket(2973))
        {
            File file = new File("/home/user/Рабочий стол/eltex-summer-school/WebServer/resources/index.html");
            Scanner scFile = new Scanner(file).useDelimiter("\0");
            String in = scFile.next();

            while (true)
            {
                Socket client = s.accept();
                new Thread(()->{
                    try {
                        OutputStream outStream = client.getOutputStream();
                        PrintWriter out = new PrintWriter(outStream);
                        String serv = "HTTP/1.0 200 OK\nContent-Length:" + Integer.toString(in.length()) + "\n\n" + in;
                        out.write(serv);
                        out.flush();
                    } catch (IOException error)
                    {
                        System.err.println(error.getMessage());
                    }
                }).start();
            }
        } catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}
package ru.eltex;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) {
        try(Socket s = new Socket("172.21.0.134",1025))
        {
            InputStream inStream = s.getInputStream();
            OutputStream outStream = s.getOutputStream();
            Scanner sc = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                System.out.println(line);
                out.write(line);
                out.flush();
            }
        } catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}

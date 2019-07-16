package ru.eltex;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) {
        try(ServerSocket s = new ServerSocket(1025))
        {
            Socket client  = s.accept();
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            Scanner sc = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            out.write("Test!");
            out.flush();
        } catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}
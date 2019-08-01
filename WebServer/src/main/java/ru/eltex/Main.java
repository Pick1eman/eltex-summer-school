package ru.eltex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.net.*;
import java.util.*;

@SpringBootApplication
class Main
{
    public String serv = "";
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository mongoRepository)
    {
        return (args)-> {
            ServerSocket serverSocket = new ServerSocket(2973);
            File file = new File("/home/user/Рабочий стол/eltex-summer-school/WebServer/src/main/resources/index.html");
            Scanner scFile = new Scanner(file).useDelimiter("\0");
            String in = scFile.next();

            while (true)
            {
                Socket client = serverSocket.accept();
                new Thread(()->{
                    OutputStream outStream = null;
                    InputStream inputStream = null;
                    try {
                        outStream = client.getOutputStream();
                        inputStream = client.getInputStream();
                        Scanner inScanner = new Scanner(inputStream);
                        String get = inScanner.nextLine();
                        String []temp = get.split(" ");
                        String []token = temp[1].split("/");
                        System.out.println(token[1]);
                        PrintWriter out = new PrintWriter(outStream);
                        serv = "HTTP/1.0 200 OK\nContent-Length:" + Integer.toString(in.length()) + "\n\n" + in;
                        if (token[1].equals("get_users") && token.length == 2)
                        {
                            mongoRepository.findAll().forEach((elem)->{serv += "\nid = " + elem.getId() + "; Fio = \"" + elem.getFio() + "\"; Phone = " + elem.getPhone();});
                            out.write(serv); out.flush();
                        } else if (token[1].equals("get_user")){
                            mongoRepository.findAll().forEach((elem) -> {if (Integer.parseInt(token[2]) == elem.getId()) {serv += "\nid = " + elem.getId() + "; Fio = \"" + elem.getFio() + "\"; Phone = " + elem.getPhone();}});
                            out.write(serv); out.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        };
    }
}
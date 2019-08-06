package ru.eltex;

import org.codehaus.jackson.map.ObjectMapper;
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
    private static String serv = "";
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository mongoRepository)
    {
        return (args)-> {
            ServerSocket serverSocket = new ServerSocket(2973);

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
                        String output = "";
                        if (token[1].equals("get_users") && token.length == 2)
                        {
                            ObjectMapper objectMapper = new ObjectMapper();
                            ArrayList<User> users = new ArrayList<>(mongoRepository.findAll());
                            output = objectMapper.writeValueAsString(users);
                            output = "HTTP/1.1 200 OK\nContent-Type:application/json\n\n" + output;
                            System.out.println(output);
                            out.write(output);
                            out.flush();
                        } else if (token[1].equals("get_user")){
                            ObjectMapper objectMapper = new ObjectMapper();
                            User user = mongoRepository.findById(Integer.valueOf(token[2])).get();
                            output = objectMapper.writeValueAsString(user);
                            output = "HTTP/1.1 200 OK\nContent-Type:application/json\n\n" + output;
                            out.write(output);
                            out.flush();
                        } else if (token[1].equals("index.html") && token.length == 2)
                        {
                            File file = new File("/home/user/Рабочий стол/eltex-summer-school/WebServer/src/main/resources/index.html");
                            Scanner scFile = new Scanner(file).useDelimiter("\0");
                            String html = scFile.next();
                            serv = "HTTP/1.0 200 OK\nContent-Length:" + html.length() + "\n\n" + html;
                            out.write(serv);
                            out.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        };
    }
}
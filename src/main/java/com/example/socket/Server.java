package com.example.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("server started");

        try{

                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected " + clientSocket.getRemoteSocketAddress());
                Scanner scan = new Scanner(System.in);

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                while(true){

                String msg;
                String reply;
                if((msg = in.readLine()) != null) {
                    System.out.printf("hi %s, your port is %d \n", msg, clientSocket.getPort());
                    System.out.println("Напишите ответ ");
                    reply =scan.nextLine();
                    out.println(reply);
                }if("end".equals(msg)) {
                    break;
                }

            }
        }catch (IOException ex){
            ex.printStackTrace();
            serverSocket.close();
        }
    }
}

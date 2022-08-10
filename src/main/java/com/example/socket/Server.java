package com.example.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

public class Server {
    public static void main(String[] args) throws IOException {


          ServerSocket serverSocket = new ServerSocket(8080);
                 out.println("server started");

                Socket clientSocket = serverSocket.accept();
                out.println("client connected " + clientSocket.getRemoteSocketAddress());
                Scanner scan = new Scanner(System.in);


              try(    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                  BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                  while (true) {

                      String msg;
                      String reply;
                      if ((msg = in.readLine()) != null) {
                          System.out.printf("Port # %d \nMessage: %s \n", clientSocket.getPort(), msg);
                          System.out.println("Напишите ответ ");
                          reply = scan.nextLine();
                          out.println(reply);
                      }
                      if ("end".equals(msg)) {
                          break;
                      }
                      serverSocket.close();
                  }
              }

    }
}

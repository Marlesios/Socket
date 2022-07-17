package com.example.socket;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);

            try(BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(
                       new OutputStreamWriter(socket.getOutputStream()),true);
                Scanner scanner = new Scanner(System.in)){
                     String msg;
                     String reply;
                while(true){
                    System.out.println("Enter message for server....");
                    msg = scanner.nextLine();
                    out.println(msg);
                    reply = in.readLine();
                    System.out.println("Server: " + reply);
                    if("end".equals(msg)) break;
                }
            }



    }
}

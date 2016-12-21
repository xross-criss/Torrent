package xyz.morecraft.dev.xross.torrenter.engine;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP {
    public void TCPclient() throws IOException {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("127.0.0.1", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + "\n");
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }

    public void TCPServer() throws IOException {
        int firsttime = 1;
        while (true) {
            String clientSentence;
            String capitalizedSentence = "";
            ServerSocket welcomeSocket = new ServerSocket(3248);
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            //System.out.println(clientSentence);
            if (clientSentence.equals("set")) {
                outToClient.writeBytes("connection is ");
                System.out.println("running here");
                //welcomeSocket.close();
                //outToClient.writeBytes(capitalizedSentence);
            }
            capitalizedSentence = clientSentence.toUpperCase() + "\n";
            //if(!clientSentence.equals("quit"))
            outToClient.writeBytes(capitalizedSentence + "enter the message or command: ");
            System.out.println("passed");
            //outToClient.writeBytes("enter the message or command: ");
            welcomeSocket.close();
            System.out.println("connection terminated");
        }
    }
}


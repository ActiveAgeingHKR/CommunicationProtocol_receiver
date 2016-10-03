/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicationprotocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Receiver {
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    ObjectInputStream in = null;
    PrintWriter out = null;

    public void receive() {
        establishContact();
        Customer person = null;
        try {
            person = (Customer) in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("Person info: " + person.getName() + " " + person.getPulse());
        closeConnection();
    }
    
    public void establishContact() {
        try {
            serverSocket = new ServerSocket(12345);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 12345");
            System.exit(-1);
        }
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 1234");
            System.exit(-1);
        }
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException ioe) {
            System.out.println("Failed in creating streams");
            System.exit(-1);
        }
    }


    private void closeConnection() {
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Could not close");
            System.exit(-1);
        }
    }
}

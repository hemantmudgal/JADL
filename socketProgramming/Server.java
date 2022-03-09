/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 09-03-2022
 *   Time: 09:28
 *   File: Server.java
 */

package socketProgramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(4000);
        System.out.println("Waiting for client connection ");
        Socket clientSocket = socket.accept();
        System.out.println("Client Connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        String msg;

        do{
            msg = in.readLine();
            System.out.println("Client Send " + msg);
            out.println("Severs acknowledge about " + msg);

        }while (!msg.equals("exit"));

    }
}
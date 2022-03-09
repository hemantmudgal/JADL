/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 09-03-2022
 *   Time: 14:23
 *   File: MulitThreadedServer.java
 */

package socketProgramming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(4001);
        System.out.println("Sever Started\n waiting for the client connection");

        while (true) {
            Socket client = socket.accept();
            System.out.println("Client Connected ");
            Messaging obj = new Messaging(client);
            obj.start();
        }
    }
}
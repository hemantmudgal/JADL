/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 09-03-2022
 *   Time: 14:23
 *   File: Messaging.java
 */

package socketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Messaging extends Thread {

    Socket clientSocket;

    public Messaging(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String msg = null;

            do {

                    msg = in.readLine();
                System.out.println("Client Send " + msg);
                out.println("Severs acknowledge about " + msg + " " + Thread.currentThread().getName());

            } while (!msg.equals("exit"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
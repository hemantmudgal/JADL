/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 09-03-2022
 *   Time: 09:28
 *   File: Client.java
 */

package socketProgramming;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost",4000);
        System.out.println("Server Connected");

        BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        Scanner sc = new Scanner(System.in);
        String msg;

        do{
            System.out.println("Enter the message which you want to send to the server");
            msg = sc.nextLine();

            out.println(msg);
            String response = in.readLine();

            System.out.println(response);
        }while(!msg.equals("exit"));

    }
}
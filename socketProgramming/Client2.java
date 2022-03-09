/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 09-03-2022
 *   Time: 14:43
 *   File: Client2.java
 */

package socketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",4001);
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
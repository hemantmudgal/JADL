/*   Created by IntelliJ IDEA.
 *   Author: Hemant Mudgal
 *   Date: 09-03-2022
 *   Time: 09:28
 *   File: Client.java
 */

package socketProgramming;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost",4000);
        System.out.println("Client Connected");
    }
}
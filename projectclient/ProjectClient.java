/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectclient;

import java.net.SocketException;

/**
 *
 * @author Naima
 */
public class ProjectClient 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //inputs
        String host;
        int port;
        if (args.length != 2)
        {
            host = "141.217.48.36";
            //host = "localhost";
            port = 4037;
        }
        else
        {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
        
        //Creating Client to communicate with server
        TCPClient c = new TCPClient();
        c.Connect(host, port);
        
        if(!c.IsConnected())
        {
            SocketException ex = new SocketException("Socket is not connected");
            ErrorHandler.HandleError(TCPClient.class.getName(), ex);
        }
        
        //setup to communication with server from client
        c.InitSocketIO();
        
        //start conversation
        c.StartCommunication();
        c.Close();
    }
    
}

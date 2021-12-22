package com.bianchi;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

public class Main 
{
    private static final int PORT = 8082;
    static final boolean verbose = true;

    public static void main(String[] args) 
	{
		try 
		{
			ServerSocket serverConnect = new ServerSocket(PORT);

			System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");
			
			// we listen until user halts server execution
			while (true) 
			{
				JavaHTTPServer myServer = new JavaHTTPServer(serverConnect.accept());
				
				if (verbose) 
				{
					System.out.println("Connecton opened. (" + new Date() + ")");
				}
				
				// create dedicated thread to manage the client connection
				Thread thread = new Thread(myServer);
				thread.start();
			}
			
		} 
		catch (IOException e) 
		{
			System.err.println("Server Connection error : " + e.getMessage());
		}
	}
}

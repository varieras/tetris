package fr.esiea.tetrisreseau;


	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.net.Socket;
	import java.net.UnknownHostException;

	public class Client
	{
	    private static int    port;
	    private static Socket socket;

	    public static void main(String[] args)
	    {
	        InputStream input   = null;
	    
	        try
	        {
	            port   = (args.length == 1) ? Integer.parseInt(args[0]) : 8080;
	            socket = new Socket((String) null, port);
	            input = socket.getInputStream();

	            // Show the server response
	            String response = new BufferedReader(new InputStreamReader(input)).readLine();
	            System.out.println("Server message: " + response);
	        }
	        catch (UnknownHostException e)
	        {
	            e.printStackTrace();
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                input.close();
	                socket.close();
	            }
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	

package es1;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Rx {
	
	private ServerSocket server;
	private Socket conn;
	private PrintStream alClient;
	private Scanner dalClient;

	public Rx() {

		try {
			server =new ServerSocket(15111);
			conn=server.accept();
			dalClient =new Scanner(conn.getInputStream());
			alClient=new PrintStream(conn.getOutputStream());
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void conversazione() {
		int c=0;
		int d=0;
		String m="";
		try {
			while(!m.equalsIgnoreCase("EE")) {
				m=dalClient.nextLine();
				System.out.println(m);
				if(!m.contains("A")&&!m.contains("E")&&!m.contains("I")&&!m.contains("O")&&!m.contains("U")&&!m.isEmpty()) {
					c++;
				}
				if(!m.contains("0")&&!m.contains("2")&&!m.contains("4")&&!m.contains("6")&&!m.contains("8")&&!m.isEmpty()) {
					d++;
				}
				
				
			}
			
			m="numero di consonanti:"+c+" numero dei numeri dispari:"+d;

			alClient.println(m);
			
			server.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
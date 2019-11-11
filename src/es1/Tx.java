package es1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Tx {
	private Socket conn;
	private Scanner s,dalServer;
	private PrintStream alServer;
	
	public Tx() {
		s=new Scanner(System.in);
		System.out.println("indirizzo di server ");
		String indirizzo=s.next();
		
		try {
			conn=new Socket(indirizzo,15111);
			
			dalServer=new Scanner(conn.getInputStream());
			alServer=new PrintStream(conn.getOutputStream());
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	public void conversazione() {
		String m = "";
		int p=0;

		try {
			while(p!=30) {
				
				m = "\n"+ (char)(int)(Math.random() * 26 + 65)+""+ (int) (Math.random() * 10)+"\n";
				System.out.println(m);
				alServer.println(m);
				if (!m.contains("1") && !m.contains("3") && !m.contains("5") && !m.contains("7") && !m.contains("9")) {
					p++;
				}

			}
			
			alServer.println("\nEE\n");
			

			m=dalServer.nextLine();
			System.out.println(m);
			
			
			conn.close();
			s.close();
			alServer.close();
			dalServer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

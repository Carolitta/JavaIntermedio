
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
public class Client{
	ClientReceiver cr;
	ClientSender cs;
	Socket s;

	public Client(Socket s) throws IOException{
		this.cr = new ClientReceiver(s);
		this.cs = new ClientSender(s);
		this.s = s;
	}

	public void run(){
		this.cr.start();
		this.cs.start();
	}

	public static void main(String[] args) throws IOException{
		String host;
		int port;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the host address: ");
		host =sc.nextLine();
		System.out.println("Enter the port: ");
		port= sc.nextInt();

		Socket s = new Socket(host,port);

		Client c = new Client(s);
		c.run();
	}
}

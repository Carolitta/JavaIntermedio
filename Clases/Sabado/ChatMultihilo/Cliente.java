import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;

public class Cliente{

	private PrintStream ps;
	private String host;
	private int port;

	//metodo set 
	public void setHost(String host){
		this.host = host;
	}

	public void setPort(int port){
		this.port = port;
	}

	//metodo que haga la conexion 

	public void conectar() throws IOException{
		Socket s = new Socket(host,port);
		ps = new PrintStream(s.getOutputStream());
	}
	//dnvia el mensaje con printstream
	public void enviar(String mensaje) throws IOException{
		ps.println(mensaje);
	}
	//cierra los flujos
	public void cerrar() throws IOException{
		ps.close();
	}

	public static void main(String[] args) throws IOException{
		//flijo de teclado 

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		Cliente c = new Cliente();
		System.out.print("Host: ");
		c.setHost(teclado.readLine());
		System.out.print("Puerto: ");
		c.setPort(Integer.parseInt(teclado.readLine()));
		c.conectar();

		String str="";

		while(!str.equals("quit")){
			System.out.print("Mensaje: ");
			str = teclado.readLine();
			c.enviar(str);
		}
		c.cerrar();
	}


}
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;

public class Servidor extends Thread{

	//atributos
	private String nombreCliente;
	private BufferedReader entrada;

	///constructor
	public Servidor(Socket s) throws IOException{
		entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
		nombreCliente = s.getInetAddress().getCanonicalHostName();//direcion ip es de tipo string por eso se guarda en nombre cliente
		//.getCanonicalHostName(); es para cuando configutaste tu direccio ip por un nombre
		System.out.println("Conexion aceptada desde: "+s.getRemoteSocketAddress());
	}	

	//crearemos metodos

	public String recibir() throws IOException{
		String str = entrada.readLine();
		return str;
	}

	public void cerrar() throws IOException{
		entrada.close();
	}

	//definimos las acciones de cliente para cada hilo
	@Override
	public void run(){
		try{
			String str = "";
			while(!str.equals("salir")){
				str = recibir();
				System.out.println(nombreCliente + " dice "+str);

			}
		}catch(IOException ex){
			System.out.println("Se cerro la conexion con: "+nombreCliente);
		}finally{
			try{
				cerrar();
			}catch(IOException ex){}
		}
	}


	public static void main(String[] args) throws IOException {
		
		ServerSocket ss;
		ss = new ServerSocket(9998);
		System.out.println("Servidor aceptado conexiones en el puerto "+ss.getLocalPort());
			
		while(true){
			Socket cliente = ss.accept();
			Servidor hilo = new Servidor(cliente);
			hilo.start();
		}
	}
}
//192.168.5.148 de rodrigo 

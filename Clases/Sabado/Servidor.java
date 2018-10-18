import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;

public class Servidor{
	public static void main(String[] args) throws IOException{
		
		//Paso. Crear un socketServer 
		
		ServerSocket ss = new ServerSocket(9999);//puerto que seguramente esta libre
		System.out.println("Esperando conexion en el puerto 9999");

		//Paso 2. Esperar una conexión 

		//esperarmos la peticion de un cliente por lo que crearemos un objeto
		Socket s = ss.accept();//conexion de un cliente mediante el servidor ss
		System.out.println("Conexion aceptada desde: "+ s.getInetAddress());//getInet devuelve la direccion ip del cliente

		//creamos cadena vacia
		String str = "";

		//Paso 3. Obetener los flujos de I/O del socket 

		//vamos a leer del cliente  un flujo de caracteres 
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		//como servidor tambien envio mensajes
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		//vamos a obtener un flujo de salida del cliente, para enviarlo printStream

		PrintStream ps = new PrintStream(s.getOutputStream());

		//Paso 4. Realizar el procesamiento

		while(!str.equals("quit")){
			//Enviamos lo que escribimos
			ps.println(teclado.readLine());
			ps.flush();//limpia
			str = br.readLine();
			System.out.println(str);
		}

		//para cerrar el programa se necesita cerrar el flujo

		//Paso 5. Cerrar flujos y conexiones 

		br.close();
		s.close();
		ss.close();




	}
}
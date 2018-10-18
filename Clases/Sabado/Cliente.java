import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;

public class Cliente{
	
	public static void main(String[] args) throws IOException{
		
		//Paso 1. Crear un socket para conectar al SocketServer
		Socket 	s = new Socket("189.216.57.119",9999);

		String str = "";

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));


		//Paso 2. Obtener los flujos I/O del Socket
		
		//entrada
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//salida
		PrintStream ps = new PrintStream(s.getOutputStream());


		//Paso 3. Realizar procesamiento
		while(!str.equals("quit")){
			str=br.readLine();
			System.out.println(str);
			str = teclado.readLine();
			ps.println(str);
			ps.flush();
		}

		//Paso 4. Cerrar los flujos y conexiones
		ps.close();
		s.close();
		br.close();

	}
}
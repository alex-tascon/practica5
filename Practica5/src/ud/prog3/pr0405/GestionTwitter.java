package ud.prog3.pr0405;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class GestionTwitter {
	
	protected static HashMap<String, UsuarioTwitter> mapaUsuarios = new HashMap<String, UsuarioTwitter>(); // ID contraseña
	protected static HashMap<String, UsuarioTwitter> mapaUsuarios2 = new HashMap<String, UsuarioTwitter>(); // Nick contraseña
	
	protected static TreeSet<UsuarioTwitter> setUsuariosSistema = new TreeSet<UsuarioTwitter>();

	public static void main(String[] args) {
		try {
			// TODO Configurar el path y ruta del fichero a cargar
			String fileName = "data.csv";
			CSV.processCSV( new File( fileName ) );
			verRelaciones();
			for ( Iterator<UsuarioTwitter> it = setUsuariosSistema.iterator(); it.hasNext(); ) {
				UsuarioTwitter u = it.next();
				System.out.println( u.getScreenName() + " - " + u.getNumeroAmigosSistema() + " amigos." );
			}
			setUsuariosSistema.last().verAmigosSistema();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Método 1 - Tarea 7
	private static void verRelaciones() {
		int usuariosConAmigos = 0;
		for (String nick : mapaUsuarios2.keySet() ) {
			int contadorSistema = 0; int contadorNoSistema = 0;
			ArrayList<String> friends = mapaUsuarios2.get( nick ).getFriends();
			for (String friend : friends) {
				if (mapaUsuarios.containsKey( friend ) ) {
					mapaUsuarios.get( friend ).incrementarAmigosSistema();
					setUsuariosSistema.add( mapaUsuarios.get( friend ) );
					contadorSistema++;
				} else {
					contadorNoSistema++;
				}
			}
			if ( contadorSistema != 0) {
				System.out.println( "Usuario " + nick + " tiene " + contadorNoSistema + " amigos fuera de nuestro sistema y " + 
						contadorSistema + " dentro." );
				usuariosConAmigos++;
			}
		}
		System.out.println( "Hay " + usuariosConAmigos + " con algunos amigos dentro de nuestro sistema." );
	}
}

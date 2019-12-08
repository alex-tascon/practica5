package ud.prog3.pr0405;

import java.util.ArrayList;

public class UsuarioTwitter implements Comparable<UsuarioTwitter> {

	// Atributos
	private String id;
	private String screenName;
	private ArrayList<String> tags;
	private String avatar;
	private long followersCount;
	private long friendsCount;
	private String lang;
	private long lastSeen;
	private String tweetId;
	private ArrayList<String> friends;
	
	private int numeroAmigosSistema;
	
	// Constructor
	public UsuarioTwitter(String id, String screenName, ArrayList<String> tags, String avatar, long followersCount,
			long friendsCount, String lang, long lastSeen, String tweetId, ArrayList<String> friends) {
		super();
		this.id = id;
		this.screenName = screenName;
		this.tags = tags;
		this.avatar = avatar;
		this.followersCount = followersCount;
		this.friendsCount = friendsCount;
		this.lang = lang;
		this.lastSeen = lastSeen;
		this.tweetId = tweetId;
		this.friends = friends;
		this.numeroAmigosSistema = 0;
	}

	// Getters y setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public long getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(long followersCount) {
		this.followersCount = followersCount;
	}

	public long getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(long friendsCount) {
		this.friendsCount = friendsCount;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public long getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(long lastSeen) {
		this.lastSeen = lastSeen;
	}

	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	public ArrayList<String> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}
	
	public int getNumeroAmigosSistema() {
		return numeroAmigosSistema;
	}

	public void setNumeroAmigosSistema(int numeroAmigosSistema) {
		this.numeroAmigosSistema = numeroAmigosSistema;
	}

	// Método que crea un UsuarioTwitter por cada línea del archivo csv
	@SuppressWarnings("unchecked")
	public static UsuarioTwitter crearUsuario(ArrayList<Object> datos) {
		UsuarioTwitter u = new UsuarioTwitter((String)datos.get(0), (String)datos.get(1), (ArrayList<String>)datos.get(2),
				(String)datos.get(3), (long)datos.get(4), (long)datos.get(5), (String)datos.get(6), (long)datos.get(7),
				(String)datos.get(8), (ArrayList<String>)datos.get(9));
		return u;
	}
	
	// Método para incrementar en uno el número de amigos en el sistema
	public void incrementarAmigosSistema() {
		setNumeroAmigosSistema( this.numeroAmigosSistema + 1 );
	}

	// Método para comparar UsuarioTwitter mediante número de amigos en el sistema
	@Override
	public int compareTo(UsuarioTwitter o) {
		return this.getNumeroAmigosSistema() - o.getNumeroAmigosSistema();
	}
	
	// Método para sacar todos los amigos que tiene en nuestro sistema (Tarea 8)
	public void verAmigosSistema() {
		System.out.println("El usuario " + this.getScreenName() + " tiene " + this.getNumeroAmigosSistema() 
			+ " amigos en nuestro sistema que son:");
		for (String friend : this.getFriends()) {
			UsuarioTwitter amigo = GestionTwitter.mapaUsuarios.get( friend );
			if ( GestionTwitter.setUsuariosSistema.contains( amigo ) ) {
				System.out.print( amigo.getScreenName() + " " );
			}
		}
	}
}

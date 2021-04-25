package excepciones;

public class AlquilerNoEntregadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlquilerNoEntregadoException() {
		super("El usuario tiene dos alquileres sin devolver");
	}
}

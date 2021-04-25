package excepciones;

public class OficioNoCoincideException extends AgregarTrabajoException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public OficioNoCoincideException() {
		super("El oficio del servicio no coincide con el del trabajador");
	}	

}

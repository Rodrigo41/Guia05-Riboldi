package excepciones;

public class AgendaOcupadaException extends AgregarTrabajoException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AgendaOcupadaException() {
		super("El trabajador ya tiene un trabajo asignado esa fecha");
	}	

}

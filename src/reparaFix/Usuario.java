package reparaFix;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.AgendaOcupadaException;
import excepciones.AlquilerNoEntregadoException;

public class Usuario {

	private String nombre;
	private String correoelectronico;
	private List<Contratable> contratos;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoelectronico() {
		return correoelectronico;
	}
	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}
	public List<Contratable> getContratos() {
		return contratos;
	}
	public void setContratos(List<Contratable> contratos) {
		this.contratos = contratos;
	}
	public Usuario(String nombre, String correoelectronico, List<Contratable> contratos) {
		this.nombre = nombre;
		this.correoelectronico = correoelectronico;
		this.contratos = new ArrayList<>();
	}
	public Usuario(String nombre, String correoelectronico) {
		this.nombre = nombre;
		this.correoelectronico = correoelectronico;
		this.contratos = new ArrayList<>();
	}
	
	public void contratar(Contratable c) throws AlquilerNoEntregadoException {
		
		if(c instanceof Alquiler && this.noAlquila()) {
			throw new AlquilerNoEntregadoException();
		}
		contratos.add(c);
	}
	
	
	private Boolean noAlquila() {
		Integer contador=0;
		for(Contratable p: contratos) {
			if(p instanceof Alquiler && ((Alquiler)p).getDiadevolucion().isEqual(LocalDate.parse("2000-01-01"))) {
				contador++;
			}
		if(contador==2) {
			return true;
		}
		}
		return false;
}
}

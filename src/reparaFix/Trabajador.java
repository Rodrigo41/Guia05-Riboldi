package reparaFix;

import java.util.ArrayList;
import java.util.List;

import excepciones.AgendaOcupadaException;
import excepciones.AgregarTrabajoException;
import excepciones.OficioNoCoincideException;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.Duration;

public class Trabajador {

	private List<Trabajo> trabajo;
	private String nombre;
	private String correo;
	private double costo;
	private double comision;
	private Oficio oficio;
	
	public List<Trabajo> getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(List<Trabajo> trabajo) {
		this.trabajo = trabajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public Oficio getOficio() {
		return oficio;
	}
	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}
	public Trabajador(String nombre, String correo, double costo, double comision, Oficio oficio) {
		this.trabajo = new ArrayList<>();
		this.nombre = nombre;
		this.correo = correo;
		this.costo = costo;
		this.comision = comision;
		this.oficio = oficio;
	}
	
	public void agregarTarea(Trabajo trabajo) throws AgregarTrabajoException{
			
		if(!(trabajo.getServicio().getOficio().getId().equals(oficio.getId()))) {
			throw new OficioNoCoincideException();
		}
		if(ocupado(trabajo)){
			throw new AgendaOcupadaException();
		}
		this.trabajo.add(trabajo);
		
	}
	private boolean ocupado(Trabajo t) {
	
		for(Trabajo p:trabajo ) {
			if(DAYS.between(p.getFechainicio(), t.getFechainicio())==0) {
				return true;
			}
		}
		return false;
	}
	
	
}

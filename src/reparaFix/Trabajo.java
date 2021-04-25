package reparaFix;

import java.time.Instant;
import java.time.LocalDate;

import excepciones.AgregarTrabajoException;

public class Trabajo implements Contratable{

	private Trabajador trabajador;
	private boolean urgente;
	private Servicio servicio;
	private LocalDate fechainicio;
	private LocalDate fechafin;
	private Double horastrabajo;
	
	
	
	@Override
	public Boolean finalizado() {
		if(fechafin!=null) {
			return true;
		}
		else
			return false;
	}
	
	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public boolean isUrgente() {
		return urgente;
	}

	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public LocalDate getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(LocalDate fechainicio) {
		this.fechainicio = fechainicio;
	}

	public LocalDate getFechafin() {
		return fechafin;
	}

	public void setFechafin(LocalDate fechafin) {
		this.fechafin = fechafin;
	}

	public Double getHorastrabajo() {
		return horastrabajo;
	}

	public void setHorastrabajo(Double horastrabajo) {
		this.horastrabajo = horastrabajo;
	}

	public Trabajo(Trabajador trabajador, boolean urgente, Servicio servicio, LocalDate fechainicio, LocalDate fechafin,
			Double horastrabajo) {
		this.trabajador = trabajador;
		this.urgente = urgente;
		this.servicio = servicio;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.horastrabajo = horastrabajo;
	}
	public Trabajo(Trabajador trabajador, boolean urgente, Servicio servicio, LocalDate fechaInicio) {
		this.trabajador = trabajador;
		this.urgente = urgente;
		this.servicio = servicio;
		this.fechainicio = fechaInicio;
	}


public static Trabajo crearTrabajo(Trabajador trabajador, Servicio servicio, Boolean urgente, LocalDate fechaInicio) {
		Trabajo t= new Trabajo(trabajador, urgente, servicio, fechaInicio);
		try {
			trabajador.agregarTarea(t);
		} catch (AgregarTrabajoException e) {
			System.out.println(e.getMessage());
			t=null;
		}
		return t;
	}
	
	@Override
	public Double calcularCosto() {
	Double costoServicio=servicio.calcularCosto();
	Double costoTotal=0.0;
	Double agregar=0.0;
	
		if(servicio instanceof ServicioEstandar) {
			costoTotal=costoServicio+trabajador.getCosto()*horastrabajo+
					trabajador.getCosto()*horastrabajo*trabajador.getComision();
		}
		else
			costoTotal=costoServicio;
		if(urgente) {
			agregar=0.5;
		}
		return costoTotal+costoTotal*agregar;
	}
	@Override
	public String toString() {
		return "TRABAJO:\n" + "Trabajador: " + trabajador.getNombre() + "\n"
				+ servicio.getClass().getName() +" de: " + servicio.getOficio().getNombre() + "\n"
						+ "Es urgente? " + urgente +"\n"
						+ "Costo total: " + this.calcularCosto();
	}
	
}

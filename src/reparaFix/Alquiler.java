package reparaFix;

import java.time.*;


import static java.time.temporal.ChronoUnit.DAYS;


public class Alquiler implements Contratable{

	private Herramienta herramienta;
	private LocalDate diainicio;
	private LocalDate diafin;
	private LocalDate diadevolucion;
	
	
	@Override
	public Double calcularCosto() {
		if(!(diadevolucion.isEqual(LocalDate.parse("2000-01-01")))) {
			return DAYS.between(diainicio, diadevolucion)*herramienta.getCostopordia();
		
		}
		else
			return DAYS.between(diainicio, LocalDate.now())*herramienta.getCostopordia();
			
		
	}
	
	public Boolean enMora() {
		
		if(diadevolucion.isAfter(diafin) || ((!(diadevolucion!=null)) && LocalDate.now().isAfter(diafin))) {
			return true;	
		}
		else
			return false;
		
	}
	
	public Herramienta getHerramienta() {
		return herramienta;
	}
	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}
	public LocalDate getDiainicio() {
		return diainicio;
	}
	public void setDiainicio(LocalDate diainicio) {
		this.diainicio = diainicio;
	}
	public LocalDate getDiafin() {
		return diafin;
	}
	public void setDiafin(LocalDate diafin) {
		this.diafin = diafin;
	}
	public LocalDate getDiadevolucion() {
		return diadevolucion;
	}
	public void setDiadevolucion(LocalDate diadevolucion) {
		this.diadevolucion = diadevolucion;
	}
	public Alquiler(Herramienta herramienta, LocalDate diainicio, LocalDate diafin, LocalDate diadevolucion) {
		this.herramienta = herramienta;
		this.diainicio = diainicio;
		this.diafin = diafin;
		this.diadevolucion = diadevolucion;
	}
	
	public Alquiler(Herramienta herramienta, LocalDate diainicio, LocalDate diafin) {
		this.herramienta = herramienta;
		this.diainicio = diainicio;
		this.diafin = diafin;
	}
	

	@Override
	public Boolean finalizado() {
		if(!(diadevolucion.isEqual(LocalDate.parse("2000-01-01")))) {
		return true;
	}
		else
			return false;
}
	@Override
	public String toString() {
	
	if(diadevolucion.isEqual(LocalDate.parse("2000-01-01"))) {
		return "ALQUILER DE: \n" + 
				"Herramienta: " + herramienta.getNombre() + "\n" 
				+"Fecha de inicio: " + diainicio + "\n" 
				+"Fecha de entrega: " + diafin + "\n"
				+"Fecha de devolucion: no tiene \n"
				+"Costo total del alquiler: " + this.calcularCosto() ;
	}
	else {
		return "ALQUILER DE: \n" + 
				"Herramienta: " + herramienta.getNombre() + "\n" 
				+"Fecha de inicio: " + diainicio + "\n" 
				+"Fecha de entrega: " + diafin + "\n"
				+"Fecha de devolucion: " + diadevolucion + "\n"
				+"Costo total del alquiler: " + this.calcularCosto() ;
	}

	}
}

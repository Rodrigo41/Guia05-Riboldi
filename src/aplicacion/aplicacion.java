package aplicacion;

import java.text.ParseException;
import java.time.LocalDate;
import excepciones.AlquilerNoEntregadoException;
import reparaFix.*;

public class aplicacion {

	public static void main(String[] args) throws ParseException {

		String fecha1="2021-01-01";
		String fecha2="2021-02-02";
		String fecha3="2021-03-11";
		String fecha4="2021-04-15";
		String fecha5="2021-04-25";
		String devolucion="2000-01-01";
		
		Oficio o1= new Oficio("ALBAÑIL",1);
		Oficio o2= new Oficio("REPARACION ASCENSORES",2);
		Oficio o3= new Oficio("CARPINTERIA",3);
		Oficio o4= new Oficio("CERRAJERIA",4);
		Oficio o5= new Oficio("GASISTA",5);
		
		Trabajador t1=new Trabajador("Mauro", "ma@hotmail.com", 20.0, 0.2, o1);
		Trabajador t2=new Trabajador("Raul", "ra@hotmail.com", 14.0, 0.15, o2);
		Trabajador t3=new Trabajador("Sebastian", "seb@hotmail.com", 2.5, 0.55, o3);
		Trabajador t4=new Trabajador("Facundo", "facu@hotmail.com", 10.5, 0.25, o4);
		Trabajador t5=new Trabajador("Lautaro", "lau@hotmail.com", 25.5, 0.6, o5);
		
		Servicio s1= new ServicioEstandar(50.0, o1);
		Servicio s2= new ServicioEstandar(75.0, o2);
		Servicio s3= new ServicioPersonalizado(10000.0, 500.0,200.0, o3); 
		
		
		Herramienta h1= new Herramienta("Retroexcavadora",3500.0);
		Herramienta h2= new Herramienta("Camion",1400.0);
		Herramienta h3= new Herramienta("Caja de herramientas",500.0);
		
		Alquiler a1= new Alquiler(h1, LocalDate.parse(fecha4), LocalDate.parse(fecha5),LocalDate.parse(devolucion));
		Alquiler a2= new Alquiler(h2, LocalDate.parse(fecha1), LocalDate.parse(fecha5),LocalDate.parse(devolucion));
		Alquiler a3= new Alquiler(h3, LocalDate.parse(fecha3), LocalDate.parse(fecha5),LocalDate.parse(devolucion));
		Alquiler a4= new Alquiler(h2, LocalDate.parse(fecha2), LocalDate.parse(fecha4),LocalDate.parse(devolucion));
		
		/*PRUEBA*/
		
		/*Trabajo Servicio estandar*/
		
		Trabajo trabajo1=Trabajo.crearTrabajo(t1, s1, true, (LocalDate.parse(fecha1)));
        trabajo1.setHorastrabajo(22.0); 
        trabajo1.setFechafin((LocalDate.parse(fecha5))); 
		
		Usuario user= new Usuario("Rodrigo","ro@hotmail.com");
		
		try {
			user.contratar(trabajo1);
		} catch (AlquilerNoEntregadoException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(user.getContratos().get(0));
		System.out.println();
	
		
	   /*Trabajo Servicio Personalizado*/
	 
		Trabajo trabajo4=Trabajo.crearTrabajo(t3, s3, false, (LocalDate.parse(fecha1)));
        trabajo4.setHorastrabajo(5.5); 
        trabajo4.setFechafin((LocalDate.parse(fecha4))); 
		try {
			user.contratar(trabajo4);
		} catch (AlquilerNoEntregadoException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println( user.getContratos().get(1));
		System.out.println();
		
		
		/*Imprimir Alquiler al dia actual*/
		
			try {
				user.contratar(a1);
			} catch (AlquilerNoEntregadoException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(user.getContratos().get(2));
			System.out.println();
			
			
		/*Imprimir Alquiler dia real de devolucion*/
			
			a1.setDiadevolucion(LocalDate.parse("2021-04-20"));
			System.out.println(user.getContratos().get(2));
			System.out.println();
		
			
		/*OficioNoCoincideException */
	
		Trabajo trabajo2=Trabajo.crearTrabajo(t1, s2, false, (LocalDate.parse(fecha2)));
		System.out.println();

	
		/*AgendaOcupadaException */
	
		Trabajo trabajo3=Trabajo.crearTrabajo(t1, s1, false, (LocalDate.parse(fecha1)));
		System.out.println();
		
		/*AlquilerNoEntregadoException*/
	   
		try {
			user.contratar(a2);
			user.contratar(a3);
			user.contratar(a4);
		} catch (AlquilerNoEntregadoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		
		/*Metodo enMora*/
		
		((Alquiler)user.getContratos().get(2)).setDiadevolucion(LocalDate.parse("2021-12-25"));
		System.out.println("Esta en mora? " +((Alquiler)user.getContratos().get(2)).enMora());
		System.out.println();

		
		/*Metodo finalizado*/

		for(Contratable c:user.getContratos()) {
			System.out.println(c.getClass().getName()+"  "+c.finalizado());
		}
		
	}

}

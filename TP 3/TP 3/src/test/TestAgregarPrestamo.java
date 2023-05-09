package test;
import negocio.ClienteABM;
import negocio.PrestamoABM;
import java.time.LocalDate;
import datos.Prestamo;

import datos.Cliente;
import datos.Cuota;

public class TestAgregarPrestamo {
	public static void main(String[] args) {
		
	ClienteABM abmCliente =new ClienteABM();
	long idCliente=1;
	Cliente cliente=abmCliente.traer(idCliente);
	
	System.out.println(cliente);
	
	PrestamoABM abmPrestamo = new PrestamoABM();
	
	LocalDate fecha = LocalDate.of(2020, 10, 1);
	double monto = 30000;
	double interes = 15000;
	int cuotas = 12;
	
	//Prestamo p = new Prestamo(fecha, monto, interes, cuotas, cliente, true);
	
	long idPrestamo = abmPrestamo.agregar(fecha, monto, interes, cuotas, cliente, false);
		
	System.out.println("Al cliente " + cliente + " se le agrego el prestamo.");
	
	//System.out.println(cliente.getPrestamos());
	
	//System.out.println(p.getCuotas());
	
	Prestamo p = new Prestamo();
	try {
		p = abmPrestamo.traerPrestamoYCuotas(2L);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(p);
	
	
	for(Cuota c: p.getCuotas()) {
		System.out.println("\n" + c.toString());
	}
	/*
		ClienteABM clienteAbm = new ClienteABM();
		PrestamoABM prestamoAbm = new PrestamoABM();
		
		LocalDate fecha = LocalDate.of(2022, 10, 23);
		double monto = 45600;
		double interes = 5;
		int cantCuotas = 10;
		Cliente cliente;
		
		try {
			cliente = clienteAbm.traer(14000000);
			prestamoAbm.agregar(fecha, monto, interes, cantCuotas, cliente, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	
	}
}

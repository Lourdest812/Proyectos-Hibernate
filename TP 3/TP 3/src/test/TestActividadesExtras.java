package test;

import java.util.List;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestActividadesExtras {
	public static void main(String[] args) {
		PrestamoABM prestamoABM=new PrestamoABM();
		
		ClienteABM clienteABM=new ClienteABM();
		
		int dni=14000000;
		
		Cliente c= clienteABM.traer(dni);
		
		System.out.println("\n---> TraerPrestamos del Cliente="+c+ "\n\n");
		
		try {
			Prestamo p = prestamoABM.traerPrestamo(1L);
			System.out.println(p.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<Prestamo> prestamosImpagos = prestamoABM.traerPrestamosImpagos(c, false);
		for(Prestamo p1: prestamosImpagos) {System.out.println(p1.toString());};
		
		
	}
}

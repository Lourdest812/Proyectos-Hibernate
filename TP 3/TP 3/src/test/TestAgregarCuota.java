package test;

import java.time.LocalDate;
import datos.Cuota;
import datos.Prestamo;
import negocio.PrestamoABM;

public class TestAgregarCuota {

	public static void main(String[] args) {
		PrestamoABM abm = new PrestamoABM();
		Cuota cuota = new Cuota(5, LocalDate.of(2016, 5, 1), 500, 600, 10, 1000, 450, true, LocalDate.now(), 750);
		//CuotaABM abmC = new CuotaABM();
		
		Prestamo p = new Prestamo();
		try {
			p = abm.traerPrestamo(1L);
			cuota.setPrestamo(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		try {
			long ultimoIdCliente = abm.agregar(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
	}

}

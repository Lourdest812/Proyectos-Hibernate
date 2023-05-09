package test;
import java.time.LocalDate;

import datos.Prestamo;
import negocio.PrestamoABM;

public class TestActualizarPrestamo {
		public static void main(String[] args) {
		PrestamoABM prestamo = new PrestamoABM();
		long id = 1;
		
			Prestamo p = null;
			
			try {
				p = prestamo.traerPrestamo(id);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			p.setCantCuotas(3);
			p.setFecha(LocalDate.now());
			p.setInteres(1235);
			p.setMonto(2144141);
			prestamo.actualizar(p);

	}
}

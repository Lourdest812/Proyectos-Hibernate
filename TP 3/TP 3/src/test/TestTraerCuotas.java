package test;

import negocio.PrestamoABM;
import datos.Cuota;
import datos.Prestamo;

public class TestTraerCuotas {

	public static void main(String[] args) {
		PrestamoABM abm = new PrestamoABM();
		
		Prestamo p=null;
		try {
			p = abm.traerPrestamoYCuotas(5L);
			for(Cuota c: p.getCuotas()) {
				System.out.println("\n"+c.toString());};
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

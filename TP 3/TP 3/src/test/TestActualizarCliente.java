package test;
import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		long id =5;
// traer el obj a modificar
		Cliente c = abm.traer(id);
		System.out.println("Cliente a Modificar -->" + c);
// modificar por set los atributos
		c.setDni(430831);
		c.setApellido("Toledo");
		c.setNombre("Lourdes");
		c.setFechaDeNacimiento(LocalDate.of(2001, 10, 4));
		try {
			abm.modificar(c);
		} catch (Exception e) {
			e.printStackTrace();
		} // update del objeto
		
			//System.out.println("Modificado: " + c);
			int dni = c.getDni();
			Cliente cModif = abm.traer(dni);
			//Cliente cModif = abm.traer(id);
			System.out.println("Cliente Modificado -->" + cModif);
		}
	}

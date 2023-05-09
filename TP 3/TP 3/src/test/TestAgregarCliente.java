package test;
import java.time.LocalDate;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		String apellido = "Lourdes";
		String nombre = "Toledo";
		int documento = 43083114;
		// tu fecha de nacimiento
		LocalDate fechaDeNacimiento = LocalDate.of(2001, 10, 4);
		ClienteABM abm = new ClienteABM();
		try {
			long ultimoIdCliente = abm.agregar(apellido, nombre, documento,fechaDeNacimiento);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}


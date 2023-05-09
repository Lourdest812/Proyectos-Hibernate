package test;

import negocio.ClienteABM;

public class TestTraerClientes {
	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		System.out.println(abm.traer().toString());
	}

}

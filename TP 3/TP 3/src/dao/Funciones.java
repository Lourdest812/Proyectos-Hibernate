package dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;

public class Funciones {
	public boolean esBisiesto(int anio) {
		return anio%400==0 || anio %4==0 && !(anio%100 == 0);
	}
	/*
	public boolean esFechaValida(LocalDate fecha) {
		//return esBisiesto(fecha.getYear());
		return (boolean) LocalDate.of(2000, 2, 29);
	}
	*/
	public static String traerFechaCorta(LocalDate fecha) {
		return fecha.toString();
	}
	
	public String traerHoraCorta(LocalTime hora) {
		return hora.toString();
	}
	public static boolean esDiaHabil(LocalDate fecha) {
		return fecha.getDayOfWeek().getValue() >=1 && 
				fecha.getDayOfWeek().getValue()<=5;
	}
	
	public static LocalDate traerProxDiaHabil(LocalDate fecha) {
		while(!esDiaHabil(fecha)) {
			fecha=fecha.plusDays(1);
		}
		return fecha;
	}
	
	public String traerDiaDeLaSemana(LocalDate dia) {
		return dia.getDayOfWeek().toString();
	}
	
	public String traerMesEnLetras(LocalDate mes) {
		return mes.getMonth().toString();
	}
	
	public String traerFechaLarga(LocalDate fecha) {
		return traerDiaDeLaSemana(fecha) + " " + fecha.getDayOfMonth() + " " + "OF" + " " + traerMesEnLetras(fecha);
	}
	
	/*
	 * + aproximar2Decimal (double valor) : double
	 * Si el tercer decimal es mayor o igual 5, suma 1 al segundo decimal
	 * */
	
	
	public int traerCantDiasDeUnMes(int anio, int mes) {
		YearMonth yearMonthObject = YearMonth.of(anio, mes);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        return daysInMonth;
	}
	
	public boolean esNumero(char c) {
		return Character.isDigit(c);
	}
	
	public boolean esLetra(char c) {
		return Character.isLetter(c);
	}
	
	public boolean esCadenaNros(String cadena) {
		int i=0;
		boolean isNumber = true;
		while(i<cadena.length() && isNumber) {
			if(esLetra(cadena.charAt(i))) {
				isNumber = false;
			}
			i++;
		}
		return isNumber;
	}
	
	public boolean esCadenaLetras(String cadena) {
		int i=0;
		boolean esLetra = true;
		while(i<cadena.length() && esLetra) {
			if(esNumero(cadena.charAt(i))) {
				esLetra = false;
			}
			i++;
		}
		return esLetra;
	}
}

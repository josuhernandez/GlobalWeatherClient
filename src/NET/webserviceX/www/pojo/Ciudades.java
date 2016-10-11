package NET.webserviceX.www.pojo;

import java.rmi.RemoteException;
import java.util.Arrays;

import NET.webserviceX.www.GlobalWeatherSoapProxy;

public class Ciudades {

	public static void main(String[] args) {
		System.out.println("llamada al WS Global Weather");
		String countryName = "Spain";

		GlobalWeatherSoapProxy conexion = new GlobalWeatherSoapProxy();

		try {

			String sCiudades = new String(conexion.getCitiesByCountry(countryName));

			// limpiar XML y queaddrnos solo con los valores
			String sCiudadesSinXML = sCiudades.replaceAll("\\<[^\\>]*>", "");

			// trocear el strind por 'Spain'
			String[] ciudades = sCiudadesSinXML.split("Spain");

			System.out.println(ciudades);
			/*
			 * // limpiar los espacios en blanco a derecha e izquierda for (int
			 * i = 0; i < miArray.slength; i++) { miArray[i] = miArray[i].trim();
			 * }
			 */

			Arrays.sort(ciudades);
			for (String ciudad : ciudades) {
				System.out.println(ciudad.trim());
			}

			// ordenar alfabeticamente

		} catch (RemoteException e) {

			e.printStackTrace();
		}

	}

}

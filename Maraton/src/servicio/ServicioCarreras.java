package servicio;

import java.util.List;
import java.util.ArrayList;
import Modelo.Carrera;
import persistencia.CarrerasHelper;

/**
 * @author admin
 */
public class ServicioCarreras {
	
	Carrera carrera = new Carrera();
	CarrerasHelper carrerasHelper = new CarrerasHelper();

	
	public List <Carrera> listarCarreras(){
		
		List<Carrera>carreras = new ArrayList<>();
		
		return carreras;
	
	}

}

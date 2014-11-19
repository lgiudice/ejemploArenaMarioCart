package org.uqbar.pdep.kart.view

import java.util.List
import org.uqbar.pdep.kart.Carrera
import java.util.ArrayList
import org.uqbar.commons.utils.Observable

@Observable
class OrganizadorDeCarreras {
	
	@Property List<Carrera> carreras = new ArrayList
	@Property Carrera carreraSeleccionada
	
	def eliminarCarrera() {
		
		//FIXME hay que hacer mas cosas
		carreras.remove(carreraSeleccionada)
	}
	
	def agregarCarrera(Carrera carrera) {
		carreras.add(carrera)
	}
	
}
package org.uqbar.pdep.kart

import java.util.ArrayList
import java.util.List
import org.uqbar.pdep.kart.excepciones.NoPuedeInscribirseException

class Carrera {
	
	@Property Integer kilometrosARecorrer
	@Property List<Corredor> inscriptos = new ArrayList
	@Property String tipoDeCarrera
	@Property String nombre
	
	new(Integer unosKms) {
		kilometrosARecorrer = unosKms
		tipoDeCarrera = "Normal"
	}
	
	def inscribir(Corredor corredor) {
		this.validarCorredor(corredor)
		inscriptos.add(corredor)
	}
	
	def validarCorredor(Corredor corredor) {
		if (corredor.seBanca(this).operator_not )
			throw new NoPuedeInscribirseException("El corredor no se banca la carrera")
		if (this.cumpleCondiciones(corredor).operator_not)
			throw new NoPuedeInscribirseException("El corredor no cumple con las condiciones de la carrera")
	}
	
	def cumpleCondiciones(Corredor corredor) {
		return hayCupoParaInscripcion() && this.cumpleCondicionesParticulares(corredor)
	}
	
	def cumpleCondicionesParticulares(Corredor corredor) {
		true
	}
	
	def hayCupoParaInscripcion() {
		inscriptos.size < 8
	}
}
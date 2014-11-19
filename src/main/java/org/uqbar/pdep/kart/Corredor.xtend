package org.uqbar.pdep.kart

import org.uqbar.commons.utils.Observable

@Observable
class Corredor {
	
	new(Integer unaAgilidad, Integer unaCantidadDeCarreras, Auto unAuto, Boolean podio) {
		auto = unAuto
		agilidad = unaAgilidad
		cantidadCarrerasGanadas = unaCantidadDeCarreras
		estuvoEnPodio = podio
	}
	
	new(Integer agi, Integer carreras, Auto auto, Boolean podio, String string) {
		this(agi, carreras,auto, podio)
		nombre = string
	}
	
	@Property Boolean estuvoEnPodio
	Auto auto
	Integer agilidad
	Integer cantidadCarrerasGanadas
	@Property String nombre
	
	def chapa() {
		(agilidad + cantidadCarrerasGanadas) * auto.nivelDeCalidad
	}
	
	def Boolean seBanca(Carrera carrera) {
		auto.seBanca(carrera)
	}
	
}
package org.uqbar.pdep.kart

class Auto {
	
	@Property Integer nivelDeCalidad
	
	Integer velocidadMaxima
	
	new(Integer unNivel, Integer unaVelocidad) {
		nivelDeCalidad = unNivel
		velocidadMaxima = unaVelocidad
	}
	
	def Boolean seBanca(Carrera carrera) {
		nivelDeCalidad * velocidadMaxima >= carrera.kilometrosARecorrer
	}
}
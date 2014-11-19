package org.uqbar.pdep.kart

import org.uqbar.pdep.kart.Carrera

class CarreraAvanzada extends Carrera {
	
	Integer chapaNecesaria
	@Property String tipoDeCarrera
	
	new(Integer unosKms) {
		super(unosKms)
	}
	
	new(Integer unosKms, Integer unaCantidad) {
		super(unosKms)
		chapaNecesaria = unaCantidad
		tipoDeCarrera = "Avanzada"
	}
	
	override cumpleCondicionesParticulares(Corredor corredor) {
		this.tieneChapaNecesaria(corredor) &&
		corredor.estuvoEnPodio
	}
	
	def tieneChapaNecesaria(Corredor corredor) {
		corredor.chapa >= chapaNecesaria
	}
	
}
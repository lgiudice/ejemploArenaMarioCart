package org.uqbar.pdep.kart.view

import org.uqbar.arena.Application
import org.uqbar.pdep.kart.view.dummyData.DummyData

class MarioCarrerasApplication extends Application {
	
	override protected createMainWindow() {
		val model = new DummyData().generarOrganizador()
		
		new TorneoWindow(this, model)
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def static void main(String[] args) {
		new MarioCarrerasApplication().start()
	}
	
}
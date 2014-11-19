package org.uqbar.pdep.kart.view.dummyData

import org.uqbar.pdep.kart.view.OrganizadorDeCarreras
import org.uqbar.pdep.kart.Carrera
import org.uqbar.pdep.kart.Corredor
import org.uqbar.pdep.kart.Auto
import org.uqbar.pdep.kart.CarreraAvanzada

class DummyData {
	
	def generarOrganizador() {
		new OrganizadorDeCarreras => [
			agregarCarrera(carreraNormal("Tropic"))
			agregarCarrera(carreraNormal("Ciudad"))
			agregarCarrera(carreraAvanzada("Campus"))
			
		]

	}
	
	def carreraAvanzada(String string) {
		new CarreraAvanzada(2300) => [
			inscribir(corredorCon(750, 30, 300 ,600, true, "Gabriel"))
			inscribir(corredorCon(600, 50,350 ,750, true, "Mari"))
			inscribir(corredorCon(630, 510, 600 ,750, true, "Jan"))
			
		]
	}
	
	def carreraNormal(String unNombre) {
		new Carrera(1500) => [
			inscribir(corredorCon(75, 3, 30 ,60, false, "Jorge"))
			inscribir(corredorCon(60, 5,35 ,75, false, "Carla"))
			inscribir(corredorCon(89, 1, 27 ,65, false, "Migue"))
			inscribir(corredorCon(63, 51, 60 ,75, false, "Kim"))
			nombre = unNombre
		]
		
		
	}
	
	def corredorCon(int i, int j, int a1, int a2, boolean b, String string) {
		new Corredor(i, j, autoCon(a1 ,a2), b, string)
	}
	
	def autoCon(int i, int j) {
		new Auto(i,j)
	}
	
}
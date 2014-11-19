package org.uqbar.pdep.kart

import junit.framework.Assert
import org.junit.Test
import org.uqbar.pdep.kart.excepciones.NoPuedeInscribirseException

import static org.assertj.core.api.Assertions.*

class MarioCarrerasTest {
	
	@Test
	def void testCalculaLaChapadeUnCorredorOk() {
		val corredor = new Corredor(15, 1, new Auto(10,5), false)
		assertThat(corredor.chapa).isEqualTo(160)
	}
	
	@Test
	def void testCorredorQuePuedeSeInscribeOk() {
		val corredor = new Corredor(15, 1, new Auto(10,5), false)
		val carrera = new Carrera(10)
		
		carrera.inscribir(corredor)
		
		assertThat(carrera.inscriptos).containsExactly(corredor)
	}
	
	@Test
	def void testCorredorCuyoAutoNoSeBancaLaCarreraNoSePuedeInscribir() {
		val corredor = new Corredor(15, 1, new Auto(10,5), false)
		val carrera = new Carrera(10000)
				
		try {
			carrera.inscribir(corredor)
			Assert.fail
		} catch (NoPuedeInscribirseException ex) {
			assertThat(ex.message).isEqualTo("El corredor no se banca la carrera")
		}
		assertThat(carrera.inscriptos).empty
	}

	@Test
	def void testUnaCarreraConOchoInscriptosNoDejaInscribir() {
		val carrera = new Carrera(10)
		carrera.inscribir(new Corredor(15, 1, new Auto(10 ,5), false))
		carrera.inscribir(new Corredor(15, 1, new Auto(10 ,5), false))
		carrera.inscribir(new Corredor(15, 1, new Auto(10 ,5), false))
		carrera.inscribir(new Corredor(15, 1, new Auto(10 ,5), false))
		carrera.inscribir(new Corredor(15, 1, new Auto(10 ,5), false))
		carrera.inscribir(new Corredor(15, 1, new Auto(10 ,5), false))
		carrera.inscribir(new Corredor(15, 1, new Auto(10 ,5), false))
		carrera.inscribir(new Corredor(15, 1, new Auto(10 ,5), false))

		assertThat(carrera.inscriptos).hasSize(8)

		val corredor = new Corredor(15, 1, new Auto(10 ,5), false)
		try {
			carrera.inscribir(corredor)
			Assert.fail
		} catch (NoPuedeInscribirseException ex) {
			assertThat(ex.message).isEqualTo("El corredor no cumple con las condiciones de la carrera")
		}
		assertThat(carrera.inscriptos).hasSize(8)
	}
	
	@Test
	def void testUnaCarreraAvanzadaNoPermiteIngresarSiNoTieneChapaSuficiente() {
		val carrera = new CarreraAvanzada(10, 123123)
		
		val corredor = new Corredor(15, 1, new Auto(10 ,5), false)
		
		assertThat(corredor.chapa).isEqualTo(160)
		try {
			carrera.inscribir(corredor)
			Assert.fail
		} catch (NoPuedeInscribirseException ex) {
			assertThat(ex.message).isEqualTo("El corredor no cumple con las condiciones de la carrera")
		}
		assertThat(carrera.inscriptos).hasSize(0)
				
	}
	
	@Test
	def void testUnaCarreraAvanzadaNoPermiteIngresarSiElTipoNoEstuvoEnElPodio() {
		val carrera = new CarreraAvanzada(10, 10)
		
		val corredor = new Corredor(15, 1, new Auto(10 ,5), false)
		
		try {
			carrera.inscribir(corredor)
			Assert.fail
		} catch (NoPuedeInscribirseException ex) {
			assertThat(ex.message).isEqualTo("El corredor no cumple con las condiciones de la carrera")
		}
		assertThat(carrera.inscriptos).hasSize(0)
	}
}
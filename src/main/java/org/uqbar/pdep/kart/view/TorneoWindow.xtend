package org.uqbar.pdep.kart.view

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.pdep.kart.Carrera
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.bindings.NotNullObservable

class TorneoWindow extends SimpleWindow<OrganizadorDeCarreras> {
	
	new(WindowOwner parent, OrganizadorDeCarreras model) {
		super(parent, model)
	}
	
	override protected createMainTemplate(Panel mainPanel) {
		super.createMainTemplate(mainPanel)
		
		title = "Mario Carreras"
		this.agregarCarrerasExistentes(mainPanel)
	}
	
	def agregarCarrerasExistentes(Panel panel) {
		val carreras = new Table<Carrera>(panel, Carrera) => [
			bindItemsToProperty("carreras")
			bindValueToProperty("carreraSeleccionada")
		]
		
		this.agregarColumnas(carreras)
	}
	
	def agregarColumnas(Table<Carrera> table) {
		new Column<Carrera>(table)
			.setTitle("Tipo de carrera")
			.setFixedSize(200)
			.bindContentsToProperty("tipoDeCarrera")
			
		new Column<Carrera>(table)
			.setTitle("Kilometros Totales")
			.setFixedSize(100)
			.bindContentsToProperty("kilometrosARecorrer")
	}
	
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel)
			.setCaption("Nueva Carrera")
			.onClick [ | this.nuevaCarrera ] 
			.setAsDefault
			.disableOnError
			
		var remove = new Button(actionsPanel)
			.setCaption("Borrar")
			.onClick [ | modelObject.eliminarCarrera ]
			
		// Deshabilitar los botones si no hay ningún elemento seleccionado en la grilla.
		var elementSelected = new NotNullObservable("carreraSeleccionada")
		remove.bindEnabled(elementSelected)
	}
	
	def nuevaCarrera() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	
	override protected createFormPanel(Panel arg0) {
		// No me interesan los filtros
	}
	
	
}
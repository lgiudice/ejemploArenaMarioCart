package org.uqbar.pdep.kart.view;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.uqbar.commons.utils.Observable;
import org.uqbar.pdep.kart.Carrera;

@Observable
@SuppressWarnings("all")
public class OrganizadorDeCarreras {
  private List<Carrera> _carreras = new Function0<List<Carrera>>() {
    public List<Carrera> apply() {
      ArrayList<Carrera> _arrayList = new ArrayList<Carrera>();
      return _arrayList;
    }
  }.apply();
  
  public List<Carrera> getCarreras() {
    return this._carreras;
  }
  
  public void setCarreras(final List<Carrera> carreras) {
    this._carreras = carreras;
  }
  
  private Carrera _carreraSeleccionada;
  
  public Carrera getCarreraSeleccionada() {
    return this._carreraSeleccionada;
  }
  
  public void setCarreraSeleccionada(final Carrera carreraSeleccionada) {
    this._carreraSeleccionada = carreraSeleccionada;
  }
  
  public boolean eliminarCarrera() {
    List<Carrera> _carreras = this.getCarreras();
    Carrera _carreraSeleccionada = this.getCarreraSeleccionada();
    boolean _remove = _carreras.remove(_carreraSeleccionada);
    return _remove;
  }
  
  public boolean agregarCarrera(final Carrera carrera) {
    List<Carrera> _carreras = this.getCarreras();
    boolean _add = _carreras.add(carrera);
    return _add;
  }
}

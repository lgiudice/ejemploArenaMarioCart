package org.uqbar.pdep.kart;

import org.uqbar.commons.utils.Observable;
import org.uqbar.pdep.kart.Auto;
import org.uqbar.pdep.kart.Carrera;

@Observable
@SuppressWarnings("all")
public class Corredor {
  public Corredor(final Integer unaAgilidad, final Integer unaCantidadDeCarreras, final Auto unAuto, final Boolean podio) {
    this.auto = unAuto;
    this.agilidad = unaAgilidad;
    this.cantidadCarrerasGanadas = unaCantidadDeCarreras;
    this.setEstuvoEnPodio(podio);
  }
  
  public Corredor(final Integer agi, final Integer carreras, final Auto auto, final Boolean podio, final String string) {
    this(agi, carreras, auto, podio);
    this.setNombre(string);
  }
  
  private Boolean _estuvoEnPodio;
  
  public Boolean getEstuvoEnPodio() {
    return this._estuvoEnPodio;
  }
  
  public void setEstuvoEnPodio(final Boolean estuvoEnPodio) {
    this._estuvoEnPodio = estuvoEnPodio;
  }
  
  private Auto auto;
  
  private Integer agilidad;
  
  private Integer cantidadCarrerasGanadas;
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  public int chapa() {
    Integer _nivelDeCalidad = this.auto.getNivelDeCalidad();
    int _multiply = (((this.agilidad).intValue() + (this.cantidadCarrerasGanadas).intValue()) * (_nivelDeCalidad).intValue());
    return _multiply;
  }
  
  public Boolean seBanca(final Carrera carrera) {
    Boolean _seBanca = this.auto.seBanca(carrera);
    return _seBanca;
  }
}

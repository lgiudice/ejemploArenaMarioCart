package org.uqbar.pdep.kart;

import org.uqbar.pdep.kart.Carrera;

@SuppressWarnings("all")
public class Auto {
  private Integer _nivelDeCalidad;
  
  public Integer getNivelDeCalidad() {
    return this._nivelDeCalidad;
  }
  
  public void setNivelDeCalidad(final Integer nivelDeCalidad) {
    this._nivelDeCalidad = nivelDeCalidad;
  }
  
  private Integer velocidadMaxima;
  
  public Auto(final Integer unNivel, final Integer unaVelocidad) {
    this.setNivelDeCalidad(unNivel);
    this.velocidadMaxima = unaVelocidad;
  }
  
  public Boolean seBanca(final Carrera carrera) {
    Integer _nivelDeCalidad = this.getNivelDeCalidad();
    int _multiply = ((_nivelDeCalidad).intValue() * (this.velocidadMaxima).intValue());
    Integer _kilometrosARecorrer = carrera.getKilometrosARecorrer();
    boolean _greaterEqualsThan = (_multiply >= (_kilometrosARecorrer).intValue());
    return Boolean.valueOf(_greaterEqualsThan);
  }
}

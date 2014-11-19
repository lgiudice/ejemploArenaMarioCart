package org.uqbar.pdep.kart;

import org.uqbar.pdep.kart.Carrera;
import org.uqbar.pdep.kart.Corredor;

@SuppressWarnings("all")
public class CarreraAvanzada extends Carrera {
  private Integer chapaNecesaria;
  
  private String _tipoDeCarrera;
  
  public String getTipoDeCarrera() {
    return this._tipoDeCarrera;
  }
  
  public void setTipoDeCarrera(final String tipoDeCarrera) {
    this._tipoDeCarrera = tipoDeCarrera;
  }
  
  public CarreraAvanzada(final Integer unosKms) {
    super(unosKms);
  }
  
  public CarreraAvanzada(final Integer unosKms, final Integer unaCantidad) {
    super(unosKms);
    this.chapaNecesaria = unaCantidad;
    this.setTipoDeCarrera("Avanzada");
  }
  
  public boolean cumpleCondicionesParticulares(final Corredor corredor) {
    boolean _and = false;
    boolean _tieneChapaNecesaria = this.tieneChapaNecesaria(corredor);
    if (!_tieneChapaNecesaria) {
      _and = false;
    } else {
      Boolean _estuvoEnPodio = corredor.getEstuvoEnPodio();
      _and = (_tieneChapaNecesaria && (_estuvoEnPodio).booleanValue());
    }
    return _and;
  }
  
  public boolean tieneChapaNecesaria(final Corredor corredor) {
    int _chapa = corredor.chapa();
    boolean _greaterEqualsThan = (_chapa >= (this.chapaNecesaria).intValue());
    return _greaterEqualsThan;
  }
}

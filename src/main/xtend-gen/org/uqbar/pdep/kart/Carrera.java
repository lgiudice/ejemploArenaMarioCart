package org.uqbar.pdep.kart;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.uqbar.pdep.kart.Corredor;
import org.uqbar.pdep.kart.excepciones.NoPuedeInscribirseException;

@SuppressWarnings("all")
public class Carrera {
  private Integer _kilometrosARecorrer;
  
  public Integer getKilometrosARecorrer() {
    return this._kilometrosARecorrer;
  }
  
  public void setKilometrosARecorrer(final Integer kilometrosARecorrer) {
    this._kilometrosARecorrer = kilometrosARecorrer;
  }
  
  private List<Corredor> _inscriptos = new Function0<List<Corredor>>() {
    public List<Corredor> apply() {
      ArrayList<Corredor> _arrayList = new ArrayList<Corredor>();
      return _arrayList;
    }
  }.apply();
  
  public List<Corredor> getInscriptos() {
    return this._inscriptos;
  }
  
  public void setInscriptos(final List<Corredor> inscriptos) {
    this._inscriptos = inscriptos;
  }
  
  private String _tipoDeCarrera;
  
  public String getTipoDeCarrera() {
    return this._tipoDeCarrera;
  }
  
  public void setTipoDeCarrera(final String tipoDeCarrera) {
    this._tipoDeCarrera = tipoDeCarrera;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  public Carrera(final Integer unosKms) {
    this.setKilometrosARecorrer(unosKms);
    this.setTipoDeCarrera("Normal");
  }
  
  public boolean inscribir(final Corredor corredor) {
    boolean _xblockexpression = false;
    {
      this.validarCorredor(corredor);
      List<Corredor> _inscriptos = this.getInscriptos();
      boolean _add = _inscriptos.add(corredor);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
  
  public void validarCorredor(final Corredor corredor) {
    Boolean _seBanca = corredor.seBanca(this);
    boolean _not = (!(_seBanca).booleanValue());
    if (_not) {
      NoPuedeInscribirseException _noPuedeInscribirseException = new NoPuedeInscribirseException("El corredor no se banca la carrera");
      throw _noPuedeInscribirseException;
    }
    boolean _cumpleCondiciones = this.cumpleCondiciones(corredor);
    boolean _not_1 = (!_cumpleCondiciones);
    if (_not_1) {
      NoPuedeInscribirseException _noPuedeInscribirseException_1 = new NoPuedeInscribirseException("El corredor no cumple con las condiciones de la carrera");
      throw _noPuedeInscribirseException_1;
    }
  }
  
  public boolean cumpleCondiciones(final Corredor corredor) {
    boolean _and = false;
    boolean _hayCupoParaInscripcion = this.hayCupoParaInscripcion();
    if (!_hayCupoParaInscripcion) {
      _and = false;
    } else {
      boolean _cumpleCondicionesParticulares = this.cumpleCondicionesParticulares(corredor);
      _and = (_hayCupoParaInscripcion && _cumpleCondicionesParticulares);
    }
    return _and;
  }
  
  public boolean cumpleCondicionesParticulares(final Corredor corredor) {
    return true;
  }
  
  public boolean hayCupoParaInscripcion() {
    List<Corredor> _inscriptos = this.getInscriptos();
    int _size = _inscriptos.size();
    boolean _lessThan = (_size < 8);
    return _lessThan;
  }
}

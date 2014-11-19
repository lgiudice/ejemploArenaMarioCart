package org.uqbar.pdep.kart.view.dummyData;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.pdep.kart.Auto;
import org.uqbar.pdep.kart.Carrera;
import org.uqbar.pdep.kart.CarreraAvanzada;
import org.uqbar.pdep.kart.Corredor;
import org.uqbar.pdep.kart.view.OrganizadorDeCarreras;

@SuppressWarnings("all")
public class DummyData {
  public OrganizadorDeCarreras generarOrganizador() {
    OrganizadorDeCarreras _organizadorDeCarreras = new OrganizadorDeCarreras();
    final Procedure1<OrganizadorDeCarreras> _function = new Procedure1<OrganizadorDeCarreras>() {
      public void apply(final OrganizadorDeCarreras it) {
        Carrera _carreraNormal = DummyData.this.carreraNormal("Tropic");
        it.agregarCarrera(_carreraNormal);
        Carrera _carreraNormal_1 = DummyData.this.carreraNormal("Ciudad");
        it.agregarCarrera(_carreraNormal_1);
        CarreraAvanzada _carreraAvanzada = DummyData.this.carreraAvanzada("Campus");
        it.agregarCarrera(_carreraAvanzada);
      }
    };
    OrganizadorDeCarreras _doubleArrow = ObjectExtensions.<OrganizadorDeCarreras>operator_doubleArrow(_organizadorDeCarreras, _function);
    return _doubleArrow;
  }
  
  public CarreraAvanzada carreraAvanzada(final String string) {
    CarreraAvanzada _carreraAvanzada = new CarreraAvanzada(Integer.valueOf(2300));
    final Procedure1<CarreraAvanzada> _function = new Procedure1<CarreraAvanzada>() {
      public void apply(final CarreraAvanzada it) {
        Corredor _corredorCon = DummyData.this.corredorCon(750, 30, 300, 600, true, "Gabriel");
        it.inscribir(_corredorCon);
        Corredor _corredorCon_1 = DummyData.this.corredorCon(600, 50, 350, 750, true, "Mari");
        it.inscribir(_corredorCon_1);
        Corredor _corredorCon_2 = DummyData.this.corredorCon(630, 510, 600, 750, true, "Jan");
        it.inscribir(_corredorCon_2);
      }
    };
    CarreraAvanzada _doubleArrow = ObjectExtensions.<CarreraAvanzada>operator_doubleArrow(_carreraAvanzada, _function);
    return _doubleArrow;
  }
  
  public Carrera carreraNormal(final String unNombre) {
    Carrera _carrera = new Carrera(Integer.valueOf(1500));
    final Procedure1<Carrera> _function = new Procedure1<Carrera>() {
      public void apply(final Carrera it) {
        Corredor _corredorCon = DummyData.this.corredorCon(75, 3, 30, 60, false, "Jorge");
        it.inscribir(_corredorCon);
        Corredor _corredorCon_1 = DummyData.this.corredorCon(60, 5, 35, 75, false, "Carla");
        it.inscribir(_corredorCon_1);
        Corredor _corredorCon_2 = DummyData.this.corredorCon(89, 1, 27, 65, false, "Migue");
        it.inscribir(_corredorCon_2);
        Corredor _corredorCon_3 = DummyData.this.corredorCon(63, 51, 60, 75, false, "Kim");
        it.inscribir(_corredorCon_3);
        it.setNombre(unNombre);
      }
    };
    Carrera _doubleArrow = ObjectExtensions.<Carrera>operator_doubleArrow(_carrera, _function);
    return _doubleArrow;
  }
  
  public Corredor corredorCon(final int i, final int j, final int a1, final int a2, final boolean b, final String string) {
    Auto _autoCon = this.autoCon(a1, a2);
    Corredor _corredor = new Corredor(Integer.valueOf(i), Integer.valueOf(j), _autoCon, Boolean.valueOf(b), string);
    return _corredor;
  }
  
  public Auto autoCon(final int i, final int j) {
    Auto _auto = new Auto(Integer.valueOf(i), Integer.valueOf(j));
    return _auto;
  }
}

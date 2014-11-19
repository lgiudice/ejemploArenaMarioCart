package org.uqbar.pdep.kart.view;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.pdep.kart.view.OrganizadorDeCarreras;
import org.uqbar.pdep.kart.view.TorneoWindow;
import org.uqbar.pdep.kart.view.dummyData.DummyData;

@SuppressWarnings("all")
public class MarioCarrerasApplication extends Application {
  protected Window<? extends Object> createMainWindow() {
    DummyData _dummyData = new DummyData();
    final OrganizadorDeCarreras model = _dummyData.generarOrganizador();
    new TorneoWindow(this, model);
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public static void main(final String[] args) {
    MarioCarrerasApplication _marioCarrerasApplication = new MarioCarrerasApplication();
    _marioCarrerasApplication.start();
  }
}

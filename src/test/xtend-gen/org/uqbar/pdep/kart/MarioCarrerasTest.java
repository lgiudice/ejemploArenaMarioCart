package org.uqbar.pdep.kart;

import java.util.List;
import junit.framework.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.IntegerAssert;
import org.assertj.core.api.ListAssert;
import org.assertj.core.api.StringAssert;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.uqbar.pdep.kart.Auto;
import org.uqbar.pdep.kart.Carrera;
import org.uqbar.pdep.kart.CarreraAvanzada;
import org.uqbar.pdep.kart.Corredor;
import org.uqbar.pdep.kart.excepciones.NoPuedeInscribirseException;

@SuppressWarnings("all")
public class MarioCarrerasTest {
  @Test
  public void testCalculaLaChapadeUnCorredorOk() {
    Auto _auto = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto, Boolean.valueOf(false));
    final Corredor corredor = _corredor;
    int _chapa = corredor.chapa();
    IntegerAssert _assertThat = Assertions.assertThat(_chapa);
    _assertThat.isEqualTo(160);
  }
  
  @Test
  public void testCorredorQuePuedeSeInscribeOk() {
    Auto _auto = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto, Boolean.valueOf(false));
    final Corredor corredor = _corredor;
    Carrera _carrera = new Carrera(Integer.valueOf(10));
    final Carrera carrera = _carrera;
    carrera.inscribir(corredor);
    List<Corredor> _inscriptos = carrera.getInscriptos();
    ListAssert<Corredor> _assertThat = Assertions.<Corredor>assertThat(_inscriptos);
    _assertThat.containsExactly(corredor);
  }
  
  @Test
  public void testCorredorCuyoAutoNoSeBancaLaCarreraNoSePuedeInscribir() {
    Auto _auto = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto, Boolean.valueOf(false));
    final Corredor corredor = _corredor;
    Carrera _carrera = new Carrera(Integer.valueOf(10000));
    final Carrera carrera = _carrera;
    try {
      carrera.inscribir(corredor);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof NoPuedeInscribirseException) {
        final NoPuedeInscribirseException ex = (NoPuedeInscribirseException)_t;
        String _message = ex.getMessage();
        StringAssert _assertThat = Assertions.assertThat(_message);
        _assertThat.isEqualTo("El corredor no se banca la carrera");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    List<Corredor> _inscriptos = carrera.getInscriptos();
    ListAssert<Corredor> _assertThat_1 = Assertions.<Corredor>assertThat(_inscriptos);
    _assertThat_1.isEmpty();
  }
  
  @Test
  public void testUnaCarreraConOchoInscriptosNoDejaInscribir() {
    Carrera _carrera = new Carrera(Integer.valueOf(10));
    final Carrera carrera = _carrera;
    Auto _auto = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto, Boolean.valueOf(false));
    carrera.inscribir(_corredor);
    Auto _auto_1 = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor_1 = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto_1, Boolean.valueOf(false));
    carrera.inscribir(_corredor_1);
    Auto _auto_2 = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor_2 = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto_2, Boolean.valueOf(false));
    carrera.inscribir(_corredor_2);
    Auto _auto_3 = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor_3 = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto_3, Boolean.valueOf(false));
    carrera.inscribir(_corredor_3);
    Auto _auto_4 = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor_4 = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto_4, Boolean.valueOf(false));
    carrera.inscribir(_corredor_4);
    Auto _auto_5 = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor_5 = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto_5, Boolean.valueOf(false));
    carrera.inscribir(_corredor_5);
    Auto _auto_6 = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor_6 = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto_6, Boolean.valueOf(false));
    carrera.inscribir(_corredor_6);
    Auto _auto_7 = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor_7 = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto_7, Boolean.valueOf(false));
    carrera.inscribir(_corredor_7);
    List<Corredor> _inscriptos = carrera.getInscriptos();
    ListAssert<Corredor> _assertThat = Assertions.<Corredor>assertThat(_inscriptos);
    _assertThat.hasSize(8);
    Auto _auto_8 = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor_8 = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto_8, Boolean.valueOf(false));
    final Corredor corredor = _corredor_8;
    try {
      carrera.inscribir(corredor);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof NoPuedeInscribirseException) {
        final NoPuedeInscribirseException ex = (NoPuedeInscribirseException)_t;
        String _message = ex.getMessage();
        StringAssert _assertThat_1 = Assertions.assertThat(_message);
        _assertThat_1.isEqualTo("El corredor no cumple con las condiciones de la carrera");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    List<Corredor> _inscriptos_1 = carrera.getInscriptos();
    ListAssert<Corredor> _assertThat_2 = Assertions.<Corredor>assertThat(_inscriptos_1);
    _assertThat_2.hasSize(8);
  }
  
  @Test
  public void testUnaCarreraAvanzadaNoPermiteIngresarSiNoTieneChapaSuficiente() {
    CarreraAvanzada _carreraAvanzada = new CarreraAvanzada(Integer.valueOf(10), Integer.valueOf(123123));
    final CarreraAvanzada carrera = _carreraAvanzada;
    Auto _auto = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto, Boolean.valueOf(false));
    final Corredor corredor = _corredor;
    int _chapa = corredor.chapa();
    IntegerAssert _assertThat = Assertions.assertThat(_chapa);
    _assertThat.isEqualTo(160);
    try {
      carrera.inscribir(corredor);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof NoPuedeInscribirseException) {
        final NoPuedeInscribirseException ex = (NoPuedeInscribirseException)_t;
        String _message = ex.getMessage();
        StringAssert _assertThat_1 = Assertions.assertThat(_message);
        _assertThat_1.isEqualTo("El corredor no cumple con las condiciones de la carrera");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    List<Corredor> _inscriptos = carrera.getInscriptos();
    ListAssert<Corredor> _assertThat_2 = Assertions.<Corredor>assertThat(_inscriptos);
    _assertThat_2.hasSize(0);
  }
  
  @Test
  public void testUnaCarreraAvanzadaNoPermiteIngresarSiElTipoNoEstuvoEnElPodio() {
    CarreraAvanzada _carreraAvanzada = new CarreraAvanzada(Integer.valueOf(10), Integer.valueOf(10));
    final CarreraAvanzada carrera = _carreraAvanzada;
    Auto _auto = new Auto(Integer.valueOf(10), Integer.valueOf(5));
    Corredor _corredor = new Corredor(Integer.valueOf(15), Integer.valueOf(1), _auto, Boolean.valueOf(false));
    final Corredor corredor = _corredor;
    try {
      carrera.inscribir(corredor);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof NoPuedeInscribirseException) {
        final NoPuedeInscribirseException ex = (NoPuedeInscribirseException)_t;
        String _message = ex.getMessage();
        StringAssert _assertThat = Assertions.assertThat(_message);
        _assertThat.isEqualTo("El corredor no cumple con las condiciones de la carrera");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    List<Corredor> _inscriptos = carrera.getInscriptos();
    ListAssert<Corredor> _assertThat_1 = Assertions.<Corredor>assertThat(_inscriptos);
    _assertThat_1.hasSize(0);
  }
}

package org.uqbar.pdep.kart.view;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.pdep.kart.Carrera;
import org.uqbar.pdep.kart.view.OrganizadorDeCarreras;

@SuppressWarnings("all")
public class TorneoWindow extends SimpleWindow<OrganizadorDeCarreras> {
  public TorneoWindow(final WindowOwner parent, final OrganizadorDeCarreras model) {
    super(parent, model);
  }
  
  protected void createMainTemplate(final Panel mainPanel) {
    super.createMainTemplate(mainPanel);
    this.setTitle("Mario Carreras");
    this.agregarCarrerasExistentes(mainPanel);
  }
  
  public Column<Carrera> agregarCarrerasExistentes(final Panel panel) {
    Column<Carrera> _xblockexpression = null;
    {
      Table<Carrera> _table = new Table<Carrera>(panel, Carrera.class);
      final Procedure1<Table<Carrera>> _function = new Procedure1<Table<Carrera>>() {
        public void apply(final Table<Carrera> it) {
          it.bindItemsToProperty("carreras");
          it.<ControlBuilder>bindValueToProperty("carreraSeleccionada");
        }
      };
      final Table<Carrera> carreras = ObjectExtensions.<Table<Carrera>>operator_doubleArrow(_table, _function);
      Column<Carrera> _agregarColumnas = this.agregarColumnas(carreras);
      _xblockexpression = (_agregarColumnas);
    }
    return _xblockexpression;
  }
  
  public Column<Carrera> agregarColumnas(final Table<Carrera> table) {
    Column<Carrera> _xblockexpression = null;
    {
      Column<Carrera> _column = new Column<Carrera>(table);
      Column<Carrera> _setTitle = _column.setTitle("Tipo de carrera");
      Column<Carrera> _setFixedSize = _setTitle.setFixedSize(200);
      _setFixedSize.bindContentsToProperty("tipoDeCarrera");
      Column<Carrera> _column_1 = new Column<Carrera>(table);
      Column<Carrera> _setTitle_1 = _column_1.setTitle("Kilometros Totales");
      Column<Carrera> _setFixedSize_1 = _setTitle_1.setFixedSize(100);
      Column<Carrera> _bindContentsToProperty = _setFixedSize_1.bindContentsToProperty("kilometrosARecorrer");
      _xblockexpression = (_bindContentsToProperty);
    }
    return _xblockexpression;
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    Button _setCaption = _button.setCaption("Nueva Carrera");
    final Action _function = new Action() {
      public void execute() {
        TorneoWindow.this.nuevaCarrera();
      }
    };
    Button _onClick = _setCaption.onClick(_function);
    Button _setAsDefault = _onClick.setAsDefault();
    _setAsDefault.disableOnError();
    Button _button_1 = new Button(actionsPanel);
    Button _setCaption_1 = _button_1.setCaption("Borrar");
    final Action _function_1 = new Action() {
      public void execute() {
        OrganizadorDeCarreras _modelObject = TorneoWindow.this.getModelObject();
        _modelObject.eliminarCarrera();
      }
    };
    Button remove = _setCaption_1.onClick(_function_1);
    NotNullObservable _notNullObservable = new NotNullObservable("carreraSeleccionada");
    NotNullObservable elementSelected = _notNullObservable;
    remove.<ControlBuilder>bindEnabled(elementSelected);
  }
  
  public void nuevaCarrera() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  protected void createFormPanel(final Panel arg0) {
  }
}

package co.unbosque.edu.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import co.unbosque.edu.persistence.EstudianteDTO;

import java.awt.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class EstudianteView extends JFrame {

	private JTextField txtCodigo, txtNombre, txtCarrera, txtPromedio, txtPorcentajeBeca, txtBuscarCodigo;
	private JCheckBox checkBecado;
	private JButton btnRegistrar, btnBuscar, btnEliminar, btnListar, btnLimpiar;
	private JTable tablaEstudiantes;
	private DefaultTableModel modeloTabla;
	private JTextArea areaMensajes;
	private JPanel panelBusqueda; 

	public EstudianteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 700);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));

		inicializarComponentes();
		organizarComponentes();
	}
	
	public void setTitulo(String titulo) {
		setTitle(titulo);
	}

	private void inicializarComponentes() {

		JPanel panelRegistro = new JPanel(new GridLayout(8, 2, 5, 5));
		panelRegistro.setBorder(BorderFactory.createTitledBorder("Registro de Estudiantes"));

		panelRegistro.add(new JLabel("Código:"));
		txtCodigo = new JTextField();
		panelRegistro.add(txtCodigo);

		panelRegistro.add(new JLabel("Nombre:"));
		txtNombre = new JTextField();
		panelRegistro.add(txtNombre);

		panelRegistro.add(new JLabel("Carrera:"));
		txtCarrera = new JTextField();
		panelRegistro.add(txtCarrera);

		panelRegistro.add(new JLabel("Promedio:"));
		txtPromedio = new JTextField();
		panelRegistro.add(txtPromedio);
		
		
		panelRegistro.add(new JLabel("Es becado?:"));
		checkBecado = new JCheckBox(); 
		panelRegistro.add(checkBecado);
		
		panelRegistro.add(new JLabel("PorcentajeBeca:"));
		txtPorcentajeBeca = new JTextField();
		panelRegistro.add(txtPorcentajeBeca);

		btnRegistrar = new JButton("Registrar");
		btnLimpiar = new JButton("Limpiar");
		JPanel panelBotonesRegistro = new JPanel(new FlowLayout());
		panelBotonesRegistro.add(btnRegistrar);
		panelBotonesRegistro.add(btnLimpiar);


		panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelBusqueda.setBorder(BorderFactory.createTitledBorder("Búsqueda y Eliminación"));

		panelBusqueda.add(new JLabel("Buscar por código:"));
		txtBuscarCodigo = new JTextField(10);
		panelBusqueda.add(txtBuscarCodigo);

		btnBuscar = new JButton("Buscar");
		panelBusqueda.add(btnBuscar);

		btnEliminar = new JButton("Eliminar");
		panelBusqueda.add(btnEliminar);

		btnListar = new JButton("Listar Todos");
		panelBusqueda.add(btnListar);


		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Código");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Carrera");
		modeloTabla.addColumn("Promedio");
		modeloTabla.addColumn("Tiene beca?");
		modeloTabla.addColumn("Porcentaje Beca");

		tablaEstudiantes = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaEstudiantes);
		scrollTabla.setBorder(BorderFactory.createTitledBorder("Lista de Estudiantes"));


		areaMensajes = new JTextArea(5, 50);
		areaMensajes.setEditable(false);
		JScrollPane scrollMensajes = new JScrollPane(areaMensajes);
		scrollMensajes.setBorder(BorderFactory.createTitledBorder("Mensajes del Sistema"));
	}

	private void organizarComponentes() {

		JPanel panelNorte = new JPanel(new BorderLayout(5, 5));


		JPanel panelRegistro = new JPanel(new BorderLayout(5, 5));
		panelRegistro.add(new JPanel(new GridLayout(6, 2, 5, 5)) {{
			add(new JLabel("Código:"));
			add(txtCodigo);
			add(new JLabel("Nombre:"));
			add(txtNombre);
			add(new JLabel("Carrera:"));
			add(txtCarrera);
			add(new JLabel("Promedio:"));
			add(txtPromedio);
			add(new JLabel("Es becado?:"));
			add(checkBecado);
			add(new JLabel("Porcentaje Beca:"));
			add(txtPorcentajeBeca);
		}}, BorderLayout.CENTER);

		JPanel panelBotonesRegistro = new JPanel(new FlowLayout());
		panelBotonesRegistro.add(btnRegistrar);
		panelBotonesRegistro.add(btnLimpiar);
		panelRegistro.add(panelBotonesRegistro, BorderLayout.SOUTH);
		panelRegistro.setBorder(BorderFactory.createTitledBorder("Registro de Estudiantes"));


		panelNorte.add(panelRegistro, BorderLayout.NORTH);
		panelNorte.add(panelBusqueda, BorderLayout.SOUTH); 


		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.add(new JScrollPane(tablaEstudiantes), BorderLayout.CENTER);
		panelCentral.setBorder(BorderFactory.createTitledBorder("Lista de Estudiantes"));


		JPanel panelSur = new JPanel(new BorderLayout());
		panelSur.add(new JScrollPane(areaMensajes), BorderLayout.CENTER);
		panelSur.setBorder(BorderFactory.createTitledBorder("Mensajes del Sistema"));


		add(panelNorte, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(panelSur, BorderLayout.SOUTH);
	}


	public String getCodigo() {
		return txtCodigo.getText().trim();
	}

	public String getNombre() {
		return txtNombre.getText().trim();
	}

	public String getCarrera() {
		return txtCarrera.getText().trim();
	}
	
	public boolean isBecado() {
		return checkBecado.isSelected();
	}

	public double getPromedio() {
		try {
			return Double.parseDouble(txtPromedio.getText().trim());
		} catch (NumberFormatException e) {
			return -1; 
		}
	}
	
	public int getPorcentajeBeca() {
		try {
			return Integer.parseInt(txtPorcentajeBeca.getText().trim());
		} catch (NumberFormatException e) {
			return 0; 
		}
	}

	public String getCodigoBusqueda() {
		return txtBuscarCodigo.getText().trim();
	}

	public void limpiarCampos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtCarrera.setText("");
		txtPromedio.setText("");
		txtBuscarCodigo.setText("");
		checkBecado.setSelected(false);
		txtPorcentajeBeca.setText("");
		
	}

	public void limpiarTabla() {
		modeloTabla.setRowCount(0);
	}
	
	public void llenarTable(Object[] fila) {
		modeloTabla.addRow(fila);
	}

	public void agregarFilaATablaEstudiante(EstudianteDTO e) {
		modeloTabla.addRow(new Object[]{ 
        		e.getCodigo(), 
        		e.getNombre(), 
        		e.getCarrera(), 
        		e.getPromedio(),
        		e.isBecado() ? "SI" : "NO",
        		e.getPorcentajeBeca()
        		});
	}

	public void mostrarMensaje(String mensaje) {
		areaMensajes.append(mensaje + "\n");
	}

	public void limpiarMensajes() {
		areaMensajes.setText("");
	}

	public int getFilaSeleccionada() {
		return tablaEstudiantes.getSelectedRow();
	}

	public String getCodigoFilaSeleccionada() {
		int fila = getFilaSeleccionada();
		if (fila != -1) {
			return modeloTabla.getValueAt(fila, 0).toString();
		}
		return null;
	}

	public void setRegistrarListener(ActionListener listener) {
		btnRegistrar.addActionListener(listener);
	}

	public void setBuscarListener(ActionListener listener) {
		btnBuscar.addActionListener(listener);
	}

	public void setEliminarListener(ActionListener listener) {
		btnEliminar.addActionListener(listener);
	}

	public void setListarListener(ActionListener listener) {
		btnListar.addActionListener(listener);
	}

	public void setLimpiarListener(ActionListener listener) {
		btnLimpiar.addActionListener(listener);
	}
}

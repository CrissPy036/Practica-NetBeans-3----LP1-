package ventanas;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogGestionCompras extends JDialog {
	private JTextField txtCodigoArticulo;
	private JTextField txtNombreArticulo;
	private JTextField txtDescripcionArticulo;
        private JTextField txtPrecioArticulo;
	private JTable tbListaCompra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogGestionCompras dialog = new DialogGestionCompras();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogGestionCompras() {
            setTitle("GESTION DE COMPRAS");
		setBounds(100, 100, 633, 355); // Ajuste de tamaño Ventala (633 - Largo ... 355 - Ancho)
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 55, 240, 250); // Ajusta el tamaño del cuadro "Datos de Recursos Humanos"
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCodigoArticulo = new JTextField();
		txtCodigoArticulo.setBounds(132, 24, 86, 20);
		panel.add(txtCodigoArticulo);
		txtCodigoArticulo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(10, 27, 46, 14);
		panel.add(lblNewLabel_3);
                
                txtNombreArticulo = new JTextField();
		txtNombreArticulo.setBounds(132, 65, 86, 20);
		panel.add(txtNombreArticulo);
		txtNombreArticulo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Articulo");
		lblNewLabel_4.setBounds(10, 68, 112, 14);
		panel.add(lblNewLabel_4);
		
                txtDescripcionArticulo = new JTextField();
		txtDescripcionArticulo.setBounds(132, 103, 86, 20);
		panel.add(txtDescripcionArticulo);
		txtDescripcionArticulo.setColumns(10);
                
		JLabel lblNewLabel_5 = new JLabel("Descripcion");
		lblNewLabel_5.setBounds(10, 106, 112, 14);
		panel.add(lblNewLabel_5);
                
                txtPrecioArticulo = new JTextField();
		txtPrecioArticulo.setBounds(132, 145, 86, 20);
		panel.add(txtPrecioArticulo);
		txtPrecioArticulo.setColumns(10);
                
                JLabel lblNewLabel_6 = new JLabel("Precio");
		lblNewLabel_6.setBounds(10, 145, 112, 14);
		panel.add(lblNewLabel_6);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.setCodigoCompras(txtCodigoArticulo.getText());
				objetoCompras.setNombreCompras(txtNombreArticulo.getText());
				objetoCompras.setDescripcionCompras(txtDescripcionArticulo.getText());
                                objetoCompras.setPrecioCompras(txtDescripcionArticulo.getText());
				objetoCompras.agregarRegistrosCompras();
			}
		});
		btnGuardar.setBounds(10, 175, 99, 23);
		panel.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.EditarCompras(tbListaCompra);
			}
		});
		btnEditar.setBounds(109, 175, 112, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.EliminarCompras(tbListaCompra, txtCodigoArticulo);
			}
		});
		btnEliminar.setBounds(10, 210, 208, 30);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de Articulos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(275, 54, 338, 177);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 318, 136);
		panel_1.add(scrollPane);
		
		tbListaCompra = new JTable();
		scrollPane.setViewportView(tbListaCompra);
		
		JButton btnCrearArchivoCompras = new JButton("Crear Archivo de Compras");
		btnCrearArchivoCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras= new clases.Compras();
				objetoCompras.crearArchivoCompras();
			}
		});
		btnCrearArchivoCompras.setBounds(10, 21, 239, 23);
		getContentPane().add(btnCrearArchivoCompras);
		
		JButton btnMostrarCompras = new JButton("Mostrar Lista de Articulos");
		btnMostrarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.MostrarTotalCompras(tbListaCompra);
			}
		});
		btnMostrarCompras.setBounds(275, 21, 158, 23);
		getContentPane().add(btnMostrarCompras);
		
		JButton btnSeleccionar = new JButton("Seleccionar RRHH");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				
				objetoCompras.seleccionarCompras(tbListaCompra);
				txtCodigoArticulo.setText(objetoCompras.getCodigoCompras());
				txtNombreArticulo.setText(objetoCompras.getNombreCompras());
				txtDescripcionArticulo.setText(objetoCompras.getDescripcionCompras());
                                txtPrecioArticulo.setText(objetoCompras.getPrecioCompras());
			}
		});
		btnSeleccionar.setBounds(443, 20, 164, 23);
		getContentPane().add(btnSeleccionar);
	}
}

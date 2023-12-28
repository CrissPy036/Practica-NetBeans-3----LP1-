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

public class DialogGestionRecursosHumanos extends JDialog {
	private JTextField txtCodigoRRHH;
	private JTextField txtNombreRRHH;
	private JTextField txtCargoRRHH;
        private JTextField txtEspecialidadRRHH;
	private JTable tbListaRRHH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogGestionRecursosHumanos dialog = new DialogGestionRecursosHumanos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogGestionRecursosHumanos() {
            setTitle("GESTION DE RECURSOS HUMANOS");
		setBounds(100, 100, 633, 355); // Ajuste de tamaño Ventala (633 - Largo ... 355 - Ancho)
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 55, 240, 250); // Ajusta el tamaño del cuadro "Datos de Recursos Humanos"
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCodigoRRHH = new JTextField();
		txtCodigoRRHH.setBounds(132, 24, 86, 20);
		panel.add(txtCodigoRRHH);
		txtCodigoRRHH.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(10, 27, 46, 14);
		panel.add(lblNewLabel_3);
                
                txtNombreRRHH = new JTextField();
		txtNombreRRHH.setBounds(132, 65, 86, 20);
		panel.add(txtNombreRRHH);
		txtNombreRRHH.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre y Apellido");
		lblNewLabel_4.setBounds(10, 68, 112, 14);
		panel.add(lblNewLabel_4);
		
                txtCargoRRHH = new JTextField();
		txtCargoRRHH.setBounds(132, 103, 86, 20);
		panel.add(txtCargoRRHH);
		txtCargoRRHH.setColumns(10);
                
		JLabel lblNewLabel_5 = new JLabel("Cargo");
		lblNewLabel_5.setBounds(10, 106, 112, 14);
		panel.add(lblNewLabel_5);
                
                txtEspecialidadRRHH = new JTextField();
		txtEspecialidadRRHH.setBounds(132, 145, 86, 20);
		panel.add(txtEspecialidadRRHH);
		txtEspecialidadRRHH.setColumns(10);
                
                JLabel lblNewLabel_6 = new JLabel("Especialidad");
		lblNewLabel_6.setBounds(10, 145, 112, 14);
		panel.add(lblNewLabel_6);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRRHH = new clases.RecursosHumanos();
				objetoRRHH.setCodigoRRHH(txtCodigoRRHH.getText());
				objetoRRHH.setNombreRRHH(txtNombreRRHH.getText());
				objetoRRHH.setCargoRRHH(txtCargoRRHH.getText());
                                objetoRRHH.setEspecialidadRRHH(txtEspecialidadRRHH.getText());
				objetoRRHH.agregarRegistrosRRHH();
			}
		});
		btnGuardar.setBounds(10, 175, 99, 23);
		panel.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRRHH = new clases.RecursosHumanos();
				objetoRRHH.EditarRRHH(tbListaRRHH);
			}
		});
		btnEditar.setBounds(109, 175, 112, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRRHH = new clases.RecursosHumanos();
				objetoRRHH.EliminarRRHH(tbListaRRHH, txtCodigoRRHH);
			}
		});
		btnEliminar.setBounds(10, 210, 208, 30);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(275, 54, 338, 177);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 318, 136);
		panel_1.add(scrollPane);
		
		tbListaRRHH = new JTable();
		scrollPane.setViewportView(tbListaRRHH);
		
		JButton btnCrearArchivoRRHH = new JButton("Crear Archivo de RRHH");
		btnCrearArchivoRRHH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRRHH= new clases.RecursosHumanos();
				objetoRRHH.crearArchivoRRHH();
			}
		});
		btnCrearArchivoRRHH.setBounds(10, 21, 239, 23);
		getContentPane().add(btnCrearArchivoRRHH);
		
		JButton btnMostrarRRHH = new JButton("Mostrar Lista RRRHH");
		btnMostrarRRHH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRRHH = new clases.RecursosHumanos();
				objetoRRHH.MostrarTotalRRHH(tbListaRRHH);
			}
		});
		btnMostrarRRHH.setBounds(275, 21, 158, 23);
		getContentPane().add(btnMostrarRRHH);
		
		JButton btnSeleccionar = new JButton("Seleccionar RRHH");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRRHH = new clases.RecursosHumanos();
				
				objetoRRHH.seleccionarRRHH(tbListaRRHH);
				txtCodigoRRHH.setText(objetoRRHH.getCodigoRRHH());
				txtNombreRRHH.setText(objetoRRHH.getNombreRRHH());
				txtCargoRRHH.setText(objetoRRHH.getCargoRRHH());
                                txtEspecialidadRRHH.setText(objetoRRHH.getEspecialidadRRHH());
			}
		});
		btnSeleccionar.setBounds(443, 20, 164, 23);
		getContentPane().add(btnSeleccionar);
	}
}

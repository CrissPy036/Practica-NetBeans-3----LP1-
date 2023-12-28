package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RecursosHumanos {
	
String codigoRRHH;
String nombreRRHH;
String cargoRRHH;
String especialidadRRHH;

public String getCodigoRRHH() {
	return codigoRRHH;
}
public void setCodigoRRHH(String codigoRRHH) {
	this.codigoRRHH = codigoRRHH;
}
public String getNombreRRHH() {
	return nombreRRHH;
}
public void setNombreRRHH(String nombreRRHH) {
	this.nombreRRHH = nombreRRHH;
}
public String getCargoRRHH() {
	return cargoRRHH;
}
public void setCargoRRHH(String cargoRRHH) {
	this.cargoRRHH = cargoRRHH;
}
public String getEspecialidadRRHH() {
	return especialidadRRHH;
}
public void setEspecialidadRRHH(String especialidadRRHH) {
	this.especialidadRRHH = especialidadRRHH;
}

public void crearArchivoRRHH() {
	try {
		File objetoArchivo = new File("RRHH.txt");
		if(objetoArchivo.createNewFile()) {
			JOptionPane.showMessageDialog(null,"Se ha creado correctamente el archivo: "+  objetoArchivo.getName());
		}
		else {
			JOptionPane.showMessageDialog(null, "El archivo ya existe");
		}
		
	} catch (Exception e) {
		System.out.println("Ocurrió un error al crear el archivo");
		
	}
}
public void agregarRegistrosRRHH() {
	try {
		FileWriter fw = new FileWriter("RRHH.txt",true);
                
		fw.write(getCodigoRRHH());
		fw.write(",");
		fw.write(getNombreRRHH());
		fw.write(",");
		fw.write(getCargoRRHH());
		fw.write(",");
		fw.write(getEspecialidadRRHH());
                fw.write("\n");
		fw.close();
		
		JOptionPane.showMessageDialog(null,"Se registró correctamente");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un error al registrar" + e.toString());
	}
}

public void MostrarTotalRRHH(JTable tablaTotalRRHH) {
	
	String nombreArchivo = "RRHH.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Cargo");
                model.addColumn("Especialidad");
		
		tablaTotalRRHH.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tablaTotalRRHH.setModel(model);
		}
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
		
	}
}

public void seleccionarRRHH(JTable tablaRRHH) {
	
	try {
		
		int  fila = tablaRRHH.getSelectedRow();
		
		if (fila>=0) {
			
			setCodigoRRHH(tablaRRHH.getValueAt(fila, 0).toString());
			setNombreRRHH(tablaRRHH.getValueAt(fila, 1).toString());
			setCargoRRHH(tablaRRHH.getValueAt(fila, 2).toString());
                        setEspecialidadRRHH(tablaRRHH.getValueAt(fila, 3).toString());
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
	}
	
}

public void EliminarRRHH (JTable tablaRRHH, JTextField codigoRRHH) {
	
	//Eliminación visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaRRHH.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(codigoRRHH.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}
	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("RRHH.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
	}
	
	//Creaci�n de los nuevos registros luego de la eliminación
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RRHH.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaRRHH.getColumnCount(); col++) {
			joiner.add(tablaRRHH.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaRRHH.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaRRHH.getColumnCount(); col++) {
				
				Object obj = tablaRRHH.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error");
	}
	
	
	
}

public void EditarRRHH(JTable tablaRRHH) {
	
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("RRHH.txt");
			writer.print("");
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
		}
		
		//Creaci�n de los nuevos registros luego de la eliminación
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RRHH.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tablaRRHH.getColumnCount(); col++) {
				joiner.add(tablaRRHH.getColumnName(col));
			}
			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();
			
			for (int row = 0; row < tablaRRHH.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tablaRRHH.getColumnCount(); col++) {
					
					Object obj = tablaRRHH.getValueAt(row, col);
					String value = obj == null ? "null" :obj.toString();
					joiner.add(value);
					
				}
				
				System.out.println(joiner.toString());
				bw.write(joiner.toString());
				bw.newLine();
				//JOptionPane.showMessageDialog(null, "Se modificó correctamente");
			}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error");
		}
		
}


}
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

public class Compras {
	
String codigoCompras;
String nombreCompras;
String descripcionCompras;
String precioCompras;

public String getCodigoCompras() {
	return codigoCompras;
}
public void setCodigoCompras(String codigoCompras) {
	this.codigoCompras = codigoCompras;
}
public String getNombreCompras() {
	return nombreCompras;
}
public void setNombreCompras(String nombreCompras) {
	this.nombreCompras = nombreCompras;
}
public String getDescripcionCompras() {
	return descripcionCompras;
}
public void setDescripcionCompras(String descripcionCompras) {
	this.descripcionCompras = descripcionCompras;
}
public String getPrecioCompras() {
	return precioCompras;
}
public void setPrecioCompras(String precioCompras) {
	this.precioCompras = precioCompras;
}

public void crearArchivoCompras() {
	try {
		File objetoArchivo = new File("Compras.txt");
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
public void agregarRegistrosCompras() {
	try {
		FileWriter fw = new FileWriter("Compras.txt",true);
                
		fw.write(getCodigoCompras());
		fw.write(",");
		fw.write(getNombreCompras());
		fw.write(",");
		fw.write(getDescripcionCompras());
		fw.write(",");
		fw.write(getPrecioCompras());
                fw.write("\n");
		fw.close();
		
		JOptionPane.showMessageDialog(null,"Se registró correctamente");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un error al registrar" + e.toString());
	}
}

public void MostrarTotalCompras(JTable tablaTotalCompras) {
	
	String nombreArchivo = "Compras.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Descripcion");
                model.addColumn("Precio");
		
		tablaTotalCompras.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tablaTotalCompras.setModel(model);
		}
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
		
	}
}

public void seleccionarCompras(JTable tablaCompras) {
	
	try {
		
		int  fila = tablaCompras.getSelectedRow();
		
		if (fila>=0) {
			
			setCodigoCompras(tablaCompras.getValueAt(fila, 0).toString());
			setNombreCompras(tablaCompras.getValueAt(fila, 1).toString());
			setDescripcionCompras(tablaCompras.getValueAt(fila, 2).toString());
                        setPrecioCompras(tablaCompras.getValueAt(fila, 3).toString());
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
	}
	
}

public void EliminarCompras (JTable tablaCompras, JTextField codigoCompras) {
	
	//Eliminación visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaCompras.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(codigoCompras.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}
	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("Compras.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
	}
	
	//Creaci�n de los nuevos registros luego de la eliminación
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Compras.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
			joiner.add(tablaCompras.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaCompras.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
				
				Object obj = tablaCompras.getValueAt(row, col);
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

public void EditarCompras(JTable tablaCompras) {
	
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("Compras.txt");
			writer.print("");
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
		}
		
		//Creaci�n de los nuevos registros luego de la eliminación
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Compras.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
				joiner.add(tablaCompras.getColumnName(col));
			}
			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();
			
			for (int row = 0; row < tablaCompras.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
					
					Object obj = tablaCompras.getValueAt(row, col);
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
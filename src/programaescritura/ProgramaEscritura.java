/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaescritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class ProgramaEscritura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File file = new File("archivo_protegido.txt");

        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre", "Archivo protegido", JOptionPane.INFORMATION_MESSAGE);
        String apellidos = JOptionPane.showInputDialog(null, "Ingrese su apellido", "Archivo protegido", JOptionPane.INFORMATION_MESSAGE);
        
        String linea = nombre + " - "+apellidos;
        FileWriter fileWriter;
        
        try {
            //Anadimos el metodo setWritable en el archivo para poder escrbir
            file.setWritable(true); 
            fileWriter = new FileWriter(file,true);
            fileWriter.write(linea+"\n");
            file.setWritable(false); 
            fileWriter.close();
            JOptionPane.showMessageDialog(null,"Archivo escrito","Todo bien",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Ocurrio un problema: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}

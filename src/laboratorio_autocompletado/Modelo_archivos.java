/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio_autocompletado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author lesepulveda
 */
public class Modelo_archivos {

    private ArrayList<String> palabras;
    JFileChooser fc;
    File archivo;

    Modelo_archivos() {
        palabras = new ArrayList<>();
        fc=new JFileChooser();
    }

public void SetText(JFrame frame, JTextPane textPane){
   FileNameExtensionFilter filter =  new FileNameExtensionFilter("Archivos .txt", "txt", "texto");
        fc.setFileFilter(filter);

        int opcion= fc.showOpenDialog(frame);
        
        if (opcion==JFileChooser.APPROVE_OPTION) {
            archivo = fc.getSelectedFile();
            
                    try(Scanner lector = new Scanner(archivo)){
                        BufferedReader leer= new BufferedReader(new FileReader(archivo));
                        String linea = leer.readLine();
                        
                // Mientras el archivo tenga otra línea.
                while(linea!=null){
                    appendString(linea,textPane);
                    linea= leer.readLine();
                    if (linea==null) {
                        textPane.setText(textPane.getText());
                    }
                    else{
                    textPane.setText(textPane.getText()+"\n");
                    }
                   
                }
            } catch (FileNotFoundException ex) {
                mostrarError("Archivo no existe", "No se pudo encontrar el archivo");
            } catch (NullPointerException ex) {
                mostrarError("Formato equivocado", "El archivo no tiene el formato correcto");
            } catch (NumberFormatException ex) {
                mostrarError("Formato equivocado", "Los tipos de datos no coinciden");
            } catch (Exception ex){
                mostrarError("Error", "Algo inesperado ocurrió");
                ex.printStackTrace();
            }
    
           
        }
}
    
public void appendString(String str, JTextPane pane) throws BadLocationException
{
     StyledDocument document = (StyledDocument) pane.getDocument();
     document.insertString(document.getLength(), str, null);
                                                    
}

    
    public void setPalabras(String palabra) {
        palabras.add(palabra);
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null,
                mensaje,
                titulo,
                JOptionPane.ERROR_MESSAGE);
    }

    public ArrayList<String> Leer_Archivo() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    Modelo_archivos.class.getResourceAsStream("archivo.txt"), "UTF-8"));
            String a = br.readLine();
            while (a != null) {
                palabras.add(a);
                a = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            mostrarError("Error", "ruta no encontrada");
        }

        return palabras;

    }

}

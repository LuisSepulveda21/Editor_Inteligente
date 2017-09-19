/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio_autocompletado;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * @author lesepulveda
 */
public class Controlador {

    Arbol principal;
    Modelo_archivos archivo;

    Controlador() {
        principal = new Arbol();
        archivo = new Modelo_archivos();
    }

    public ArrayList<String> buscar_palabras(String letras) {
        return principal.buscar_palabras(letras);
    }

    void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null,
                mensaje,
                titulo,
                JOptionPane.ERROR_MESSAGE);
    }
    
      void mostrarMensaje(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null,
                mensaje,
                titulo,
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public void seleccionar(JFrame frame, JTextPane textPane){
    archivo.SetText(frame, textPane);
    }
    

    public void Agregar_Nuevas_Palabras(String palabra) throws IOException {
        boolean flag = false;
        ArrayList<String> palabras = archivo.getPalabras();
        for (String p : palabras) {
            if (p.equals(palabra)) {
                flag = true;
            }
        }
        if (!palabra.matches("[0-9]+") && palabra.matches("[a-zA-Z_]+")) {
            if (flag == false) {
                archivo.setPalabras(palabra);
                principal.agregar_palabraN(palabra);
                mostrarMensaje("Exito","Palabra agregada");
            } else {
                mostrarError("Error", "Imposible agregar esta palabra");
            }
        } else {
            mostrarError("Error", "Solo palabras");
        }

    }

    public void Agregar_palabras() throws IOException {
        //crea el arbol
        principal.Crear_Arbol(archivo.Leer_Archivo());

    }

}

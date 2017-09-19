/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio_autocompletado;

import java.util.ArrayList;

/**
 *
 * @author lesepulveda
 */
class Nodo {

    private Boolean marcador;

    private ArrayList<Nodo> hijos;

    private Nodo padre;

    private char letra;

    Nodo(char letra) {
        this.letra = letra;
        hijos = new ArrayList<>();
        marcador = false;

    }

    public void AgregarHijo(Nodo hijo) {
        hijos.add(hijo);
    }

    public Boolean getMarcador() {
        return marcador;
    }

    public void setMarcador(Boolean marcador) {
        this.marcador = marcador;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public Nodo getPadre() {
        return padre;
    }

    public Nodo getHijo(char c) {
        for (Nodo a : hijos) {
            if (a.getletra() == c) {
                return a;
            }

        }
        return null;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public char getletra() {
        return letra;
    }

}

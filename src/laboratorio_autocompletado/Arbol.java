package laboratorio_autocompletado;

import java.util.ArrayList;

public class Arbol {

    private Nodo raiz;
    ArrayList<String> palabras;
    String palabra;

    public Arbol() {
        palabras = new ArrayList<>();
    }

    public void agregar_palabraN(String palabra) {
        Add_recursiva(palabra, raiz, 0);
    }

    public ArrayList<String> buscar_palabras(String letras) {
        palabras.clear();
        palabra = "";
        Nodo letra = null;
        Nodo n = raiz;
        int cont = 0;

        for (int i = 0; i < letras.length(); i++) {
            if (i == 0) {
                letra = Buscar_nodo(raiz, letras.charAt(i));
                if (letra != raiz) {
                    cont = cont + 1;
                    n = letra;
                    palabra = palabra + letra.getletra();
                }
            } else {
                letra = Buscar_nodo(letra, letras.charAt(i));
                if (letra != n) {
                    n = letra;
                    cont = cont + 1;
                    palabra = palabra + letra.getletra();
                }

            }
        }

        if (cont == letras.length() && letra != raiz) {
            buscar_palabras(letra, 0);
        }
        return palabras;
    }

    public void buscar_palabras(Nodo letra, int k) {

        if (letra.getMarcador() == true && k == 1) {
            palabra = palabra + letra.getletra();
            palabras.add(palabra);
            if (letra.getHijos() == null) {
                palabra = "";
            }

        } else if (k == 1) {
            palabra = palabra + letra.getletra();
        }

        for (int i = 0; i < letra.getHijos().size(); i++) {
            String palabra_aux = palabra;
            buscar_palabras(letra.getHijos().get(i), 1);
            palabra = palabra_aux;
        }

    }

    public void Add_recursiva(String palabra, Nodo n, int i) {

        if (i < palabra.length()) {
            char letra = palabra.charAt(i);
            Nodo busqueda = Buscar_nodo(n, letra);

            if (busqueda != n) {
                Add_recursiva(palabra, busqueda, i + 1);
            } else {
                Nodo k = new Nodo(letra);
                busqueda.AgregarHijo(k);
                k.setPadre(busqueda);
                Add_recursiva(palabra, busqueda.getHijo(letra), i + 1);
            }
        } else {
            n.setMarcador(true);
        }

    }

    public Nodo Buscar_nodo(Nodo n, char letra) {
        Nodo k = n;
        if (n != null) {
            Nodo a = n.getHijo(letra);
            if (a != null) {
                return a;
            }
        }
        return k;
    }

    public void vertodo(Nodo n) {
        if (n != null) {
            for (Nodo k : n.getHijos()) {
                vertodo(k);
            }

        }
    }

    public void Crear_Arbol(ArrayList<String> palabras) {
        Nodo n = new Nodo('X');
        raiz = n;
        int j = 0;
        while (j < palabras.size()) {
            Add_recursiva(palabras.get(j), raiz, 0);
            j = j + 1;
        }

    }

}

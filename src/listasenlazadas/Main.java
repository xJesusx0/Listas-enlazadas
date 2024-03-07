package listasenlazadas;

import listasenlazadas.Nodo;
import static listasenlazadas.Nodo.*;
import static listasenlazadas.Metodos.*;
import static listasenlazadas.ListasEnlazadas.*;

public class Main {

    static Nodo cabeza = null;
    public static void main(String[] args) {

        while (true) {
            menu();
            byte opcion = inputByte("Ingrese su opcion");

            switch (opcion) {
                case 0 -> System.out.println("Saliendo...");
                case 1 -> imprimirLista();
                case 2 -> iniciarLista();
                case 3 -> insertarAlInicio();
                case 4 -> insertarAlFinal();
                case 6 -> eliminarPrimero();
                default -> System.out.println("Opcion invalida");
                    
            }

            if(opcion == 0){
                break;
            }
        }
        
    }

}


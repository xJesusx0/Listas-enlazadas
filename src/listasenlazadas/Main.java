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
            System.out.println("╔═══════════════════╗");
            byte opcion = inputByte("║ Ingrese su opcion ║");
            System.out.println("╚═══════════════════╝");

            switch (opcion) {
                case 0 -> mostrarAviso("Saliendo...");
                case 1 -> imprimirLista();
                case 2 -> iniciarLista();
                case 3 -> insertarAlInicio();
                case 4 -> insertarAlFinal();
                case 6 -> eliminarPrimero();
                case 7 -> eliminarUltimo();
                default -> mostrarError("Opcion invalida");
                    
            }

            if(opcion == 0){
                break;
            }
        }
        
    }

}


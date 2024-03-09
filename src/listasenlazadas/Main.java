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
            
            byte opcion = inputByte("╔═══ Ingrese su opcion");
            

            switch (opcion) {
                case 0 -> mostrarAviso("Saliendo...");
                case 1 -> imprimirLista();
                case 2 -> iniciarLista();
                case 3 -> insertarAlInicio();
                case 4 -> insertarAlFinal();
                case 6 -> eliminarPrimero();
                case 7 -> eliminarUltimo();
                case 12 -> buscarPorNombre();
                case 13 -> buscarPorSaldo();
                case 14 -> buscarPorSaldoMayorA();
                case 15 -> buscarPorSaldoMenorA();
                case 16 -> buscarMayor();
                case 17 -> buscarMenor();
                default -> mostrarError("Opcion invalida");
                    
            }

            if(opcion == 0){
                break;
            }
        }
        
    }

}


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
                case 8 -> eliminarPorNombre();
                case 9 -> eliminarPorSaldo();
                case 10 -> eliminarPorSaldoMayorA();
                case 11 -> eliminarPorSaldoMenorA();
                case 12 -> eliminar();
                case 13 -> buscarPorNombre();
                case 14 -> buscarPorSaldo();
                case 15 -> buscarPorSaldoMayorA();
                case 16 -> buscarPorSaldoMenorA();
                case 17 -> buscarMayor();
                case 18 -> buscarMenor();
                case 19 -> promedioDeSueldos();
                case 20 -> sumatoriaDeSueldos();
                default -> mostrarError("Opcion invalida");
                    
            }

            if(opcion == 0){
                break;
            }
        }
        
    }

}


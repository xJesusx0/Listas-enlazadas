package listasenlazadas;

import static listasenlazadas.Main.*;
import static listasenlazadas.Metodos.*;
import static listasenlazadas.Nodo.imprimirNodo;

import listasenlazadas.Nodo.*;

public class ListasEnlazadas {

    //Iniciar lista

    public static void iniciarLista(){

        boolean existeLista = cabeza != null;

        if(existeLista){
            mostrarError("La lista ya ha sido creada");
            return;
        } 

        cabeza = new Nodo(); 

        avisoInicio("Creando nodo...");
        cabeza.nombre = input("Ingrese el nombre");
        cabeza.saldo = inputInt("Ingres el saldo");
        cabeza.apuntador = null;

        avisoFin("Lista creada correctamente");
    }

    //Imprimir lista

    public static void imprimirLista(){

        boolean existeLista = cabeza != null;

        if(!existeLista){
            mostrarError("La lista no existe");
            return;
        }

        Nodo auxiliar = cabeza;
        int contador = 1;
        while(auxiliar != null){
            imprimirNodo(auxiliar,contador);
            auxiliar = auxiliar.apuntador;
            contador++;

        }
    }

    //Insercion de nodos

    public static void insertarAlInicio(){

        boolean existeLista = cabeza != null;

        if(!existeLista){
            mostrarError("La lista no existe");
            return;
        } 

        Nodo auxiliar = new Nodo();

        avisoInicio("Creando nodo...");
        auxiliar.nombre = input("Ingrese el nombre");
        auxiliar.saldo = inputInt("Ingrese el saldo");
        auxiliar.apuntador = cabeza;

        cabeza = auxiliar;

        avisoFin("Nodo insertado al inicio correctamente");
        imprimirNodo(auxiliar, -1);
    }


    public static void insertarAlFinal(){

        boolean existeLista = cabeza != null;

        if(!existeLista){
            mostrarError("La lista no existe");
            return;
        }

        avisoInicio("Creando nodo...");
        Nodo nuevoNodo = new Nodo();

        nuevoNodo.nombre = input("Ingrese el nombre");
        nuevoNodo.saldo = inputInt("Ingrese el saldo");
        nuevoNodo.apuntador = null;

        Nodo auxiliar = cabeza;
        while(auxiliar.apuntador != null){
            auxiliar = auxiliar.apuntador;
        }
        
        auxiliar.apuntador = nuevoNodo;

        avisoFin("Nodo insertado al final correctamente");
        imprimirNodo(nuevoNodo,-1);

    }

    public static void insertarEntreNodos(Nodo anterior, Nodo siguiente){

        boolean existeLista = cabeza != null;

        if(!existeLista){
            mostrarError("La lista no existe");
            return;
        }


        avisoInicio("Creando nodo...");

        Nodo nuevoNodo = new Nodo();

        nuevoNodo.nombre = input("Ingrese el nombre");
        nuevoNodo.saldo = inputInt("Ingrese el saldo");

        avisoFin("Nodo creado correctamente");
        avisoInicio("Insertando nodo...");

        anterior.apuntador = nuevoNodo;
        nuevoNodo.apuntador = siguiente;

        avisoFin("Nodo insertado correctamente");
    }

    //Eliminacion de nodos

    public static void eliminarPrimero(){
        
        boolean existeLista = cabeza != null;

        if(!existeLista){
            mostrarError("La lista no existe");
            return;
        }

        if (cabeza.apuntador == null) {
            cabeza = null;
            System.out.println("Único elemento eliminado. La lista está vacía ahora.");
            return;
        }
        
        Nodo auxiliar = cabeza;
        
        System.out.println("Nodo a eliminar: ");
        imprimirNodo(auxiliar, -1);

        int confirmacion = inputInt("Confirmar eliminacion (1 = Si) / (cualquier otro numero = No)");

        if(confirmacion != 1){
            System.out.println("Eliminacion cancelada");
            return;
        }


        avisoInicio("Eliminando nodo...");
        cabeza = auxiliar.apuntador;

        auxiliar = null;
        avisoFin("Nodo eliminado correctamente");
    }

    public static void eliminarUltimo(){
        
        boolean existeLista = cabeza != null;

        if(!existeLista){
            mostrarError("La lista no existe");
            return;
        }

        if (cabeza.apuntador == null) {
            cabeza = null;
            System.out.println("Único elemento eliminado. La lista está vacía ahora.");
            return;
        }

        
        Nodo auxiliar = cabeza;
        Nodo penultimoNodo = new Nodo();

        while(auxiliar.apuntador != null){
            penultimoNodo = auxiliar;
            auxiliar = auxiliar.apuntador;
        }
        
        System.out.println("Nodo a eliminar: ");
        imprimirNodo(auxiliar, -1);

        int confirmacion = inputInt("Confirmar eliminacion (1 = Si) / (cualquier otro numero = No)");

        if(confirmacion != 1){
            System.out.println("Eliminacion cancelada");
            return;
        }

        avisoInicio("Eliminando nodo...");
        penultimoNodo.apuntador = null;
        auxiliar = null;
        avisoFin("Nodo eliminado correctamente");
    }

    public static void eliminarPorNombre(){

        if(cabeza != null){
            Nodo auxiliar = cabeza;
            Nodo auxiliar1 = new Nodo();
            String nombre = input("Ingrese el nombre a eliminar");

            while((auxiliar != null) && (!auxiliar.nombre.equals(nombre))){
                auxiliar1 = auxiliar;
                auxiliar = auxiliar.apuntador;

            }

            if(auxiliar != null){
                if(auxiliar == cabeza){
                    cabeza = cabeza.apuntador;

                } else {
                    auxiliar1.apuntador = auxiliar.apuntador;
                }

                auxiliar = null;

            } else {
                System.out.println("No hay referencia");

            }

        }
        

    }
}

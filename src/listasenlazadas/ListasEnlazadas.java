package listasenlazadas;

import static listasenlazadas.Main.*;
import static listasenlazadas.Metodos.*;
import static listasenlazadas.Nodo.imprimirNodo;

import listasenlazadas.Nodo.*;
import static listasenlazadas.Estilos.*;

public class ListasEnlazadas {

    //Iniciar lista

    public static void iniciarLista(){


        if(existeLista()){
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

    public static boolean existeLista(){
        return cabeza != null;
    }

    //Imprimir lista

    public static void imprimirLista(){


        if(!existeLista()){
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


        if(!existeLista()){
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


        if(!existeLista()){
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


        if(!existeLista()){
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
        

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }
        
        if(cabeza.apuntador == null){
            mostrarAviso("Ultimo elemento de la lista");
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
        

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        if(cabeza.apuntador == null){
            mostrarAviso("Ultimo elemento de la lista");
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

    public static void buscarPorNombre(){

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        String nombre = input("Ingrese el nombre a buscar");

        Nodo auxiliar = cabeza;

        int contador = 1;
        int cantidadEncontrados = 0;

        while(auxiliar != null){

            if(auxiliar.nombre.equals(nombre)){
                imprimirNodo(auxiliar,contador);
                cantidadEncontrados++;
            }
    
            auxiliar = auxiliar.apuntador;
            contador++;

        }

        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);

    }

    public static void buscarPorSaldo(){

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        int saldo = inputInt("Ingrese el saldo a buscar");

        Nodo auxiliar = cabeza;

        int contador = 1;
        int cantidadEncontrados = 0;

        while(auxiliar != null){

            if(auxiliar.saldo == saldo){
                imprimirNodo(auxiliar,contador);
                cantidadEncontrados++;
            }
   
            auxiliar = auxiliar.apuntador;
            contador++;

        }

        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
            return;
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);

    }

    public static void buscarPorSaldoMayorA(){
        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        int saldo = inputInt("Ingrese el saldo a buscar");

        Nodo auxiliar = cabeza;

        int contador = 1;
        int cantidadEncontrados = 0;

        while(auxiliar != null){

            if(auxiliar.saldo > saldo){
                imprimirNodo(auxiliar,contador);
                cantidadEncontrados++;
            }
   
            auxiliar = auxiliar.apuntador;
            contador++;

        }

        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
            return;
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);

    }

    public static void buscarPorSaldoMenorA(){
        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        int saldo = inputInt("Ingrese el saldo a buscar");

        Nodo auxiliar = cabeza;

        int contador = 1;
        int cantidadEncontrados = 0;

        while(auxiliar != null){

            if(auxiliar.saldo < saldo){
                imprimirNodo(auxiliar,contador);
                cantidadEncontrados++;
            }
   
            auxiliar = auxiliar.apuntador;
            contador++;

        }

        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
            return;
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);     
    }
    
    public static void buscarSaldoRepetido(int saldo){

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        Nodo auxiliar = cabeza;

        int contador = 1;
        int cantidadEncontrados = 0;

        while(auxiliar != null){

            if(auxiliar.saldo == saldo){
                imprimirNodo(auxiliar,contador);
                cantidadEncontrados++;
            }
   
            auxiliar = auxiliar.apuntador;
            contador++;

        }

        if(cantidadEncontrados == 0){
            mostrarAviso("No se encontro ningun nodo");
            return;
        }

        System.out.println(GREEN + "Nodos encontrados: " + cantidadEncontrados + RESET);

    }

    public static void buscarMayor(){

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        Nodo auxiliar = cabeza;
        int mayor = auxiliar.saldo;

        while(auxiliar != null){
            auxiliar = auxiliar.apuntador;

            if(auxiliar.saldo > mayor){
                mayor = auxiliar.saldo;

            }
        }

        buscarSaldoRepetido(mayor);

    }

    public static void buscarMenor(){

        if(!existeLista()){
            mostrarError("La lista no existe");
            return;
        }

        Nodo auxiliar = cabeza;
        int menor = auxiliar.saldo;

        while(auxiliar.apuntador!= null){
            auxiliar = auxiliar.apuntador;

            if(auxiliar.saldo < menor){
                menor = auxiliar.saldo;

            }
        }

        buscarSaldoRepetido(menor);

    }
    // >
    // <
}

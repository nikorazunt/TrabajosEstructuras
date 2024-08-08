/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase01;

/**
 *
 * @author Admin
 */
public class ListaDinamica {
    private int[] lista;
    private int tamanio;
    
    public ListaDinamica(){
        lista = new int[10];
        tamanio=0;        
    }
    
    public void agregarElemento(int elemento){
        if(tamanio == lista.length){
            redimensionarArreglo();
        }
        lista[tamanio++]=elemento;
        System.out.print("elemento" + elemento + "agregado");
        
    }
    
    public void eliminarElemento(int elemento){
        int indice = buscarElemento(elemento);
        if(indice!= -1){
            for( int i =indice; i<tamanio-1; i++){
            lista[i]=lista [i+1];
        }
            tamanio--;
              System.out.print("elemento" + elemento + "eliminado");
    
        }else{
              System.out.print("elemento no encontrado");
        }
        
    }
    public void mostrarElementos(){
        if(tamanio==0){
              System.out.print("lista vacia");
        }else {
            for(int i=0; i<tamanio;i++){
                System.out.println(lista[i]+" ");
            }
        }
    }
    public void redimensionarArreglo(){
        int[] nuevoarreglo = new int[lista.length*2];
        System.arraycopy(lista, 0, nuevoarreglo, 0, lista.length);
        lista=nuevoarreglo;               
    }
    public int buscarElemento(int elemento){
        for(int i =0; i<tamanio; i++){
            if(lista[i]==elemento){
                 return i;     
            }
        }
        return -1;
    }

    
}


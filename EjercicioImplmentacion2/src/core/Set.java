/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author isabe
 */
public class Set {
    
    private int puntosJugador1;
    private int puntosJugador2;
    private int index;

    public Set(int puntosJugador1, int puntosJugador2) {
        this.puntosJugador1 = puntosJugador1;
        this.puntosJugador2 = puntosJugador2;
        this.index = index;
    }

   

    public int getPuntosJugador1() {
        return puntosJugador1;
    }

    public int getPuntosJugador2() {
        return puntosJugador2;
    }

    public int getIndex(Set set){
       return this.index;
    }
}

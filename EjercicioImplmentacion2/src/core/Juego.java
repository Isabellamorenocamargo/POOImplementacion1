/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.persona.Juez;
import core.persona.Jugador;
import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juez juez;
    private Juego juegoPrevio1;
    private Juego juegoPrevio2;
    private Juego juegoSiguiente;
    private ArrayList<Set> sets;

    public Juego(Jugador jugador1, Jugador jugador2, Juez juez) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.juez = juez;
        this.sets = new ArrayList<>();
        this.juegoPrevio1 = null;
        this.juegoPrevio2 = null;
        this.juegoSiguiente = null;

        this.jugador1.addJuegos(this);
        this.jugador2.addJuegos(this);
        this.juez.addJuegos(this);
    }
  
    public Juego(Juego juegoPrevio1, Juego juegoPrevio2, Juez juez) {
          this.juegoPrevio1 = juegoPrevio1;
        this.juegoPrevio2 = juegoPrevio2;
        this.jugador1 = this.juegoPrevio1.getGanador();
        this.jugador2 = this.juegoPrevio2.getGanador();
        this.juez = juez;
      
        this.sets = new ArrayList<>();
        this.juegoSiguiente = null;

        this.juegoPrevio1.setJuegoSiguiente(this);
        this.juegoPrevio2.setJuegoSiguiente(this);
         this.jugador1.addJuegos(this);
        this.jugador2.addJuegos(this);
        this.juez.addJuegos(this);

    }

    public void addSets(Set set1, Set set2, Set set3) {
        sets.add(set1);
        sets.add(set2);
        sets.add(set3);
    }

    public void addSets(Set set1, Set set2) {
        sets.add(set1);
        sets.add(set2);
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Juez getJuez() {
        return juez;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }

    public void setJuegoSiguiente(Juego juegoSigueinte) {
        this.juegoSiguiente = juegoSigueinte;
    }

    public Jugador getGanador() {
        ArrayList<Integer> counts = new ArrayList<>();
        for (Set set : sets) {
            counts.add(0);
        }

        for (Set set : sets) {
            //si gano el set el jugador 1 se suma en el contador
            if (set.getPuntosJugador1() >= 6 && (set.getPuntosJugador1() - set.getPuntosJugador2()) >= 2) {
                counts.set(0, counts.get(0) + 1);
            } else {
                //si gano el set el juagdor 2 entonces se suma la cuenta a este
                if (set.getPuntosJugador2() >= 6 && (set.getPuntosJugador2() - set.getPuntosJugador1()) >= 2) {
                    counts.set(1, counts.get(1) + 1);
                }
            }
        }
        if (counts.get(0) == 2) {
            return jugador1;
        } else {

            return jugador2;

        }

    }

}

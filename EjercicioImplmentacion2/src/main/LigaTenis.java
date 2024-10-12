/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import core.Campeonato;
import core.Juego;
import core.Set;
import core.persona.Juez;
import core.persona.Jugador;
import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class LigaTenis {

    private ArrayList<Campeonato> campeonatos;
    private ArrayList<Juez> jueces;
    private ArrayList<Jugador> jugadores;

    public LigaTenis() {
        this.campeonatos = new ArrayList<>();
        this.jueces = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }

   

    public boolean addJuez(Juez juez) {
        if (!this.jueces.contains(juez)) {
            this.jueces.add(juez);
            return true;
        }
        return false;
    }

    public boolean addJugador(Jugador jugador) {
        if (!this.jugadores.contains(jugador)) {
            this.jugadores.add(jugador);
            return true;
        }
        return false;
    }

    public boolean addCampeonato(Campeonato campeonato) {
        if (!this.campeonatos.contains(campeonato)) {
            this.campeonatos.add(campeonato);
            return true;
        }
        return false;
    }

    public Campeonato getCampeonato(int index) {
        return this.campeonatos.get(index);
    }

    public Jugador getJugador(int index) {
        return this.jugadores.get(index);
    }

    public Juez getJuez(int index) {
        return this.jueces.get(index);
    }

    public void calcSetsGanadosJugadoresCampeonato(int index) {
        int count;
        //para cada jugador en la lista de jugadores
        for (Jugador jugador : this.jugadores) {
            //inicializar el contador de sets ganados en 0
            count = 0;
            //para cada juego de ese jugador, y para cada set...
            for (Juego juegos : jugador.getJuegos()) {
                for (Set set : juegos.getSets()) {
                    //hallar si gano, primero verificar que sea el jugador 1 o 2 y si gano y aumentar el contador en 1, tener en cuanta que se gana el set con ventaja de 2 puntos
                    if (juegos.getJugador1().equals(jugador) && set.getPuntosJugador1() >= 6 && (set.getPuntosJugador1() - set.getPuntosJugador2()) >= 2) {
                        count++;
                    } else {
                        if (juegos.getJugador2().equals(jugador) && set.getPuntosJugador2() >= 6 && (set.getPuntosJugador2() - set.getPuntosJugador1()) >= 2) {
                            count++;
                        }
                    }
                }

            }
            System.out.println("El jugador: " + jugador.getNombre() + " gano " + count + " sets en el campeonato");
        }
    }
}

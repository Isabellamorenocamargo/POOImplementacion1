/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import core.persona.Jugador;
import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class Campeonato {

    private ArrayList<Juego> juegos;

    public Campeonato() {
        this.juegos = new ArrayList<>();
    }

    public boolean addJuego(Juego juego) {
        if (!this.juegos.contains(juego)) {
            this.juegos.add(juego);
            return true;
        }
        return false;

    }

    public Juego getJuego(int index) {
        return this.juegos.get(index);
    }

    public void showResumen() {
        Campeonato campeonato = this;

        for (int i = 0; i <= 6; i++) {
            System.out.println("Jugador 1: " + this.getJuego(i).getJugador1().getNombre());
            System.out.println("Jugador 2: " + this.getJuego(i).getJugador2().getNombre());
            System.out.println("Juez: " + this.getJuego(i).getJuez().getNombre());
            int indexofset = 0;
            for (Set set : campeonato.getJuego(i).getSets()) {

                System.out.println("Set " + (indexofset + 1) + ": " + set.getPuntosJugador1() + " - " + set.getPuntosJugador2());
                indexofset++;
            }
            System.out.println("Ganador: " + this.getJuego(i).getGanador().getNombre() + "\n");
        }

        System.out.println("El ganador del campeonato es: " + this.getJuego(6).getGanador().getNombre() + "\n");

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea5;

import java.awt.Color;

/**
 *
 * @author Daniel
 */
public class Fondo {
    final Color ROJO = new Color(252, 216, 209);
    final Color BLANCO = new Color(255, 255, 255);
    final Color VERDE = new Color(218, 252, 209);
    private static Color color;
    
    public Fondo(){
        color = BLANCO;
    }

    public Color getColor() {
        return color;
    }
    
    public void cambiarColor(Color c) {
        color = c;
    }
}

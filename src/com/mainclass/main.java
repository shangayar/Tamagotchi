package com.mainclass;
import com.mascotavirtual.mascota_virtual;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

		long startTime, endTime, time;
		int valor = 0;
		String input;
		boolean food= false;
		boolean play = false;
		

		JOptionPane.showMessageDialog(null, "*********Welcome to Tamagotchi***********");
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre para su mascota:");
				
		mascota_virtual tamagotchi = new mascota_virtual(nombre);
		startTime = System.currentTimeMillis(); // Inicio cuenta de tiempo en milisegundos
		

		do {
			input = JOptionPane.showInputDialog("Elija entre las siguientes opciones: \n"
					+ "1. Alimenta a "+nombre+"\n"
					+ "2. Juega con "+nombre+"\n"
					+ "3. Como está "+nombre+"?\n"
					+ "4. Salir");
			
			try {
				valor = Integer.parseInt(input);
				
				switch(valor) {
					case 1: 
						endTime = System.currentTimeMillis();
						time = endTime-startTime;
						if(!food) {
							food = tamagotchi.comer(time);
							startTime = System.currentTimeMillis();
						}
						else {
							JOptionPane.showMessageDialog(null, "No tengo hambre!!","Aviso", JOptionPane.WARNING_MESSAGE, null);
						}						
						break;
					case 2:
						endTime = System.currentTimeMillis();
						time = endTime-startTime;
						if(!play) {
							play = tamagotchi.jugar();
						}

						break;
					case 3:
						endTime = System.currentTimeMillis();
						time = endTime-startTime;
						if(time>55000 && time<75000){
							tamagotchi.setEstado("Hambrienta");
							food = false;
						}else if(time>=75000 && play==true && time<90000) {
							tamagotchi.setEstado("Aburrida");
							play = false;
						}else if(time>=90000 && play==false && food==false) {
							tamagotchi.setEstado("Triste");
						}
						tamagotchi.mostrar();
					case 4:
						break;
					default: 
						JOptionPane.showMessageDialog(null, "Escoja entre las opciones","Error",JOptionPane.WARNING_MESSAGE);
						break;
				}		
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "La opción no es correcta","Error", JOptionPane.WARNING_MESSAGE, null);
			}
				
			
		}while(valor != 4);
		
		
		
	}

}

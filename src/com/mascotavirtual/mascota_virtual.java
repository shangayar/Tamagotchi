package com.mascotavirtual;

import javax.swing.JOptionPane;

public class mascota_virtual {
	private String nombre;
	private int nivel;
	private String estado;
	
	public mascota_virtual(String nombre) {
		this.nombre = nombre;
		this.nivel = 0;
		this.estado = "Contenta";		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void mostrar(){
		JOptionPane.showMessageDialog(null," Tu mascota se llama "+this.getNombre()+"\n"
				+ "y está "+this.getEstado()+"\n"
						+ "su nivel es: "+this.getNivel());
	}
	public boolean comer(long time) {
		JOptionPane.showMessageDialog(null, "Gracias por la comida!","Aviso", JOptionPane.INFORMATION_MESSAGE, null);
		if(this.getEstado().equals("Contenta")) {
			int var = this.getNivel();
			var++;
			this.setNivel(var);
		}else if(this.getEstado().equals("Hambrienta")) {
			this.setEstado("Contenta");
		}else if((this.getEstado().equals("Aburrida") && time>180000)) {//cambiar valor a 4800000 para 80'
			this.setEstado("Contenta");
		}
		return true;
	}
	public boolean jugar() {		
		if(this.getEstado().equals("Contenta")) {
			JOptionPane.showMessageDialog(null, "Sii Juguemos!!","Aviso", JOptionPane.INFORMATION_MESSAGE, null);
			int var = this.getNivel();
			var++;
			this.setNivel(var);
		}else if(this.getEstado().equals("Aburrida")) {
			System.out.println("Estoy Jugando!!!");
			this.setEstado("Contenta");
		}else if(this.getEstado().equals("Hambrienta")) {
			System.out.println("No puedo jugar con hambre!!");
		}
		return true;
	}


}

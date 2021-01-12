package tarea3;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class Cientifico implements Trabajo {
	/*
	Funcion: Investigar
	Input: Adulto
	Funcionalidad: Por investigar el adulto gana entre 10 a 20 monedas y 
				   pierde entre 10 a 15 de energia
	*/
	public void investigar(Adulto adulto){
		Random rand = new Random();
		int dinero, gasto;

		//NextInt(11) -> 0, 10 -> 10 20
		dinero = rand.nextInt(11) + 10;
		gasto = rand.nextInt(6) + 10;
		JOptionPane.showMessageDialog(null,
        adulto.getNombre() + ": OOOH! Este paper me salio de pana banana\n"
		+adulto.getNombre() + ": Gane " + dinero + " de dinero aunque me canse " + gasto+" de energia" , "MIMS", JOptionPane.PLAIN_MESSAGE);
		
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - gasto);
	}

	/*
	Funcion: Experimentar
	Input: Adulto
	Funcionalidad: Por experimentar el adulto gana entre 10 a 30 monedas y 
				   pierde entre 10 a 20 de energia
	*/
	public void experimentar(Adulto adulto){
		Random rand = new Random();
		int dinero, gasto;

		dinero = rand.nextInt(21) + 10;
		gasto = rand.nextInt(11) + 10;

		JOptionPane.showMessageDialog(null,
        adulto.getNombre() + ": *BOOOM* Uf casi exploto el lugar, pero fue un experimento interesante!\n"
		+adulto.getNombre() + ": Gane " + dinero + " de dinero aunque me canse " + gasto+" de energia" , "MIMS", JOptionPane.PLAIN_MESSAGE);
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - gasto);
	}

	/*
	Funcion: Trabajar
	Input: Adulto, Int
	Funcionalidad: Hace elegir adulto entre sus 2 pegas posibles, y eso una cantidad de Horas.
				   Si es que el cansancio es menor a 0, se setea cansancio a 0 y se para el ciclo.
	*/
	public void trabajar(Adulto adulto, int horas){
		String trabajo;

		while(horas-- > 0){
			trabajo = (JOptionPane.showInputDialog(null,
                "Seleccione un trabajo" , "MIMS",JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elegir opcion","Investigar","Experimentar"},"Elegir opcion")).toString();
			
			if(trabajo=="Investigar"){
				JOptionPane.showMessageDialog(null, 
                    adulto.getNombre() + ": Es el momento de escribir un paper!", "MIMS",JOptionPane.PLAIN_MESSAGE);
				this.investigar(adulto);
			}
			else{
				JOptionPane.showMessageDialog(null, 
                    adulto.getNombre() + ": me voy al laboratorio... Chao, loh vimoh!","MIMS",JOptionPane.PLAIN_MESSAGE);
				this.experimentar(adulto);
			}

			if(adulto.getEnergia() < 0){
				adulto.setEnergia(0);
				if(adulto.getSexo() == "Hombre")
					JOptionPane.showMessageDialog(null, 
					adulto.getNombre() + ": Puff estoy muy cansado, no doy más. A veces me gustaría ser un fontanero que rescata princesas...", "MIMS",JOptionPane.PLAIN_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, 
					adulto.getNombre() + adulto.getNombre() + ": Puff estoy muy cansada, no doy más. A veces me gustaría ser una princesa en problemas...", "MIMS",JOptionPane.PLAIN_MESSAGE);
				break;
			}
			if(horas == 0){
				JOptionPane.showMessageDialog(null, 
				adulto.getNombre() + ": Hoy fue un día increible :D.", "MIMS",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
package tarea3;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class Deportista implements Trabajo{
    /*
    Método: entrenar
    Inputs: Adulto
    Funcionalidad: Por entrenar el adulto gana entre 20 a 100 monedas y pierde entre 40 y 60 de energia
    */
    public void entrenar(Adulto adulto){
        Random rand = new Random();
		int dinero, gasto;

		dinero = rand.nextInt(81) + 20;
		gasto = rand.nextInt(21) + 40;

		JOptionPane.showMessageDialog(null,
        adulto.getNombre() + ": *con voz cansada* Que entrenamiento mas intenso...\n"
		+adulto.getNombre() + ": Gane " + dinero + " de dinero aunque me canse " + gasto+" de energia" , "MIMS", JOptionPane.PLAIN_MESSAGE);
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - gasto);
    }

    /*
    Método: competir
    Inputs: Adulto
    Funcionalidad: Por competir el adulto gana entre 100 a 200 monedas y pierde entre 60 y 100 de energia
    */
    public void competir(Adulto adulto){
        Random rand = new Random();
		int dinero, gasto;

		dinero = rand.nextInt(101) + 100;
		gasto = rand.nextInt(41) + 60;

		JOptionPane.showMessageDialog(null,
        adulto.getNombre() + ": *casi desmayandose* Menos mal gane ese partido de mi****...\n"
		+adulto.getNombre() + ": Gane " + dinero + " aunque me canse " + gasto , "MIMS", JOptionPane.PLAIN_MESSAGE);
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - gasto);
    }

    /*
    Método: 	   trabajar
    Inputs: 	   Adulto, int
    Funcionalidad: Realiza el proceso de trabajar para adulto, llamando a pintar o a esculpir según
                   corresponda, la cantidad de veces correspondiente a la cantidad de horas a trabajar
                   y siempre y cuando tenga energí
    */
    public void trabajar(Adulto adulto, int horas){
		String trabajo;

		while(horas-- > 0){
			trabajo = (JOptionPane.showInputDialog(null,
                "Seleccione un trabajo" , "MIMS",JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elegir opcion","Entrenar","Competir"},"Elegir opcion")).toString();
			
			if(trabajo=="Entrenar"){
				JOptionPane.showMessageDialog(null, 
					"Entrenador: Calienta unos 10 miuntos, vamos a entrenar\n"
					+adulto.getNombre()+": Si entrenador!", "MIMS",JOptionPane.PLAIN_MESSAGE);
				this.entrenar(adulto);
			}
			else{
				JOptionPane.showMessageDialog(null, 
				"Entrenador: Tenemos un partido mañana, mentalizate!\n"
				+adulto.getNombre()+": Si entrenador!","MIMS",JOptionPane.PLAIN_MESSAGE);
				this.competir(adulto);
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
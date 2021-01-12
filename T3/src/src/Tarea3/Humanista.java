package tarea3;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class Humanista implements Trabajo{
    /*
    Método:         ensenar
    Inputs:         Adulto
    Funcionalidad:  Realiza el trabajo esculpir, haciendo que el adulto gane dinero a costo de energia
    */
    public void ensenar(Adulto adulto){
        Random rand = new Random();
        int dinero, gasto;
        dinero = rand.nextInt(5)+9;
        gasto = rand.nextInt(4)+6;
        JOptionPane.showMessageDialog(null,
        adulto.getNombre() + ": Que buena clase! espero que lxs chicxs hayan aprendido mucho.\n"
		+adulto.getNombre() + ": Gane " + dinero + " de dinero aunque me canse " + gasto+" de energia" , "MIMS", JOptionPane.PLAIN_MESSAGE);

        adulto.setDinero(adulto.getDinero()+dinero);
        adulto.setEnergia(adulto.getEnergia()-gasto);
    }

    /*
    Método:         Escribir
    Inputs:         Adulto
    Funcionalidad:  Realiza el trabajo esculpir, haciendo que el adulto gane dinero a costo de energia
    */
    public void escribir(Adulto adulto){
        Random rand = new Random();
        int dinero, gasto;
        dinero = rand.nextInt(11)+4;
        gasto = rand.nextInt(10)+4;
        JOptionPane.showMessageDialog(null,
        adulto.getNombre() + ": Que buen poema, Pablo Neruda estaria orgulloso de mi.\n"
		+adulto.getNombre() + ": Gane " + dinero + " de dinero aunque me canse " + gasto+" de energia" , "MIMS", JOptionPane.PLAIN_MESSAGE);

        adulto.setDinero(adulto.getDinero()+dinero);
        adulto.setEnergia(adulto.getEnergia()-gasto);
    }

    /*
    Método:         trabajar
    Inputs:         Adulto, int
    Funcionalidad:  Realiza el proceso de trabajar para adulto, llamando a pintar o a esculpir según
                    corresponda, la cantidad de veces correspondiente a la cantidad de horas a trabajar
                    y siempre y cuando tenga energía
    */
    public void trabajar(Adulto adulto, int horas){
        String trabajo;

		while(horas-- > 0){
			trabajo = (JOptionPane.showInputDialog(null,
                "Seleccione un trabajo" , "MIMS",JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elegir opcion","Ensenar","Escribir"},"Elegir opcion")).toString();
			
			if(trabajo=="Ensenar"){
				JOptionPane.showMessageDialog(null, 
					adulto.getNombre()+": Voy a hacer clases a mis alumnxs!","MIMS",JOptionPane.PLAIN_MESSAGE);
				this.ensenar(adulto);
			}
			else{
				JOptionPane.showMessageDialog(null, 
				adulto.getNombre()+": Ando creativo, escribire algo!","MIMS",JOptionPane.PLAIN_MESSAGE);
				this.escribir(adulto);
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
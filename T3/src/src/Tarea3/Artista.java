package tarea3;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.Random;

public class Artista implements Trabajo{
    /*
    Método:         esculpir
    Inputs:         Adulto
    Funcionalidad:  Realiza el trabajo esculpir, haciendo que el adulto gane dinero a costo de energia
    */
    public void esculpir(Adulto adulto){
        Random rand = new Random();
        int dinero, gasto;
        dinero = rand.nextInt(26);
        gasto = rand.nextInt(25)+6;

        JOptionPane.showMessageDialog(null,
        adulto.getNombre() + "Que Miguel Angel... Que Donatello... " + adulto.getNombre() + " senores!\n"
        +adulto.getNombre() + ": Gane " + dinero + " de dinero aunque me canse " + gasto+" de energia" , "MIMS", JOptionPane.PLAIN_MESSAGE);

        adulto.setDinero(adulto.getDinero()+dinero);
        adulto.setEnergia(adulto.getEnergia()-gasto);
    }

    /*
    Método:         pintar
    Inputs:         Adulto
    Funcionalidad:  Realiza el trabajo esculpir, haciendo que el adulto gane dinero a costo de energia
    */
    public void pintar(Adulto adulto){
        Random rand = new Random();
        int dinero, gasto;
        dinero = rand.nextInt(5)+4;
        gasto = rand.nextInt(5)+3;

        JOptionPane.showMessageDialog(null,
        adulto.getNombre() + "Que Picasso... Que Da Vinci... " + adulto.getNombre() + " senores!\n"
        +adulto.getNombre() + ": Gane " + dinero + " de dinero aunque me canse " + gasto+" de energia", "MIMS", JOptionPane.PLAIN_MESSAGE);

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
                "Elegir opcion","Esculpir","Pintar"},"Elegir opcion")).toString();
			
			if(trabajo=="Esculpir"){
				JOptionPane.showMessageDialog(null, 
                    adulto.getNombre() + ": Charlie vengo inspirado *agarra el cincel*", "MIMS",JOptionPane.PLAIN_MESSAGE);
				this.esculpir(adulto);
			}
			else{
                JOptionPane.showMessageDialog(null, 
                    adulto.getNombre() + ": A pintar!... Y si grabo un Tik Tok?...", "MIMS",JOptionPane.PLAIN_MESSAGE);
				this.pintar(adulto);
			}

			if(adulto.getEnergia() < 0){
				adulto.setEnergia(0);
                if(adulto.getSexo() == "Hombre")
                    JOptionPane.showMessageDialog(null, 
                    adulto.getNombre() + ": Puff estoy muy cansado, no doy más. A veces me gustaría ser un fontanero que rescata princesas...", "MIMS",JOptionPane.PLAIN_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, 
                    adulto.getNombre() + ": Puff estoy muy cansada, no doy más. A veces me gustaría ser una princesa en problemas...", "MIMS",JOptionPane.PLAIN_MESSAGE);
				break;
			}
			if(horas == 0){
                JOptionPane.showMessageDialog(null, 
                adulto.getNombre() + ": Hoy fue un día increible :D.", "MIMS",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
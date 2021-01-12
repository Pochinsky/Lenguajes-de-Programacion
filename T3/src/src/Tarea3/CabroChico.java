package tarea3;

import java.util.Random;
import javax.swing.JOptionPane;

public class CabroChico extends Personaje{
    /*
    Constructor:    CabroChico
    Input:          No recibe
    Funcionalidad:  Inicializa un cabro chico y sus atributos
    */
    public CabroChico(){
        //constructor Personaje
        super();

        //asignacion de sexo
        Random rand = new Random();
        int sex = rand.nextInt(2);
        if(sex==0){
            this.sexo = "Hombre";
        }
        else{
            this.sexo = "Mujer";
        }
        
        //asignacion de edad, dinero y comida
        this.edad = 0;
        this.dinero = 0;
        this.comida = 0;

        //asignacion de fuerza
        this.fuerza = 30;

        //asignacion de energia
        this.energia = 100;
    }

    /*
    Método:         comer
    Inputs:         int
    Funcionalidad:  Descuenta la fuerza correspondiente según la cantidad de comida ingresada.
    */
    @Override
    public void comer(int comida){
        this.comida -= comida;
        int proporcion = (int)(comida/3);
        this.fuerza -= proporcion;
        JOptionPane.showMessageDialog(null, this.nombre+": Que rica la paleta!\n"+this.nombre+": Perdi "+proporcion+" de fuerza :(", "MIMS", JOptionPane.PLAIN_MESSAGE);
    }

    /*
    Método:         dameAlimento<
    Inputs:         int
    Funcionalidad:  Intercambia la cantidad de dinero ingresada por la cantidad de comida correspondiente
    */
    @Override
    public void dameAlimento(int dinero){
        int proporcion = (int)(dinero/4);
        this.dinero -= dinero;
        this.comida += proporcion*6;
        JOptionPane.showMessageDialog(null, 
			this.nombre + ": Que bien! Con mi mesada que compre muchas paletas.\n"+this.nombre+": gaste "+dinero+" monedas y obtuve "+(proporcion*6)+" de comida.", 
			"MIMS", JOptionPane.PLAIN_MESSAGE);
    }

    /*
    Método: dormir
    Inputs: No recibe
    Funcionalidad: Recupera entre 20 y 50 de energía de forma aleatoria
   */
    @Override
    public void dormir(){
        Random rand = new Random();
        int sleep = rand.nextInt(31)+20;
        this.energia += sleep;
        if(this.energia >=100){
            JOptionPane.showMessageDialog(null, this.nombre+": Wooooh!! Energia Maxima!! (100)", "MIMS", JOptionPane.PLAIN_MESSAGE);
            this.energia = 100;
        }
        JOptionPane.showMessageDialog(null, 
			this.nombre+": zzz...\n"+this.nombre+": Genial! Recupere "+sleep+" de energia.",
			"MIMS",JOptionPane.PLAIN_MESSAGE);
    }

    /*
    Método: jugar
    Inputs: No recibe
    Funcionalidad: descuenta energía correspondiente y genera probabilidad de recibir dinero o alimento
    */
    public void jugar(){
        int unidades,probabilidad;
        Random rand = new Random();
        String mensaje = "";

        //dinero
        probabilidad = rand.nextInt(10);
        if(probabilidad == 0){
            unidades = rand.nextInt(2);
            if(unidades==0){
                this.dinero +=2;
                mensaje += this.nombre + ": Oh si! Me encontre 2 monedas.\n";
            }
            else{
                this.dinero += 3;
                mensaje += this.nombre + ": Oh si! Me encontre 3 monedas.\n";
            }
        }
        //comida
        probabilidad = rand.nextInt(20);
        if(probabilidad==0){
            unidades = rand.nextInt(2);
            if(unidades==0){
                this.comida += 1;
                mensaje += this.nombre + ": Oh si! Me encontre una paleta.\n";
            }
            else{
                this.comida += 2;
                mensaje += this.nombre + ": Oh si! Me encontre dos paletas.\n";
            }
        }
        //gasto energético
        int gasto = rand.nextInt(9)+2;
        this.energia -= gasto;
        if(this.energia<=0){
            JOptionPane.showMessageDialog(null, this.nombre+": Oh no! Me he quedado sin energia! (0)", "MIMS", JOptionPane.PLAIN_MESSAGE);
            this.energia = 0;
        }
        mensaje += this.nombre + ": Gaste "+gasto+" de energia.";
        JOptionPane.showMessageDialog(null, mensaje, "MIMS", JOptionPane.PLAIN_MESSAGE);
    }
}
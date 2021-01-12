package tarea3;

import java.util.Random;

import javax.swing.JOptionPane;

public class Adulto extends Personaje{
	//atributos
	protected int estudios;
	protected Trabajo trabajo;

	/*
	Constructor: 	Adulto
	Inputs: 		String, String, int, int, int, int, int
	Funcionalidad:	Inicializa un adulto y todos sus atributos
	*/
	Adulto(String nombre, String sexo, int dinero, int edad, int energia, int fuerza, int comida){
		super();
		this.setNombre(nombre);
		this.setSexo(sexo);
		this.setDinero(dinero);
		this.setEdad(edad);
		this.setEnergia(energia);
		this.setFuerza(fuerza);
		this.setComida(comida);
		this.estudios = 0;
	}
	
	/*
    Método:         comer
    Inputs:         int
    Funcionalidad:  Descuenta la fuerza correspondiente según la cantidad de comida ingresada.
    */
    @Override
    public void comer(int comida){
		this.comida -= comida;
        int proporcion = (int)(comida/6);
		this.fuerza -= proporcion;
		JOptionPane.showMessageDialog(null, 
			this.nombre+": Que rica la pasta... Mamma mia!\n"+this.nombre+": Perdi "+proporcion+" de fuerza :(",
			"MIMS", JOptionPane.PLAIN_MESSAGE);
    }

	/*
    Método:         dameAlimento
    Inputs:         int
    Funcionalidad:  Intercambia la cantidad de dinero ingresada por la cantidad de comida correspondiente
    */
    @Override
    public void dameAlimento(int dinero){
        int proporcion = (int)(dinero/4);
        this.dinero -= dinero;
		this.comida += proporcion*6;
		JOptionPane.showMessageDialog(null, 
			this.nombre + ": Que cara la comida, ta cuatica la inflacion.\n"+this.nombre+": gaste "+dinero+" monedas y obtuve "+(proporcion*6)+" de comida.", 
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
		JOptionPane.showMessageDialog(null, 
			this.nombre+": zzz...\n"+this.nombre+": Genial! Recupere "+sleep+" de energia.",
			"MIMS",JOptionPane.PLAIN_MESSAGE);
		if(this.energia>=100){
			JOptionPane.showMessageDialog(null, this.nombre+": Wooooh!! Energia Maxima!! (100)", "MIMS", JOptionPane.PLAIN_MESSAGE);
			this.energia = 100;
		}
	}
	
	//setters
	public void setEstudios(int estudios){
		this.estudios = estudios;
	}

	public void setTrabajo(Trabajo trabajo){
		this.trabajo = trabajo;
	}

	//getters
	public int getEstudios(){
		return this.estudios;
	}
	
	public Trabajo getTrabajo(){
		return this.trabajo;
	}

	/*
	Método: estudiar
	Inputs: int
	Funcionalidad: Le da un estudio a un adulto habilitando que pueda trabajar
	*/
	public void estudiar(int estudio){//falta asignar trabajo
		//asignamos el estudio
		String mensaje = "";
		if(estudio==1){//Cientificx
			setEstudios(estudio);
			if(this.getSexo() == "Hombre")
				mensaje += this.nombre + ": Genial! Ahora soy cientifico.\n";
			else
			mensaje += this.nombre + ": Genial! Ahora soy cientifica.\n";
			Cientifico new_trabajo = new Cientifico();
			setTrabajo(new_trabajo);
		}
		else if(estudio==2){//humansita
			setEstudios(estudio);
			mensaje += this.nombre + ": Genial! Ahora soy humanista.\n";
			Humanista new_trabajo = new Humanista();
			setTrabajo(new_trabajo);
		}
		else if(estudio==3){//artista
			setEstudios(estudio);
			mensaje += this.nombre + ": Genial! Ahora soy artista.\n";
			Artista new_trabajo = new Artista();
			setTrabajo(new_trabajo);
		}
		else if(estudio==4){//deportista
			setEstudios(estudio);
			mensaje += this.nombre + ": Genial! Ahora soy deportista.\n";
			Deportista new_trabajo = new Deportista();
			setTrabajo(new_trabajo);
		}
		//gasto energético
		this.energia -= 50;
		if(this.energia<=0){
			JOptionPane.showMessageDialog(null, this.nombre+": Oh no! Me he quedado sin energia! (0)", "MIMS", JOptionPane.PLAIN_MESSAGE);
			this.energia = 0;
		}
		mensaje += this.nombre + ": He gastado 50 de energia estudiando.";
		JOptionPane.showMessageDialog(null, mensaje, "MIMS", JOptionPane.PLAIN_MESSAGE);
	}
}
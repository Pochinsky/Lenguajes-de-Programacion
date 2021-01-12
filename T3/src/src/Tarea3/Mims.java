package tarea3;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mims {
	//para contar las 4 acciones que envejecen
	public int contador_acciones;

	//para implementar el menú
	public Menu menu;

	//atributos
	public ArrayList<Personaje> personajes;
	public ArrayList<Familia> familias;

	/*
	Constructor:	Mims
	Input:			No reciba
	Funcionalidad:	Inicializa los atributos de la clase y 4 adultos iniciales almacenandolos en el
					atributo personajes
	*/
	public Mims(){
		Adulto a1, a2, a3, a4;
		a1 = new Adulto("Mario","Hombre",0,18,100,30,0);
		a2 = new Adulto("Peach","Mujer",0,18,100,30,0);
		a3 = new Adulto("Luigi","Hombre",0,18,100,30,0);
		a4 = new Adulto("Daisy","Mujer",0,18,100,30,0);
		personajes = new ArrayList<Personaje>();
		familias = new ArrayList<Familia>();
		this.personajes.add(a1);
		this.personajes.add(a2);
		this.personajes.add(a3);
		this.personajes.add(a4);
		this.menu = new Menu();
		this.contador_acciones = 0;
	}

	//getters
	public ArrayList<Personaje> getPersonajes(){
		return this.personajes;
	}

	/*
	Método: 		agregarAdulto
	Inputs: 		No recibe
	Funcionalidad:	Agrega un adulto al atributo personajes
	*/
	public void agregarAdulto(){
		Adulto nuevo_adulto = null;
		String nombre = menu.nombreAdulto();
		int sexo = menu.sexoAdulto();
		int edad = menu.edadAdulto();

		if(sexo==1){
			nuevo_adulto = new Adulto(nombre, "Hombre", 0, edad, 100, 30, 0);
		}
		else if(sexo==2){
			nuevo_adulto = new Adulto(nombre, "Mujer", 0, edad, 100, 30, 0);
		}
		personajes.add(nuevo_adulto);
		JOptionPane.showMessageDialog(null,
		"Se ha creado a "+this.personajes.get(this.personajes.size()-1).getNombre()+"!", "MIMS", JOptionPane.PLAIN_MESSAGE);
	}

	/*
	Método: 		casarse
	Inputs:			No recibe
	Funcionalidad:	crea una familia entre 2 adultos elegidos por el usuario
	*/
	public void casarse(){
		Adulto adulto1,adulto2;
		int adulto_elegido1,adulto_elegido2;
		ArrayList<Integer> indices = new ArrayList<>();
		String mensaje1 = "";
		String mensaje2 = "";

		mensaje1 += "\n~~~~~ Realizar Casorio ~~~~~\n";
		mensaje2 += "\n~~~~~ Realizar Casorio ~~~~~\n";
		for(int i=0,j=1;i<this.personajes.size(); i++){
			if(this.personajes.get(i).getEdad()>=18){
				mensaje1 += j+". "+this.personajes.get(i).getNombre()+".\n";
				mensaje2 += j+". "+this.personajes.get(i).getNombre()+".\n";
				indices.add(i);
				j++;
			}
		}
		mensaje1 += "Escriba el numero del adultx 1: ";
		adulto_elegido1 = Integer.parseInt(JOptionPane.showInputDialog(null,
			mensaje1,"MIMS",JOptionPane.PLAIN_MESSAGE));
		mensaje2 += "Escriba el numero del adultx 2: ";
		adulto_elegido2 = Integer.parseInt(JOptionPane.showInputDialog(null,
			mensaje2,"MIMS",JOptionPane.PLAIN_MESSAGE));
		adulto1 = (Adulto)this.personajes.get(indices.get(adulto_elegido1-1));
		adulto2 = (Adulto)this.personajes.get(indices.get(adulto_elegido2-1));

		Familia nueva_familia = new Familia(adulto1,adulto2);
		this.familias.add(nueva_familia);
		this.menu.casorio(adulto1,adulto2);
	}

	/*
	Método: 		personaje
	Inputs: 		Personaje, Mims
	Funcionalidad:	administra el menu general al seleccionar un personaje en la opcion elegir personaje del menu principal
	*/
	public static boolean personaje(Personaje personaje_actual, Mims juego){
		boolean flag1=true;
		if(personaje_actual.getEdad()>=18){//el personaje es adulto
			Adulto adulto = (Adulto) personaje_actual;
			int accion = juego.menu.menuPersonaje(adulto);
			if(accion==1){//comer
				if(juego.menu.comerPersonaje(adulto)==false){
					flag1 = false;
				}
				if(adulto.getFuerza()<=0){
					JOptionPane.showMessageDialog(null, "La fuerza de "+adulto.getNombre()+" ha llegado a 0... "+adulto.getNombre()+" ha muerto :(\nComo estas de luto, te llevaremos al menu principal.","MIMS",JOptionPane.PLAIN_MESSAGE);
					juego.morirPersonaje(adulto);
					flag1 = false;
				}
			}
			else if(accion==2){//dormir
				if(juego.menu.dormirPersonaje(adulto)==false){
					flag1 = false;
				}
				juego.contador_acciones++;
				if(juego.contador_acciones!=0 & juego.contador_acciones%4==0){
					juego.envejecerPersonajes();
				}
				if(adulto.getEdad()==80){
					JOptionPane.showMessageDialog(null, "Como estas de luto, te llevaremos al menú principal al Menu Principal!");
					flag1 = false;
				}
				if(juego.disminuirFuerza()){
					JOptionPane.showMessageDialog(null, "Como estas de luto, te llevaremos al Menu Principal");
					flag1 = false;
				}
			}
			else if(accion==3){//dame alimento
				if(juego.menu.dameAlimentoPersonaje(adulto)==false){
					flag1 = false;
				}
			}
			else if(accion==4){//Estudiar o trabajar
				if(adulto.getEstudios()==0){
					if(juego.menu.menuEstudiar(adulto)==false){
						flag1 =  false;
					}
				}
				else{
					if(juego.menu.menuTrabajar(adulto)==false){
						flag1 = false;
					}
				}
				juego.contador_acciones++;
				if(juego.contador_acciones!=0 & juego.contador_acciones%4==0){
					juego.envejecerPersonajes();
				}
				if(adulto.getEdad()==80){
					JOptionPane.showMessageDialog(null, "No puede seguir realizando acciones con "+adulto.getNombre()+" despues de haber muerto :c\nLo enviaremos al Menu Principal!");
					flag1 = false;
				}
				if(juego.disminuirFuerza()){
					JOptionPane.showMessageDialog(null, "Como estas de luto, te llevaremos al Menu Principal");
					flag1 = false;
				}
			}
			else if(accion==5){//mostrar estado
				juego.menu.mostrarEstado(adulto);
				String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con "
            	+adulto.getNombre()+"?","MIMS~>Elegir Personaje~>"+adulto.getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        		if(option=="No")
            		flag1 = false;
			}
			else if(accion==6){//menu principal
				flag1 =  false;
			}
		}
		else{//el personaje es cabro chico
			CabroChico cabroChico = (CabroChico) personaje_actual;
			int accion = juego.menu.menuPersonaje(cabroChico);
			if(accion==1){//comer
				if(juego.menu.comerPersonaje(cabroChico)==false){
					flag1 = false;
				}
				if(cabroChico.getFuerza()<=0){
					JOptionPane.showMessageDialog(null, "La fuerza de "+cabroChico.getNombre()+" ha llegado a 0... "+cabroChico.getNombre()+" ha muerto :(","MIMS",JOptionPane.PLAIN_MESSAGE);
					juego.morirPersonaje(cabroChico);
					flag1 = false;
				}
			}
			else if(accion==2){//dormir
				if(juego.menu.dormirPersonaje(cabroChico)==false){
					flag1 = false;
				}
				juego.contador_acciones++;
				if(juego.contador_acciones!=0 & juego.contador_acciones%4==0){
					juego.envejecerPersonajes();
				}
				if(cabroChico.getEdad()==18){
					JOptionPane.showMessageDialog(null, "No puede seguir realizando acciones con "+cabroChico.getNombre()+" despues de haber crecido!\nLo enviaremos al Menu Principal!");
					flag1 = false;
				}
				if(juego.disminuirFuerza()){
					JOptionPane.showMessageDialog(null, "Como estas de luto, te llevaremos al Menu Principal");
					flag1 = false;
				}
			}
			else if(accion==3){//dame alimento
				if(juego.menu.dameAlimentoPersonaje(cabroChico)==false){
					flag1 = false;
				}
			}
			else if(accion==4){//jugar
				if(juego.menu.menuJugar(cabroChico)==false){
					flag1 = false;
				}
				juego.contador_acciones++;
				if(juego.contador_acciones!=0 & juego.contador_acciones%4==0){
					juego.envejecerPersonajes();
				}
				if(cabroChico.getEdad()==18){
					JOptionPane.showMessageDialog(null, "No puede seguir realizando acciones con "+cabroChico.getNombre()+" despues de haber crecido!\nLo enviaremos al Menu Principal!");
					flag1 = false;
				}
				if(juego.disminuirFuerza()){
					JOptionPane.showMessageDialog(null, "Como estas de luto, te llevaremos al Menu Principal");
					flag1 = false;
				}
			}
			else if(accion==5){//estado
				juego.menu.mostrarEstado(cabroChico);
				String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con "
            	+cabroChico.getNombre()+"?","MIMS~>Elegir Personaje~>"+cabroChico.getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        		if(option=="No")
            		flag1 = false;
			}
			else if(accion==6){//menu principal
				flag1 = false;
			}
		}
		return flag1;
	}

	/*
	Método 			familia
	Inputs: 		Familia, Mims
	Funcionalidad:	administra el menu general al seleciconar una familia en la opcion elegir familia
	*/
	public static boolean familia(Familia familia_actual, Mims juego){
		boolean flag = true;
		int accion = juego.menu.menuFamilia(familia_actual);
		if(accion==1){//alimentar hijos
			if(juego.menu.menuAlimentarHijos(familia_actual)==false){
				return false;
			}
			juego.contador_acciones++;
			if(juego.contador_acciones!=0 & juego.contador_acciones%4==0){
				juego.envejecerPersonajes();
			}
			if(juego.disminuirFuerza()){
				JOptionPane.showMessageDialog(null, "Como estas de luto, te llevaremos al Menu Principal");
				flag = false;
			}
		}
		else if(accion==2){//hacer hijo
			if(juego.menu.menuHacerHijo(familia_actual,juego)==false){
				flag = false;
			}
			juego.contador_acciones++;
			if(juego.contador_acciones!=0 & juego.contador_acciones%4==0){
				juego.envejecerPersonajes();
			}
			if(juego.disminuirFuerza()){
				JOptionPane.showMessageDialog(null, "Como estas de luto, te llevaremos al Menu Principal");
				flag = false;
			}
		}
		else if(accion==3){//acostar hijo
			if(juego.menu.menuAcostarHijos(familia_actual)==false){
				flag = false;
			}
			if(juego.disminuirFuerza()){
				JOptionPane.showMessageDialog(null, "Como estas de luto, te llevaremos al Menu Principal");
				flag = false;
			}
		}
		else if(accion==4){//estados
			if(juego.menu.menuEstadosFamilia(familia_actual)==false){
				flag = false;
			}
		}
		else if(accion==5){//volver al menu principal
			flag = false;
		}
		return flag;
	}

	/*
	Método: 		legalidad
	Inputs: 		CabroChico
	Funcionalidad:	convierte un CabroChico a Adulto cuando este cumple 18 años
	*/
	public void legalidad(int i){
		String nombre = this.personajes.get(i).getNombre();
		String sexo = this.personajes.get(i).getSexo();
		int dinero = this.personajes.get(i).getDinero();
		int edad = this.personajes.get(i).getEdad();
		int energia = this.personajes.get(i).getEnergia();
		int fuerza = this.personajes.get(i).getFuerza();
		int comida = this.personajes.get(i).getComida();
		Adulto adulto = new Adulto(nombre,sexo,dinero,edad,energia,fuerza,comida);
		this.personajes.set(i,adulto);
	}

	/*
	Método: 		borrarFamilia
	Inputs: 		Familia
	Funcionalidad:	elimina una familia del juego
	*/
	public void borrarFamilia(Familia familia){
		if(this.familias.indexOf(familia)!=-1)
			this.familias.remove(familia);
	}

	/*
	Método: 		morirPersonaje
	Inputs: 		Personaje
	Funcionalidad:	borrar al Personaje de la existencia :c
	*/
	public boolean morirPersonaje(Personaje personaje){
		boolean flag = false;
		ArrayList<Familia> aux = new ArrayList<Familia>();
		ArrayList<CabroChico> aux_hijos = new ArrayList<CabroChico>();
		if(personaje.getEdad()>=18){
			if(this.personajes.indexOf(personaje)!=-1){
				this.personajes.remove(personaje);
				flag = true;
			}
			for(int i=0; i<this.familias.size(); i++){
				if(this.familias.get(i).borrarAdulto((Adulto)personaje)){
					aux.add(this.familias.get(i));
				}
			}
		}
		else{
			if(this.personajes.indexOf(personaje)!=-1){
				this.personajes.remove(personaje);
				flag = true;
			}
			for(int i=0; i<this.familias.size(); i++){
				this.familias.get(i).borrarCabroChico((CabroChico)personaje);
			}
		}
		if(aux.size()!=0){
			for(int i=0; i<aux.size(); i++){
				this.borrarFamilia(aux.get(i));
			}
		}
		return flag;
	}

	/*
	Método: 		envejecerPersonajes
	Inputs: 		No recibe
	Funcionalidad:	aumenta la edad de todos los personajes en un año
	*/
	public void envejecerPersonajes(){
		int edad_actual;
		ArrayList<Adulto> aux = new ArrayList<Adulto>();
		for(int i=0; i<this.personajes.size(); i++){
			edad_actual = this.personajes.get(i).getEdad();
			this.personajes.get(i).setEdad(edad_actual+1);
			if(this.personajes.get(i).getEdad()==18){
				JOptionPane.showMessageDialog(null, 
				"Felices 18!! "+this.personajes.get(i).getNombre()+" ya no es cabro chico, ahora es adulto!", "MIMS", JOptionPane.PLAIN_MESSAGE);
				for(int j=0; j<this.familias.size(); j++){
					this.familias.get(j).borrarCabroChico((CabroChico)this.personajes.get(i));
				}
				this.legalidad(i);
			}
			else if(this.personajes.get(i).getEdad()==80){
				if(this.personajes.get(i).getNombre().equals("Rosalina")){
					JOptionPane.showMessageDialog(null, "Que raro... Rosalina cumplio 80 anios y no ha muerto...");
				}
				else{
					aux.add((Adulto)this.personajes.get(i));
				}
			}
		}
		if(aux.size()!=0){
			for(int i=0; i<aux.size(); i++){
				this.morirPersonaje(aux.get(i));
				JOptionPane.showMessageDialog(null,"R.I.P: "+aux.get(i).getNombre()+" ha muerto :c.","MIMS",JOptionPane.PLAIN_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(null, "Todos los personajes envejecieron 1 anio!", "MIMS", JOptionPane.PLAIN_MESSAGE);
	}

	/*
	Método: 		disminuirFuerza
	Inputs: 		No recibe
	Funcionalidad:	Disminute la fuerza de todos los personajes en 2
	*/
	public boolean disminuirFuerza(){
		boolean flag = false;
		ArrayList<Personaje> borrar = new ArrayList<Personaje>();
		for(int i=0; i<this.personajes.size(); i++){
			int fuerza_actual = this.personajes.get(i).getFuerza();
			this.personajes.get(i).setFuerza(fuerza_actual-2);
			if(this.personajes.get(i).getFuerza()<=0){
				JOptionPane.showMessageDialog(null, "La fuerza de "+this.personajes.get(i).getNombre()+" ha llegado a 0... "+this.personajes.get(i).getNombre()+" ha muerto :(","MIMS",JOptionPane.PLAIN_MESSAGE);
				borrar.add(this.personajes.get(i));
			}
		}
		for(int i=0; i<borrar.size(); i++){
			flag = true;
			this.morirPersonaje(borrar.get(i));
		}
		JOptionPane.showMessageDialog(null, "La fuerza de todos lxs personajes ha disminuido en 2!","MIMS",JOptionPane.PLAIN_MESSAGE);
		return flag;
	}

	//main
	public static void main(String[] args){
		Mims juego = new Mims();
		boolean flag = true;

		while(flag){//se ejecuta mientras no se salga de MIMS
			int eleccion = juego.menu.menuInicial(juego);
			if(juego.familias.size() == 0){//no considera familias en el menu
				if(eleccion == 1){//elegir personaje
					int indice_personaje = juego.menu.elegirPersonaje(juego);
					boolean flag1 = true;
					int accion;
					while(flag1){//se ejecuta mientras se quieran hacer acciones en el adulto
						Personaje personaje_actual= (Personaje) juego.personajes.get(indice_personaje);
						flag1 = personaje(personaje_actual,juego);
					}
				}
				if(eleccion == 2){//agregar adulto
					juego.agregarAdulto();
				}
				else if(eleccion == 3){//realizar casorio
					juego.casarse();
					juego.contador_acciones++;
					if(juego.contador_acciones!=0 & juego.contador_acciones%4==0){
						juego.envejecerPersonajes();
					}
				}
				else if(eleccion == 4){
					flag = false;
				}
			}
			else{//se considera familias en el menu
				if(eleccion==1){//elegir personaje
					int indice_personaje = juego.menu.elegirPersonaje(juego);
					boolean flag1 = true;
					Personaje personaje_actual = juego.personajes.get(indice_personaje);
					while(flag1){//se ejecuta mientras se quieran hacer acciones en el personaje
						flag1 = personaje(personaje_actual,juego);
					}
				}
				else if(eleccion==2){//elegir familia
					int indice = juego.menu.elegirFamilia(juego)-1;
					boolean flag2 = true;
					Familia familia_actual = juego.familias.get(indice);
					while(flag2){
						flag2 = familia(familia_actual,juego);
					}

				}
				else if(eleccion==3){//agregar adulto
					juego.agregarAdulto();
				}
				else if(eleccion==4){//realizar casorio
					juego.casarse();
					juego.contador_acciones++;
					if(juego.contador_acciones!=0 & juego.contador_acciones%4==0){
						juego.envejecerPersonajes();
					}
				}
				else if(eleccion==5){
					flag = false;
				}
			}
		}
	}
}



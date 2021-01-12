package tarea3;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
    /*
    Método:         nombreAdulto
    Inputs:         No recibe
    Funcionalidad:  Pide por pantalla el nombre a asignar al adulto que se está agregando
    */
    public String nombreAdulto(){
        String nombre = (JOptionPane.showInputDialog(null, 
            "Cual sera el nombre?","MIMS",JOptionPane.PLAIN_MESSAGE)).toString();
        return nombre;
    }

    /*
    Método:         sexoAdulto
    Inputs:         No recibe
    Funcionalidad:  Pide por pantalla el sexo a asignar al adulto que se está agregando
    */
    public int sexoAdulto(){
        int sexo = Integer.parseInt(JOptionPane.showInputDialog(null, 
            "Cual sera el sexo?\n1. Hombre\n2. Mujer","MIMS",JOptionPane.PLAIN_MESSAGE));
        return sexo;
    }

    /*
    Método:         edadAdulto
    Inputs:         No recibe
    Funcionalidad:  Pide por pantalla la edad a asignar al adulto que se está agregando
    */
    public int edadAdulto(){
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cual sera la edad?","MIMS",JOptionPane.PLAIN_MESSAGE));
        return edad;
    }

    /*
    Método:         casorio
    Inputs:         Adulto, Adulto
    Funcionalidad:  muestra los dialogos del matrimonio entre adulto1 y adulto2
    */
    public void casorio(Adulto adulto1, Adulto adulto2){
        String mensaje = "";
        if(adulto2.getSexo() == "Hombre"){
            mensaje += "Oficial Civil: "+adulto1.getNombre()+", ¿acepta a "+adulto2.getNombre()+" como su esposo?\n";
            mensaje += adulto1.getNombre()+": Si! Acepto!\n";
        }
        else{
            mensaje += "Oficial Civil: "+adulto1.getNombre()+", ¿acepta a "+adulto2.getNombre()+" como su esposa?\n";
            mensaje += adulto1.getNombre()+": Si! Acepto!\n";
        }
        if(adulto1.getSexo() == "Hombre"){
            mensaje += "Oficial Civil: "+adulto2.getNombre()+", ¿acepta a "+adulto1.getNombre()+" como su esposo?\n";
            mensaje += adulto2.getNombre()+": Si! Acepto!\n";
        }
        else{
            mensaje += "Oficial Civil: "+adulto2.getNombre()+", ¿acepta a "+adulto1.getNombre()+" como su esposa?\n";
            mensaje += adulto2.getNombre()+": Si! Acepto!\n";
        }
        mensaje += "Oficial Civil: Ya pueden besarse.\n";
        mensaje += "*"+adulto1.getNombre()+" y "+adulto2.getNombre()+" se besan*\n";
        mensaje += "*Aplausos*";
        JOptionPane.showMessageDialog(null, 
        mensaje, "MIMS", JOptionPane.PLAIN_MESSAGE);
    }

    /*
    Método:         menuInicial
    Inputs:         Mims
    Funcionalidad:  Muestra el menu inicial al ejecutar el programa
    */
    public int menuInicial(Mims juego){
        String num_personajes = Integer.toString(juego.personajes.size());
        String num_familias = Integer.toString(juego.familias.size());
        String mensaje_personajes = "Elegir personaje ("+num_personajes+" disponibles)";
        String mensaje_familias = "Elegir Familia ("+num_familias+" disponibles)";
        if(juego.familias.size() != 0){
            String option = (JOptionPane.showInputDialog(
                null, "Elige una opcion para interactuar con el mundo de MIMS!", "MIMS", 
                JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion",mensaje_personajes,mensaje_familias,"Agregar Adulto","Realizar Casorio","Salir de MIMS"},"Elige una opcion")).toString();
            if(option==mensaje_personajes){
                return 1;
            }
            else if(option==mensaje_familias){
                return 2;
            }
            else if(option=="Agregar Adulto"){
                return 3;
            }
            else if(option=="Realizar Casorio"){
                return 4;
            }
            else if(option=="Salir de MIMS"){
                return 5;
            }
        }
        else{
            String option = (JOptionPane.showInputDialog(
                null, "Elige una opcion para interactuar con el mundo de MIMS!", "MIMS", 
                JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion",mensaje_personajes,"Agregar Adulto","Realizar Casorio","Salir de MIMS"},"Elige una opcion")).toString();
            System.out.println(option);
            if(option==mensaje_personajes){
                return 1;
            }
            else if(option=="Agregar Adulto"){
                return 2;
            }
            else if(option=="Realizar Casorio"){
                return 3;
            }
            else if(option=="Salir de MIMS"){
                return 4;
            }
        }
        return 0;
    }

    /*
    Método:         elegirPersonaje
    Inputs:         Mims
    Funcionalidad:  da al usuario a elegir entre uno de los personajes disponibles (tanto Adulto como
                    CabroChico) para luego realizar acciones sobre el
    */
    public int elegirPersonaje(Mims juego){
        String[] nombres = new String[juego.personajes.size()+1];
        nombres[0] = "Elegir opcion";
        for(int i=1;i<=juego.personajes.size();i++){
            nombres[i] = juego.personajes.get(i-1).getNombre();
        }
        
        String option = (JOptionPane.showInputDialog(
                null, "Elige un personaje.", "MIMS~>Elegir Personaje", 
                JOptionPane.PLAIN_MESSAGE,null,nombres,"Elige una opcion")).toString();        

        for(int i=1; i<juego.personajes.size(); i++){
            if(option==juego.personajes.get(i).getNombre()){
                return i;
            }
        }
        return 0;
    }

    /*
    Método:         menuPersonaje
    Inputs:         Personaje
    Funcionalidad:  Muestra las acciones del personaje ingresado y da al usuario a elegir una.
    */
    public int menuPersonaje(Personaje personaje){
        String str;
        if(personaje.getEdad()>=18){//menu para adulto
            Adulto adulto = (Adulto) personaje;
            if(adulto.getEstudios()==0){
                str = (JOptionPane.showInputDialog(
                    null, "Elige un accion.", "MIMS~>"+adulto.getNombre(), 
                    JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                    "Elige una opcion","Comer","Dormir","Dame Alimento","Estudiar","Mostrar Estado","Volver al Menu Principal"},"Elige una opcion")).toString();
                if(str=="Comer"){
                    return 1;
                }
                else if(str=="Dormir"){
                    return 2;
                }
                else if(str=="Dame Alimento"){
                    return 3;
                }
                else if(str=="Estudiar"){
                    return 4;
                }
                else if(str=="Mostrar Estado"){
                    return 5;
                }
                else if(str=="Volver al Menu Principal"){
                    return 6;
                }
            }
            else{
                str = (JOptionPane.showInputDialog(
                    null, "Elige un accion.", "MIMS~>"+adulto.getNombre(), 
                    JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                    "Elige una opcion","Comer","Dormir","Dame Alimento","Trabajar","Mostrar Estado","Volver al Menu Principal"},"Elige una opcion")).toString();
                if(str=="Comer"){
                    return 1;
                }
                else if(str=="Dormir"){
                    return 2;
                }
                else if(str=="Dame Alimento"){
                    return 3;
                }
                else if(str=="Trabajar"){
                    return 4;
                }
                else if(str=="Mostrar Estado"){
                    return 5;
                }
                else if(str=="Volver al Menu Principal"){
                    return 6;
                }
            }
        }
        else{//menu para cabro chico
            CabroChico cabroChico = (CabroChico) personaje;
            str = (JOptionPane.showInputDialog(
                    null, "Elige un accion.", "MIMS~>"+cabroChico.getNombre(), 
                    JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                    "Elige una opcion","Comer","Dormir","Dame Alimento","Jugar","Mostrar Estado","Volver al Menu Principal"},"Elige una opcion")).toString();
            if(str=="Comer"){
                return 1;
            }
            else if(str=="Dormir"){
                return 2;
            }
            else if(str=="Dame Alimento"){
                return 3;
            }
            else if(str=="Jugar"){
                return 4;
            }
            else if(str=="Mostrar Estado"){
                return 5;
            }
            else if(str=="Volver al Menu Principal"){
                return 6;
            }
        }
        return 0;
    }
    

    /*
    Método:         comerPersonaje
    Inputs:         Presonaje
    Funcionalidad:  menu a mostrar cuando se elige la accion comer
    */
    public boolean comerPersonaje(Personaje personaje){
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                null, "Ingrese la cantidad de comida que desea comer. (Max: "+Integer.toString(personaje.getComida())+")","MIMS~>"+personaje.getNombre(),JOptionPane.PLAIN_MESSAGE));
        personaje.comer(cantidad);
        String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con "
            +personaje.getNombre()+"?","MIMS~>"+personaje.getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

    /*
    Método:         dormirPersonaje
    Inputs:         Personaje
    Funcionalidad:  menu a mostrar cuando se elige la accion dormir
    */
    public boolean dormirPersonaje(Personaje personaje){
        personaje.dormir();
        String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con "
            +personaje.getNombre()+"?","MIMS~>"+personaje.getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

    /*
    Método:         darAlimentoPersonaje
    Inputs:         Personaje
    Funcionalidad:  menu a mostrar cuando se elige la accion dameAlimento
    */
    public boolean dameAlimentoPersonaje(Personaje personaje){
        int dinero = Integer.parseInt(JOptionPane.showInputDialog(
            null, "Ingrese la cantidad de dinero que desea gastar. (Max: "+Integer.toString(personaje.getDinero())+")","MIMS~>"+personaje.getNombre(),JOptionPane.PLAIN_MESSAGE));
        personaje.dameAlimento(dinero);
        String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con "
            +personaje.getNombre()+"?","MIMS~>Elegir Personaje~>"+personaje.getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

    /*
    Metodo:         menuEstudiar
    Inputs:         Adulto
    Funcionalidad:  menu a mostrar cuando se elige la accion estudiar
    */
    public boolean menuEstudiar(Adulto adulto){
        String opcion = (JOptionPane.showInputDialog(
            null, "Ingrese el area que desea estudiar.","MIMS~>"+adulto.getNombre(),JOptionPane.PLAIN_MESSAGE,null,
            new Object[] {"Elige una opcion","Cientifico","Humanista","Artista","Deportista"},"Elige una opcion")).toString();
        if(opcion=="Cientifico"){
            adulto.estudiar(1);
        }
        else if(opcion=="Humanista"){
            adulto.estudiar(2);
        }
        else if(opcion=="Artista"){
            adulto.estudiar(3);
        }
        else if(opcion=="Deportista"){
            adulto.estudiar(4);
        }
        String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con "
            +adulto.getNombre()+"?","MIMS~>"+adulto.getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

    /*
    Método:         menuTrabajar
    Inputs:         Adulto
    Funcionalidad:  menu a mostrar cuando se elige la accion trabajar
    */
    public boolean menuTrabajar(Adulto adulto){
        int h = Integer.parseInt(JOptionPane.showInputDialog(null, 
            "Ingrese las horas que desea trabajar.","MIMS",JOptionPane.PLAIN_MESSAGE));
        adulto.getTrabajo().trabajar(adulto,h);
        String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con "
            +adulto.getNombre()+"?","MIMS~>"+adulto.getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

    /*
    Método:         mostrarEstado
    Inputs:         Personaje
    Funcionalidad:  muestra los atributos del personaje
    */
    public void mostrarEstado(Personaje personaje){
        String mensaje = "";
        mensaje += "\n~~~~~ Estado de "+personaje.getNombre()+" ~~~~~\n";
        mensaje += "Nombre del personaje: "+personaje.getNombre()+".\n";
        mensaje += "Sexo del personaje: "+personaje.getSexo()+".\n";
        mensaje += "Edad: ";
        if(personaje.getEdad()<18){
            mensaje += personaje.getEdad()+" (Cabro Chico).\n";
            mensaje += "Dinero: "+personaje.getDinero()+" monedas.\n";
            mensaje += "Energia: "+personaje.getEnergia()+".\n";
            mensaje += "Fuerza: "+personaje.getFuerza()+".\n";
            mensaje += "Comida: "+personaje.getComida()+".\n";
        }
        else{
            mensaje += personaje.getEdad()+" (Adulto).\n";
            mensaje += "Dinero: "+personaje.getDinero()+" monedas.\n";
            mensaje += "Energia: "+personaje.getEnergia()+".\n";
            mensaje += "Fuerza: "+personaje.getFuerza()+".\n";
            mensaje += "Comida: "+personaje.getComida()+".\n";
        }
        if(personaje.getEdad()>=18){
            Adulto adulto = (Adulto) personaje;
            mensaje += "Estudios: ";
            if(adulto.getEstudios()==0)
                mensaje += adulto.getNombre()+" no tiene estudios.";
            else if(adulto.getEstudios()==1)
                mensaje += "Cientifico.";
            else if(adulto.getEstudios()==2)
                mensaje += "Humanista.";
            else if(adulto.getEstudios()==3)
                mensaje += "Artista.";
            else if(adulto.getEstudios()==4)
                mensaje += "Deportista.";
        }
        JOptionPane.showMessageDialog(null,
            mensaje, "MIMS", JOptionPane.PLAIN_MESSAGE);
    }

    /*
    Método:         menuJugar
    Inputs:         CabroChico
    Funcionalidad:  menu a mostrar cuando se elige la accion jugar
    */
    public boolean menuJugar(CabroChico cabroChico){
        cabroChico.jugar();
        String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con "
            +cabroChico.getNombre()+"?","MIMS~>Elegir Personaje~>"+cabroChico.getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

    /*
    Método:         elegirFamilia
    Inputs:         Mims
    Funcionalidad:  muestra las familias disponibles para que el usuario utilice una
    */
    public int elegirFamilia(Mims juego){
        int opcion;
        String mensaje = "";

        mensaje += "\n~~~~~ Elegir Familia ~~~~~\n";
        for(int i=0; i<juego.familias.size(); i++){
            int n = i + 1;
            mensaje += n+". \tMatrimonio: "+juego.familias.get(i).getAdulto1().getNombre()+" - "+juego.familias.get(i).getAdulto2().getNombre()+".\n";
            if(juego.familias.get(i).getHijos().size()==0)
                mensaje += "   \t0 hijos.\n";
            else{
                mensaje += "   \tHijos: ";
                for(int j=0; j<juego.familias.get(i).getHijos().size()-1; j++)
                    mensaje += juego.familias.get(i).getHijos().get(j).getNombre()+" - ";
                mensaje += juego.familias.get(i).getHijos().get(juego.familias.get(i).getHijos().size()-1).getNombre()+".\n";
            }
        }
        mensaje += "Ingrese el numero de la familia a elegir: ";
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
            mensaje,"MIMS",JOptionPane.PLAIN_MESSAGE));
        return opcion;
    }

    /*
    Método:         menuFamilia
    Inputs:         Familia
    Funcionalidad:  muestra las acciones a realizar con la familia ingresada para que el usuario
                    escoja una
    */
    public int menuFamilia(Familia familia_actual){
        String opcion = (JOptionPane.showInputDialog(null, 
            "Seleccione una opcion.",
            "MIMS~>Familia de "+familia_actual.getAdulto1().getNombre()+" y "+familia_actual.getAdulto2().getNombre(),
            JOptionPane.PLAIN_MESSAGE,null,new Object[] {
            "Elegir opcion","Alimentar Hijos","Hacer Hijo","Acostar Hijos","Mostrar Estado de lxs Integrantes de la Familia","Volver al menu principal"},"Elegir opcion")).toString();
        if(opcion=="Alimentar Hijos"){
            return 1;
        }
        else if(opcion=="Hacer Hijo"){
            return 2;
        }
        else if(opcion=="Acostar Hijos"){
            return 3;
        }
        else if(opcion=="Mostrar Estado de lxs Integrantes de la Familia"){
            return 4;
        }
        else if(opcion=="Volver al menu principal"){
            return 5;
        }
        return 0;
    }

    /*
    Método:         menuAlimentarHijos
    Inputs:         Familia
    Funcionalidad:  menu a mostrar cuando se elige la accion alimentarHijos
    */
    public boolean menuAlimentarHijos(Familia familia){
        String adulto = (JOptionPane.showInputDialog(null,
            "Seleccione el nombre del adulto o adulta que alimentara a lxs hijxs.", "MIMS", JOptionPane.PLAIN_MESSAGE,null,new Object[]{
            "Elegir opcion",familia.getAdulto1().getNombre(),familia.getAdulto2().getNombre()},"Elegir opcion")).toString();
        int comida = Integer.parseInt(JOptionPane.showInputDialog(null, 
            "Ingrese la cantidad de comidada a darle a cada unx de lxs hijxs","MIMS",JOptionPane.PLAIN_MESSAGE));

        if(adulto==familia.getAdulto1().getNombre()){
            familia.alimentarHijos(familia.getAdulto1(),comida);
        }
        else if(adulto==familia.getAdulto2().getNombre()){
            familia.alimentarHijos(familia.getAdulto2(),comida);
        }

        String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con la familia de "
            +familia.getAdulto1().getNombre()+" y "+familia.getAdulto2().getNombre()+"?","MIMS~>"+"Familia "+familia.getAdulto1().getNombre()+" y "+familia.getAdulto2().getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

    /*
    Método:         menuHacerHijo
    Inputs:         Familia, Mims
    Funcionalidad:  menu a mostrar cuando se elige la accion hacerHijo
    */
    public boolean menuHacerHijo(Familia familia, Mims juego){
        if(familia.getAdulto1().getSexo()=="Hombre"&familia.getAdulto2().getSexo()=="Hombre"){
            familia.hacerHijo(1,juego);
        }
        else if(familia.getAdulto1().getSexo()=="Mujer"&familia.getAdulto2().getSexo()=="Mujer"){
            familia.hacerHijo(2,juego);
        }
        else{
            familia.hacerHijo(0,juego);
        }
        String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con la familia de "
            +familia.getAdulto1().getNombre()+" y "+familia.getAdulto2().getNombre()+"?","MIMS~>Familia de "+familia.getAdulto1().getNombre()+" y "+familia.getAdulto2().getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

    /*
    Método:         menuAcostarHijos
    Inputs:         Familia
    Funcionalidad:  menu a mostrar cuando se elige la accion acostarHijos
    */
    public boolean menuAcostarHijos(Familia familia){
        familia.acostarHijos();
        String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con la familia de "
            +familia.getAdulto1().getNombre()+" y "+familia.getAdulto2().getNombre()+"?","MIMS~>Familia de "+familia.getAdulto1().getNombre()+"  y "+familia.getAdulto2().getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

    /*
    Método:         menuEstadosFamilia
    Inputs:         Familia
    Funcionalidad:  muestra el estado de todos los integrantes de la familia
    */
    public boolean menuEstadosFamilia(Familia familia){
        this.mostrarEstado(familia.getAdulto1());
        this.mostrarEstado(familia.getAdulto2());
        for(int i=0; i<familia.getHijos().size(); i++)
            this.mostrarEstado(familia.getHijos().get(i));
            String option = (JOptionPane.showInputDialog(null, "Desea realizar otra accion con la familia de "
            +familia.getAdulto1().getNombre()+" y "+familia.getAdulto2().getNombre()+"?","MIMS~>Familia de "+familia.getAdulto1().getNombre()+" y "+familia.getAdulto2().getNombre(),JOptionPane.PLAIN_MESSAGE,null,new Object[] {
                "Elige una opcion","Si","No"},"Elige una opcion")).toString();
        if(option=="No")
            return false;
        else
            return true;
    }

}
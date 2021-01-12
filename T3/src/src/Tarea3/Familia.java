package tarea3;
import java.util.*;

import javax.swing.JOptionPane;

public class Familia {
    //atributos
    protected Adulto adulto1;
    protected Adulto adulto2;
    protected ArrayList<CabroChico> hijos;

    /*
    Constructor:    Familia
    Input:          Adulto, Adulto,
    Funcionalidad:  inicializa una familia y sus atributos
    */
    public Familia(Adulto adulto1, Adulto adulto2){
        this.adulto1 = adulto1;
        this.adulto2 = adulto2;
        hijos = new ArrayList<CabroChico>();
    }

    //getters
    public Adulto getAdulto1(){
        return this.adulto1;
    }

    public Adulto getAdulto2(){
        return adulto2;
    }

    public ArrayList<CabroChico> getHijos(){
        return this.hijos;
    }

    /*
    Método:         alimentarHijos
    Inputs:         Adulto, int
    Funcionalidad:  El adulto ingresado le da de su comida a sus hijos siempre y cuando tenga comida
    */
    public void alimentarHijos(Adulto adulto, int cantidad){
        if(hijos.size() == 0)
            JOptionPane.showMessageDialog(null, 
            adulto.getNombre() + ": Que hijos voy a alimentar si no tengo xd.","MIMS",JOptionPane.PLAIN_MESSAGE);
        else{
            for(int i=0; i<hijos.size(); i++){
                hijos.get(i).comer(cantidad);
                adulto.setComida(adulto.getComida()-cantidad);
                if(adulto.getComida() <= 0 && i == (hijos.size()-1)){
                    JOptionPane.showMessageDialog(null, 
                    adulto.getNombre() + ": Oh no! Me he quedado sin comida... Menos mal alcance a alimentar a todxs mis hijxs.","MIMS",JOptionPane.PLAIN_MESSAGE);
                    adulto.setComida(0);
                }
                else if(adulto.getComida() <= 0 && i < (hijos.size()-1)){
                    JOptionPane.showMessageDialog(null, 
                    adulto.getNombre() + ": Oh no! Me he quedado sin comida para alimentar al resto de mis hijxs :c.","MIMS",JOptionPane.PLAIN_MESSAGE);
                    adulto.setComida(0);
                    break;
                }
            }

        }
    }

    /*
    Método:         hacerHijo
    Inputs:         int, Mims
    Funcionalidad:  crea un hijo correspondiente a la pareja de adultos de la familia y la añade al
                    ArrayList hijos
    */
    public void hacerHijo(int flag, Mims juego){
        CabroChico nuevo_hijo = new CabroChico();
        String nombre;
        String mensaje = "";
        hijos.add(0,nuevo_hijo);
        mensaje += "\n~~~~~ Hacer Hijo ~~~~~\n";
        if(flag==1){//matrimonio hombre-hombre
            mensaje += this.adulto1.getNombre()+": Mi amor, adoptemos?\n";
            mensaje += this.adulto2.getNombre()+": *emocionado* Yaaa!\n";
            mensaje += "*el dia de la adopcion*\n";
            if(nuevo_hijo.getSexo()=="Hombre"){
                mensaje += "Funcionarix Registro Civil: Les hemos asignado un hombre.\n";
                mensaje += "Funcionarix Registro civil: ¿Cual sera el nombre?\n";
                mensaje += "Inserte nombre del hijo:";
                nombre = (JOptionPane.showInputDialog(null, mensaje,"MIMS",JOptionPane.PLAIN_MESSAGE)).toString();
                nuevo_hijo.setNombre(nombre);
                JOptionPane.showMessageDialog(null, "Funcionarix Registro Civil: Que bien! Ahora tienen un hijo llamado "+nuevo_hijo.getNombre(),"MIMS",JOptionPane.PLAIN_MESSAGE);
            }
            else{
                mensaje += "Funcionarix Registro Civil: Les hemos asignado una mujer.\n";
                mensaje += "Funcionarix Registro civil: ¿Cual sera el nombre?\n";
                mensaje += "Inserte nombre de la hija: ";
                nombre = (JOptionPane.showInputDialog(null, mensaje,"MIMS",JOptionPane.PLAIN_MESSAGE)).toString();
                nuevo_hijo.setNombre(nombre);
                JOptionPane.showMessageDialog(null, "Funcionarix Registro Civil: Que bien! Ahora tienen una hija llamada "+nuevo_hijo.getNombre(),"MIMS",JOptionPane.PLAIN_MESSAGE);
            }
        }
        else if(flag==2){//matrimonio mujer-mujer
            mensaje += this.adulto1.getNombre()+": Mi amor, adoptemos?\n";
            mensaje += this.adulto2.getNombre()+": *emocionada* Yaaa!\n";
            mensaje += "*el dia de la adopcion*\n";
            if(nuevo_hijo.getSexo()=="Hombre"){
                mensaje += "Funcionarix Registro Civil: Les hemos asignado un hombre.\n";
                mensaje += "Funcionarix Registro civil: ¿Cual sera el nombre?\n";
                mensaje += "Inserte nombre del hijo: ";
                nombre = (JOptionPane.showInputDialog(null, mensaje,"MIMS",JOptionPane.PLAIN_MESSAGE)).toString();
                nuevo_hijo.setNombre(nombre);
                JOptionPane.showMessageDialog(null, "Funcionarix Registro Civil: Que bien! Ahora tienen un hijo llamado "+nuevo_hijo.getNombre(),"MIMS",JOptionPane.PLAIN_MESSAGE);
            }
            else{
                mensaje += "Funcionarix Registro Civil: Les hemos asignado una mujer.\n";
                mensaje += "Funcionarix Registro civil: ¿Cual sera el nombre\n";
                mensaje += "Inserte nombre de la hija: ";
                nombre = (JOptionPane.showInputDialog(null, mensaje,"MIMS",JOptionPane.PLAIN_MESSAGE)).toString();
                nuevo_hijo.setNombre(nombre);
                JOptionPane.showMessageDialog(null, "Funcionarix Registro Civil: Que bien! Ahora tienen una hija llamada "+nuevo_hijo.getNombre(),"MIMS",JOptionPane.PLAIN_MESSAGE);
            }
        }
        else if(flag==0){//matrimonio hombre-mujer
            mensaje += this.adulto1.getNombre()+": Mi amor... Tengamos un hijo?\n";
            mensaje += this.adulto2.getNombre()+": *con voz coqueta* Ya!\n";
            mensaje += "*haciendo el sin respeto*\n";
            mensaje += "*9 meses mas tarde*\n";

            if(this.adulto1.getSexo()=="Mujer"){
                if(nuevo_hijo.getSexo()=="Hombre"){
                    mensaje += this.adulto1.getNombre()+": Mi amor! Nacio! Y es "+nuevo_hijo.getSexo()+".\n";
                    mensaje += this.adulto2.getNombre()+": Genial! Como lo llamaremos?\n";
                    mensaje += "Ingrese el nombre del hijo: ";
                    nombre = (JOptionPane.showInputDialog(null, mensaje,"MIMS",JOptionPane.PLAIN_MESSAGE)).toString();
                    nuevo_hijo.setNombre(nombre);
                    JOptionPane.showMessageDialog(null, this.adulto1.getNombre()+": "+nuevo_hijo.getNombre()+"!","MIMS",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    mensaje += this.adulto1.getNombre()+": Mi amor! Nacio! Y es "+nuevo_hijo.getSexo()+".\n";
                    mensaje += this.adulto2.getNombre()+": Genial! Como la llamaremos?\n";
                    mensaje += "Ingrese el nombre de la hija: ";
                    nombre = (JOptionPane.showInputDialog(null, mensaje,"MIMS",JOptionPane.PLAIN_MESSAGE)).toString();
                    nuevo_hijo.setNombre(nombre);
                    JOptionPane.showMessageDialog(null, this.adulto1.getNombre()+": "+nuevo_hijo.getNombre()+"!","MIMS",JOptionPane.PLAIN_MESSAGE);
                }
            }
            else{
                if(nuevo_hijo.getSexo()=="Hombre"){
                    mensaje += this.adulto2.getNombre()+": Mi amor! Nacio! Y es "+nuevo_hijo.getSexo()+".\n";
                    mensaje += this.adulto1.getNombre()+": Genial! Como lo llamaremos?\n";
                    mensaje += "Ingrese el nombre del hijo: ";
                    nombre = (JOptionPane.showInputDialog(null, mensaje,"MIMS",JOptionPane.PLAIN_MESSAGE)).toString();
                    nuevo_hijo.setNombre(nombre);
                    JOptionPane.showMessageDialog(null, this.adulto2.getNombre()+": "+nuevo_hijo.getNombre()+"!","MIMS",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    mensaje += this.adulto2.getNombre()+": Mi amor! Nacio! Y es "+nuevo_hijo.getSexo()+".\n";
                    mensaje += this.adulto1.getNombre()+": Genial! Como la llamaremos?\n";
                    mensaje += "Ingrese el nombre de la hija: ";
                    nombre = (JOptionPane.showInputDialog(null, mensaje,"MIMS",JOptionPane.PLAIN_MESSAGE)).toString();
                    nuevo_hijo.setNombre(nombre);
                    JOptionPane.showMessageDialog(null, this.adulto2.getNombre()+": "+nuevo_hijo.getNombre()+"!","MIMS",JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
        juego.personajes.add(nuevo_hijo);
    }

    /*
    Método:         acostarHijos
    Inputs:         No recibe
    Funcionalidad:  hace dormir a todos los hijos
    */
    public void acostarHijos(){
        if(hijos.size() == 0)
            JOptionPane.showMessageDialog(null, 
            this.adulto1.getNombre() + ": Mi amor no tenemos hijxs xd.","MIMS",JOptionPane.PLAIN_MESSAGE);
        else{
            for(int i=0; i<hijos.size(); i++)
                hijos.get(i).dormir();
                JOptionPane.showMessageDialog(null, 
                this.adulto1.getNombre() + ": Mi amor, están todxs nuestros hijxs durmiendo","MIMS",JOptionPane.PLAIN_MESSAGE);
        }
    }

    /*
    Método:         borrarCabroChico
    Inputs:         CabroChico
    Funcionalidad:  borra el CabroChico ingresado si es que está en el ArrayList hijos
    */
    public boolean borrarCabroChico(CabroChico cabroChico){
        if(this.hijos.indexOf(cabroChico)!=-1){
            this.hijos.remove(cabroChico);
            return true;
        }
        return false;
    }

    /*
    Método:         borrarAdulto
    Inputs:         Adulto
    Funcionalidad:  borra el Adulto ingresado si es Adulto1 o Adulto2
    */
    public boolean borrarAdulto(Adulto adulto){
        if(this.adulto1==adulto){
            this.adulto1 = null;
            return true;
        }
        else if(this.adulto2==adulto){
            this.adulto2 = null;
            return true;
        }
        return false;
    }

}
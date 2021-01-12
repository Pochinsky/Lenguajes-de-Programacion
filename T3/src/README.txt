Tomás Guttman Pogorzelski
201873525-6

1. Este MIMS acepta casorios homosexuales y asimismo la homoparentalidad

2. La opcion de ver el estado de un personaje se muestra en el menu del personaje, es decir, para ver el estado de un personaje, hay que seleccionar al personaje

3. Se implementa la clase Menu que contiene los mensajes por pantalla y diálogos de las acciones.

4. Se modificó la firma de los métodos de la clase abstracta Personaje de la siguiente manera:
    a. comer() recibe un int.
    b. dameAlimento() recibe un int.

5. Los adultos agregados por el usuario, también tendrán los valores por defecto que determina el enunciado.

6. el método getHijo() no recibe el nombre del hijo o hija debido a la forma en que se programo este MIMS.
   Recibe un entero con el que se determina el tipo de matrimonio de la familia correspondiente.

7. Se asume que las acciones de la clase Deportista, al igual que las acciones de las otras clases
   implementan la interfaz Trabajo, tampoco cuentan para el conteo de las 4 acciones para envejecer un año.

8. Se entiende que agregar adulto es una opción del juego, no de los personajes y por ende no cuenta para el conteo de 4 acciones para envejecer 1 año.

9. Se asume que si un CabroChico pasa a ser Adulto, aun así sus padres pueden alimentarlo y mandarlo a acostar.

10. Si muere un Adulto perteneciente a una Familia, también muere la Familia (hay un quiebre en ella, los personajes siguen existiendo pero no se relacionan entre si después de la muerte del familiar):c

11. La gran gran mayoría de opciones no consideran que se ingresen inputs invalidos.

12. Este MIMS contiene un easter egg!!
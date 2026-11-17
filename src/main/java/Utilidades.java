import java.util.Scanner;

/**
 * Clase con métodos de utilidad para la entrada de datos por teclado y el manejo de días de la semana.
 */
public class Utilidades {
    /**
     * Función que devuelve la linea introducida por el usuario
     * @param teclado
     * @param s Texto para mostrar al usuarios
     */
    public static String leerCadena(Scanner teclado, String s) {
       String texto;
       System.out.print(s);
       texto = teclado.nextLine();
       return texto;
    }

    /**
     * Función que lee un número introducido por teclado entre los
     * valores introducidos como parámetro (minimo y maximo),
     * comprobando que el numero introducido es un entero.
     * @param teclado
     * @param mensaje
     * @param minimo
     * @param maximo
     */
    public static int leerNumero(Scanner teclado, String mensaje, int minimo, int maximo) {
        int numero=0;
        while(!teclado.hasNextInt()){
            System.out.print(mensaje);
            teclado.next();
        }
        while(teclado.hasNextInt()){
            do{
                numero = teclado.nextInt();
                System.out.print(mensaje);
            }while((numero < minimo || numero > maximo) && teclado.hasNextInt());
        }

        return numero;
    }

    /**
     * Funcion que lee un día de la semana (L,M,X,J,V,S,D) y devuelve la posición del mismo (0-6)
     * comprobando que el usuario a introducido una letra válida (mayúscula o minúscula)
     * @param teclado
     * @param mensaje

     */
    public static int leerDiaDeLaSemana(Scanner teclado, String mensaje) {
        String dia;
        do{
            System.out.println(mensaje);
            dia=teclado.nextLine();

        }while(dia.length()!=1 || !(dia.equals("L") || dia.equals("l") || dia.equals("M") || dia.equals("m") || dia.equals("X") || dia.equals("x") || dia.equals("j") || dia.equals("J") || dia.equals("V") || dia.equals("v") || dia.equals("S") || dia.equals("s") || dia.equals("D") || dia.equals("d")));
        int numero=0;
        if(dia.equals("L") || dia.equals("l")){
            numero=0;
        }else if(dia.equals("M") || dia.equals("m")){
            numero=1;
        }else if(dia.equals("X") || dia.equals("x")){
            numero=2;
        }else if(dia.equals("J") || dia.equals("j")){
            numero=3;
        }else if(dia.equals("V") || dia.equals("v")){
            numero=4;
        }else if(dia.equals("S") || dia.equals("s")){
            numero=5;
        }else if(dia.equals("D") || dia.equals("d")){
            numero=6;
        }
        return numero;
    }

    /**
     * Devuelve la posicion del dia de la semana (L,M,X,J,V,S,D)
     * dentro de la semana(0,1,2,3,4,5,6) o -1 si no es un día no valido.
     * @param dia Dia de la semana (L,M,X,JV,S,D)
     *
     */
    public static int diaSemanaAPosicion(String dia) {
        int numero;
        if(dia=="L" || dia=="l"){
            numero=0;
        } else if (dia=="M" || dia=="m") {
            numero = 1;
        } else if (dia=="X" || dia=="x") {
            numero = 2;
        }else if (dia=="J" || dia=="j") {
            numero = 3;
        }else if (dia=="V" || dia=="v") {
            numero = 4;
        }else if (dia=="S" || dia=="s") {
            numero = 5;
        }else if (dia=="D" || dia=="d") {
            numero = 6;
        }else {
            numero = -1;
        }
        return numero;
    }

    /**
     * Función que devuelve el día de la semana
     * (Lunes,Martes,Miercoles,Jueves,Viernes,Sábado,Domingo) correspondiente
     * a la posición indicada (0-6) o "desconocido" si la posición es incorrecta.
     * @param pos Posición del día de la semana
     */
    public static String posicionADiaSemana(int pos) {
        String posicion;
        if(pos==0){
            posicion = "Lunes";
        }else if(pos==1){
            posicion = "Martes";
        }else if(pos==2) {
            posicion = "Miércoles";
        }else if(pos==3) {
            posicion = "Jueves";
        }else if(pos==4) {
            posicion = "Viernes";
        }else if(pos==5) {
            posicion = "Sábado";
        }else if(pos==6) {
            posicion = "Domingo";
        }else{
            posicion = "Desconocido";
        }
        return posicion;
    }
}

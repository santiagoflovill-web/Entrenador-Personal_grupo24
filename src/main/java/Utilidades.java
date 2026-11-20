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
        boolean valida = false;
        while(!valida){
            System.out.print(mensaje);
            String linea = teclado.nextLine();
            try{
                numero = Integer.parseInt(linea.trim());
                valida = numero >= minimo && numero <= maximo;
            }catch (NumberFormatException e){
                valida = false;
            }
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
            dia = leerCadena(teclado, mensaje);
        }while(dia.length()!=1 || !(dia.equalsIgnoreCase("L") || dia.equalsIgnoreCase("M") ||
                dia.equalsIgnoreCase("X") || dia.equalsIgnoreCase("j")  ||
                dia.equalsIgnoreCase("V")  || dia.equalsIgnoreCase("s") ||dia.equalsIgnoreCase("d")));
        int numero;
        numero = diaSemanaAPosicion(dia);
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
        if(dia==null){
            numero =-1;
        }else if (dia.length()!=1) {
            numero = -1;
        } else if (dia.equalsIgnoreCase("L")){
            numero=0;
        }else if(dia.equalsIgnoreCase("M")){
            numero=1;
        }else if(dia.equalsIgnoreCase("X")){
            numero=2;
        }else if(dia.equalsIgnoreCase("J")){
            numero=3;
        }else if(dia.equalsIgnoreCase("V")){
            numero=4;
        }else if(dia.equalsIgnoreCase("S")){
            numero=5;
        }else if(dia.equalsIgnoreCase("D")){
            numero=6;
        }else{
            numero=-1;
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
        String posicion="";
        String[] dias = new String[] {"Lunes", "Martes" ,"Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        if(pos >= 0 && pos <=6){
            posicion = dias[pos];
        }else{
            posicion = "Desconocido";
        }
        return posicion;
    }
}

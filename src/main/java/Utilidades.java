import java.util.Scanner;

/**
 * Clase con métodos de utilidad para la entrada de datos por teclado y el manejo de días de la semana.
 */
public class Utilidades {
    public static String leerCadena(Scanner teclado, String s) {
       String texto;
       System.out.print(s);
       texto = teclado.nextLine();
       return texto;
    }

    public static int leerNumero(Scanner teclado, String mensaje, int minimo, int maximo) {
       int numero;
        do{
            System.out.print(mensaje);
            numero = teclado.nextInt();
        }while(numero<minimo && numero>maximo);
        return numero;
    }

    public static int leerDiaDeLaSemana(Scanner teclado, String mensaje) {
        char dia;
        int numero=0;
        do{
            System.out.print(mensaje);
            dia = teclado.nextLine().charAt(0);
            switch (dia){
                case 'L':
                    numero = 0;
                    break;
                case 'M':
                    numero = 1;
                    break;
                case 'X':
                    numero = 2;
                    break;
                case 'J':
                    numero = 3;
                    break;
                case 'V':
                    numero = 4;
                    break;
                case 'S':
                    numero = 5;
                    break;
                case 'D':
                    numero = 6;
                    break;
            }

        }while(dia != 'L' || dia != 'M' || dia != 'X' || dia != 'J' || dia !='V' || dia != 'S' || dia != 'D');

        return numero;
    }

    public static int diaSemanaAPosicion(String dia) {
        // Devuelve la posición de un día de la semana (L, M, X, J, V, S, D) dentro de la semana (0-6),
        // o -1 si no es un día válido
        return 0; // @todo MODIFICAR PARA DEVOLVER LA POSICIÓN DEL DÍA DE LA SEMANA
    }

    public static String posicionADiaSemana(int pos) {
        // Devuelve el día de la semana (Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo)
        // correspondiente a una posición dentro de la semana (0-6), o "Desconocido" si no es válida
        return null; // @todo MODIFICAR PARA DEVOLVER EL DÍA DE LA SEMANA
    }
}

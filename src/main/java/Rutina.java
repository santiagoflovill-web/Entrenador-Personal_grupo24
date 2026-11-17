import java.util.Arrays;//Uso este metodo para los metodos toString para que sean más faciles de manejar

/**
 * Clase Rutina que tiene como atributos el nombre de la rutina
 * y dos arrays de strings, uno de ejercicios de la rutina y el otro de los estiramientos.
 * Tiene los metodos 'get' que dan el nombre, número máximo de ejrcicicios/estiramientos y arrays con el
 * número de ejercicios y estiramientos actuales como longitud del array, además de tener dichos
 * ejericicios/estiramientos dentro de los arrays; también tiene lo metodos de 'agregar' añaden ejercicios
 * o estiramientos a su array respectivo; están los "comprobadores", que comprueban el tamaño o si están
 * llenos los arrays; y por último los toString que transforman la rutina en una string y los saca por consola
 * o en un fichero.
 */
public class Rutina {
    String nombreRutina;
    String[] ejercicios;
    String[] estiramientos;

    /**
     * Constructor que inicializa los atributos de la rutina
     * @param nombre
     * @param maxEjercicios
     * @param maxEstiramientos
     */
    public Rutina(String nombre, int maxEjercicios, int maxEstiramientos) {
        // Inicialización de la rutina
        nombreRutina = nombre;
        ejercicios = new String[maxEjercicios];
        estiramientos = new String[maxEstiramientos];
    }

    /**
     * Devuelve el nombre de la rutina
     * @return nombreRutina
     */
    public String getNombre() {
        // Devuelve el nombre de la rutina
        return nombreRutina;
    }

    /**
     * Devuelve un array unicamente con los ejercicios y sin nulls, teniendo la longitud igual
     * al número de ejercicios
     * @return copia parcial del array
     */
    public String[] getEjercicios() {
        // Devuelve los ejercicios de la rutina (array de longitud igual al número de ejercicios actuales)
        return Arrays.copyOf(this.ejercicios,this.numEjercicios());
    }

    /**
     * Lo mismo que el anterior, pero aplicado a los estiramientos
     * @return copia parcial del array
     */
    public String[] getEstiramientos() {
        // Devuelve los estiramientos de la rutina (array de longitud igual al número de estiramientos actuales)
        return Arrays.copyOf(this.estiramientos, this.numEstiramientos());
    }

    /**
     * Añade un ejercicio al array, comprobando primero si se puede añadir. Para esto se apoya en
     * la función numEjercicios.
     * @param ejercicio
     */
    public boolean agregarEjercicio(String ejercicio) {
        // Añade un ejercicio a la rutina (si está completa, muestra un mensaje de error)
        boolean esAñadido = true;
        int numEjercicios = numEjercicios();
        if (numEjercicios == ejercicios.length){
            esAñadido = false;
            System.out.print("No se pueden añadir más ejercicios.\n");
        }else{
            ejercicios[numEjercicios] = ejercicio;
        }
        return esAñadido;
    }

    /**
     * Lo mismo que la función anterior, pero aplicada a los estiramientos y apoyandose en numEstiramientos
     * @param estiramiento
     */
    public boolean agregarEstiramiento(String estiramiento) {
        // Añade un estiramiento a la rutina (si está completa, muestra un mensaje de error)
        boolean esAñadido = true;
        int numEstiramientos = numEstiramientos();
        if (numEstiramientos == estiramientos.length){
            esAñadido = false;
            System.out.print("No se pueden añadir más estiramientos.\n");
        }else{
            estiramientos[numEstiramientos] = estiramiento;
        }
        return esAñadido;
    }

    /**
     * Comprueba si el array de los ejercicios está completo
     */
    public boolean ejerciciosCompletos() {
        // Comprueba si la rutina tiene el máximo de ejercicios
        boolean lleno;
        if(ejercicios.length ==0){
            lleno=true;
        }else{
          lleno =ejercicios[ejercicios.length-1] != null;
        }
        return lleno;
    }

    /**
     * Lo mismo que el anteriior pero aplicado a estiramientos
     */
    public boolean estiramientosCompletos() {
        // Comprueba si la rutina tiene el máximo de estiramientos
        boolean lleno;
        if(estiramientos.length ==0){
            lleno=true;
        }else{
            lleno =estiramientos[estiramientos.length-1] != null;
        }
        return lleno;
    }

    /**
     * Devuelve el número de ejercicios que hay. Para esto se apoya en ejerciciosCompletos para ver si está lleno
     */
    public int numEjercicios() {
        // Devuelve el número de ejercicios de la rutina
        int aux=0;
        int numEjercicios;
        if (ejerciciosCompletos()) {
            numEjercicios = ejercicios.length;
        } else {
            while(ejercicios[aux] != null){
                aux++;
            }
            numEjercicios = aux;
        }
        return numEjercicios;
    }

    /**
     * Lo mismo que el anterior pero aplicado a los estiramientos
     */
    public int numEstiramientos() {
        // Devuelve el número de estiramientos de la rutina
        int aux=0;
        int numEstiramientos;
        if (estiramientosCompletos()) {
            numEstiramientos = estiramientos.length;
        } else {
            while(estiramientos[aux] != null){
                aux++;
            }
            numEstiramientos =aux;
        }
        return numEstiramientos;
    }

    /**
     * Devuelve un string para poder sacarlo por la consola
     */
    @Override
    public String toString() {
        // Devuelve una representación en forma de cadena de la rutina, para mostrar por pantalla
        StringBuilder rutinaSb = new StringBuilder();
        rutinaSb.append("Rutina: ").append(nombreRutina).append("\nEjercicios:");
        for(int i=0; i !=numEjercicios(); i++){
            rutinaSb.append("\n- ").append(ejercicios[i]);
        }
        rutinaSb.append("\nEstiramientos:");
        for(int i=0; i !=numEstiramientos(); i++){
            rutinaSb.append("\n").append(i+1).append(". ").append(estiramientos[i]);
        }
        rutinaSb.append("\n");
        return rutinaSb.toString();
    }

    /**
     * Lo mismo que la anterior, pero con un formato para meterlo en un fichero
     */
    public String toRawString() {
        // Devuelve una representación en forma de cadena de la rutina sin formato, para guardar en archivo
        StringBuilder rutinaFichSb = new StringBuilder();
        rutinaFichSb.append(nombreRutina);
        for(int i=0; i !=numEjercicios(); i++){
            rutinaFichSb.append("\n").append(ejercicios[i]);
        }
        rutinaFichSb.append("\nESTIRAMIENTOS");
        for(int i=0; i !=numEstiramientos(); i++){
            rutinaFichSb.append("\n").append(estiramientos[i]);
        }
        rutinaFichSb.append("\n=====\n");
        return rutinaFichSb.toString();
    }

    /**
     * Devuelve el número maximo de ejercicios que puede tener el array de los ejercicios
     */
    public int getMaxEjercicios() {
        // Devuelve el máximo de ejercicios permitidos en la rutina
        return ejercicios.length;
    }

    /**
     * Lo mismo que el anterior, pero para los estiramientos
     */
    public int getMaxEstiramientos() {
        // Devuelve el máximo de estiramientos permitidos en la rutina
        return estiramientos.length;
    }
}

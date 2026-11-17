public class Rutina {
    String nombreRutina;
    String[] ejercicios;
    String[] estiramientos;

    public Rutina(String nombre, int maxEjercicios, int maxEstiramientos) {
        // Inicialización de la rutina
        nombreRutina = nombre;
        ejercicios = new String[maxEjercicios];
        estiramientos = new String[maxEstiramientos];
    }

    public String getNombre() {
        // Devuelve el nombre de la rutina
        return nombreRutina;
    }

    public String[] getEjercicios() {
        // Devuelve los ejercicios de la rutina (array de longitud igual al número de ejercicios actuales)
        return ejercicios;
    }

    public String[] getEstiramientos() {
        // Devuelve los estiramientos de la rutina (array de longitud igual al número de estiramientos actuales)
        return estiramientos;
    }

    public boolean agregarEjercicio(String ejercicio) {
        // Añade un ejercicio a la rutina (si está completa, muestra un mensaje de error)
        boolean esAñadido = true;
        int numEjercicios = numEjercicios();
        if (numEjercicios == ejercicios.length){
            esAñadido = false;
        }else{
            ejercicios[numEjercicios-1] = ejercicio;
        }
        return esAñadido;
    }

    public boolean agregarEstiramiento(String estiramiento) {
        // Añade un estiramiento a la rutina (si está completa, muestra un mensaje de error)
        boolean esAñadido = true;
        int numEstiramientos = numEstiramientos();
        if (numEstiramientos == estiramientos.length){
            esAñadido = false;
        }else{
            estiramientos[numEstiramientos-1] = estiramiento;
        }
        return esAñadido;
    }

    public boolean ejerciciosCompletos() {
        // Comprueba si la rutina tiene el máximo de ejercicios
        return ejercicios[ejercicios.length - 1] != null;
    }

    public boolean estiramientosCompletos() {
        // Comprueba si la rutina tiene el máximo de estiramientos
        return estiramientos[estiramientos.length - 1] != null;
    }

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
            numEjercicios =aux;
        }
        return numEjercicios;
    }

    public int numEstiramientos() {
        // Devuelve el número de estiramientos de la rutina
        int aux=0;
        int numEstiramientos;
        if (estiramientosCompletos()) {
            numEstiramientos = estiramientos.length;
        } else {
            do {
                aux++;
            }while(estiramientos[aux] != null);
            numEstiramientos =aux;
        }
        return numEstiramientos; // @todo MODIFICAR PARA DEVOLVER EL NÚMERO DE ESTIRAMIENTOS
    }

    @Override
    public String toString() {
        // Devuelve una representación en forma de cadena de la rutina, para mostrar por pantalla
        String rutina = "Rutina: " + nombreRutina + "\nEjercicios:";
        for(int i=0; i !=numEjercicios(); i++){
            rutina +="\n- " +ejercicios[i];
        }
        rutina +="\nEstiramientos";
        for(int i=0; i !=numEstiramientos(); i++){
            rutina+="\n"+ i+1 + ". " + estiramientos[i];
        }
        return rutina; // @todo MODIFICAR PARA DEVOLVER LA CADENA CORRECTA
    }

    public String toRawString() {
        // Devuelve una representación en forma de cadena de la rutina sin formato, para guardar en archivo
        String rutinaFich = nombreRutina;
        for(int i=0; i !=numEjercicios(); i++){
            rutinaFich +="\n" + ejercicios[i];
        }
        rutinaFich +="\nESTIRAMIENTOS";
        for(int i=0; i !=numEstiramientos(); i++){
            rutinaFich +="\nestiramientos[i]";
        }
        return rutinaFich; // @todo MODIFICAR PARA DEVOLVER LA CADENA CORRECTA
    }

    public int getMaxEjercicios() {
        // Devuelve el máximo de ejercicios permitidos en la rutina
        return ejercicios.length;
    }

    public int getMaxEstiramientos() {
        // Devuelve el máximo de estiramientos permitidos en la rutina
        return estiramientos.length;
    }
}

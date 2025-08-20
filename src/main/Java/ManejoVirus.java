

/**
 *
 * @author Víctor Daniel AH
 */
public class ManejoVirus {

    private int[][][] celstateaux = new int[1000][10][10];//Variable para manejo de generaciones, para efectos de retorno a generaciones anteriores.
    private int[][] initial = new int[10][10];//Variable de la generación 0 (Generada por el usuario)
    private int[][] celstate = new int[10][10];//Variable para el manejo de lógica de la Generación actual
    private int[] coordenada = new int[100]; // Variable que almacena en números ordenados naturalmente, las coordenadas para su tratamiento posterior

    /**
     *
     */
    public int vivasaux = 0, 

    /**
     *
     */
    vivasact = 0;//Variable para manejo de cantidades de celulas sanas en la generacion actual/visualizada
    private int cont = 0; //Variable para efectos de manejo de lógica del virus
    private int posxt = 0, posyt = 0; //Posición en coordenadas de la célula en análisis

    /**
     *
     */
    public int gen = 0, 

    /**
     *
     */
    auxgen = 0, 

    /**
     *
     */
    cicle = 0, 

    /**
     *
     */
    sanasact = 0, 

    /**
     *
     */
    sanasvis = 0, 

    /**
     *
     */
    infectadasact = 0, 

    /**
     *
     */
    infectadasvis = 0, 

    /**
     *
     */
    auxant = 0, 

    /**
     *
     */
    auxsig = 0; //Variables generales, para información general del curso de ejecución

    /**
     *
     */
    public boolean iniciado = false; //Variable Interna, para manejo de lógica de continuidad del programa
    private int vivas = 0, contcoor = 0; //Variables auxiliares para manejo de estado

    /**
     *
     */
    public String log; //Variable para recopilación de lógica y acciones del virus durante la ejecución

    /**
     *
     */
    public String[] loggens = new String[3]; //Variable para muestreo de etapa del virus.

    //Constructor
    ManejoVirus() {
        for (int x = 0; x <= 9; x++) {
            for (int y = 0; y <= 9; y++) {
                celstate[x][y] = 0;
                initial[x][y] = 0;
            }
        }
        for (int z = 0; z <= 999; z++) {
            for (int x = 0; x <= 9; x++) {
                for (int y = 0; y <= 9; y++) {
                    celstateaux[z][x][y] = 0;
                }
            }
        }
        for (int f = 0; f <= 99; f++) {
            coordenada[f] = 0;
        }
        iniciado = false;
        posxt = 0;
        posyt = 0;
        cont = 0;
        gen = 0;
        cicle = 0;
        vivas = 0;
        contcoor = 0;
        auxgen = 0;
        sanasact = 0;
        sanasvis = 0;
        infectadasact = 0;
        infectadasvis = 0;
        vivasaux = 0;
        vivasact = 0;
        log = "";
        loggens[0] = "GENERACIÓN 1 : El Virus Infecta a Todas Las Células Sanas Que La Rodean.";
        loggens[1] = "GENERACIÓN 2 : Las Células Infectadas que están rodeadas por 5 o más células infectadas, Mueren.";
    }//FIN CONSTRUCTOR
    
    //Inicio Función comprobacion. Verifica células vecinas para retornar valor a tratar posteriormente

    /**
     *
     * @param px
     * @param py
     * @return
     */
    public int comprobacion(int px, int py) {
        cont = 0;
        if (px != 0 && py != 0) {
            if (celstate[px - 1][py - 1] == 1) {
                cont = cont + 1;
            }
        }
        if (px != 0) {
            if (celstate[px - 1][py] == 1) {
                cont = cont + 1;
            }
        }
        if (px != 0 && py != 9) {
            if (celstate[px - 1][py + 1] == 1) {
                cont = cont + 1;
            }
        }
        if (py != 0) {
            if (celstate[px][py - 1] == 1) {
                cont = cont + 1;
            }
        }
        if (py != 9) {
            if (celstate[px][py + 1] == 1) {
                cont = cont + 1;
            }
        }
        if (px != 9 && py != 0) {
            if (celstate[px + 1][py - 1] == 1) {
                cont = cont + 1;
            }
        }
        if (px != 9) {
            if (celstate[px + 1][py] == 1) {
                cont = cont + 1;
            }
        }
        if (px != 9 && py != 9) {
            if (celstate[px + 1][py + 1] == 1) {
                cont = cont + 1;
            }
        }

        return cont;
    }//FIN DE COMPROBACION DE ESTADO DE CELULAS VECINAS

    //Método de manejo cuando el virus se encuentra en el ciclo primero de su vida

    /**
     *
     */
    public void generaciones() {
        if (cicle == 0) {
            if (celstate[posxt][posyt] == 1) {
                for (int x = posxt - 1; x <= posxt + 1; x++) {
                    for (int y = posyt - 1; y <= posyt + 1; y++) {
                        if (((x <= 9 && y <= 9) && (x >= 0 && y >= 0))) {
                            celstate[x][y] = 1;
                            log = log + "[INFECTADA] Índice: " + x + ", " + y + "." + "\n";
                        }
                    }
                }
            }
        }

    }//FIN DE MANEJO DE CELULA

    //Método de valorespositivos(). Comprobación de células infectadas, para posterior tratamiento en "manejovirus()"

    /**
     *
     */
    public void valorespositivos() {
        contcoor = 0;
        for (int f = 0; f <= 99; f++) {
            coordenada[f] = 0;
        }
        if (cicle == 0) {
            for (int i = 0; i <= 9; i++) {
                for (int e = 0; e <= 9; e++) {
                    if (celstate[i][e] == 1) {
                        if (i != 0) {
                            coordenada[contcoor] = (10 * i) + (e + 1);
                        } else if (i == 0) {
                            coordenada[contcoor] = (e + 1);
                        }
                        contcoor = contcoor + 1;
                    }
                }
            }
        } else if (cicle == 1) {
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    if ((comprobacion(i, j) >= 5)) {
                        if (i != 0) {
                            coordenada[contcoor] = (10 * i) + (j + 1);
                        } else if (i == 0) {
                            coordenada[contcoor] = (j + 1);
                        }
                        contcoor = contcoor + 1;
                    }

                }
            }
        }

    }//Fin de valorespositivos(). Método de comprobación de células infectadas.

    //Método de inicialización de coordenadas para análisis de célula según valor dado en números ordenados naturalmente
    void inicializacion(int post) {
        posxt = 0;
        posyt = 0;
        for (int xm = 1; xm <= 10; xm++) {

            if (xm == 10 && post > 10) {
                post = post - 10;
                posxt = posxt + 1;
                xm = 0;
            }

            if (xm == post) {
                posyt = xm - 1;
                break;
            }

        }

    } //FIN MÉTODO INCIALIZACIÓN.

    //Función para determinar la continuidad de ejecución en base si existen aún células infectadas que analizar
    boolean continuidad() {
        vivas = 0;
        boolean continuidad = false;

        for (int i = 0; i <= 9; i++) {
            for (int e = 0; e <= 9; e++) {
                if (celstate[i][e] == 1) {
                    vivas = vivas + 1;
                }
            }
        }
        if (vivas >= 1) {
            continuidad = true;
        }
        return continuidad;
    } //FIN FUNCIÓN CONTINUIDAD

    //Función para cambiar estado de célula de sana a infectada o visebersa desde la interfaz
    int cambiarvalormatriz(int pospre) {
        posxt = 0;
        posyt = 0;
        inicializacion(pospre);
        if (celstate[posxt][posyt] == 0) {
            celstate[posxt][posyt] = 1;
        } else if (celstate[posxt][posyt] == 1) {
            celstate[posxt][posyt] = 0;
        }
        return celstate[posxt][posyt];

    } //FIN MÉTODO CAMBIARVALORMATRIZ

    //Método para establecer cantidad de células sanas según la generación que se visualiza para mostrarlo en la interfaz

    /**
     *
     */
    public void vivas() {
        vivasaux = 0;
        vivasact = 0;
        if (auxgen == gen) {
            for (int x = 0; x <= 9; x++) {
                for (int y = 0; y <= 9; y++) {
                    if (celstate[x][y] == 1) {
                        vivasaux = vivasaux + 1;
                        vivasact = vivasact + 1;
                    }
                }
            }
        } else if (auxgen != gen) {
            for (int x = 0; x <= 9; x++) {
                for (int y = 0; y <= 9; y++) {
                    if (celstateaux[auxgen - 1][x][y] == 1) {
                        vivasaux = vivasaux + 1;
                    }
                    if (celstateaux[gen - 1][x][y] == 1) {
                        vivasact = vivasact + 1;
                    }
                }
            }
        }
    } //FIN MÉTODO VIVAS

    //MÉTODO PRINCIPAL DE MANEJO Y DISTRIBUCIÓN DE ACCIONES PARA LÓGICA DE VIRUS
    void comportamientovirus() {

        if (gen == 0) {
            for (int x = 0; x <= 9; x++) {
                for (int y = 0; y <= 9; y++) {
                    initial[x][y] = celstate[x][y];
                }
            }
        }
        if (cicle == 2) {
            cicle = 0;
        }
        if (cicle == 0) {
            valorespositivos();
            for (int c = 0; c <= contcoor; c++) {
                inicializacion(coordenada[c]);
                if (celstate[posxt][posyt] == 1) {
                    log = log + "[CÉLULA MADRE] Índice: " + posxt + ", " + posyt + ". Valor: " + celstate[posxt][posyt] + "\n";
                }
                generaciones();
            }

            cicle = cicle + 1;
        } else if (cicle == 1) {
            log = log + "\n\n\n";
            valorespositivos();
            for (int c = 0; c <= contcoor - 1; c++) {
                inicializacion(coordenada[c]);
                log = log + "\n[SOBREPOBLADO] Índice: " + posxt + ", " + posyt + ". Por Población cercana >=5.";
                celstate[posxt][posyt] = 0;
            }

            cicle = cicle + 1;
        }

        establecerciclos(0);

    }//FIN MÉTODO COMPORTAMIENTOVIRUS

    //Método para manejo del "historial" de generaciones, para retornar a generaciones anteriores.

    /**
     *
     * @param inicial_anterior_siguiente
     */
    public void establecerciclos(int inicial_anterior_siguiente) {

        if (inicial_anterior_siguiente == 0) {

            if (auxgen == gen) {
                for (int x = 0; x <= 9; x++) {
                    for (int y = 0; y <= 9; y++) {
                        celstateaux[gen][x][y] = celstate[x][y];
                    }
                }
                gen = gen + 1;
            } else if (auxgen != gen) {

                for (int x = 0; x <= 9; x++) {
                    for (int y = 0; y <= 9; y++) {
                        celstateaux[auxgen - 1][x][y] = celstate[x][y];
                    }
                }
                for (int ag = auxgen; ag <= gen - 1; ag++) {
                    for (int x = 0; x <= 9; x++) {
                        for (int y = 0; y <= 9; y++) {
                            celstateaux[ag][x][y] = 0;
                        }
                    }
                }
                log = log + "\n\n\n[REPOSICIONAMIENTO] La nueva generación actual es la generación en análisis " + auxgen + ". Posición de retorno desde Generación: " + gen + ".\n\n\n";
                gen = auxgen;
                gen = gen + 1;
            }
            auxgen = gen;
            vivas();
        } else if (inicial_anterior_siguiente == 1) {
            if (auxgen > 1) {
                auxgen = auxgen - 1;
                for (int x = 0; x <= 9; x++) {
                    for (int y = 0; y <= 9; y++) {
                        celstate[x][y] = celstateaux[auxgen - 1][x][y];
                    }
                }
                log = log + "\n\n\n[ATENCIÓN]: SE VISUALIZA UNA GENERACIÓN ANTERIOR. Generación " + auxgen + "\n";
            } else if (auxgen == 1) {
                for (int x = 0; x <= 9; x++) {
                    for (int y = 0; y <= 9; y++) {
                        celstate[x][y] = initial[x][y];
                    }
                }
                log = log + "[ATENCIÓN]: La posición que se visualiza es la Inicial. No se puede retornar más " + "\n";
            }
            vivas();
        } else if (inicial_anterior_siguiente == 2) {
            if (auxgen < gen) {
                auxgen = auxgen + 1;
                for (int x = 0; x <= 9; x++) {
                    for (int y = 0; y <= 9; y++) {
                        celstate[x][y] = celstateaux[auxgen - 1][x][y];
                    }
                }
                if ((auxgen - 1) != (gen - 1)) {
                    log = log + "\n\n\n[ATENCIÓN]: SE VISUALIZA UNA GENERACIÓN ANTERIOR. Generación " + auxgen + "\n";
                } else if ((auxgen - 1) == (gen - 1)) {
                    log = log + "[ATENCIÓN]: SE VISUALIZA LA GENERACIÓN ACTUAL. Generación " + auxgen + "\n";
                }

            }
            vivas();
        }

    } //FIN MÉTODO ESTABLECER CICLOS

    //Función para conocer el estado de una célula, útil para interfaz y su actualización de estados en cada generación

    /**
     *
     * @param posvis
     * @return
     */
    public int visualizarestado(int posvis) {
        inicializacion(posvis);
        return celstate[posxt][posyt];

    } //FIN FUNCIÓN VISUALIZARESTADO

}

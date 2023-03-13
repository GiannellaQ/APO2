import java.util.Scanner;

public class JuegoDeLaVida {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir tamaño del mundo
        System.out.print("Ingrese el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = scanner.nextInt();
        
        // Crear mundo en la generación 0 y llenarlo aleatoriamente
        int[][] mundoGeneracion0 = new int[filas][columnas];
        inicializarMundoAleatoriamente(mundoGeneracion0);
        
        // Crear mundo en la generación 1 y aplicar reglas
        int[][] mundoGeneracion1 = aplicarReglas(mundoGeneracion0);
        
        // Mostrar mundos por pantalla
        System.out.println("Mundo en la generación 0:");
        mostrarMundo(mundoGeneracion0);
        System.out.println("Mundo en la generación 1:");
        mostrarMundo(mundoGeneracion1);
    }
    
    // Inicializar mundo aleatoriamente
    public static void inicializarMundoAleatoriamente(int[][] mundo) {
        for (int i = 0; i < mundo.length; i++) {
            for (int j = 0; j < mundo[0].length; j++) {
                mundo[i][j] = Math.random() < 0.5 ? 0 : 1; // 0 representa célula muerta, 1 célula viva
            }
        }
    }
    
    // Aplicar reglas para crear mundo en la generación siguiente
    public static int[][] aplicarReglas(int[][] mundoActual) {
        int[][] mundoSiguiente = new int[mundoActual.length][mundoActual[0].length];
        
        for (int i = 0; i < mundoActual.length; i++) {
            for (int j = 0; j < mundoActual[0].length; j++) {
                int vecinasVivas = contarVecinasVivas(mundoActual, i, j);
                if (mundoActual[i][j] == 0 && vecinasVivas == 3) {
                    mundoSiguiente[i][j] = 1; // nace
                } else if (mundoActual[i][j] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) {
                    mundoSiguiente[i][j] = 1; // sobrevive
                } else {
                    mundoSiguiente[i][j] = 0; // muere
                }
            }
        }
        
        return mundoSiguiente;
    }
    
    // Contar células vecinas vivas
    public static int contarVecinasVivas(int[][] mundo, int i, int j) {
        int vecinasVivas = 0;
        
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x == i && y == j) {
                    continue; // no contar la célula en sí misma
                }
           
53
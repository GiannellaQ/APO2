import java.util.Scanner;

public class Juego {
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Pedimos al usuario el tamaño del mundo
	        
	        System.out.print("Ingrese el número de filas del mundo: ");
	        int filas = sc.nextInt();
	        System.out.print("Ingrese el número de columnas del mundo: ");
	        int columnas = sc.nextInt();

	        // Creamos la matriz para el mundo en la generación 0
	        
	        int[][] mundo0 = new int[filas][columnas];

	        // Llenamos la matriz aleatoriamente con células vivas o muertas
	        
	        for (int i = 0; i < filas; i++) {
	            for (int j = 0; j < columnas; j++) {
	                mundo0[i][j] = (int) (Math.random() * 2);
	            }
	        
	  }
	     // Creamos la matriz para el mundo en la generación 1
	        
	        int[][] mundo1 = new int[filas][columnas];

	        // Aplicamos las reglas para llenar la matriz del mundo en la generación 1
	        
	        for (int i = 0; i < filas; i++) {
	            for (int j = 0; j < columnas; j++) {
	                int vecinosVivos = contarVecinosVivos(mundo0, i, j);
	                if (mundo0[i][j] == 0 && vecinosVivos == 3) {
	                    mundo1[i][j] = 1; // La célula nace
	                } else if (mundo0[i][j] == 1 && (vecinosVivos == 2 || vecinosVivos == 3)) {
	                    mundo1[i][j] = 1; // La célula sobrevive
	                } else {
	                    mundo1[i][j] = 0; // La célula muere
	                }
	            }
	        }

	        // Mostramos por pantalla los mundos en las dos generaciones
	        
	        System.out.println("Mundo en la generación 0:");
	        mostrarMundo(mundo0);
	        System.out.println("\nMundo en la generación 1:");
	        mostrarMundo(mundo1);
	    }

	    // Función para contar el número de células vecinas vivas de una célula en el mundo
	    public static int contarVecinosVivos(int[][] mundo, int fila, int columna) {
	        int vecinosVivos = 0;
	        for (int i = fila - 1; i <= fila + 1; i++) {
	            for (int j = columna - 1; j <= columna + 1; j++) {
	                if (i >= 0 && i < mundo.length && j >= 0 && j < mundo[0].length && mundo[i][j] == 1) {
	                    vecinosVivos++;
	                }
	            }
	        }
	        // Restamos la célula central (fila, columna) que también fue contada
	        vecinosVivos -= mundo[fila][columna];
	        return vecinosVivos;
	    }

	    // Función para mostrar el mundo por pantalla
	    public static void mostrarMundo(int[][] mundo) {
	        for (int i = 0; i < mundo.length; i++) {
	            for (int j = 0; j < mundo[0].length; j++) {
	                System.out.print(mundo[i][j])} } }  
	    
   }
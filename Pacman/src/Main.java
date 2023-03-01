import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class pacman{
    public int contador;
    public List<Integer> comida;
}
public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        byte numero;
        byte contador = 0; // asignacion 1 OE
        char tablero[][];
        String dato = "";  // asignacion 1 OE

        numero = leer.nextByte(); // asignacion 1 OE
        //3 OE
        do{
            dato = dato + leer.next();  // asignacion n 0E, n suma

        }while (contador !=numero); // comparacion n OE
        //2n^2 +3

        tablero = crearTablero(numero, dato); // Asignacion 1 OE
        // 20n^2 +20n +42
        obtenerComida(tablero); //80n^2 +100n +21
    } //102^2 +120 +66
    // Resultado ---->102^2 +120 +66 la complejidad del algoritmo es una funcion lineal

    public static char[][] crearTablero(byte numero, String dato)
    {
        char tablero[][] = new char[numero][numero];
        int contador = 0; // asignacion 1 OE

        for(int i = 0; i < tablero.length; i++) { // asignacion 1 OE , COMPARAION n + 1 OE, suma n OE
            for(int j = 0; j < tablero.length; j++) { // asignacion 1 OE , COMPARAION n + 1 OE, suma n OE
                tablero[i][j] = dato.charAt(contador);   // 4 OE
                contador++; // Suma 1 OE
            } //
        }
        return tablero; // retorno 1 OE
        // 20n^2 +20n +41
    }
    public static void obtenerComida(char[][] tablero)
    {
        pacman pacman = new pacman();
        pacman.comida = new ArrayList<>();

        for(int i = 0; i < tablero.length; i++) { // asignacion 1 OE , COMPARAION n + 1 OE, suma n OE
            if(i%2 == 0) {  // modulo - comparacion 2 OE
                pacman = recorrerIzquierdaDerecha(i,tablero,pacman); // 20n +2
            }
            else { // 1 OE
                pacman =recorrerDerechaIzquierda(i,tablero,pacman);  // 20n +2
            }
            //40n+6
        } //80n^2 +92n +12
        pacman.comida.add(pacman.contador );// asignacion 1 OE
        //80n^2 +92n +13
        calcularMaximaComida(pacman.comida); //8n+9
    }  //80n^2 +100n +21
    public static pacman recorrerDerechaIzquierda(int fila, char[][] tablero, pacman pacman)
    {
        for(int j = tablero.length-1; j >= 0; j--) { // asinacion 1OE , comparacion n+1 , suma n
            if(tablero[fila][j] == 'A') { // acceder a una posicion en matriz 2 OE , comparacion 1 OE
                pacman.comida.add(pacman.contador); // agregar 1 OE
                pacman.contador = 0; // asignacion 1 OE
            }
            else if (tablero[fila][j] == 'o') { // acceder a una posicion en matriz 2 OE , comparacion 1 OE
                pacman.contador = pacman.contador+1; // asignacion 1 OE , suma 1 OE
            }
        }
        return pacman; // retorno 1 OE
    } // 20n+2
    public static pacman recorrerIzquierdaDerecha(int fila, char[][] tablero, pacman pacman )
    {
        for(int j = 0; j < tablero.length; j++) // asinacion 1OE , comparacion n+1 , suma n
        {
            if(tablero[fila][j] == 'A') { // acceder a una posicion en matriz 2 OE , comparacion 1 OE
                pacman.comida.add(pacman.contador); // agregar 1 OE
                pacman.contador = 0; // asignacion 1 OE
            }
            else if (tablero[fila][j] == 'o') { // acceder a una posicion en matriz 2 OE , comparacion 1 OE
                pacman.contador = pacman.contador+1; // asignacion 1 OE , suma 1 OE
            }
        }
        return pacman; // retorno 1 OE
    } // 20n+2
    public static void calcularMaximaComida(List<Integer> comida)
    {
        int maximo=0; // asignacion 1 0E
        for (int i = 0; i < comida.size(); i++) { // ASISNACION  1 OE, COMPARACION n+1 OE , suma n  OE
            if(maximo < comida.get(i)) { // comparacion 1 OE , aceder 1OE
                maximo = comida.get(i); // asignacion  1OE , aceder 1 0E
            }
        }
        System.out.println(maximo); // IMPRECION 1 posicion
    } //8n+9
}
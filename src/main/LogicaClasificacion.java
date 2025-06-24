package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();
        for (char c : texto.toCharArray()) {
            pila.push(c);
        }
        StringBuilder Sb = new StringBuilder();
        while (!pila.isEmpty()) {
            Sb.append(pila.pop());
        }
        return Sb.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String cad) {
         Stack<Character> pila = new Stack<>();
        for (int i=0; i<cad.length(); i++) {
            char caracter=cad.charAt(i);
            if (caracter == '(' || caracter == '{' || caracter == '[') {
                pila.push(caracter);
            } else {
                if (pila.isEmpty()) {
                    return false;
                }
                char apertura = pila.pop();
                if ((caracter == ')' && apertura != '(') ||
                    (caracter == '}' && apertura != '{') ||
                    (caracter == ']' && apertura != '[')) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> pilaAuxiliar = new Stack<>();
        while (!pila.isEmpty()) {
            int ord = pila.pop();
            while (!pilaAuxiliar.isEmpty() && pilaAuxiliar.peek() < ord) {
                pila.push(pilaAuxiliar.pop());
            }
            pilaAuxiliar.push(ord);
        }
        List<Integer> listaOrdenada = new ArrayList<>();
        while (!pilaAuxiliar.isEmpty()) {
            listaOrdenada.add(pilaAuxiliar.pop());
        }
        return listaOrdenada;
      
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
    LinkedList<Integer> pares = new LinkedList<>();
    LinkedList<Integer> impares = new LinkedList<>();
        for (int i=0; i < original.size(); i++) {
            int num = original.get(i);
            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }
        LinkedList<Integer> resultado = new LinkedList<>();
        resultado.addAll(pares);
        resultado.addAll(impares);
        return resultado;
    }
}
//* */
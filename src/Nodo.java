/**
 * 
 * @author Luis Diego Fernandez
 * @version 22.03.17
 * Clase del objeto Nodo
 *
 */
public class Nodo <Letra extends Comparable> implements Comparable {
	
	private Letra Valor;
	private Nodo Izquierdo;
	private Nodo Derecho;
	
	/**
	 * Inicializador
	 * @param valor
	 */
	public Nodo(Letra valor){
		Valor = valor;
	}
	
	/**
	 * Devuleve valor del nodo.
	 * @return Valor del nodo.
	 */
	public Letra getValor() {
		return Valor;
	}
	
	/**
	 * SetValor
	 * @param valor
	 */
	public void setValor(Letra valor) {
		Valor = valor;
	}
	
	/**
	 * Devuleve nodo izquierdo.
	 * @return Nodo Izquiedo.
	 */
	public Nodo getIzquierdo() {
		return Izquierdo;
	}
	
	/**
	 * Set Nodo izq
	 * @param izquiedo
	 */
	public void setIzquierdo(Nodo izquierdo) {
		Izquierdo = izquierdo;
	}
	
	/**
	 * Devuleve nodo derecho.
	 * @return Nodo derecho.
	 */
	public Nodo getDerecho() {
		return Derecho;
	}
	
	/**
	 * Set nodo derecho.
	 * @param derecho
	 */
	public void setDerecho(Nodo derecho) {
		Derecho = derecho;
	}
	
	/**
	 * toString
	 */
	public String toString(){
		return Valor.toString();
	}


	public int compareTo(Nodo<Letra> other) {
		
		return Valor.compareTo((other.getValor())) * -1;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		
		try {
			
			Nodo comparable = (Nodo) o;
			
			return Valor.compareTo(comparable.getValor()) * -1;
			
			
		} catch (Exception e) {
			
			return 1;
		}
		
		
	}

	

}

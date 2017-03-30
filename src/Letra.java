/**
 * 
 * @author Luis Diego Fernandez
 * @version 29.3.17
 *
 */
public class Letra implements Comparable <Letra>{
	
	
	private String Caracter;
	private int Frecuencia;
	
	/**
	 * Metodo para inicializar los atributos segun los parametros enviados.
	 * @param caracter , String con el caracter ingresado.
	 * @param frecuencia , int de veces que el caracter se encuentra en el mensaje.
	 */
	public Letra(String caracter, int frecuencia){		
		setCaracter(caracter);
		setFrecuencia(frecuencia);	
	}
	
	/**
	 * Metodo para devolver el caracter.
	 * @return Caracter
	 */
	public String getCaracter() {
		return Caracter;
	}
	
	/**
	 * Metodo para establecer el caracter.
	 * @param caracter
	 */
	public void setCaracter(String caracter) {
		Caracter = caracter;
	}
	
	/**
	 * Metodo para devolver la frecuencia.
	 * @return Frecuencia
	 */
	public int getFrecuencia() {
		return Frecuencia;
	}

	/**
	 * Metodo para establecer la frecuencia.
	 * @param frecuencia
	 */
	public void setFrecuencia(int frecuencia) {
		Frecuencia = frecuencia;
	}
	
	@Override
	/**
	 * Metodo para comparar a otro objeto de tipo Letra.
	 * @param Letra
	 */
	public int compareTo(Letra other) {
		
		
		if(this.equals(other))
			return 0;
		
		else if (Frecuencia > other.getFrecuencia()){
			return 1;  
		}
		
		else 
			return -1;
			
	}	
	
	/**
	 * Metodo toString para devolver los atributos de la clase ordenadamente.
	 */
	public String toString(){
		return ("Caracter " + Caracter + " Frecuencia " + Frecuencia + "|");
	}
	
}

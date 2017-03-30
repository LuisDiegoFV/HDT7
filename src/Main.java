import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		
		//PriorityQueues a utilizar. PQ para el el heap que guarda todos los objetos de clase Letra que se estaran eviando a BinTree, y pqForesta para la implementacion del
		//heap que contiene los nodos del arbol binario.
		
		PriorityQueue<Letra> pq = new PriorityQueue<Letra>();
		PriorityQueue<Nodo> pqForesta = new PriorityQueue<Nodo>();
		
		//Objeto de clase BinTree que se utilizara para crear la foresta y ordenar el arbol.
		
		BinTree bTree = new BinTree();
		
		System.out.println("Porfavor ingrese frase a utilizar:");
		String cadena = teclado.nextLine();
		
		//String con caracteres que ya fueron ingresados.
		
		String carUsados = "";
		
		//Se ingresan los objetos de clase Letra con su respectivos atributos segun la cadena de caracteres ingresada por el usuario.
		
		for (int i = 0; i < cadena.length(); i++){
			
			int frecuencia = 0;
			boolean repetida = false;
			
			for (int j = 0; j < carUsados.length(); j++){
				
				if (cadena.substring(i, i+1).equals(carUsados.substring(j,j+1)))
						repetida = true;
				
			}
			
			if (!repetida){
				
				carUsados = carUsados + cadena.substring(i,i+1);
				
				for (int k = i; k < cadena.length(); k++){
					
					if (cadena.substring(i,i+1).equals(cadena.substring(k,k+1)))
						frecuencia++;
						
						
				}
				
				Letra letraTemp = new Letra(cadena.substring(i,i+1), frecuencia);
				pq.add(letraTemp);
			}
			
			
		}
		
		
		//Se hace el arbol binario y ademas se devuelve una PriorityQueue con la foresta de arboles binarios intermedios.
		
		pqForesta = bTree.AgregarPQ(pq);
		
		//Se usa el metodo printInOrder de la clase de arbolBinario para poder obtener los caracteres de manera ordenada.
		
		String resultado = bTree.printInOrder();
		
		//Arrays a utilizar
		ArrayList cortes = new ArrayList();
		ArrayList arrayCodigos = new ArrayList();
		
		cortes.add(0);
		
		for (int i = 0; i < resultado.length(); i++){
			
			if (resultado.substring(i, i+1).equals("|"))
					cortes.add(i);
			
		}
		
		int pushInicial = 0;
		String codigo = "0";
		
		//Se imprime los caracteres con sus frecuencias y se crean los codigos para cada uno de estos.
		
		while (!cortes.isEmpty()){
			
			System.out.print(resultado.substring((int)cortes.get(0) + pushInicial, (int)cortes.get(1)) + " Codigo ");	
			cortes.remove(0);
			cortes.remove(0);
			
			
			if (cortes.isEmpty()){
				
				codigo = codigo.substring(0, codigo.length() - 2) + "1";
				System.out.println(codigo);
				arrayCodigos.add(codigo);
				
			}
			
			else {
				
				System.out.println(codigo);
				arrayCodigos.add(codigo);
				codigo = "1" + codigo;
				
			}
			
			pushInicial = 2;
			
		}
		
		//Se le permite a al usuario ingresar codigos.
		System.out.println("");
		System.out.println("Ingrese una frase utilizando el codigo desplegado (unicamente los codigos habilitados y separados por espacio cada codigo)");
		String cadenaCodigos = teclado.nextLine();
		
		//Arrays a utilizar
		ArrayList codigosSeparados = new ArrayList();
		ArrayList cortesCodigos = new ArrayList();
		cortesCodigos.add(0);

		for (int i = 0; i < cadenaCodigos.length(); i++){
			
			if (cadenaCodigos.substring(i, i+1).equals(" "))
				cortesCodigos.add(i);
			
		}
		
		boolean first = true;
		
		while (!cortesCodigos.isEmpty()){
			
			if (cortesCodigos.size() == 1 && first)
				codigosSeparados.add(cadenaCodigos);	
			
			else if (first)
				codigosSeparados.add(cadenaCodigos.substring((int)cortesCodigos.get(0), (int)cortesCodigos.get(1)));
			
			else if (cortesCodigos.size() == 1)
				codigosSeparados.add(cadenaCodigos.substring((int)cortesCodigos.get(0) + 1));
			
			else
				codigosSeparados.add(cadenaCodigos.substring((int)cortesCodigos.get(0) + 1 , (int)cortesCodigos.get(1)));
			
			first = false;
			
			cortesCodigos.remove(0);
			
		}
				
		String resultados = "";
		
		//Se imprime las letras ingresadas por el usuario en forma de codigos y se le menciona aquellos codigos no aceptados.
		
		while (!codigosSeparados.isEmpty()){
			
			boolean codigoAceptado = false;
			
			for (int i = 0; i < arrayCodigos.size(); i++){
				
				if (codigosSeparados.get(0).equals(arrayCodigos.get(i))){
					
						codigoAceptado = true;
						
				}
			}
			
			if (codigoAceptado){
				
				String codigoTemp = (String) codigosSeparados.get(0);
				int numeroArbol = 0;
				int dirRama = 0;
				
				while (codigoTemp.length() != 0){

					if (codigoTemp.length() == 1){
						
						dirRama = Integer.parseInt(codigoTemp.substring(0));
						
					}
					
					else {
						
						numeroArbol++;
						
					}
					
					codigoTemp = codigoTemp.substring(1);
					
				}
				
				Nodo nodoAct = pqForesta.peek();
				
				while (numeroArbol != 0) {
					
					nodoAct = nodoAct.getDerecho();
					
					numeroArbol --;
					
				}
				
				if (dirRama == 0)
					nodoAct = nodoAct.getIzquierdo();
				
				else 
					nodoAct = nodoAct.getDerecho();
				
				try {
				
					Letra caracter = (Letra) nodoAct.getValor();
					resultados = resultados + caracter.getCaracter() + " ";
					
				} catch (Exception E){
					
					
				}
				
				
				
			}
			
			else {
				System.out.println(codigosSeparados.get(0) + " No es un codigo aceptado");
			}
			
			codigosSeparados.remove(0);
		}
		
		//Se despliagan los resultados
		System.out.println(resultados);
		
		//Se termina el programa
		System.out.println("");
		System.out.println("Programa Finalizado...");
	}

}

import java.util.PriorityQueue;

/**
 * 
 * @author Luis Diego Fernandez
 * @version 22.03.17
 * Clase Tree para formar un BST (Binary Search Tree) con los metodos para devolver Strings con el post-order, in-order y pre-order.
 *
 */
public class BinTree <T extends Comparable> {
	
	private Nodo<Letra> Root;
	private PriorityQueue<Letra> pq;
	private PriorityQueue<Nodo> retPQ;
	
	
	
	public PriorityQueue AgregarPQ (PriorityQueue<Letra> priority){
		
		retPQ = new PriorityQueue<Nodo>();
		
		if (priority.size() == 1){
			Root = new Nodo(priority.remove());
			retPQ.add(Root);
		}
		
		else{
			Nodo<Letra> nodoTemp2 = new Nodo(priority.remove());
			Nodo<Letra> nodoTemp1 = new Nodo(priority.remove());
			
			int valorRoot = nodoTemp1.getValor().getFrecuencia() + nodoTemp2.getValor().getFrecuencia();
			
			Letra letraTemp = new Letra("zz", valorRoot);
			Nodo<Letra> nodoRoot1 = new Nodo(letraTemp);
			
			nodoRoot1.setDerecho(nodoTemp2);
			nodoRoot1.setIzquierdo(nodoTemp1);
			
			Nodo<Letra> rootAct = nodoRoot1;
			
			while (!priority.isEmpty()){
				
				retPQ.add(rootAct);
				
				Nodo<Letra> nodoTemp3 = new Nodo(priority.remove());
				
				int valorNewRoot = nodoTemp3.getValor().getFrecuencia() + rootAct.getValor().getFrecuencia();
				Letra letraTemp2 = new Letra("zz", valorNewRoot);
				Nodo<Letra> rootTemp2 = new Nodo(letraTemp2);
				
				rootTemp2.setDerecho(rootAct);
				rootTemp2.setIzquierdo(nodoTemp3);
				
				
				rootAct = rootTemp2;
				
			}
			
			Root = rootAct;
			
			retPQ.add(rootAct);
			
			
		}
		
		return retPQ;
		
	}
	
	/**
	 * Devuelve un String con el BST ordenado  en in-order.
	 * @return String con BST ordenado en in-order.
	 */
	public String printInOrder(){
		return inOrder(Root);
	}
	
	/**
	 * Metodo recursivo para ordenar el BST en in-order.
	 * @param Padre , Nodo padre
	 * @return String con valores ordenados.
	 */
	private String inOrder (Nodo Padre){
		
		StringBuilder sb = new StringBuilder();
		
		if (Padre == null)
			return "";
		
		if (Padre.getIzquierdo() != null){
			sb.append(inOrder(Padre.getIzquierdo()));
			sb.append(",");
		}
		
		sb.append(Padre);
		
		if (Padre.getDerecho() != null){
			sb.append(",");
			sb.append(inOrder(Padre.getDerecho()));
		}
		
		return sb.toString();
			
	}
	
}
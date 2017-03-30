/**
 * 
 * @author Luis Diego Fernandez
 * @version 22.03.17
 * Clase Tree para formar un BST (Binary Search Tree) con los metodos para devolver Strings con el post-order, in-order y pre-order.
 *
 */
public class Tree <T extends Comparable> {
	
	private Nodo Root;
	
	/**
	 * Metodo para agregar un valor generico a un BST.
	 * @param valor , Argumento generico con el valor para ingresar en los nodos.
	 */
	public void Agregar (T valor) {
		if (Root == null)
			Root = new Nodo(valor);
		
		else {
			 
			Nodo NodoActual = Root;
			while (NodoActual != null){
				
				if (NodoActual.compareTo(valor) > 0){
					if (NodoActual.getIzquierdo() == null){
						NodoActual.setIzquierdo(new Nodo(valor));
						return;
					}
					
					else
						NodoActual = NodoActual.getIzquierdo();
				}
				
				else if (NodoActual.compareTo(valor) < 0){
					if (NodoActual.getDerecho() == null){
						NodoActual.setDerecho(new Nodo(valor));
						return;
					}
					
					else
						NodoActual = NodoActual.getDerecho();
				}
			}
			
		}
	}
	
	/**
	 * Devuelve un String con el BST ordenado  en pre-order.
	 * @return String con BST ordenado en pre-order.
	 */
	public String printPreOrder(){
		return preOrder(Root);
	}
	
	/**
	 * Devuelve un String con el BST ordenado  en post-order.
	 * @return String con BST ordenado en post-order.
	 */
	public String printPostOrder(){
		return postOrder(Root);
	}
	
	/**
	 * Devuelve un String con el BST ordenado  en in-order.
	 * @return String con BST ordenado en in-order.
	 */
	public String printInOrder(){
		return inOrder(Root);
	}
	
	/**
	 * Metodo recursivo para ordenar el BST en pre-order.
	 * @param Padre , Nodo padre
	 * @return String con valores ordenados.
	 */
	private String preOrder (Nodo Padre){
		
		StringBuilder sb = new StringBuilder();
		
		if (Padre == null)
			return "";
		
		sb.append(Padre);
		
		if (Padre.getIzquierdo() != null){
			sb.append(",");
			sb.append(preOrder(Padre.getIzquierdo()));
		}
		
		if (Padre.getDerecho() != null){
			sb.append(",");
			sb.append(preOrder(Padre.getDerecho()));
		}
		
		return sb.toString();
		
		
		
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
	
	/**
	 * Metodo recursivo para ordenar el BST en post-order.
	 * @param Padre , Nodo padre
	 * @return String con valores ordenados.
	 */
	private String postOrder (Nodo Padre){
		
		StringBuilder sb = new StringBuilder();
		
		if (Padre == null)
			return "";
		
		if (Padre.getIzquierdo() != null){
			sb.append(postOrder(Padre.getIzquierdo()));
			sb.append(",");
		}
		
		
		if (Padre.getDerecho() != null){
			sb.append(postOrder(Padre.getDerecho()));
			sb.append(",");
		}
		
		sb.append(Padre);
		
		return sb.toString();
			
		
	}
	
}

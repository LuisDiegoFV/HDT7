/**
 * 
 * @author Luis Diego Fernandez
 * @version 22.03.17
 * Codigo principal para probar los metodos establecidos en la clase Tree
 *
 */
public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree arbol = new Tree();
		arbol.Agregar(10);
		arbol.Agregar(11);
		arbol.Agregar(9);
		arbol.Agregar(15);
		arbol.Agregar(7);
		arbol.Agregar(21);
		arbol.Agregar(6);
		arbol.Agregar(14);
		arbol.Agregar(8);
		
		System.out.println("InOrder:");
		System.out.println(arbol.printInOrder());
		System.out.println("PreOrder:");
		System.out.println(arbol.printPreOrder());
		System.out.println("PostOrder:");
		System.out.println(arbol.printPostOrder());

	}

}

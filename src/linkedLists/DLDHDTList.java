package linkedLists;

import java.util.NoSuchElementException;

public class DLDHDTList<E> extends AbstractDLList<E> {
	private DNode<E> header, trailer; 
	private int length; 
	
	public DLDHDTList() { 
		header = null;
		header.setNext(trailer);
		trailer = null;
		trailer.setPrev(header);
		length = 0;
		// ADD CODE HERE to generate empty linked list of this type 
	}
	
	public void addFirstNode(Node<E> nuevo) {
		addNodeAfter(header, nuevo); 
	}
	
	public void addLastNode(Node<E> nuevo) { 
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = trailer.getPrev();  
		nBefore.setNext(dnuevo); 
		trailer.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(trailer); 
		length++; 
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = (DNode<E>) target; 
		DNode<E> nAfter = nBefore.getNext(); 
		nBefore.setNext(dnuevo); 
		nAfter.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(nAfter); 
		length++; 
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// ADD CODE HERE
		DNode<E> td = (DNode<E>) target;
		DNode<E> nuevoD = (DNode<E>) nuevo;
		DNode<E> prev = td.getPrev();
		
		if(target == header.getNext()) {
			nuevoD.setPrev(header);
			header.setNext(nuevoD);
			nuevoD.setNext(td);
			td.setPrev(nuevoD);
		}else {
		nuevoD.setNext(td);
		nuevoD.setPrev(prev);
		prev.setNext(nuevoD);
		td.setPrev(nuevoD);
		}
	}

	public Node<E> createNewNode() {
		return new DNode<E>();
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return header.getNext();
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return trailer.getPrev();
	}

	public Node<E> getNodeAfter(Node<E> target)
			throws NoSuchElementException {
		if(target == trailer.getPrev()) {
			throw new NoSuchElementException("no such element exists");
		}
		// ADD CODE HERE AND MODIFY RETURN ACCORDINGLY
		DNode<E> td = (DNode<E>) target;
		
		return td.getNext(); 
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		if(target == header.getNext()) {
			throw new NoSuchElementException("no such element exists");
		}
		// ADD CODE HERE AND MODIFY RETURN ACCORDINGLY
		DNode<E> td = (DNode<E>) target;

		return td.getPrev(); 
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		// ADD CODE HERE to disconnect target from the linked list, reduce lent, clean target...
		DNode<E> td = (DNode<E>) target;
		DNode<E> prev = td.getPrev();
		DNode<E> next = td.getNext();
		
		if(target == header.getNext() && target == trailer.getPrev()) {
			header.setNext(trailer);;
			trailer.setPrev(header);;
		}else if(target == trailer.getPrev()) {
			prev.setNext(trailer);
			trailer.setPrev(prev);
		}else if(target == header) {
			next.setPrev(header);
			header.setNext(next);
		}else {
			prev.setNext(next);
			next.setPrev(prev);
		}
		length --;

	}
	
	public Object[] toArray() {
		Object[] newArray = new Object[length];
		DNode<E> dn = (DNode<E>) header;
		int i = 0;
		while(i < length) {
			newArray[i] = dn.getElement();
			dn.getNext();
			i++;
		}
		return newArray;
	}


	public <T1> T1[] toArray(T1[] array) {
		DNode<E> dn = (DNode<E>) header;
		if(length<array.length) {
			for(int i = 0;i<length;i++) {
				array[i] =  (T1) dn.getElement();
				dn.getNext();
			}
			for(int i = length; i<array.length ;i++) {
				array[i] = null;
				dn.getNext();
			}
		}
		// TODO as in Exercise 3
		return array;
	}
	
	/**
	 * Prepares every node so that the garbage collector can free 
	 * its memory space, at least from the point of view of the
	 * list. This method is supposed to be used whenever the 
	 * list object is not going to be used anymore. Removes all
	 * physical nodes (data nodes and control nodes, if any)
	 * from the linked list
	 */
	private void destroy() {
		while (header != null) { 
			DNode<E> nnode = header.getNext(); 
			header.clean(); 
			header = nnode; 
		}
	}
	
	/**
	 * The execution of this method removes all the data nodes from
	 * the current instance of the list, leaving it as a valid empty
	 * doubly linked list with dummy header and dummy trailer nodes. 
	 */
	public void makeEmpty() { 
		// TODO
	}
		
	protected void finalize() throws Throwable {
	    try {
			this.destroy(); 
	    } finally {
	        super.finalize();
	    }
	}

}

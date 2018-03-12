package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		// TODO Auto-generated method stub
		SNode <E> sn = (SNode<E>) nuevo;
		sn.setNext(first);
		first = sn;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		SNode<E> ts = (SNode<E>) target;
		SNode<E> ns = (SNode<E>) nuevo;
		
		if(ts == last){
			last = ns;
		}else{
			SNode<E> next = ts.getNext();
			ns.setNext(next);
		}
		ts.setNext(ns);
		length++;

		
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		//pre: target is valid Node in 'this'
		//pre: nuevo es tipo SNdoe
			SNode<E> ts = (SNode<E>) target;
			SNode<E> ns = (SNode<E>) nuevo;
				
			ns.setNext(ts);
				
			if(ts == first){
				first = ns;
			}else{
				SNode<E> prev = (SNode<E>) first;
				while(prev!=ts){
					prev = prev.getNext();
				}
				prev.setNext(ns);
			}
			length++;
				
		
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		// TODO Auto-generated method stub
		SNode<E> ts = (SNode<E>)target;		
		
		return ts.getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		// TODO Auto-generated method stub
		SNode ts = (SNode<E>) target;
		SNode prev = (SNode<E>) first;
		
		while(prev != ts){
			prev = prev.getNext();
		}
		return prev;
	}

	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		SNode<E> ntr = (SNode<E>) target;
		SNode<E> next = ntr.getNext();
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}

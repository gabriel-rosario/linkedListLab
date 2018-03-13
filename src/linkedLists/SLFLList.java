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
import linkedLists.AbstractDLList.DNode;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		SNode <E> sn = (SNode<E>) nuevo;
		if(length == 0) {
			first = sn;
			last = sn;
			sn.setNext(null);
		}
		// TODO Auto-generated method stub
		sn.setNext(first);
		first = sn;
		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		// TODO Auto-generated method stub
		//pre: target is a valid node
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
								
			if(ts == first){
				first = ns;
			}else{
				SNode<E> prev = (SNode<E>) first;
				while(prev!=ts){
					prev = prev.getNext();
				}
				prev.setNext(ns);
			}
			
			ns.setNext(ts);
			length++;
				
		
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(length == 0) throw new NoSuchElementException("no such element exists");
		
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if(length == 0) {
			throw new NoSuchElementException("no such element exists");
		}
		// TODO Auto-generated method stub
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		if(target == last) {
			throw new NoSuchElementException("no such element exists");
		}
		// TODO Auto-generated method stub
		SNode<E> ts = (SNode<E>)target;		
		
		return ts.getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		if(target == first) {
			throw new NoSuchElementException("no such element exists");
		}
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
		SNode<E> ntr = (SNode<E>) target;
		SNode<E> next = ntr.getNext();
		SNode<E> prev = (SNode<E>) first;
		
		while(prev != ntr){
			prev = prev.getNext();
		}

		//only one node
		if (target == first && target == last) {
			first = null;
			last = null;
		}else if(target == first) {
			first = ntr.getNext();
		}else if(target == last) {
			last = prev;
		}else {
			prev.setNext(next);
		}
		length --;
		
		// TODO Auto-generated method stub
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

	public Object[] toArray() {
		Object[] newArray = new Object[length];
		SNode<E> sn = (SNode<E>) first;
		int i = 0;
		while(i < length) {
			newArray[i] = sn.getElement();
			sn.getNext();
			i++;
		}
		return newArray;
	}


	public <T1> T1[] toArray(T1[] array) {
		SNode<E> sn = (SNode<E>) first;
		if(length<array.length) {
			for(int i = 0;i<length;i++) {
				array[i] =  (T1) sn.getElement();
				sn.getNext();
			}
			for(int i = length; i<array.length ;i++) {
				array[i] = null;
				sn.getNext();
			}
		}
		return array;
	}
}

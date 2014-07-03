package demo;

import java.util.*;
/**
 * @author Macklin
 *
 */
public class MySet implements Set<Object> {
	
	
	private Object[] mySet;
	private Object[] temp;
	private int size, expand; 
	
	public MySet() {
		expand=10;
		mySet = new Object[expand];
		temp = new Object[expand*2];
		size=0; 
		
	
	}

	@Override
	public boolean add(Object arg0) {
		if (contains(arg0)==false) {
			mySet[size]=arg0;
			size++;
			
			if (size==expand){ //expand array
				expand=expand*2;
				for (int x=0 ; x<size; x++) {
					temp[x]=mySet[x]; 
				}
				mySet = new Object[expand];
				mySet=temp;
				temp = new Object [expand*2];
			}	
			return true;
		}
		else 
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Object> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		for (int x =0; x<size; x++ ) {			
			mySet[x]=null; 
		}
		size=0;
		return;


	}

	@Override
	public boolean contains(Object arg0) {
		for (int x =0; x<size; x++ ) {			
			if (arg0.equals(mySet[x])){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
		
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {

		if (contains(arg0)==false) {
			return false;}
		else {
			for (int x =0; x<size; x++ ) {			
				if (arg0.equals(mySet[x])){
					for (; x<size;x++) {
						if (x!= expand) {
							mySet[x]=mySet[x+1];
							mySet[size]=null;
							size--;
						}
					}
				}
			}
			return true;
		}
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public static void main(String []args){
		MySet s = new MySet();
		s.add(1);
		
	}

}

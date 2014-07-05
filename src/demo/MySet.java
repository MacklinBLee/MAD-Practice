package demo;

import java.util.*;
/**
 * @author Macklin
 *
 */
public class MySet implements Set<Object> {
	
	
	private Object[] mySet;
	
	private int size;
	
	public MySet() {
		mySet = new Object[10];
		size=0; 
		
	
	}



	public void expand() {
		if (size==mySet.length){ //expand array
			Object[] temp = new Object[size*2];
			for (int x=0 ; x<size; x++) {
				temp[x]=mySet[x]; 
			}
			int expand =size*2;
			mySet = new Object[expand];
			mySet=temp;
		} else {
			return;
		}
	}

	@Override
	public boolean add(Object arg0) {

		if (contains(arg0)==false) {
			expand();//expand 
			mySet[size]=arg0;
			size++;
			return true;
		} else {
			return false;
		}
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

		if (contains(arg0)==true) {
			for (int x =0; x<size; x++ ) {			
				if (arg0.equals(mySet[x])){
					mySet[x]=mySet[size];
					size--;
					return true;	
				}
			}
		}
		return false;
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

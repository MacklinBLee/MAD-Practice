package mad;

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
		size = 0; 
	}

	public void expand() {
		Object[] temp = new Object[size*2];
		for (int x = 0 ; x<size; x++) {
			temp[x] = mySet[x]; 
		}
		mySet = new Object[size*2];
		mySet = temp;
	}

	@Override
	public boolean add(Object arg0) {
		if (arg0 == null) return false;
		if (! contains(arg0)) {
			if (size == mySet.length) expand();//expand 
			mySet[size] = arg0;
			size++;
			return true;
		}
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
	}

	@Override
	public boolean contains(Object arg0) {
		if (search(arg0) == null) return false;
		return true;
	}

	@Override
	public boolean remove(Object arg0) {
		Integer index = search (arg0);
		if (index == null) return false;
		mySet[index] = mySet[size];
		size--;
		return true;
	}

	private Integer search (Object arg0) {
		if (arg0 == null) return null;
		for (int x = 0; x<size; x++) {
			if (arg0.equals(mySet[x])) {
				return x;
			}
		}
		return null;

	}
	
	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
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

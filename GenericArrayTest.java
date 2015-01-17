package AdtArraylist;


import java.util.Arrays;

public class GenericArrayTest<T> {
	T[] array;
	int count = 0;

	@SuppressWarnings("unchecked")
	public GenericArrayTest() {
		array = (T[]) new Object[20];
	}

	public T get(int index) {
		if (index < count) {
			return array[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void addEnd(T t) {
		if (array.length - count <= 5) {
			increaseListSize();
		}
		array[count++] = t;
	}
	public void addIndex(T t, int index){
		if (array.length - count <= 5) {
			increaseListSize();
		}
		array[index] = t;
		}
		
	

	public T remove(int index) {
		if (index < count) {
			T t = array[index];
			array[index] = null;
			int tmp = index;
			while (tmp < count) {
				array[tmp] = array[tmp + 1];
				array[tmp + 1] = null;
				tmp++;
			}
			count--;
			return t;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
public int size(){
	return count;
}
	private void increaseListSize() {
		// TODO Auto-generated method stub
		array = Arrays.copyOf(array, array.length * 2);
		System.out.println("\nNew length: " + array.length);
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		GenericArrayTest k = new GenericArrayTest();
		 k.addEnd(new Integer(666));
		k.addEnd(56);
		k.addEnd(117);
		k.addEnd(785);
		k.addEnd(34);
		k.addEnd(8);
		k.addEnd(98);
		k.addIndex(3, 2);
		k.addIndex(new String("abc"), 3);

		for (int i = 0; i < k.size(); i++) {
			System.out.println(k.get(i) + "  ");
		}
	}


}
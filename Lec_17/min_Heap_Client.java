package Lec_17;

public class min_Heap_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Min_Heap m =new Min_Heap();
		
		m.add(3);
		m.add(2);
		m.add(1);
		
		System.out.println(m.remove());
		System.out.println(m.remove());
		System.out.println(m.remove());
	}

}

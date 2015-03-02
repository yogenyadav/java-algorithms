public class BitwiseMasking {

	public static void main(String[] args) {
		//ANDing to extract
		int value = 0x01020304;
		System.out.println("value: " + value);
		int mask = 0x000000ff;
		System.out.println("mask: " + mask);

		int byte1 = (value >> 24);
		System.out.println("byte1: " + byte1);
		System.out.println("value: " + value);

		int byte2 = (value >> 16) & mask;
		System.out.println("byte2: " + byte2);
		System.out.println("value: " + value);

		int byte3 = (value >> 8) & mask;
		System.out.println("byte3: " + byte3);
		System.out.println("value: " + value);

		int byte4 = value & mask;
		System.out.println("byte4: " + byte4);
		System.out.println("value: " + value);
		
		//XORing to toggle
		mask = 0x000000FF;
		value = 0x00000012;
		System.out.println("value: " + value);
		
		value = value ^ mask;
		System.out.println("toggled value: " + value);
		value = value ^ mask;
		System.out.println("toggled value: " + value);
	}
}

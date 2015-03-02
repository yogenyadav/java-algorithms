package datastructs.list;

public interface CustomLinkedList {
    // inserts the object in the specified index of the list
    void insert(int index, Object object);

    // inserts the object at the end of the list
    void insert(Object object);

    // returns the element in the middle of the list
    Object middleElement();

    // determines if the list has a loop  (i.e, A -> B -> C -> D -> B)
   boolean hasLoop();
    
    // reverses the linked list
    void reverse();
    
	public void print();

	void createLoop();
	
	public ListNode getListNode();
	
	public static class ListNode {
		public ListNode(Object object) {
			data = object;
			next = null;
		}
		public Object data;
		public ListNode next;
	}
}

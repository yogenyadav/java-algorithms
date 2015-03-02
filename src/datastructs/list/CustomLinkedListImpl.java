package datastructs.list;


public class CustomLinkedListImpl implements CustomLinkedList {
	private ListNode head;
	private ListNode tail;
	private int length = 0;
	
	@Override
	public void insert(int index, Object object) {
		ListNode node  = new ListNode(object);
		if(length == 0)
			this.insert(object);
		else{
			ListNode nodeBeforeIndex = getNodeAtIndex((index - 1));
			ListNode nodeAtIndex = nodeBeforeIndex.next;
			node.next = nodeAtIndex;
			nodeBeforeIndex.next = node;
			length++;
		}
	}

	@Override
	public void insert(Object object) {
		length++;
		ListNode node  = new ListNode(object);
		if(head == null){
			head = tail = node;
		}else{
			tail.next = node;
			tail = node;
		}
	}

	@Override
	public Object middleElement() {
		int mid = length/2;
		return getNodeAtIndex(mid).data;
	}

	@Override
	public boolean hasLoop() {
		ListNode node = head;
		ListNode slowRunner = head;
		ListNode fastRunner = head;
		while(true){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next !=null ? fastRunner.next.next : null;
			if(slowRunner == null || fastRunner == null)
				break;
			if(slowRunner == fastRunner){
				System.out.println("meeting point: " + slowRunner.data);
				return true;
			}
		}
		return false;
	}

	@Override
	public void reverse() {
		reverseList(head);
		ListNode tempTail = tail;
		tail = head;
		tail.next = null;
		head = tempTail;
	}

	@Override
	public void createLoop() {
		tail.next = getNodeAtIndex(12);
	}

	@Override
	public void print(){
		ListNode node = head;
		int idx = 1;
		while(node != null){
			System.out.println(idx + " " + node.data);
			node = node.next;
			idx++;
		}
	}
	
	@Override
	public ListNode getListNode() {
		return head;
	}


	private ListNode reverseList(ListNode node){
		if(node.next == null)
			return node;
		ListNode n = reverseList(node.next);
		n.next = node;
		return node;
	}
	
	private ListNode getNodeAtIndex(int index){
		ListNode nodeAtIndex = head;
		int idx = 1;
		while(idx != index){
			nodeAtIndex = nodeAtIndex.next;
			idx++;
		}
		return nodeAtIndex;
	}
	
	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedListImpl();
		list.insert("a");
		list.insert("b");
		list.insert("c");
		list.insert("d");
		list.insert("e");
		list.insert("f");
		list.insert("g");
		list.insert("h");
		list.insert("i");
		list.insert("j");
		list.insert("k");
		list.print();
		
		list.reverse();
		list.print();
		
		list.insert(9, "l");
		list.insert(3, "m");
		list.insert(8, "n");
		list.insert(4, "o");
		list.print();
		
		System.out.println(list.middleElement());
		
		list.reverse();
		list.print();
		
		//list.createLoop();
		System.out.println(list.hasLoop());
	}
}

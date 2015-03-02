package algo;

import datastructs.list.CustomLinkedList;
import datastructs.list.CustomLinkedListImpl;
import datastructs.list.CustomLinkedList.ListNode;

public class FindKthFromLastFromList {

	public static ListNode find(ListNode head, int k){
		ListNode n = head;
		ListNode m = null;
		int i = 0;
		if(k == i){
			m = head;
		}
		while(n != null){
			n = n.next;
			i++;
			if(m != null){
				m = m.next;
			}else if(k == i){
				m = head;
			}
		}
		return m;
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
		ListNode n = FindKthFromLastFromList.find(list.getListNode(), 8);
		System.out.println("6th from last: " + n.data);
	}
}

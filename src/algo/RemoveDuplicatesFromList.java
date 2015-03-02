package algo;

import java.util.HashSet;
import java.util.Set;

import datastructs.list.CustomLinkedList;
import datastructs.list.CustomLinkedList.ListNode;
import datastructs.list.CustomLinkedListImpl;

public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedListImpl();
		list.insert("a");
		list.insert("b");
		list.insert("c");
		list.insert("d");
		list.insert("e");
		list.insert("f");
		list.insert("f");
		list.insert("g");
		list.insert("h");
		list.insert("i");
		list.insert("j");
		list.insert("j");
		list.insert("k");
		list.print();

		ListNode nextNode = list.getListNode();
		ListNode prevNode = list.getListNode();
		Set<Object> s = new HashSet<Object>();
		while(nextNode != null){
			if(s.contains(nextNode.data)){
				prevNode.next = nextNode.next;
				nextNode = nextNode.next;
			}else{
				s.add(nextNode.data);
				prevNode = nextNode;
				nextNode = nextNode.next;
			}
		}
		list.print();
	}
}

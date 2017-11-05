package DLL;

public class DLL <T extends Comparable<T>>{
	private class DLLNode{
		public final T data;
		public DLLNode next; 
		public DLLNode prev; 
		
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode){
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
		
	}
	
	private DLLNode head , tail;
	
	public boolean isEmpty(){
		if(this.head == null)
			return true;
		
		return false;
	}
	
	public void insertBefore(int pos, T data){
		DLLNode temp = new DLLNode(data,null,null);
		
		if(this.isEmpty()== true){
			this.head = temp; 
			this.tail = temp; 
			return; 
		}
		
		if(pos <= 0){
			temp.next = head;
			head.prev = temp; 
			this.head = temp;
			return;
		}
		
		int counter =0; 
		temp = this.head;
		while(counter < pos){
			if(temp.next == null){
				DLLNode insertNode = new DLLNode(data,null,null);
				this.tail.next = insertNode;
				insertNode.prev = this.tail; 
				this.tail= insertNode;
				return;
			}
			
			temp = temp.next;
			counter++;
		}
		
		DLLNode insertNode = new DLLNode(data,null,null);
		DLLNode beforeNode = temp.prev; 
		beforeNode.next = insertNode;
		insertNode.prev = beforeNode;
		temp.prev = insertNode;
		insertNode.next = temp;
		
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next) {
			if (!isFirst) {
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}
	
	public static void main(String[] args){
		DLL Dlist = new DLL();
		Dlist.insertBefore(0, 10);
		Dlist.insertBefore(0, 50);
		Dlist.insertBefore(0, 70);
		Dlist.insertBefore(1, 100);
		Dlist.insertBefore(3, 200);
		Dlist.insertBefore(-5, 1000);
		Dlist.insertBefore(100, 2000);





		System.out.println(Dlist.toString());

	}
	
}

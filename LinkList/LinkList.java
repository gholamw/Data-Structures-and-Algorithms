package LinkList;

public class LinkList {
	class LLNode{
		public int data;
		public LLNode next;
		
		public LLNode(int d, LLNode nxt){data = d; next = nxt; }
		
	}
	
	private LLNode head;

	
	public boolean isEmpty(){
		if(this.head == null)
			return true;	
		return false;			
	}
	
	public void insert(int data){
		enqueue(data);
	}
	
	
	public void insertLast(LLNode hed, int data){
		LLNode temp = hed;
		LLNode nodeToInsert = new LLNode(data,null);
		if(this.isEmpty()){
			this.head = nodeToInsert;
			return;
		}
		
		
		while(temp.next != null){
			temp = temp.next; 
		}
		temp.next = nodeToInsert;
	}
	
	public boolean deleteSecond(LLNode hed, int sum){
		int counter = 0;
		int counterMovement =0;
		
		if(this.isEmpty()){
			return false;
		}
	
	LLNode temp = this.head;
	LLNode temp1 = this.head;
	
	while(temp != null){

		if(temp.data == sum)
			counter++;
		
		if(counter == 2){
			break;
		}
		
		temp = temp.next;
		if(counterMovement != 0)
			temp1 = temp1.next;
		
		counterMovement++;	
	}
	
	if(counter == 2){
		LLNode temp3;
		temp3 = temp.next;
		temp1.next = temp3;
		temp.next = null;
		temp = null;
		return true;
	}
	
	return false;
}
	
	
	public void enqueue(int data){
		LLNode temp = new LLNode(data,null);
		if(this.isEmpty()){
			this.head = temp;
			return; 
		}
		
		temp.next = this.head; 
		this.head = temp;
		
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

		// iterate over the list, starting from the head
		for (LLNode iter = head; iter != null; iter = iter.next) {
			if (!isFirst) {
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data);
		}

		return s.toString();
	}
	
	
	
	public void insertBefore(LLNode head, int index, int data)
	{
		LLNode temp = head;
		int counter = 0;
		while(counter < index)
		{
			if(temp.next == null)
			{
				insert(data);
				return;
			}

			temp = temp.next;
			counter++;
		}
		
		LLNode newNode = new LLNode(data, temp.next);
		temp.next = newNode;
	}
	
	public void appendIfNew(LLNode head, int num){
		if(this.head == null){
			this.head = new LLNode(num, null);
			return;
		}
		LLNode temp = this.head;
		while(temp.next != null){
			if(temp.next.data == num)
				return;
			
			temp = temp.next;
		}
		
		temp.next = new LLNode(num, null);
	}
	
	
	
	public static void main(String[] args){
		LinkList list = new LinkList();
		list.insert(10);
		list.insert(4);
		list.insert(17);
		list.insertLast(list.head, 1000);
		list.insert(4);
		list.insertLast(list.head, 2000);
		list.insertLast(list.head, 2000);

		
		System.out.println(list.toString());
		list.deleteSecond(list.head, 4);
		System.out.println(list.toString());
		list.insert(4);
		System.out.println(list.toString());
		list.deleteSecond(list.head, 4);
		System.out.println(list.toString());
		list.deleteSecond(list.head, 2000);
		System.out.println(list.toString());
		list.deleteSecond(list.head, 55);
		System.out.println(list.toString());
		list.insertBefore(list.head, 2, 5000);
		System.out.println(list.toString());
		list.appendIfNew(list.head, 6000);
		System.out.println(list.toString());
		list.appendIfNew(list.head, 6000);
		System.out.println(list.toString());















	}

}

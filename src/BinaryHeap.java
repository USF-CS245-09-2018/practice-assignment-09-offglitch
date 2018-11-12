public class BinaryHeap {
	private int[] heap;
	private int size;

	public BinaryHeap() {
		size = 0;
		heap = new int[10];
	}

	public void swap(int [] heap, int pos1, int pos2) {
		int tmp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = tmp;
	}

	public void add(int elem) {
		if(size >= heap.length){
			grow_array();
		}
		
		heap[size] = elem;
		++size;
		int idx = size -1;
		int root = (idx-1)/2;

		while (idx > 0 && heap[idx] < heap[root]) {
			swap(heap, idx, root);
			idx=root;
			root = (idx-1)/2;
		}
	}

	public int remove() {
		int tmp = heap[0];
		heap[0] = heap[size-1];
		--size;
		pushdown(0);
		return tmp;
	}

	public void pushdown(int position) {
		int child = position*2+1;
		
		if(child >= size) {
			return;
		}
		
		if(heap[child+1] < heap[child]) {
			child++;
		}
		
		if(heap[child] < heap[position]) {
			swap(heap, child, position);
			pushdown(child);
		}
	}
	
	public void grow_array(){
		int[] newArray = new int[heap.length*2];
		for(int i = 0; i < heap.length; i++){
			newArray[i] = heap[i];
		}
		heap = newArray;
		
	}

}
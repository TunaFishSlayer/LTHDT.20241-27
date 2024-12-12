package datastructure;

public class List extends Datastructure {

    // constructor
    public List(int capacity) {
        super(capacity);
    }

    // utility function
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    // insert at index
    public void insertAt(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if (isFull()) {
            resize(); 
        }
        // dịch các phần tử sang phải để tạo chỗ cho phần tử mới
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
         size ++;
    }

    // delete at index
    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        // dịch các phẩn tử sang trái để đè lên các phần tử cũ và xoá phần tử cần xoá
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = 0; 
        size --;
    }

    @Override
    // create
    public void create(){
        elements = new int[capacity];
        size = 0;
    }

    // insert at the end
    public void insert(int element) {
       if (isFull()) {
            resize(); 
        }
        elements[size] = element;
        size++;
    }

    // remove a matching element
    public void delete(int element) {
        int index = find(element);
        if (index == -1) {
            throw new IllegalArgumentException("Element " + element + " not found in the list");
        }
        deleteAt(index);
    }

    // display 
    public String display() {
        if (size == 0) {
            return "List is empty.";
        }
        StringBuilder result = new StringBuilder("List: ");
        for (int i = 0; i < size; i++) {
            result.append(elements[i]).append(" ");
        }
        return result.toString().trim(); 
    }
    
    // sort 
    public void sort() {
        if (size  <= 1) return; 
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    // find
    public int find(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i; // trả về vị trí tìm được phần tử
            }
        }
        return -1; // không tìm thấy
    }
}

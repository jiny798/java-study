//package Algorithm.MyLinkedList;
//
//public class DLinkedList implements List {
//    private Node<E> head;
//    private Node<E> tail;
//    private int size;
//
//    public DLinkedList(){
//        this.head = null;
//        this.tail = null;
//        this.size = 0;
//    }
//
//    //특정 위치의 노드를 반환하는 메소드
//    private Node<E> search(int index){  // 1 2 3 4 5 6 7 8 9 10
//        if(index < 0 || index >= size){
//            throw new IndexOutOfBoundsException();
//        }
//
//        //뒤에서부터 검색  index 8 일경우
//        if(index + 1 > size/2 ){
//            Node<E> x = tail; // 10
//            for(int i = size - 1 ; i>index;i--){
//                x = x.prev;
//            }
//            return x;
//        }else {
//            Node<E> x = head;
//            for (int i =0 ;i<index ; i++){
//                x = x.next;
//            }
//            return x;
//        }
//    }
//    public void addFirst(E value){
//        Node<E> newNode = new Node<E>(value);
//        newNode.next = head;
//
//        if(head != null){
//            head.prev = newNode;
//        }
//        head = newNode;
//        size++;
//
//        if(head.next == null){
//            tail = head;
//        }
//    }
//
//    public boolean add(E value){
//        addLast(value);
//        return true;
//    }
//
//    public void addLast(E value){
//        Node<E> newNode = new Node<E>(value);
//
//        if(size ==0){
//            addFirst(value);
//            return;
//        }
//
//        tail.next = newNode;
//        newNode.prev = tail;
//        tail = newNode;
//        size++;
//    }
//
//    public void add(int index,E value){
//        if( index > size || index < 0){
//            throw new IndexOutOfBoundsException();
//        }
//        if(index == 0){
//            addFirst(value);
//            return;
//        }
//
//        if(index == size){
//            addLast(value);
//            return;
//        }
//
//        Node<E> prev_Node = search(index - 1);
//        Node<E> next_Node = prev_Node.next;
//
//        Node<E> newNode = new Node<E>(value);
//
//        //링크 끊기
//        prev_Node.next = null;
//        next_Node.prev = null;
//
//        //링크 연결하기
//        prev_Node.next = newNode;
//
//        newNode.prev = prev_Node;
//        newNode.next = next_Node;
//
//        next_Node.prev = newNode;
//        size++;
//
//    }
//
//
//
//}

import java.util.*;

class Node<T> {
    T data;
    Node<T> left, right;
    Node<T> next;

    public Node(T item) {
        data = item;
        left = right = null;
    }

    public Node(String data) {
        this.data = (T) data;
        this.next = null;
    }
}
class Queue<T> {
    Node<T> front, rear;

    public Queue() {
        front = rear = null;
    }

    // Metode untuk menambah elemen ke dalam antrian
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Metode untuk menghapus elemen dari antrian
    public T dequeue() {
        if (front == null) {
            return null;
        }
        T item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Stack<T> {
    Node<T> top;

    public Stack() {
        top = null;
    }

    // Metode untuk menambah elemen ke dalam tumpukan
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    // Metode untuk menghapus elemen dari tumpukan
    public T pop() {
        if (top == null) {
            return null;
        }
        T item = top.data;
        top = top.next;
        return item;
    }
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}

class LinkedList<T> {
    Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(String data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked List kosong.");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Metode static untuk menggabungkan dua LinkedList
    public static <T> LinkedList<T> merge(LinkedList<T> list1, LinkedList<T> list2) {
        LinkedList<T> mergedList = new LinkedList<>();

        Node<T> current1 = list1.head;
        while (current1 != null) {
            mergedList.insert(String.valueOf(current1.data));
            current1 = current1.next;
        }

        Node<T> current2 = list2.head;
        while (current2 != null) {
            mergedList.insert(String.valueOf(current2.data));
            current2 = current2.next;
        }

        return mergedList;
    }

    // Metode static untuk mencari panjang LinkedList
    public static <T> int length(LinkedList<T> list) {
        int count = 0;
        Node<T> current = list.head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public void remove(T value) {
        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.data.equals(value)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev != null) {
                prev.next = current.next;
            } else {
                head = current.next;
            }
        }
    }
    // Metode static untuk melakukan pengurutan menggunakan Insertion Sort
    public static <T extends Comparable<T>> LinkedList<T> insertionSort(LinkedList<T> list) {
        LinkedList<T> sortedList = new LinkedList<>();
        Node<T> current = list.head;

        while (current != null) {
            Node<T> next = current.next;
            insertSorted(sortedList, current.data);
            current = next;
        }

        return sortedList;
    }

    // Metode private untuk menyisipkan elemen ke dalam linked list secara terurut
    private static <T extends Comparable<T>> void insertSorted(LinkedList<T> list, T data) {
        Node<T> newNode = new Node<>(data);
        if (list.head == null || data.compareTo(list.head.data) < 0) {
            newNode.next = list.head;
            list.head = newNode;
        } else {
            Node<T> current = list.head;
            while (current.next != null && data.compareTo(current.next.data) >= 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

}

class HashTable<K, V> {
    private HashMap<K, LinkedList<V>> table;

    public HashTable() {
        table = new HashMap<>();
    }

    public void put(K key, V value) {
        LinkedList<V> list = table.get(key);
        if (list == null) {
            list = new LinkedList<>();
            table.put(key, list);
        }
        list.insert(String.valueOf(value));
    }

    public void display() {
        for (Map.Entry<K, LinkedList<V>> entry : table.entrySet()) {
            K key = entry.getKey();
            LinkedList<V> list = entry.getValue();
            System.out.print(key + ": ");
            list.display();
        }
    }

    public void remove(K key, V value) {
        LinkedList<V> list = table.get(key);
        if (list != null) {
            list.remove(value);
        }
    }


    public LinkedList<V> get(K key) {
        return table.get(key);
    }
}

class BTNode {
    BTNode left, right;
    int data;

    /* Constructor */
    public BTNode() {
        left = null;
        right = null;
        data = 0;
    }

    /* Constructor */
    public BTNode(int n) {
        left = null;
        right = null;
        data = n;
    }

    /* Function to set left node */
    public void setLeft(BTNode n) {
        left = n;
    }

    /* Function to set right node */
    public void setRight(BTNode n) {
        right = n;
    }

    /* Function to get left node */
    public BTNode getLeft() {
        return left;
    }

    /* Function to get right node */
    public BTNode getRight() {
        return right;
    }

    /* Function to set data to node */
    public void setData(int d) {
        data = d;
    }

    /* Function to get data from node */
    public int getData() {
        return data;
    }
}

/* Class SearchResult */
class SearchResult {
    private boolean found;
    private int nodeOrder;

    public SearchResult() {
        found = false;
        nodeOrder = 0;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public int getNodeOrder() {
        return nodeOrder;
    }

    public void setNodeOrder(int nodeOrder) {
        this.nodeOrder = nodeOrder;
    }
}

/* Class BT */
class BT {
    private BTNode root;

    /* Constructor */
    public BT() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Functions to insert data */
    public void insert(int data) {
        root = insert(root, data);
    }

    /* Function to insert data recursively */
    private BTNode insert(BTNode node, int data) {
        if (node == null)
            return new BTNode(data);
        else {
            if (data > node.getData())
                node.setRight(insert(node.getRight(), data));
            else
                node.setLeft(insert(node.getLeft(), data));
        }
        return node;
    }

    /* Function to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively */
    private int countNodes(BTNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    /* Function to search for an element */
    public boolean search(int val) {
        SearchResult result = new SearchResult(); // Membuat objek SearchResult
        return search(root, val, result);
    }

    /* Function to search for an element recursively */
    private boolean search(BTNode r, int val, SearchResult result) {
        if (r == null)
            return false;

        // Jika nilai ditemukan, set informasi hasil pencarian
        if (r.getData() == val) {
            result.setFound(true);
            result.setNodeOrder(result.getNodeOrder() + 1); // Menambahkan urutan node
            System.out.println("Node found at order: " + result.getNodeOrder());
            return true;
        }

        // Jika nilai tidak ditemukan pada saat ini, cek anak kiri dan anak kanan
        if (search(r.getLeft(), val, result)) {
            result.setNodeOrder(result.getNodeOrder() + 1);
            return true;
        }
        if (search(r.getRight(), val, result)) {
            result.setNodeOrder(result.getNodeOrder() + 1);
            return true;
        }

        return false;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(BTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(BTNode r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(BTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }
}












class Graph {
    private int[][] matrix;
    private boolean[] visited;

    public Graph(int[][] matrix) {
        this.matrix = matrix;
        this.visited = new boolean[matrix.length];
    }

    public void dfs(int node) {
        if (!visited[node]) {
            System.out.print(node + " ");
            visited[node] = true;
            for (int i = 0; i < matrix[node].length; i++) {
                if (matrix[node][i] == 1) {
                    dfs(i);
                }
            }
        }
    }

    public void bfs(int startNode) {
        Queue<Integer> queue = new Queue<>();
       queue.enqueue(startNode);
        visited[startNode] = true;

        //while (!queue.isEmpty()) {
            int currentNode = queue.dequeue();
            System.out.print(currentNode + " ");

            for (int i = 0; i < matrix[currentNode].length; i++) {
                if (matrix[currentNode][i] == 1 && !visited[i]) {
                    queue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
    }



public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static Queue<Object> queue = new Queue<>();
    private static Stack<Object> stack = new Stack<>();
    private static List<Object> list = new ArrayList<>();
    private static LinkedList<Object> linkedList = new LinkedList<>();
    //Scanner scanner = new Scanner(System.in);
    private static HashTable<String, Object> hashTable = new HashTable<>();
    Scanner scan = new Scanner(System.in);
    BT bt = new BT();



    public static void main(String[] args) {
        while (true) {
            System.out.println("DAFTAR PROGRAM : ");
            System.out.println("Pilih operasi:");
            System.out.println("1. Collections");
            System.out.println("2. Linked List");
            System.out.println("3. Hash");
            System.out.println("4. Binary Search Tree");
            System.out.println("5. Graph");
            System.out.println("0. Keluar");
            System.out.print("Pilih operasi:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performCollectionsOperation();
                    break;
                case 2:
                    performLinkedListOperation();
                    break;
                case 3:
                    performHashTableOperation();
                    break;
                case 4:
                    performBinarySearchTreeOperation();
                    break;
                case 5:
                    performGraphOperation();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void performCollectionsOperation() {
        while (true) {
            System.out.println("Daftar operasi Collections:");
            //System.out.println("1. Insert");
            //System.out.println("2. Delete");
            //System.out.println("3. Tampilkan");
            System.out.println("1. Queue - Enqueue");
            System.out.println("2. Queue - Dequeue");
            System.out.println("3. Queue - Display");
            System.out.println("4. Stack - Push");
            System.out.println("5. Stack - Pop");
            System.out.println("6. Stack - Display");
            System.out.println("0. Kembali");
            System.out.print(" Pilih Operasi Collections: ");

            int choice = scanner.nextInt();

            switch (choice) {
                //case 1:
                    //System.out.println("Masukkan nilai yang akan dimasukkan:");
                    //Object valueToInsert = scanner.next();
                    //list.add(valueToInsert);
                    //System.out.println(valueToInsert + " berhasil dimasukkan ke dalam Collections.");
                    //break;
                //case 2:
                    //System.out.println("Masukkan nilai yang akan dihapus:");
                    //Object valueToDelete = scanner.next();
                    //boolean removed = list.remove(valueToDelete);
                    //if (removed) {
                        //System.out.println(valueToDelete + " berhasil dihapus dari Collections.");
                    //} else {
                        //System.out.println(valueToDelete + " tidak ditemukan dalam Collections.");
                    //}
                    //break;
                //case 3:
                    //System.out.println("Collections: " + list);
                    //break;
                case 1:
                    System.out.print("Masukkan nilai yang akan dimasukkan ke dalam Queue:");
                    Object valueToEnqueue = scanner.next();
                    queue.enqueue(valueToEnqueue);
                    System.out.println(valueToEnqueue + " berhasil dimasukkan ke dalam Queue.");
                    break;
                case 2:
                    try {
                        Object dequeuedValue = queue.dequeue();
                        System.out.println(dequeuedValue + " berhasil dikeluarkan dari Queue.");
                    } catch (IllegalStateException e) {
                        System.out.println("Queue sudah kosong.");
                    }
                    break;
                case 3:
                    System.out.print("Queue saat ini : \n");
                    queue.display();
                    break;
                case 4:
                    System.out.print("Masukkan nilai yang akan dimasukkan ke dalam Stack:");
                    Object valueToPush = scanner.next();
                    stack.push(valueToPush);
                    System.out.println(valueToPush + " berhasil dimasukkan ke dalam Stack.");
                    break;
                case 5:
                    try {
                        Object poppedValue = stack.pop();
                        System.out.println(poppedValue + " berhasil dikeluarkan dari Stack.");
                    } catch (IllegalStateException e) {
                        System.out.println("Stack sudah kosong.");
                    }
                case 6 :
                    System.out.print("Stack saat ini : \n");
                    stack.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void performLinkedListOperation() {
        while (true) {
            System.out.println("\nLinked List Menu:");
            System.out.println("1. Tambah Elemen");
            System.out.println("2. Tampilkan Linked List");
            System.out.println("0. Kembali");

            System.out.print("Pilih menu (1/2/3): ");
            scanner.nextLine();
            String choice = scanner.nextLine();

            if (!choice.matches("\\d+")) {
                System.out.println("Pilihan tidak valid. Harap masukkan angka.");
                continue;
            }

            switch (choice) {
                case "1":

                    System.out.print("Masukkan data: ");
                    String data = scanner.nextLine();
                    linkedList.insert(data);
                    break;

                case "2":

                    //LinkedList<Integer> linkedList = new LinkedList<>();
                    System.out.println("Linked List saat ini:");
                    linkedList.display();

                    //LinkedList<Integer> sortedList = LinkedList.insertionSort(linkedList);
                    //System.out.println("Linked List setelah sorting:");
                    //sortedList.display();
                    break;

                case "3":
                    System.out.println("Program berakhir.");
                    //scanner.close();
                    //System.exit(0);
                case "0":
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void performHashTableOperation() {
        while (true) {
            System.out.println("Daftra Hash Table Operation ");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Get");
            System.out.println("4. Display");
            System.out.println("0. Kembali");
            System.out.print("Pilih Operasi : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan key: ");
                    String key = scanner.next();
                    System.out.print("Masukkan data: ");
                    Object data = scanner.next();
                    hashTable.put(key, data);
                    break;
                case 2:
                    System.out.print("Masukkan key: ");
                    key = scanner.next();
                    System.out.print("Masukkan data yang akan dihapus: ");
                    Object dataToRemove = scanner.next();
                    hashTable.remove(key, dataToRemove);
                    break;
                case 3:
                    System.out.print("Masukkan key: ");
                    key = scanner.next();
                    LinkedList<Object> result = hashTable.get(key);
                    if (result != null) {
                        System.out.print("Data pada key " + key + ": ");
                        result.display();
                    } else {
                        System.out.println("Key tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.println("Isi Hash Table:");
                    hashTable.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void performBinarySearchTreeOperation() {
        BT bt = new BT();
        Scanner scan = new Scanner(System.in);
        char ch;
        do {
            System.out.println("\nBinary Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number of nodes to insert");
                    int numberOfNodes = scan.nextInt();
                    System.out.println("Enter integer elements to insert");
                    for (int i = 0; i < numberOfNodes; i++) {
                        bt.insert(scan.nextInt());
                    }
                    break;
                case 2:
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : " + (bt.search(scan.nextInt()) ? "Node found" : "Node not found"));
                    break;
                case 3:
                    System.out.println("Nodes = " + bt.countNodes());
                    break;
                case 4:
                    System.out.println("Empty status = " + bt.isEmpty());
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /* Display tree */
            System.out.print("\nPost order Traversal: ");
            bt.postorder();
            System.out.print("\nPre order Traversal: ");
            bt.preorder();
            System.out.print("\nIn order Traversal: ");
            bt.inorder();
            System.out.println("\n\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }



    private static void postOrderTraversal(Node<Object> root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    private static void performGraphOperation() {
        while (true) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Masukkan 1 untuk memulai atau O untuk kembali : ");
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah simpul (nodes): ");
                    int n = scanner.nextInt();
                    System.out.println("Masukkan elemen matriks (0 atau 1):");
                    int[][] matrix = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            matrix[i][j] = scanner.nextInt();
                        }
                    }

                   Graph graph = new Graph(matrix);

                    // DFS dari node 0
                    System.out.println("DFS:");
                    graph.dfs(0);
                    System.out.println();

                    // BFS dari node 0
                    System.out.println("BFS:");
                    graph.bfs(0);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        }
    }
}
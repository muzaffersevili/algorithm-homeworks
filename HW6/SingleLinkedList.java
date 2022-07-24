public class SingleLinkedList {

    Node head;

    //Add Name&Score
    public void addName_Score(Object dataToAdd,Object point) {

        if (head == null) { // Add when list is empty
            Node newnode = new Node(dataToAdd,point);
            head = newnode;
        }

        else if ((int) point >= (int) head.getPoint()) { // Add to the begin of the list
            Node newnode = new Node(dataToAdd,point);
            newnode.setLink(head);
            head = newnode;
        }

        else {
            Node temp = head;
            Node previous = null;

            while (temp != null && (int) point < (int) temp.getPoint()) {
                previous = temp;
                temp = temp.getLink();
            }

            Node newnode = new Node(dataToAdd,point);
            if (temp == null) // Adding to the end of the list
                previous.setLink(newnode);

            else { // Add to the middle of the list
                newnode.setLink(temp);
                previous.setLink(newnode);
            }
        }
    }

    //Add String (Sorted)
    public void addString_Sort(Object dataToAdd) {

        if (head == null) {  // Add when list is empty
            Node newnode = new Node(dataToAdd);
            head = newnode;

        }
        else if ( head.getData().toString().compareTo((String) dataToAdd)>=0) { // Add to the top of the list
            Node newnode = new Node(dataToAdd);
            newnode.setLink(head);
            head = newnode;
        }

        else {
            Node temp = head;
            Node previous = null;

            while (temp != null && temp.getData().toString().compareTo((String) dataToAdd)<0) {
                previous = temp;
                temp = temp.getLink();
            }

            Node newnode = new Node(dataToAdd);
            if (temp == null)  // Adding to the end of the list
                previous.setLink(newnode);

            else { // Add to the middle of the list
                newnode.setLink(temp);
                previous.setLink(newnode);
            }
        }
    }

    // Add (not Sorting)
    public void add_NotSort(Object data){
        if (head==null){  // Add when list is empty
            Node newNode= new Node(data);
            head=newNode;
        }
        else { // Adding to the end of the list
            Node temp= head;
            while (temp.getLink()!=null){
                temp= temp.getLink();
            }
            Node newNode= new Node(data);
            temp.setLink(newNode);
        }
    }

    public void delete(Object dataToDelete) { //Deletes specified item
        Node temp = head;
        Node prev = null;
        if(temp != null && temp.getData() == dataToDelete) {
            head = temp.getLink();
            return;
        }

        while(temp != null && temp.getData() != dataToDelete) {
            prev = temp;
            temp = temp.getLink();
        }
        if(temp == null) return;
        prev.setLink(temp.getLink());
    }

    // Print
    public void print() {
        if (head == null)
            System.out.println("Linked list is empty");
        else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.getData()+ " ");
                temp = temp.getLink();
            }
        }
    }

    //Printing Score Table
    public void printScoreTable() {
        if (head == null)
            System.out.println("Linked list is empty");
        else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.getData()+" "+ temp.getPoint());
                temp = temp.getLink();
            }
        }
    }

    //Find Data and Names
    public Object findData(int x){
        Object returned=null;
        if (head == null){
            System.out.println("Linked list is empty");
            returned= null;
        }
        else {
            Node temp = head;
            for(int i=0;i<x-1;i++) {
                if (temp != null)
                    temp = temp.getLink();
            }
            returned= temp.getData();
        }
        return returned;
    }

    //Find Point
    public Object findPoint(int x){
        Object returned=null;
        if (head == null){
            System.out.println("Linked list is empty");
            returned= null;
        }
        else {
            Node temp = head;
            for(int i=0;i<x-1;i++) {
                if (temp != null)
                    temp = temp.getLink();
            }
            returned= temp.getPoint();
        }
        return returned;
    }

    // Letter Changer
    public void letter_changer(Object item,int x) {

        if (head == null)
            System.out.println("Linked list is empty");
        else {
            Node temp = head;
            for (int i=1;i<x;i++) {
                temp = temp.getLink();
            }
            temp.setData(item);
        }
    }

    // Size
    public int size() {

        int count = 0;

        if (head == null)
            System.out.println("Linked list is empty");
        else {
            Node temp = head;
            while (temp != null) {
                count++;
                temp = temp.getLink();
            }
        }
        return count;
    }
}

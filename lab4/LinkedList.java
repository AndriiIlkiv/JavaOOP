package lab4;



import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
    Node<T> head;
    private int currentIndex = 0;
    public LinkedList()
    {
        head = new Node<T>();
        head.setData(null);
        head.setNext(null);
    }
    public Node<T> getHead() {
        return head;
    }
    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void add(T data)
    {
        Node<T> temp = new Node<T>();
        temp.setData(data);
        temp.setNext(null);

        Node<T> current = head;
        while(current.getNext() !=null)
        {
            current = current.getNext();
        }
        current.setNext(temp);
    }
    public T get(int index){
        Node<T> temp = head;
        int counter = 0;
        while (temp != null) {
            if (counter == index+1) {
                return (T) temp.getData();
            }
            counter++;
            temp = temp.getNext();
        }
        return null;
    }

    public LinkedList<TicketBox> toLinkList(ArrayList<TicketBox> ready){
        LinkedList<TicketBox> linkList = new LinkedList<>();
        for ( TicketBox i: ready){
            linkList.add(i);
        }
        return linkList;
    }

    public boolean delete(int index)
    {
        if(index<0)
            return false;
        Node<T> current = head;
        Node<T> current2;
        for(int i = 0 ; i < index ; i++)
        {
            if(current.getNext() != null)
                current = current.getNext();
            else if(current.getNext() == null)
                return false;
        }
        current2 = current;
        if(current.getNext() != null)
        {
            current = current.getNext();
            if(current.getNext() == null)
            {
                current2.setNext(null);
                return true;
            }
            else
            {
                current = current.getNext();
                current2.setNext(current);
                return true;
            }
        }
        else if(current.getNext() == null)
        {
            return false;
        }
        return false;
    }

    public int size()
    {
        Node<T> current = head;
        int i = 0;
        while(current.getNext()!=null)
        {
            current = current.getNext();
            i++;
        }
        return i;
    }
    public T getNext() {
        if(get(currentIndex) != null)
            currentIndex++;
        return get(currentIndex);
    }
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {



            @Override
            public boolean hasNext() {
                return currentIndex < size()-1;
            }


            @Override
            public T next() {
                if(get(currentIndex) != null)
                    currentIndex++;
                return get(currentIndex);
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}

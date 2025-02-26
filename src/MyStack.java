public class MyStack<T> {

    private SimpleList<T> list;

    public MyStack(){
        list = new SimpleList<T>();
    }

    public T push(T item) {
        list.add(0, item);
        return item;
    }

    public T pop() {
        T removed = list.get(0);
        list.remove(0);
        return removed;
    }

    public T peek() {
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

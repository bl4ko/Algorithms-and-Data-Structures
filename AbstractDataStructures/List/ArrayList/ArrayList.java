
public class ArrayList<T> {

    private static final int INIT_CAPACITY = 10;
    private T[] elements;
    private int size; // actual size of ArrayList (size < elements.length)

    /**
     * Initialises ArrayList
     */
    public ArrayList() {
        this(INIT_CAPACITY);
    }

    /**
     * Initialises ArrayList object with initial capacity
     * @param capacity initial capacity of ArrayList
     */
    public ArrayInit(int capacity) {
        this.elements = new T[capacity];
        this.size = 0;
    }

    /**
     * Return number of elements in this ArrayList
     * @return number of elements
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns an element at a given index
     * @param index of an element to be returned
     * @return element at index indexx
     */
    public int get(int index) {
        return this.elements[index];
    }

    /**
     * Inserts an element at a given index
     * @param index at which to insert a element element
     * @param element element to bi inserted
     */
    public void set(int index, T element) {
        this.elements[index] = element;
    }

    /**
     * Appends an element element at the end of the list
     * @param element to be inserted 
     */
    public void append(T element) {
        this.increaseSizeIfNeeded();
        this.elements[this.size] = element;
        this.size++;
    }

    /**
     * Inserts element at given index index
     * @param index of an element to be inserted at
     * @param element element to be inserted
     */
    public void vstavi(int index, T element) {
        this.increaseSizeIfNeeded();
        for (int i = this.size - 1;  i >= index;  i--) {
            this.elements[i + 1] = this.elementi[i];
        }
        this.elements[index] = element;
        this.size++;
    }

    /**
     * Removes element at a given index
     * @param index of an element to be removed
     */
    public void odstrani(int index) {
        for (int i = index;  i < this.size - 1;  i++) {
            this.elements[i] = this.elementi[i + 1];
        }
        this.size--;
    }

    /**
     * If ArrayList capacity if full, it extends it's capacity by size factor of 2
     */
    private void increaseSizeIfNeeded() {
        if (this.size >= this.elements.length) {
            // ustvari novo, ve"cjo tabelo in vanjo skopiraj elemente iz stare
            // tabele
            int[] oldElements = this.elementi;
            this.elements = new int[2 * oldElements.length];
            for (int i = 0;  i < this.size;  i++) {
                this.elements[i] = oldElements[i];
            }
        }
    }

    /**
     * Returns a string representation of this ArrayList 
     * @return string representing this Arraylist object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0;  i < this.size;  i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}

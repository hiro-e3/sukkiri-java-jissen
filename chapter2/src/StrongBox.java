public class StrongBox<T> {
    private T item;
    private int currentCount = 0;
    private final int keyCount;

    public StrongBox(KeyType keyType) {
        switch (keyType) {
            case PADLOCK:
                this.keyCount = 1_024;
                break;
            case BUTTON:
                this.keyCount = 10_000;
                break;
            case DIAL:
                this.keyCount = 30_000;
                break;
            case FINGER:
                this.keyCount = 1_000_000;
                break;
            default:
                throw new IllegalArgumentException("Invalid key type: " + keyType);
        }
    }

    public T put(T item) {
        T oldItem = this.item;
        this.item = item;
        return oldItem;
    }

    public T get() {
        currentCount++;
        if (currentCount >= keyCount) {
            return item;
        }
        return null;
    }
}

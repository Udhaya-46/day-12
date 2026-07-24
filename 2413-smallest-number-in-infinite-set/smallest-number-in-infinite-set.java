import java.util.*;

class SmallestInfiniteSet {

    private int current;
    private TreeSet<Integer> addedBack;

    public SmallestInfiniteSet() {
        current = 1;
        addedBack = new TreeSet<>();
    }

    public int popSmallest() {
        if (!addedBack.isEmpty()) {
            return addedBack.pollFirst();
        }
        return current++;
    }

    public void addBack(int num) {
        if (num < current) {
            addedBack.add(num);
        }
    }
}
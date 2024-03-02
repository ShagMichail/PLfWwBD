package First;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntegerSet {
    private Set<Integer> set;

    public IntegerSet(int... numbers) {
        set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }
    }

    public IntegerSet intersect(IntegerSet other) {
        Set<Integer> resultSet = new HashSet<>(this.set);
        resultSet.retainAll(other.set);
        return new IntegerSet(resultSet.stream().mapToInt(Integer::intValue).toArray());
    }

    public IntegerSet union(IntegerSet other) {
        Set<Integer> resultSet = new HashSet<>(this.set);
        resultSet.addAll(other.set);
        return new IntegerSet(resultSet.stream().mapToInt(Integer::intValue).toArray());
    }
    @Override
    public String toString() {
        return "{" + String.join(", ", Arrays.toString(set.toArray())) + "}";
    }
}

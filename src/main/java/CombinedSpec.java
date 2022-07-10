public class CombinedSpec<T> implements Specification<T>{
    public Specification<T> first, second;

    public CombinedSpec(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

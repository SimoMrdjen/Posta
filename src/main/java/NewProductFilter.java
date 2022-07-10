import java.util.List;
import java.util.stream.Stream;

class NewProductFilter implements Filter<Product> {

//    public NewProductFilter(List<Product> products, ColorSpecification colorSpecification) {
//    }

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

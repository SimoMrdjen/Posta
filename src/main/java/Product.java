
class Product  {
    private int price;
    private String name;
    public Color color;
    public Size size;

    public Product(int price, String name, Color color, Size size) {
        this.price = price;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public int compareTo(Product o) {
//        if (this.price > o.price)
//            return 1;
//        else if (this.price < o.price)
//            return -1;
//        return 0;
//    }
}

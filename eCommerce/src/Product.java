public class Product extends ProductAbtract implements IProduct{


    public Product(int price, String name, String id) {
        super.Price = price;
        super.name = name;
        super.ID = id;
    }

    @Override
    public String toString() {
        return "Product [ID=" + ID + ", Price=" + Price + ", name=" + name + "]";
    }

    @Override
    public void showdata() {
        System.out.println(super.name);

    }
}


import java.util.ArrayList;

public class ProductCatagory {
    public ArrayList<Product> products = new ArrayList<>();
    public void Showproduct() {
        System.out.println("Product in Category");
        for(int i =0;i<this.products.size();i++) {
            System.out.printf("ID : %s Name : %s  Price :%d\n" , this.products.get(i).ID , this.products.get(i).name ,this.products.get(i).Price);
        }
    }
    public void Addproduct(Product productinput) {
        this.products.add(productinput);
    }
    public void Removeproduct(String id){
        this.products.removeIf(e -> e.ID.equals(id));
    }
    public Product getProductById(String ID) {
        for(Product product : this.products) {
            if(product.ID.equals(ID)) {
                return product;

            }
        }
        Product p = new Product(-1, "-1", "-1");
        return p;
    }


}

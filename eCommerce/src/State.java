import java.util.ArrayList;

public class State {
    private static State instance;

    public static State getInstance() {
        if(instance == null) {
            instance = new State();
        }
        return instance;
    }
    public Mode isAdmin = Mode.CUSTOMER;
    public boolean isHome  = true;
    public ArrayList<Product> shoppingcart = new ArrayList<Product>();
    public void showproducts() {
        System.out.println("Product in Cart");
        for(int i=0;i<shoppingcart.size();i++) {
            System.out.printf("ID : %s Name : %s  Price :%d\n" , this.shoppingcart.get(i).ID , this.shoppingcart.get(i).name ,this.shoppingcart.get(i).Price);
        }
    }
    public void addproductbyid(String id,ProductCatagory productCatagory){
        Product p =  productCatagory.getProductById(id);
        this.shoppingcart.add(p);
    }

    public void Removeproduct(String id){
        this.shoppingcart.removeIf(e -> e.ID.equals(id));
    }

}

import java.util.Scanner;

public class Ecommerce {
    public static Scanner input = new Scanner(System.in);

    public static void readCommand(State state, ProductCatagory productList) {
        if (state.isHome == true) {
            readCommandMain(state, productList);
        } else

        if (state.isAdmin == Mode.CUSTOMER) {
            readAdminCommand(state, productList);
        } else if (state.isAdmin == Mode.SELLER) {
            readCustomerCommand(state, productList);
        }

    }

    public static void readCommandMain(State state, ProductCatagory productList) {
        System.out.println("What do you want to do?\n 1.Customer \n 2.Seller \n");

        int n = input.nextInt();
        state.isHome = false;
        state.isAdmin = n == 2 ? Mode.SELLER : Mode.CUSTOMER;
        readCommand(state, productList);
    }

    public static void CustomerAddProductToCart(State state, ProductCatagory productList) {
        System.out.println("What Product id which you want?");

        int i = input.nextInt();
        System.out.println(i);
        String s = String.valueOf(i);

        state.addproductbyid(s,productList);

        System.out.println("done");
    }

    public static void CustomerRemoveProductFromCart(State state, ProductCatagory productList) {
        System.out.println("What Product id which you remove?");

        int i = input.nextInt();
        String s = String.valueOf(i);
        state.Removeproduct(s);

        System.out.println("done");
    }

    public static void SellerAddProduct(State state, ProductCatagory productList) {
        System.out.println("What Product ID which you want to add?");
        String s1 = input.next();
        System.out.println("Name?");
        String s2 = input.next();
        System.out.println("Price?");
        int s3 = input.nextInt();

        Product p = new Product(s3, s2, s1);

        productList.Addproduct(p);

        System.out.println("done");
    }

    public static void SellerRemoveProduct(State state, ProductCatagory productList) {
        System.out.println("What Product ID which you want to Remove?");
        String s1 = input.next();
        productList.Removeproduct(s1);

        System.out.println("done");
    }

    public static void readCustomerCommand(State state, ProductCatagory productList) {
        System.out.println(
            "What do you do?\n 0.Show All Product in Shop\n 1.Show All Product In Cart\n 2.Add Product to Cart\n 3.Remove Product From Cart\n 4.Back to main");

        int n = input.nextInt();
        if (n == 0)
            productList.Showproduct();
        if (n == 1)
            state.showproducts();
        if (n == 2) {
            CustomerAddProductToCart(state, productList);
        }
        if (n == 3) {
            CustomerRemoveProductFromCart(state, productList);
        }

        if (n == 4) {
            state.isHome = true;
        }

        readCommand(state, productList);
    }

    public static void readAdminCommand(State state, ProductCatagory productList) {
        productList.Showproduct();
        System.out.println("What do you do?\n 0.Show All Product\n 1.Add Product\n 2.Remove Product\n 3.Back to main");
        int n = input.nextInt();
        if (n == 0)
            productList.Showproduct();
        if (n == 1)
            SellerAddProduct(state, productList);
        if (n == 2)
            SellerRemoveProduct(state, productList);
        if (n == 3)
            state.isHome = true;
        readCommand(state, productList);
    }

    public static void main(String[] agrs) {
        Product product = new Product(100, "pepsi", "101");
        Product product2 = new Product(200, "lay", "102");
        Product product3 = new Product(2001, "lipton", "103");
        ProductCatagory productCatagory = new ProductCatagory();
        productCatagory.Addproduct(product);
        productCatagory.Addproduct(product2);
        productCatagory.Addproduct(product3);
        productCatagory.Removeproduct("102");
        System.out.println(productCatagory.getProductById("101"));

        readCommand(State.getInstance(), productCatagory);
    }
}


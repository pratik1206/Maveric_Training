package exam.productproblem;


public class ClientUsage {
    public static void main(String[] args) {
        IOldProductService oldService=new OldProductServiceImpl();
        OldClient oldClient=new OldClient(oldService);
        System.out.println("display all products");
        oldClient.displayAllProducts();
        System.out.println("display product by id");
        oldClient.displayProductById(1);
    }
}

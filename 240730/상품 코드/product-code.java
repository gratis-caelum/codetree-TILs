import java.util.Scanner;
class product {
    String productName;
    int productCode;

    public product() {
        this.productName = "codetree";
        this.productCode = 50;
    }

    public product(String productName, int productCode)
    {
        this.productName = productName;
        this.productCode = productCode;
    }

    public void display() {
        System.out.println("product" + " " + productCode + " " + "is " + productName);
    }
};

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 상품명과 상품코드 입력
        String productName = input.next();
        int productCode = input.nextInt();

        // 객체 생성 및 출력
        product product1 = new product();
        product product2 = new product(productName, productCode);

        product1.display();
        product2.display();
    }
}
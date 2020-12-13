package net.xdclass.productService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductService8082Application {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String port = scanner.nextLine();
//        new SpringApplicationBuilder(ProductServiceApplication.class)
//                .properties("server.port=" + port).run(args);
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductService8082Application.class, args);
    }

}
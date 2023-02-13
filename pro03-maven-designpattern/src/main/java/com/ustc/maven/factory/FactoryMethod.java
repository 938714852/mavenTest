package com.ustc.maven.factory;

/**
 * @author Miracle
 * @date 2022/11/22 21:45
 * @description FactoryMethod
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Product product;
        Application application = new ConcreteProductA();
        product = application.createProduct();
        product.method();
    }

}

interface Product {
    void method();
}

class ProductA implements Product {
    @Override
    public void method() {
        System.out.println("A");
    }
}

class ProductB implements Product {
    @Override
    public void method() {
        System.out.println("B");
    }
}

class SimpleFactory {
    public static Product createProduct(String type) {
        if (type.equals("0")) {
            return new ProductA();
        } else if (type.equals("1"))
            return new ProductB();
        return null;
    }
}

abstract class Application {
    abstract Product createProduct();
}

class ConcreteProductA extends Application{
    @Override
    Product createProduct() {
        return new ProductA();
    }
}
package com.ustc.maven.decorator;

/**
 * @author Miracle
 * @date 2022/11/23 11:13
 * @description DecoratorTest
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator1(new ConcreteComponent());
        component.operaton();
    }
}

interface Component {
    void operaton();
}

class ConcreteComponent implements Component {

    @Override
    public void operaton() {
        System.out.println("拍照。");
    }
}

abstract class Decorator implements Component {
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operaton() {
        System.out.println("美颜。");
        component.operaton();
    }
}

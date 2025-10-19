 public class DecoratorPattern{
    public static void main(String[] args){
        BasePizza pizza=new Margharita();
        pizza=new ExtraCheese(pizza);
        pizza=new Mushroom(pizza);
        pizza=new Corn(pizza);
        System.out.println(pizza.cost());
    }
}
abstract class BasePizza{
    public abstract int cost();
} 
class Margharita extends BasePizza{
    public int cost(){
        return 100;
    }
}
class FarmHouse extends BasePizza{
     public int cost(){
        return 120;
    }
}
class VegLoaded extends BasePizza{
     public int cost(){
        return 200;
    }
}
abstract class ToppingDecorator extends BasePizza{
    
}
class ExtraCheese extends ToppingDecorator{
    BasePizza pizza;
    ExtraCheese(BasePizza pizza){
        this.pizza=pizza;
    }
    public int cost(){
        return pizza.cost()+10;
    }
}
class Mushroom extends ToppingDecorator{
     BasePizza pizza;
    Mushroom(BasePizza pizza){
        this.pizza=pizza;
    }
    public int cost(){
        return pizza.cost()+12;
    }
}
class Corn extends ToppingDecorator{
     BasePizza pizza;
    Corn(BasePizza pizza){
        this.pizza=pizza;
    }
    public int cost(){
        return pizza.cost()+5;
    }
}
 
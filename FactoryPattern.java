public class FactoryPattern{
    public static void main(String[]args){
        ShapeFactory s=new ShapeFactory();
        shape sh=s.getShape("circle");
        sh.draw();
        
    }
}
interface shape{
    void draw();
}
class circle implements shape{
    public void draw(){
        System.out.println("Circle");
    }
}
class square implements shape{
    public void draw(){
        System.out.println("Square");
    }
}
class triangle implements shape{
    public void draw(){
        System.out.println("Triangle");
    }
}
class ShapeFactory{
  public shape getShape(String s){
      switch( s){
          case "circle":
         return new circle();
         case "square":
         return new square();
         case "triangle":
         return new triangle();
         default:
         return null;
      }
  }
} 

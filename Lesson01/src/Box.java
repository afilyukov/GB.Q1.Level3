import java.util.ArrayList;

public class Box <T extends Fruits> {
    private float quantity = 0;
    private ArrayList<T> content = new ArrayList<>();



    public void add(T fruit){
        content.add(fruit);
        quantity++;
    }

    public float getWeight(){
        float weight = 0;
        if (quantity > 0) {
            if (content.get(0) instanceof Apple){    //не придумал\нашел более элегантного способа узнать тип генерика, которым был инициализирован класс(хранилка). Только через рефлексию, которую еще не проходили
                return this.quantity * Apple.getWeightOfFruit();
            } else {
                return this.quantity * Orange.getWeightOfFruit();
            }
        }
        return weight;
    }

    public boolean compare (Box box){
       if (this.getWeight()==box.getWeight()) {return true;}
       return false;
    }

    public void transfer(Box<T> box){
        box.content.addAll(this.content);
        this.content.clear();
        quantity = 0;
        System.out.println("Пересыпали!");
   }
}

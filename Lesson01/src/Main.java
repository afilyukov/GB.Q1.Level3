public class Main {
    public static void main(String[] args) {
        Tasks t = new Tasks();
        t.doDemo();

        //Task 3
        Box<Orange> boxOfOranges1 = new Box();
        Box<Apple> boxOfApples1 = new Box();
        Box<Apple> boxOfApples2 = new Box();
        boxOfApples1.add(new Apple());
        boxOfApples1.add(new Apple());
        boxOfApples1.add(new Apple());

        boxOfOranges1.add(new Orange());
        boxOfOranges1.add(new Orange());
        boxOfOranges1.add(new Orange());

        System.out.println("Вес коробки яблок1: " + boxOfApples1.getWeight());
        System.out.println("Вес коробки апельсинов1: " + boxOfOranges1.getWeight());
        System.out.println("Вес коробки яблок2: " + boxOfOranges1.getWeight());

        System.out.println("Коробки равны по весу: " + boxOfApples1.compare(boxOfOranges1));
        System.out.println("Коробки равны по весу: " + boxOfOranges1.compare(boxOfApples1));

        boxOfApples1.transfer(boxOfApples2);
        System.out.println("Вес коробки яблок1: " + boxOfApples1.getWeight());
        System.out.println("Вес коробки яблок2: " + boxOfOranges1.getWeight());

    }
}

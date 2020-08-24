import java.util.ArrayList;
import java.util.Arrays;

public class Tasks {
    public <E> void doDemo(){
        Array array = new Array(10);
        Array<Integer>arrayIntegers = new Array(10);  //варианты сужения типов
        Array<String>arrayStrings = new Array(10); //варианты сужения типов

       // меняем, допустим, 1 и 7. Можно будет уточнить при конкретизации задачи
        Object tmp = array.get(7);
        array.set(7, array.get(1));
        array.set(1, tmp);

        ArrayList<E> arrayList = new ArrayList<E>();
        fromArrayToArrayList(array, arrayList);
    }
    //task 2
    public <E> void fromArrayToArrayList(Array array, ArrayList<E> arrayList) {
        for (int i = 0; i < array.length; i++) {
            arrayList.add((E)array.get(i));
            //без проверки unchecked. Просто как проверка принципа
        }
    }
}

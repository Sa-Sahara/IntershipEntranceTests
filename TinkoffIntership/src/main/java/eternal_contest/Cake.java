package eternal_contest;

import java.util.Scanner;

// Ваня принес на кухню рулет, который он хочет разделить с коллегами. Для этого он хочет разрезать рулет на
// N равных частей. Разумеется, рулет можно резать только поперек. Соотвественно, Костя сделает 
// N−1 разрез ножом через равные промежутки. Нож Вани бесконечно длинный.Требуется сказать,
// каким минимальным числом разрезов можно обойтись.
// Выведите одно число — минимальное число движений, которое придется сделать.
public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long person = scanner.nextLong();
        long result = 0;

        System.out.println(divideRecursive(person, result));
    }

    private static long divideRecursive(long pers, long result){
        if (pers == 1 || pers == 0) return result;
        if (pers == 2) return ++result;

        return divideRecursive(pers / 2 + pers % 2, ++result);
    }
}

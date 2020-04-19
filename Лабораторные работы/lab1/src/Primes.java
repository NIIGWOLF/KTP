public class Primes{
    public static void main(String[] args) {
        for (int i = 3; i <= 100; i++) {    //перебор чисел от 3 до 100
            if (isPrime(i)) {               //вызов метода проверки на простое число
                System.out.print(i+" ");      //вывод простого числа
            }
        }
    }

    public static boolean isPrime(int n) {  //метод определения простого числа
        for (int i = 2; i <= n / 2; i++) {  //перебор чисел от 2 до 100
            if (n % i == 0) return false;   //выход из метода, если число делится
        }
        return true;                        //выход из метода, если не на одно число не разделилось
    }
}
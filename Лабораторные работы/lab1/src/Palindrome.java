public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {     //перебо всех входных данных
            String s = args[i];
            if (isPalindrome(s)){                   //проверка на палиндром
                System.out.print(s+" ");              //вывод палиндрома
            }
        }
    }

    public static String reverseString(String str){
        String s="";
        for (int i=str.length()-1;i>=0;i--){        //перебор букв в обратном порядке
            s+=str.charAt(i);
        }
        return s;
    }

    public static boolean isPalindrome(String s){
        return s.equals(reverseString(s));          //сравнение слова с обратным
    }
}

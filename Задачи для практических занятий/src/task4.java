import java.util.*;

public class task4 {
    /**1. Бесси работает над сочинением для своего класса писателей. Поскольку ее почерк довольно плох,
     * она решает напечатать эссе с помощью текстового процессора. Эссе содержит N слов (1≤N≤100),
     * разделенных пробелами. Каждое слово имеет длину от 1 до 15 символов включительно и состоит только
     * из прописных или строчных букв. Согласно инструкции к заданию, эссе должно быть отформатировано
     * очень специфическим образом: каждая строка должна содержать не более K (1≤K≤80) символов, не считая пробелов.
     * К счастью, текстовый процессор Бесси может справиться с этим требованием, используя следующую стратегию:
     * – Если Бесси набирает Слово, и это слово может поместиться в текущей строке, поместите его в эту строку.
     *      В противном случае поместите слово на следующую строку и продолжайте добавлять к этой строке.
     *      Конечно, последовательные слова в одной строке все равно должны быть разделены одним пробелом.
     *      В конце любой строки не должно быть места.
     * – К сожалению, текстовый процессор Бесси только что сломался.
     *      Пожалуйста, помогите ей правильно оформить свое эссе! */
    public static String Text(int n, int k, String str){
        String[] text=str.split(" ");
        str="";
        String textOut="";
        for(int i=0;i<n;i++){
            if (str.length()+text[i].length()>k){
                textOut=textOut.trim()+"\r\n"+text[i]+" ";
                str=text[i];
            }
            else{
                textOut+=text[i]+" ";
                str+=text[i];
            }
        }
        return textOut.trim();
    }

    /**2. Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер должен быть сбалансирован.*/
    public static String[] split(String str){
        List<String> list=new ArrayList<String>();
        int f=0;
        int i=0;
        while (str.length()>0){
            if(str.charAt(i)=='(') f++;
            else f--;
            if (f==0) {
                list.add(str.substring(0,i+1));
                str=str.substring(i+1);
                i=0;
                continue;
            }
            i++;
        }
        return list.toArray(new String[list.size()]);
    }

    /**3. Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет одну строку и преобразует ее либо в camelCase, либо в snake_case.*/
    public static String toCamelCase(String str){
        String[] text=str.split("_");
        str=text[0];
        for(int i=1;i<text.length;i++)
            str+=text[i].substring(0,1).toUpperCase()+text[i].substring(1,text[i].length());
        return str;
    }

    public static String toSnakeCase(String str){
        return str.replaceAll("([A-Z])","_$1").toLowerCase();
    }

    /**4. Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную с сверхурочной работой.

     Работа с 9 до 5: обычные часы работы После 5 вечера это сверхурочная работа Ваша функция получает массив с 4 значениями:
     – Начало рабочего дня, в десятичном формате, (24-часовая дневная нотация)
     – Конец рабочего дня. (Тот же формат)
     – Почасовая ставка
     – Множитель сверхурочных работ

     Ваша функция должна возвращать: $ + заработанные в тот день (округлены до ближайшей сотой) */
    public static String overTime(double[] mas){
        if (mas[1]>=17)
            return String.format("$%.2f",((17-mas[0])*mas[2])+((mas[1]-17)*mas[2]*mas[3]));
        else
            return String.format("$%.2f",(mas[1]-mas[0])*mas[2]);
    }

    /**5. Индекс массы тела (ИМТ) определяется путем измерения вашего веса в килограммах и деления на квадрат вашего роста в метрах.
     * Категории ИМТ таковы:

     Недостаточный вес: <18,5
     Нормальный вес: 18.5-24.9
     Избыточный вес: 25 и более Создайте функцию, которая будет принимать вес и рост (в килограммах, фунтах, метрах или дюймах)
     и возвращать ИМТ и связанную с ним категорию. Округлите ИМТ до ближайшей десятой.*/
    public static String BMI(String m, String h){
        double mas=Double.valueOf(m.split(" ")[0]);
        if (m.contains("pounds")) mas*=0.453592;
        double height=Double.valueOf(h.split(" ")[0]);
        if (m.contains("inches")) height*=0.0254;
        double score=Math.round((mas/(height*height)) * 10.0) / 10.0;
        if (score<18.5) return score+" Underweight";
        else if (score<25) return score+" Normal weight";
        else return score+" Overweight";
    }

    /**6. Создайте функцию, которая принимает число и возвращает его мультипликативное постоянство,
     * которое представляет собой количество раз, которое вы должны умножать цифры в num, пока не достигнете одной цифры.*/
    public static int bugger(int num){
        int i=0;
        int mul=num;
        while(mul>9){
            mul=1;
            do{
                mul*=num%10;
                num=num/10;
            }while (num!=0);
            num=mul;
            i++;
        }
        return i;
    }

    /**7. Напишите функцию, которая преобразует строку в звездную стенографию. Если символ повторяется n раз, преобразуйте его в символ*n. */
    public static String toStarShorthand(String str){
        if (str.isEmpty()) return "";
        int j=1;
        char c=str.charAt(0);
        String text="";
        for(int i=1;i<str.length();i++){
            if (str.charAt(i)==c) j++;
            else {if (j>1)
                text+=c+"*"+j;
            else
                text+=c;
            c=str.charAt(i);
            j=1;
            }
        }

        if (j>1) text+=c+"*"+j;
        else text+=c;

        return text;
    }

    /**8. Создайте функцию, которая возвращает true, если две строки рифмуются, и false в противном случае.
     * Для целей этого упражнения две строки рифмуются, если последнее слово из каждого предложения содержит одни и те же гласные.*/
    public static boolean doesRhyme(String str1, String str2){
        str1 = str1.substring(str1.lastIndexOf(" ")).toLowerCase();
        str2 = str2.substring(str2.lastIndexOf(" ")).toLowerCase();

        for (int i=0;i<str1.length();i++){
            if (String.valueOf(str1.charAt(i)).matches("[aeiyou]"))
                if (!str2.contains(String.valueOf(str1.charAt(i)))) return false;
        }
        for (int i=0;i<str2.length();i++){
            if (String.valueOf(str2.charAt(i)).matches("[aeiyou]"))
                if (!str1.contains(String.valueOf(str2.charAt(i)))) return false;
        }
        return true;
    }

    /**9. Создайте функцию, которая принимает два целых числа и возвращает true,
     * если число повторяется три раза подряд в любом месте в num1 и то же самое число повторяется два раза подряд в num2.*/
    public static boolean trouble(long num1, long num2){
        String a=String.valueOf(num1);
        String b=String.valueOf(num2);
        for(int i=0;i<10;i++){
            if (a.contains(i+String.valueOf(i)+i) && b.contains(String.valueOf(i)+i)) return true;
        }
        return false;
    }

    /**10. Предположим, что пара одинаковых символов служит концами книги для всех символов между ними.
     * Напишите функцию, которая возвращает общее количество уникальных символов (книг, так сказать) между всеми парами концов книги.*/
    public static int countUniqueBooks(String str, char c){
        int sum=0;
        while (str.contains(String.valueOf(c))){
            Set<Character> set = new HashSet<Character>();
            str=str.substring(str.indexOf(c)+1);

            char ch=' ';
            for(int i=0;i<str.length();i++){
                ch=str.charAt(i);
                if (ch==c) break;
                set.add(str.charAt(i));
            }

            sum+=set.size();
            str=str.substring(str.indexOf(c)+1);
        }
        return sum;
    }
}

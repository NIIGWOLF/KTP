import java.util.*;

public class task6 {
    /**1. Число Белла - это количество способов, которыми массив из n элементов может быть разбит на непустые подмножества.
     * Создайте функцию, которая принимает число n и возвращает соответствующее число Белла. */
    public static int bell(int i){
        int[][] stirl = new int[i+1][i+1];
        stirl[0][0]=1;
        stirl[i][i]=1;
        for (int n=1; n<=i;n++) {
            for (int k = 1; k < i; k++){
                stirl[n][k]=stirl[n-1][k-1]+k*stirl[n-1][k];
            }
        }
        int sum=0;
        for (int k=0;k<=i;k++)sum+=stirl[i][k];
        return sum;
    }

    /**2. – Если слово начинается с согласного, переместите первую букву (буквы) слова до гласного до конца слова и добавьте «ay» в конец.
     *    – Если слово начинается с гласной, добавьте "yay" в конце слова. */
    public static String translateWord(String str){
        if (str.isEmpty()) return "";
        if(!Character.isLetter(str.charAt(0))) return "";
        if (str.matches("[aeiyouAEIYOU].*"))
            return str+"yay";
        else{
            String s=str.split("[aeiyouAEIYOU]")[0];
            return str.replaceFirst(s,"")+s+"ay";
        }
    }

    public static String translateSentence(String str){
        String out="";
        String buff="";
        for(char c: str.toCharArray()){
            if (Character.isLetter(c))
                buff+=c;
            else{
                out+=translateWord(buff);
                out+=c;
                buff="";
            }
        }
        return out+=translateWord(buff);
    }

    /**3. Учитывая параметры RGB (A) CSS, определите, является ли формат принимаемых значений допустимым или нет.
     * Создайте функцию, которая принимает строку (например, " rgb(0, 0, 0)") и возвращает true,
     * если ее формат правильный, в противном случае возвращает false.*/
    public static boolean validColor(String str){
        String[] in=str.split("[\\(\\),]");
        if(in[0].length()==in.length-1)
            try{
                for(int i=1; i<in.length;i++){
                    int num = Integer.parseInt(in[i]);
                    if (num<0 || num>255) return false;
                }
            }
            catch (Exception e){
                return false;
            }
        return true;
    }

    /**4. Создайте функцию, которая принимает URL (строку), удаляет дублирующиеся параметры запроса и параметры,
     * указанные во втором аргументе (который будет необязательным массивом).*/
    public static String stripUrlParams(String url, String[] arrParam){
        if (!url.contains("?")) return url;
        String out=url.split("\\?")[0]+"?";
        String[] params=url.split("\\?")[1].split("&");

        Map<String, String> map = new HashMap<String, String>();
        for(String par: params) {
            boolean flag=true;
            for (String str : arrParam) {
                if(par.indexOf(str)==0) flag=false;
            }
            if(flag) map.put(par.split("=")[0],par.split("=")[1]);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out+=entry.getKey()+"="+entry.getValue()+"&";
        }
        return out.substring(0,out.length()-1);
    }

    public static String stripUrlParams(String url) {
        return stripUrlParams(url,new String[0]);
    }

    /**5. Напишите функцию, которая извлекает три самых длинных слова из заголовка газеты и преобразует их в хэштеги.
     * Если несколько слов одинаковой длины, найдите слово, которое встречается первым.*/
    public static String[] getHashTags(String str){
        List<String> words=new ArrayList<String>();
        String buff="";
        for (char c: str.toCharArray()){
            if (Character.isLetter(c))
                buff+=c;
            else{
                words.add("#"+buff.toLowerCase());
                buff="";
            }
        }
        if (!buff.isEmpty()) words.add("#"+buff.toLowerCase());
        Comparator<String> compare = (String  o1, String o2) -> o2.length()-o1.length();
        Collections.sort(words, compare);

        while (words.size()>3) words.remove(words.size()-1);

        return words.toArray(new String[words.size()]);
    }

    /**6. Создайте функцию, которая принимает число n и возвращает n-е число в последовательности Улама.*/
    public static int ulam(int n){
        int[] mas = new int[n];
        mas[0]=1;
        mas[1]=2;
        int len=2;
        int next=3;
        while (next<Integer.MAX_VALUE && len<n){
            int count =0;
            for (int i=0;i<len;i++){
                for (int j=len-1; j>i; j--){
                    if (mas[i]+mas[j]==next && mas[i]!=mas[j])
                        count++;
                    else if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                mas[len]=next;
                len++;
            }
            next++;
        }
        return mas[n-1];
    }

    /**7. Напишите функцию, которая возвращает самую длинную неповторяющуюся подстроку для строкового ввода.*/
    public static String longestNonrepeatingSubstring(String str){
        String word="";
        String buff="";
        for(char c: str.toCharArray()){
            if (!buff.contains(String.valueOf(c)))
                buff+=c;
            else{
                if (buff.length()>word.length())
                    word=buff;
                buff=""+c;
            }
        }
        if (buff.length()>word.length())
            word=buff;
        return word;
    }

    /**8. Создайте функцию, которая принимает арабское число и преобразует его в римское число.*/
    public static String convertToRoman(int num){
        int iLet=1000;
        String let="MDCLXVI";
        int i=0;
        String out="";
        while(i!=7){
            if (num/iLet>0) {
                out += let.charAt(i);
                num-=iLet;
            }
            else {
                if (i % 2 == 0) iLet = iLet / 2;
                else iLet = iLet / 5;
                i++;
            }
        }
        return out;
    }

    /**9. Создайте функцию, которая принимает строку и возвращает true или false в зависимости от того,
     * является ли формула правильной или нет.*/
    public static boolean formula(String str){
        if (!str.matches("^(\\d+\\s[\\*\\+-/]\\s\\d+\\s=\\s\\d+)$"))
            return false;
        String[] left=str.split("=")[0].trim().split(" ");
        String right=str.split("=")[1].trim();
        int fun=0;

        switch (left[1]){
            case "+":fun=Integer.parseInt(left[0])+Integer.parseInt(left[2]); break;
            case "-":fun=Integer.parseInt(left[0])-Integer.parseInt(left[2]); break;
            case "*":fun=Integer.parseInt(left[0])*Integer.parseInt(left[2]); break;
            case "/":fun=Integer.parseInt(left[0])/Integer.parseInt(left[2]); break;
        }
        if (fun==Integer.parseInt(right)) return true;
        else return false;
    }

    /**10. Создайте функцию, которая возвращает значение true, если само число является палиндромом
     * или любой из его потомков вплоть до 2 цифр (однозначное число - тривиально палиндром).
     * Прямой потомок числа создается путем суммирования каждой пары соседних цифр, чтобы создать цифры следующего числа.*/
    public static boolean palindromedescendant(int num){
        String number=String.valueOf(num);
        while(true){
            if (number.equals(new StringBuilder(number).reverse().toString())){
                return true;
            }else{
                if (number.length()%2==1) return false;
                String sum="";
                for (int i=1;i<number.length();i+=2){
                    sum+=Integer.parseInt(String.valueOf(number.charAt(i)))+Integer.parseInt(String.valueOf(number.charAt(i-1)));
                }
                number=sum;
            }
        }
    }


    public static void main(String[] args) {
        String[] s = {"b"};
        System.out.println(ulam(206));
    }
}

public class lab3 {
    static long timer=0;

    public static void main(String[] args) {
        String str = "Надстройка нетривиальна. Согласно мнению известных философов, дедуктивный метод естественно порождае";
        String sub = "дед";
        Boolean registr = true;

        timeSet();
        int search1=KMP(str, sub, registr);
        timeSet();timeSet();
        int search2=str.indexOf(sub);
        timeSet();
    }

    public static int KMP(String string, String subString, Boolean Registr){

        if (!Registr){
            string=string.toLowerCase();
            subString=subString.toLowerCase();
        }

        int[] pref=PrF(subString);
        int index=0;
        int indexPref=0;
        char[] str=string.toCharArray();
        char[] sub=subString.toCharArray();


        while(index<(string.length()-pref.length) && indexPref<sub.length){
            if (str[index]==sub[indexPref]){
                index++;
                indexPref++;
            }
            else {
                if (indexPref == 0)
                    index++;
                else
                    indexPref = pref[indexPref - 1];
            }
        }

        if (indexPref>=sub.length) return index-indexPref;
        return -1;
    }

    public static int[] PrF(String s){
        int size = s.length();
        int[] mas = new int[size];
        int sum=0;

        for(int i=2; i<=size;i++, sum=0){
            for (int j=1;j<i;j++){
                String str1=s.substring(0,j);
                String str2=s.substring(i-j,i);
                if (s.substring(0,j).equals(s.substring(i-j,i)))
                    sum+=1;
            }
            mas[i-1]=sum;
        }

        return mas;
    }

    public static void timeSet(){
        if (timer==0) timer=System.nanoTime();
        else {
            double val = (double)(System.nanoTime()-timer);
            System.out.println(val/1000000);
            timer=0;
        }
    }
}

public class Demo {
   public static String getMonth(String accoundPeriod){
       if(accoundPeriod.charAt(4) == '0') return accoundPeriod.substring(5);
       else return accoundPeriod.substring(4);
    }
    public static void main(String[] args) {
        System.out.println(getMonth("201907"));
        System.out.println(getMonth("201910"));
    }
}

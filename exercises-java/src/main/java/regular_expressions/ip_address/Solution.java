package regular_expressions.ip_address;

import java.util.Scanner;

class Solution{

    private static String digitPattern = "(([0-1]?[0-9]{0,2})?|(2?[0-4]?[0-9])?|(25[0-5]))";
    private static String pattern = "^" + digitPattern + "[.]" + digitPattern + "[.]" + digitPattern + "[.]" + digitPattern + "$";

    public static boolean isIP(String input) {
        return input.matches(pattern);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(isIP(IP));
        }

    }
}

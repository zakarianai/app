package ma.banque.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utils {

    public static String getAccountNumber(){
        Set<String> accountNumber = new HashSet<>();
        accountNumber.add(String.valueOf(16 * new Random().nextInt()));
        return accountNumber.iterator().next().replace("-", "");
    }

    public static String getOperationCode(){
        Set<String> accountNumber = new HashSet<>();
        accountNumber.add(String.valueOf(10 * new Random().nextInt()));
        return accountNumber.iterator().next().replace("-", "");
    }

    public static String getEmployeeCode(){
        Set<String> accountNumber = new HashSet<>();
        accountNumber.add(String.valueOf(8 * new Random().nextInt()));
        return "E-" + accountNumber.iterator().next().replace("-", "");
    }
}

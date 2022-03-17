package leetCode;

import java.util.ArrayList;

public class CompareVersion {

    public static int compareVersion(String version1, String version2) {
        ArrayList<Long> v1 = new ArrayList<>();
        ArrayList<Long> v2 = new ArrayList<>();
        String a = version1;
        for(int i = 0; i< a.length(); i++){
            int j = i;
            while ( j < a.length() && a.charAt(j) != '.')
                j++;
            if(j - i > 0 && a.substring(i, j) != ".")
                v1.add(Long.valueOf(a.substring(i, j)));
            i = j;
        }
        a = version2;
        for(int i = 0; i< a.length(); i++){
            int j = i;
            while ( j < a.length() && a.charAt(j) != '.')
                j++;
            if(j - i > 0 && a.substring(i, j) != ".")
                v2.add(Long.valueOf(a.substring(i, j)));
            i = j;
        }
        int i = 0, j = 0;
        while(i < v1.size() && j < v2.size()){
            if(v1.get(i) > v2.get(j))
                return 1;
            else if(v1.get(i) < v2.get(j))
                return -1;
            i++;j++;
        }
        if(i != v1.size()) {
            while(i < v1.size())
                if(v1.get(i) > 0)
                     return 1;
        }
        if(j != v2.size()) {
            while(j < v2.size())
                if(v2.get(j) > 0)
                    return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "1.01",
        b = "1.001";
        System.out.println(compareVersion(a,b));
    }
}

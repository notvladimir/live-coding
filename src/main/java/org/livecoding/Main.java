package org.livecoding;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "minusplusminus";
        var ss = s.replaceAll("plus", "+");
        var sss = ss.replaceAll("minus", "-");
        System.out.println(sss);
    }
}

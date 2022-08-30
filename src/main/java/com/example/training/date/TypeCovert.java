package com.example.training.date;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Strings;

/**
 * @author yang han
 * @date 2022/8/26 11:45
 */

public class TypeCovert {


    public static void main(String[] args) {

//        String num = "01";
//        long l = Long.parseLong(num);
//        System.out.println(l);

 //      String num = "01.01.01";
        String num = "01";
        int i = num.lastIndexOf(".");
        String substring = num.substring(i + 1);
        System.out.println(substring);
        long l = Long.parseLong(substring ) + 1;
        String s = Strings.padStart(StrUtil.toString(l), 2, '0');
        System.out.println(s);
        if (num.contains(".")){
            String substring1 = num.substring(0, i);
             s = substring1 + "."+  s;
        }
        System.out.println(s);


    }


}

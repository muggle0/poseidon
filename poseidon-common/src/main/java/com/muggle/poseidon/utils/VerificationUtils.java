package com.muggle.poseidon.utils;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author ：muggle
 * @date ：Created in 2018/12/31
 * @description：验证码生成器
 * @version: 1.0
 */
public class VerificationUtils {
    private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ,
            'a','b','c','d','e','f','g','h','i','j','k','m','l','n','o','p',
            'q','r','s','t','u','v','w','x','y','z'};
    /**
     * 随机生成字符 或 者数字
     *
     * @return
     */
    private static String getRandom() {
        String value = "";
        Random random = new Random();
        int gen = random.nextInt(2);
        String charOrNum = gen % 2 == 0 ? "char" : "num";
        if ("char".equals(charOrNum)) {
            //字符
            int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
            int ascii = random.nextInt(26);
            value += (char) (ascii + temp);
        } else if ("num".equals(charOrNum)) {
            //是数字
            value += String.valueOf(random.nextInt(10));
        }
        return value;
    }

    /**
     * 随机生成字符串（包含字符和数字）
     *
     * @param length 指定长度
     * @return 返回set
     */
    private static Set<String> getStrAndNum(int length) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            String value = getRandom();
            set.add(value);
        }
        //若生成的字符串没达到指定长度 继续生成
        if (set.size() < length) {
            String value = getRandom();
            set.add(value);
        }
        return set;
    }

    /**
     * 存放在set中的字符组拼接成字符串
     *
     * @param set
     * @return
     */
    private static String printSet(Set set) { //打印set的方法
        Iterator iterator = set.iterator();
        String value = "";
        while (iterator.hasNext()) {
            //String ele = (String) iterator.next();
            value += (String) iterator.next();
        }
        return value;
    }

    /**
     * 返回生成的随机字符串
     *
     * @param length 指定随机字符串长度
     * @return 指定长度 大于零 返回指定长度随机字符，小于等于零 返回null
     */
    public static String getRandonString(int length) {
//        fixme
        return getStr();
    }

    static String getStr(){
        char [] code=new char[4];
        Random random=new Random();
        for (int i=0;i<4;i++){
            code[i]=codeSequence[random.nextInt(62)];
        }
        String s = String.valueOf(code);
        return s;
    }
}

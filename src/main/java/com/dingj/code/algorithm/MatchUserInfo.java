package com.dingj.code.algorithm;

import org.springframework.util.StringUtils;

import java.io.*;

public class MatchUserInfo {

    public static final String PW_PATTERN = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,}";

    /**
     * 读取txt，并匹配密码格式，生成不符合条件的txt
     *
     * @throws IOException
     */
    public void readUserInfoTxtAndMatch() throws IOException {
        File file = new File("d:\\wait4check.txt");
        BufferedReader reader = null;
        String temp = null;

        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine()) != null) {
                if (!match(temp)) {
                    sb.append(temp + "\n");
                }
            }
            createResultTxt(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }


    /**
     * 判断密码是否符合以下条件：
     * 1. 同时包含大小写字母、数字和特殊字符(ascii 可表示的)
     * 2. 长度大于等于 8 位
     * 3. 不包含用户名
     *
     * @param s
     * @return
     */
    private boolean match(String s) {
        String[] userInfo = s.split(" ");
        String userName = userInfo[0];
        String pwd = userInfo[1];
        if (pwd.contains(userName)) {
            return false;
        }
        return pwd.matches(PW_PATTERN);
    }

    private void createResultTxt(String result) throws IOException {
        if (StringUtils.isEmpty(result)) {
            System.out.printf("无不符合条件的数据！");
            return;
        }
        FileWriter fw = new FileWriter("d:\\result.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bw.close();
        }
    }


}

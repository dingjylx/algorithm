package com.dingj.code.algorithm.stack;

import java.util.Stack;

/**
 * 71. 简化路径
 */
public class LC_71_SimplifyPath {


    /**
     * 栈解决,把当前目录压入栈中,遇到..弹出栈顶,最后返回栈中元素.
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length; i++){
            if(!stack.isEmpty() && s[i].equals("..")){
                stack.pop();
            }else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals("..")){
                stack.push(s[i]);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        StringBuffer res = new StringBuffer();
        for(int i = 0; i<stack.size();i++){
            res.append("/").append(stack.get(i));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        // 简化为/c
        String path = "/a/./b/../../c/";
        new LC_71_SimplifyPath().simplifyPath(path);
    }
}

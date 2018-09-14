

import java.io.IOException;
import java.io.*;
import java.util.Scanner;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class textcount {  
  
	
	public static int words = 1;
	public static int lines = 1;
	public static int chars = 0;
        public static int space = 0;
        
	

		public static void calculate(String s) throws IOException {
		FileInputStream f = new FileInputStream(s);
		// 根据前后空格来判断是否为单词
		boolean notblank = false;
		String blank = " \t\n\r";
                int c;
		while ((c = f.read()) != -1) {
			chars++;
			if(c == '\n') lines++;//计算行数
                        if(c == ' ') space++;
			if(blank.indexOf(c) != -1) {
				if(notblank) {
					words++;
				}
				notblank = false;
			} else {
				notblank = true;
			}
		}if(chars==0) {words=0;lines=0;}//空文件
		
		
}
        public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {		
			
            System.out.println("本文件有如下功能，操作指引如下");
            System.out.println("-a（空一格）文件路径，输出所有内容 ");
            System.out.println("-c（空一格）文件路径，输出文件字符数 ");
            System.out.println("-w（空一格）文件路径，输出文件词的数目");
            System.out.println("-l（空一格）文件路径，输出文件行数");
          
            
            // 获取输入指令
            System.out.print("请输入命令：");
            Scanner s = new Scanner(System.in);
            String m = s.nextLine();
            String arr[]= m.split("\\s");
            
            // 根据获取指令来执行函数
            try {
                switch (arr[0]){
                	//打印输出结果
	                case "-c": textcount.calculate(arr[1]);
                      if(chars==0) System.out.println
        ("本文件共有字符数：" + chars);//空文件情况
                         else{
                       System.out.println
        ("本文件共有字符数：" + (chars-(lines-1)*2-space));}//不计空格和换行
                        break; 	//返回文件字符数
	                
                        case "-w": textcount.calculate(arr[1]);
                        System.out.println("本文件共有单词数：" + words+"\n");
                        break; 		//返回文件单词数目
                        
                       //空行也计算在内 
	                case "-l": textcount.calculate(arr[1]);
                        System.out.println("本文件共有行数：" + lines+"\n");
                        break;      //返回文件行数
	               
                         case "-a": textcount.calculate(arr[1]);
                   if(chars==0) System.out.println("本文件共有字符数：" + chars);
                         else{
                       System.out.println
        ("本文件共有字符数：" + (chars-(lines-1)*2-space));}
                       System.out.println("本文件共有单词数：" + words);
                       System.out.println("本文件共有行数：" + lines);
                      
                        break;
                 
	                default: System.out.println("\n不存在该指令！"+"\n");break;
                }
			} catch (FileNotFoundException e) {//读取失败
	            System.out.println("\n不存在该文件路径！");
	        } catch (IOException e){
	            System.out.println("\n文件读取错误！");
	        }System.out.println("运行结束，感谢您的使用");break;
        }
	}

}

package com.meridian.assessment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TreeSumming {
	public static boolean checkRootToLeafPath(int sum, int target, char c, FileReader inputStream) throws IOException{
		int token = 0;
		while(c == ' ' || c == '\n')
			c = (char)inputStream.read();
		if(c == '('){
			while((c = (char) inputStream.read()) !=-1 ){
				if(Character.isDigit(c)){
					 token = token*10 + Character.getNumericValue(c);
				}
			}
		}
		while(c == ' ' || c == '\n')
			c = (char)inputStream.read();
		boolean left = checkRootToLeafPath(sum + token, target,'(',inputStream );
		boolean right = checkRootToLeafPath(sum + token, target,')',inputStream );
		if (left == true && right == true && sum == target)
			return true;
		return false;
	}
public static void main(String args[]) throws IOException{
	
	 FileReader inputStream = null;

     try {
         inputStream = new FileReader("xanadu.txt");
         int c;
         while ((c = inputStream.read()) != -1) {
        	 checkRootToLeafPath(0, Character.getNumericValue(c),);
         }
     } finally {
         if (inputStream != null) {
             inputStream.close();
         }
     }
}
}

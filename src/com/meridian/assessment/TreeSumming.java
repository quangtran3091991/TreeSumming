package com.meridian.assessment;

import java.io.FileReader;
import java.io.IOException;

public class TreeSumming {

	static FileReader inputStream;
	static boolean yes;
	static {
		try {
			inputStream = new FileReader("resource/input.txt");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean processTree(int sum, int target, char ch) throws IOException {
		int token = 0;
		while (ch == ' ' || ch == '\n')
			ch = (char) inputStream.read();
		if (ch == '(') {
			ch = (char) inputStream.read();
			while (ch != ')' && ch != '(') {
				if (Character.isDigit(ch)) {
					token = token * 10 + Character.getNumericValue(ch);
					;
				}
				ch = (char) inputStream.read();
			}
			while (ch == ' ' || ch == '\n')
				ch = (char) inputStream.read();
			sum += token;
			boolean left = processTree(sum, target, ' ');
			while (ch != '(')
				ch = (char) inputStream.read();
			boolean right = processTree(sum, target, ' ');

			if (left == false && right == false) {
				if (sum == target)
					yes = true;

			}
			while (ch != ')')
				ch = (char) inputStream.read();
		}
		return true;
	}

	public static void main(String[] args) {

		try {
			TreeSumming treeSumming = new TreeSumming();
			int ch;
			int target = 0;
			boolean result = false;
			while ((ch = inputStream.read()) != -1) {
				while ((char) ch != ' ') {

					if (Character.isDigit((char) ch)) {
						target = target * 10 + Character.getNumericValue(ch);
					}
					ch = (char) inputStream.read();
				}
				treeSumming.processTree(0, target, ' ');
				if (yes == true)
					System.out.println("yes");
				else
					System.out.println("no");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}

	}
}

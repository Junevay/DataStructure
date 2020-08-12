package utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {

	public static boolean readFile(String fileName,List<String> words) {
		if(fileName==null||words==null) {
			System.out.println("fileName or words is Null!");
			return false;
		}
		
		Scanner scanner;	
			try {
				File file =new File(fileName);
 				if(file.exists()) {
					FileInputStream fis;
				fis = new FileInputStream(file);
				scanner=new Scanner(new BufferedInputStream(fis),"UTF-8");
				scanner.useLocale(Locale.ENGLISH);
				}else {
					return false;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("could not open :"+fileName);
				return false;
			}
			
		if(scanner.hasNextLine()) {
			String content=scanner.useDelimiter("\\A").next();
		
			int start = firstCharacterIndex(content,0);
			for(int i=start+1;i<content.length();) {
				if(i==content.length()||!Character.isLetter(content.charAt(i))) {
					String word = content.substring(start, i).toLowerCase();
					words.add(word);
					start=firstCharacterIndex(content, i);
					i=start+1;
				}else {
					i++;
				}
			}
		}
		return true;
	}
	
	public static int firstCharacterIndex(String s,int start) {
		for (int i = start; i < s.length(); i++) {
			if(Character.isLetter(s.charAt(i)))
				return i;	
		}
		return s.length();
	}
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
public class A4 {


	public static String is_valid_file_name() throws IOException{
		String file_name1= null;
		Scanner user_input1 = new Scanner( System.in );
		System.out.println("Enter the name of the file: ");
		file_name1= (user_input1.next().strip()	);
		File f = new File(file_name1);
		if (f.exists()) {
		}else {
			user_input1.close();
			return null;
			
		}
		user_input1.close();
		return file_name1;
				
		}
				
	public static String get_file_name() throws IOException {
		
		String file_name=null;
		do {
			file_name=is_valid_file_name();
		} while (file_name==null);
		return file_name;
		
	}
	
	public static String clean_word(String word) {
		word = word.replaceAll("[^a-zA-Z]+"," ").toLowerCase();
		return word;
		
	}

	public static boolean test_letters(String w1, String w2) {
		char[] chars1 = w1.toCharArray();
		char[] chars2 = w2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}


	public static List<String> create_clean_sorted_noduplicates_list(String s){
		String s1= clean_word(s);
		List<String>No_dup=new ArrayList<String>();
		String str[]= s1.split(" ");
		No_dup=Arrays.asList(str);
		return No_dup;
		
	}


	public static List<String> word_anagrams(String word, List<String>wordbook){
		List<String>ang=new ArrayList<String>();
		for(String j : wordbook) {
			if ((test_letters(word,j)== true)&& (word!=j)){
	    			ang.add(j);
	    		}
		}
		return ang;		
	}

	
	public static List<Integer> count_anagrams(List<String>l, List<String>wordbook){
		List<Integer> num_of_ang = new ArrayList<Integer>();
		for(String j : l) {
			int val= ((word_anagrams(j,wordbook)).size()-1);
			num_of_ang.add(val);
		}
		return num_of_ang;
			
	}
	public static List<String> k_anagram(List<String>l, List<Integer>anagcount, int k){
		List<String> val_of_anag = new ArrayList<String>();
		for (int i = 0 ; i < anagcount.size() ; i++) {
			if (anagcount.get(i)==k){
				val_of_anag.add(l.get(i));
			}
		}
		return val_of_anag;
		
	}

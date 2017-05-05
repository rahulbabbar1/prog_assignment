package com.assignement.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;  

public class JavaAssignment {
	private static final String FILENAME = "C:\\Users\\rahul\\workspace\\java_assign\\alice30.txt";
	
	public static void main(String[] args){
		System.out.println("Hello World");
		
		HashMap<String, Integer> wordMap = new HashMap<String,Integer>();
		Set<String> wordSet = new HashSet<>();
		
		
		// List<String> lines = Files.readAllLines(Paths.get(arg0));
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
//				System.out.println(sCurrentLine);
				String[] splited = sCurrentLine.split("\\s+");
				for(int i=0;i<splited.length;i++){
					wordSet.add(splited[i]);
					if(wordMap.containsKey(splited[i]))
						wordMap.put(splited[i],wordMap.get(splited[i])+1);
					else
						wordMap.put(splited[i],1);
				}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		String[] wordArray = wordSet.toArray(new String[wordSet.size()]);
		for(int i=0;i<wordArray.length;i++){
			System.out.println(wordArray[i]+","+wordMap.get(wordArray[i]));
		}
	}
}

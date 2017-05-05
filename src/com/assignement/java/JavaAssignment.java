package com.assignement.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;  

public class JavaAssignment {
	
	public static void main(String[] args){
//		System.out.println(args[0]);
		
		String filename = "C:\\Users\\rahul\\workspace\\java_assign\\alice30.txt";
		HashMap <String, Integer> wordMap = getWordMap(filename);
//		printWordMap(wordMap);
		printWordsWithPrefix(wordMap,args[0]);
	}
	
	public static void printWordsWithPrefix(HashMap <String, Integer> wordMap, String prefix){
		Set<String> wordSet = wordMap.keySet();
		String[] wordArray = wordSet.toArray(new String[wordSet.size()]);
		for(int i=0;i<wordArray.length;i++){
			if(wordArray[i].startsWith(prefix))
				System.out.println(wordArray[i]+","+wordMap.get(wordArray[i]));
		}
	}
	
	public static void printWordMap(HashMap <String, Integer> wordMap){
		Set<String> wordSet = wordMap.keySet();
		String[] wordArray = wordSet.toArray(new String[wordSet.size()]);
		for(int i=0;i<wordArray.length;i++){
			System.out.println(wordArray[i]+","+wordMap.get(wordArray[i]));
		}
	}
	
	
	public static HashMap<String, Integer> getWordMap(String filename){
		HashMap<String, Integer> wordMap = new HashMap<String,Integer>();
//		Set<String> wordSet = new HashSet<>();
		
		
		// List<String> lines = Files.readAllLines(Paths.get(arg0));
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(filename);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(filename));

			while ((sCurrentLine = br.readLine()) != null) {
//				System.out.println(sCurrentLine);
				String[] splited = sCurrentLine.split("\\s+");
				for(int i=0;i<splited.length;i++){
//					wordSet.add(splited[i]);
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
		
		return wordMap;
		
//		Set<String> wordSet = wordMap.keySet();
//		String[] wordArray = wordSet.toArray(new String[wordSet.size()]);
//		for(int i=0;i<wordArray.length;i++){
//			System.out.println(wordArray[i]+","+wordMap.get(wordArray[i]));
//		}

	}
}

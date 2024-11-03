package baekjoon.level20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int wordCount = Integer.parseInt( inp[0] );
		int maxLength = Integer.parseInt( inp[1] );
		
		List<Word> book = new ArrayList<>();
		Map<String, Word> search = new HashMap<>();
		for (int i = 0; i < wordCount; i++) {
			String word = br.readLine();
			if (word.length() <  maxLength) 
				continue;
			if (!search.containsKey(word) ) {
				Word w = new Word(word);
				search.put(word, w);
				book.add(w);
			}
			Word w = search.get(word);
			w.increase();
		}
		
		Collections.sort(book);
		
		StringBuilder sb = new StringBuilder();
		for(Word w : book) {
			sb.append(w.getStr()).append("\n");
		}
		System.out.println(sb.toString());
	}
}

class Word implements Comparable<Word> {
	private String str;
	private int count;
	private int length;
	
	public Word(String str) {
		this.str = str;
		this.count = 0;
		this.length = str.length();
	}
	
	public void increase() {
		this.count++;
	}
	
	public String getStr() {
		return str;
	}
	public int getCount() {
		return count;
	}
	public int getLength() {
		return length;
	}

	@Override
	public int compareTo(Word o) {
		if (count > o.getCount())
			return -1;
		else if (count < o.getCount())
			return 1;
		else {
			if (length > o.getLength())
				return -1;
			else if (length < o.getLength())
				return 1;
			else {
				return str.compareTo(o.getStr());
			}
		}
	}
}
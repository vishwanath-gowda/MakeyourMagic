package com.vishwanathgowdak.makeyourmagic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resource {

	public static class LanguageMap{
		private static HashMap<String, String> LangSlang = new HashMap<String, String>();
		private static HashMap<String, String> LangMisType = new HashMap<String, String>();
		public static String getSlang(String key){
			String Value=null;
			if(LangSlang.containsKey(key)){
				Value=LangSlang.get(key);
			}
			return Value;
		}
		public static String getMisType(String key){
			String Value=null;
			if(LangMisType.containsKey(key)){
				Value=LangMisType.get(key);
			}
			return Value;
		}
		
		public static void init(String[] keys, String[] values, String[] misType){
			for (int i = 0; i < Math.min(keys.length, values.length); ++i) {
				LangSlang.put(keys[i], values[i]);
			}
			for (int i = 0; i < Math.min(keys.length, misType.length); ++i) {
				LangMisType.put(keys[i], misType[i]);
			}

		}
		public static ArrayList<String> getArrayListofLang(){
			ArrayList<String> langList = new ArrayList<String>();
			for(Map.Entry<String,String> map : LangSlang.entrySet()){
				langList.add(map.getKey());
			}
			return langList;
		}
	}

}

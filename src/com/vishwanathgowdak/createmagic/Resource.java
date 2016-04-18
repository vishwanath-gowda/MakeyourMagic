package com.vishwanathgowdak.createmagic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resource {

	public static class LanguageMap{
		
		private static HashMap<String, String> LangSlang = new HashMap<String, String>();
		private static HashMap<String, String> LangMisType = new HashMap<String, String>();
		private static HashMap<String, String> ImageSrc = new HashMap<String, String>();
		private static HashMap<String, String> MisyTypeImageSrc = new HashMap<String, String>();
		
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
		
		public static String imageSrc(String key){
			String Value=null;
			if(ImageSrc.containsKey(key)){
				Value=ImageSrc.get(key);
			}
			return Value;
		}
		
		public static String MisTypeimageSrc(String key){
			String Value=null;
			if(MisyTypeImageSrc.containsKey(key)){
				Value=MisyTypeImageSrc.get(key);
			}
			return Value;
		}
		
		public static void init(String[] lang, String[] slang, String[] misType, String[] imageSrc, String[] misTypeImageSrc){
			for (int i = 0; i < Math.min(lang.length, slang.length); ++i) {
				LangSlang.put(lang[i], slang[i]);
			}
			for (int i = 0; i < Math.min(lang.length, misType.length); ++i) {
				LangMisType.put(lang[i], misType[i]);
			}
			for (int i = 0; i < Math.min(lang.length, imageSrc.length); ++i) {
				ImageSrc.put(lang[i], imageSrc[i]);
			}
			for (int i = 0; i < Math.min(lang.length, misTypeImageSrc.length); ++i) {
				MisyTypeImageSrc.put(lang[i], misTypeImageSrc[i]);
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

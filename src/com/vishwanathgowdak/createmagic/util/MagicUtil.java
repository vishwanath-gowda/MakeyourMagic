package com.vishwanathgowdak.createmagic.util;

import java.lang.reflect.Field;

import com.vishwanathgowdak.gen.*;
import com.vishwanathgowdak.gen.R.drawable;

public class MagicUtil {
	
	public static int getDrawableResourceID(String name){
		int rVal = -1;
		try {
		    Class<drawable> Rclass = R.drawable.class;
		    Field field = Rclass.getField(name);
		    int drawableId = field.getInt(null);
		    return drawableId;
		}
		catch (Exception e) {	}
		return rVal;
	}
}

package com.ga.tc.common;

public class DeCoder {
    	public String encode(String value)
	{
		if (value != null) {
			value = value.trim();
			int level = 0;
			String keyStr = new String("12tabsa12");
			byte key[] = keyStr.getBytes();
			IceKey ik = new IceKey(level);
			ik.clear();
			ik.set(key);
			value = ik.encode(value);
			}
        
		return value;
	}
	public String decode(String value)
	{
		  
		String newValue=null;
		if(value!=null)
        {
            value=value.trim();
   
            String keyStr = new String("12tabsa12"); 
            byte key []= keyStr.getBytes();
            newValue = new String(key);
        }
		
		return newValue;
	}
	public static void main(String[] args) {
		System.out.println(new DeCoder().encode("1234"));
		
	}
}

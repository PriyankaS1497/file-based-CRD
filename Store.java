package com.CRD.json;

import org.json.simple.*;
import java.util.*;
import java.io.*;

public class Store  {
	
	String location = "";
	String filename ="";
	
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public Store(String fp)
	{
		try {
			location = fp;
			filename = "document";
		}catch(Exception e) {System.out.println("File not found."); }
	} 
	
	public void createKey(String s, int t)
	{
		if(validateKey(s))
		{    toEnterKey(s, t);  }
		else {  System.out.println("Invalid key.");}
	}
	
	public void readKey(String s)
	{ 
		if(validateKey(s))
		{
			if(map.containsKey(s)) {
				System.out.println(map.values());
			}
		}else {   System.out.println("Key doesnot exist. ");}
	}
	
	public void deleteKey(String s)
	 {
	   	if(validateKey(s))
	   	{
	   		map.remove(s); System.out.println("Key was removed successfully.");
	   	} else{   System.out.println("Key doesnot exist. ");}

	 }
	
	public boolean validateKey(String s)
	  {boolean b = false;
		  String ss = s.toLowerCase(); 
		   char[] c =ss.toCharArray();
		   for(int x=0; x<c.length; x++)
		     {
			   if(c[x]>='a' && c[x]<='z') { b= true; }}
		   return b;
		     
	  }
	
	public void toEnterKey(String s, int x)
	{ 
		FileInputStream fis = null;
	    FileOutputStream fos = null;
	    ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
		File f = new File(filename);
		if(f.exists()) {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			map = (HashMap<String, Integer>) ois.readObject();
			
			fis.close();  ois.close();
			map.put(s, x);
			
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			
			fis.close(); oos.close(); 
			
		}
		}catch(Exception e) { e.printStackTrace();}
	}
	
	 public static FileInputStream fis = null;
	 public static FileOutputStream fos = null;
	 public static  ObjectInputStream ois = null;
	 public static ObjectOutputStream oos = null;
	
	
 public static boolean toWriteKey(String k, int t, String fp)
  {   
	 HashMap<String, Integer> map = null;
	 
	 try {
		 File f = new File(fp);
		 if(f.exists())
		  { 
			 fis = new FileInputStream(f);
			 ois = new ObjectInputStream(fis);
			 map = (HashMap<String, Integer>) ois.readObject();
			 
			 fis.close(); ois.close();
			 
			 map.put(k, t);
			 
			 fos = new FileOutputStream(f);
			 oos = new ObjectOutputStream(fos);
			 oos.writeObject(map);
			 
			 fos.close(); oos.close();
			   return true;
			}
		 else {
			 map = new HashMap<String, Integer>();
			 map.put(k, t);
			 
			 fos = new FileOutputStream(f);
			 oos = new ObjectOutputStream(fos);
			 oos.writeObject(map);
			 
			 fos.close(); oos.close(); 
			  return true;  }
	 } 
	 catch(Exception e) { return false; }    
  }
 
 
 public static void toReadKey(String key, String fp)
 {
	 HashMap<String, Integer> map = new HashMap<String, Integer>();
	 try {
		 File f = new File(fp);
		 if(f.exists())
		 {
			 fis = new FileInputStream(f);
			 ois = new ObjectInputStream(fis);
			 map = (HashMap<String, Integer>) ois.readObject();
		     
			 fis.close(); ois.close(); System.out.println(key+" "+map.get(key));
		 }
		 else { System.out.println("Key doesnot exist."); }
	 }
	 catch(Exception e) {  e.printStackTrace();  }
  }

  public static boolean toEraseKey(String key, String fp)
  {
	  HashMap<String, Integer> map =new HashMap<String, Integer>();
	    try {
		     File f = new File(fp);
		     if(f.exists())
		     {
		    	 fis = new FileInputStream(f);
			     ois = new ObjectInputStream(fis);
			     map = (HashMap<String, Integer>) ois.readObject();
			     
			     fis.close(); ois.close();
			     map.remove(key);
			     
			     fos = new FileOutputStream(f);
			     oos = new ObjectOutputStream(fos);
			     oos.writeObject(map);
			     
			     fos.close(); oos.close(); 
			 return true;    }
		     else { return false;  }
		     }
	     catch(Exception e) { return false; }
  }
  
  public static void toRewritekey(String key, int new_value, String fp)
  {
	 HashMap<String, Integer> map = new HashMap<String, Integer>();
  try {
	 File f = new File(fp);
	 if(f.exists())
	 {
		 fis = new FileInputStream(f);
		 ois = new ObjectInputStream(fis);
		 
		 map = (HashMap<String, Integer>) ois.readObject();
		 map.replace(key, new_value);  
		 
		 fis.close(); ois.close();
		 
		 
		 System.out.println("Key was modified with the new value"); 
	 } 
   }catch(Exception e) { System.out.println("Key doesnot exist.");  }
	 
  }
  
}

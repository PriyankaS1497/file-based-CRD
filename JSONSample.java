package com.CRD.json;
import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;
import com.CRD.json.*;

public class JSONSample
{
    
   public static JSONSample js = new JSONSample();
    String filepath = "";//path to store the data
	
  public static void main(String[] args)
  {
	  
	 Scanner sc = new Scanner(System.in);
   	 
	 Store s = new Store("");
	 
	 s.createKey("google", 80);
	 s.createKey("firefox", 60);
  
	 s.readKey("google");
	 s.readKey("ie");
	 
	 s.deleteKey("chrome");
	 s.deleteKey("firefox");
	 

}
 
}
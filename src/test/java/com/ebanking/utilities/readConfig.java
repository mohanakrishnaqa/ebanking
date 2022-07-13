package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig 
{
Properties prop; 

public readConfig()
{
File source = new File("./Configuration/config.properties");
FileInputStream fis;

try 
{
	fis = new FileInputStream(source);
	prop= new Properties();
	prop.load(fis);
}

catch (Exception e)
{
	System.out.println("Exception is " + e.getMessage());
}

}

public String getApplicatonURL()
{
	String burl = prop.getProperty("baseURL");
	return burl;
}

public String getUserName()
{
	String uname= prop.getProperty("uname");
	return uname;
}

public String getPassword()
{
	String pwd = prop.getProperty("pwd");
	return pwd;
}

public String getChromePath()
{
String chromepath= prop.getProperty("chromepath");
return chromepath;
}

public String getFireFox()
{
String firefox = prop.getProperty("firefox");	
return firefox;
}

public String getMSEdge()
{
String msedge = prop.getProperty("msedge");	
return msedge;
}

}

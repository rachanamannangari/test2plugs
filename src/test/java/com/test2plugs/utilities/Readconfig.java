package com.test2plugs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
public Readconfig()
	{
File fl=new File("./configuration/config.properties");
try
{
FileInputStream input=new FileInputStream(fl);
pro= new Properties();
pro.load(input);
}
catch(Exception e)
{
	System.out.println("exception is "+e.getMessage());
}
	}

public String getApplicationurl()
{
String url=	pro.getProperty("url");
return url;
}

public String getUsername()
{
String username=	pro.getProperty("username");
return username;
}
public String getPassword()
{
String password=	pro.getProperty("password");
return password;
}

public String getChromepath()
{
String chromepath=	pro.getProperty("chromepath");
return chromepath;
}

public String getfirefoxpath()
{
String firefoxpath=	pro.getProperty("firefoxpath");
return firefoxpath;
}




}


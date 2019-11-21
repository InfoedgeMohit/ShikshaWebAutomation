package com.shiksha.resourses;

public class ServerSettings {

	public static String[] settings(String server)
	{
		String[] credentials = new String[4];
		switch(server.toLowerCase())
		{
		case "test01":
			credentials[0] = "https://shikshatest01.infoedge.com/";
			credentials[1] = "jdbc:mysql://172.16.3.247:3306/shiksha";
			credentials[2] = "shiksha";
			credentials[3] = "shiKm7Iv80l";
			break;			
			
		case "test02" :
			credentials[0] = "https://shikshatest02.infoedge.com/";
			credentials[1] = "jdbc:mysql://172.16.3.111:3306/shiksha";
			credentials[2] = "shiksha";
			credentials[3] = "shiKm7Iv80l";
			break;
			
		case "test03" :
			credentials[0] = "https://shikshatest03.infoedge.com/";
			credentials[1] = "jdbc:mysql://172.16.3.247:3306/shiksha";
			credentials[2] = "shiksha";
			credentials[3] = "shiKm7Iv80l";
			break;
			
		case "test04":
			credentials[0] = "https://shikshatest04.infoedge.com/";
			credentials[1] = "jdbc:mysql://172.16.3.247:3306/shiksha";
					//"jdbc:mysql://172.16.3.109:3306/shiksha";
			credentials[2] = "shiksha";
			credentials[3] = "shiKm7Iv80l";
			break;
		
		case "test05" :
			credentials[0] = "https://shikshatest05.infoedge.com/";
			credentials[1] = "jdbc:mysql://172.16.3.247:3306/shiksha";
			//credentials[1] = "jdbc:mysql://172.16.3.111:3306/shiksha";
			credentials[2] = "shiksha";
			credentials[3] = "shiKm7Iv80l";
			break;
			
		case "live" :
			credentials[0] = "https://www.shiksha.com/";
			credentials[1] = "";
			credentials[2] = "";
			credentials[3] = "";
			break;
		
		default :
			break;
		}
		
		return credentials;
		
	}
	
	
}

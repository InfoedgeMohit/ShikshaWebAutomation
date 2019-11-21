package com.shiksha.resourses;

public class InputsAndPlaceHolder {
	private String placeholder="";
	private String input_Type="";
	
	public InputsAndPlaceHolder(String column_Name)
	{
	try
		{
			placeholder=column_Name.substring(0,column_Name.indexOf("###"));
			input_Type=column_Name.substring(column_Name.indexOf("###")+3,column_Name.length());
			
		}
		catch(Exception e)
	{
			System.out.println("invalid data"+column_Name);
			e.printStackTrace();
			
	}
	}
	
	public String get_Placeholder()
	{
		return placeholder;
	}
	public String get_Input_Type()
	{
		return input_Type;
	}
}

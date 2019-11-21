package com.shiksha.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.shiksha.resourses.ReadConfigFile;
import com.shiksha.resourses.ReadXML;
import com.shiksha.resourses.Variables;

public class Selenium {
	public static void main(String[] args) throws Exception {
		String path;
		try {
			path = new java.io.File(".").getCanonicalPath();
			path = path + "\\src\\test\\resources\\" + "DriverScript.xlsx";
			DriverScriptExcel.readDriverExcel(path);

			ReadConfigFile rr = new ReadConfigFile();
			rr.ReadMyConfigFile();

			ReadXML rXml = new ReadXML();
			rXml.XMLReader();

			Variables.createExtinctReportPath();

			List<Thread> threadList = new ArrayList<Thread>();

			for (Entry<String, HashMap<String, String[]>> driverObject : Variables.driverExcelObject
					.entrySet()) {
				String className = driverObject.getKey();
				HashMap<String, String[]> testCase = Variables.driverExcelObject
						.get(className);
				ThreadClass th = new ThreadClass(className, testCase);
				Thread tobj = null;
				tobj = new Thread(th);
				tobj.start();
				threadList.add(tobj);
				Thread.sleep(10000);
			}
			for (Thread t : threadList) {
				// Waits for this thread to die
				t.join();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

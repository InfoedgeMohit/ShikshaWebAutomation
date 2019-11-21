package com.shiksha.main;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;

import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.DataPooling;
import com.shiksha.resourses.DriverInstance;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.SendEmail;
import com.shiksha.resourses.ServerSettings;
import com.shiksha.resourses.Variables;

public class ThreadClass implements Runnable {

	String className = "";
	HashMap<String, String[]> testCases = new HashMap<String, String[]>();
	CommonFunctions CommonFunctions = new CommonFunctions();

	public ThreadClass(String className, HashMap<String, String[]> testCase) {
		this.className = className;
		this.testCases = testCase;
	}

	@Override
	public void run() {
		executeScript();
	}

	public String getServerSettings(String className, String server) {
		String serverSettings[] = ServerSettings.settings(server);

		switch (className.toLowerCase()) {

		case "url":
			return serverSettings[0];

		case "dburl":
			return serverSettings[1];

		case "dbname":
			return serverSettings[2];

		case "dbpassword":
			return serverSettings[3];

		default:
			return "no data";
		}
	}

	@SuppressWarnings("rawtypes")
	private void executeScript() {
		Objects object = new Objects();
		try {
			WebDriver driver = null;
			DriverInstance driverInstance = new DriverInstance();

			// // Create new folder
			String path = Variables.extinctReportsPath + "\\" + this.className;
			File file = new File(path);
			file.mkdir();
			String url = "";
			String usr = "";
			String pass = "";
			for (Entry<String, String[]> tc : this.testCases.entrySet()) {
				String[] data = new String[6];
				data = tc.getValue();
				url = getServerSettings("dburl", data[5]);
				url = getServerSettings("dbname", data[5]);
				url = getServerSettings("dbpassword", data[5]);
				break;
			}
			try {
				object.setDataPooling(new DataPooling(url, usr, pass));
				object.setDataSource(object.getDataPooling().setUpPool());
				object.setConnection(object.getDataSource().getConnection());

			} catch (Exception e) {
				// // db issue in
			}
			String path2 = Variables.extinctReportsPath + "\\" + this.className
					+ "\\Screenshots";
			File file2 = new File(path2);
			file2.mkdir();
			object.setpath(path2);

			object.setReport(CommonFunctions.createExtinctReport(path,
					this.className));
			object.setmoduleName(this.className);

			// object.setNewReport(GenericFunction.getReport(object));

			object.setNewReport(GenericFunction
					.getRepor2t(path, this.className));

			String email = "aman.jain@shiksha.com , anisha.jain@naukri.com , geetu.sadana@shiksha.com "
					+ ", jahangeer.alam@shiksha.com , jyoti.thakral@naukri.com ,"
					+ " mohd.alimkhan@shiksha.com , mohit.g@shiksha.com , mohit.k1@shiksha.com , "
					+ "arora.sakshi@shiksha.com , vinay.gupta@shiksha.com";

			for (Entry<String, String[]> tc : this.testCases.entrySet()) {
				try {
					String[] data = new String[6];
					String testCase = tc.getKey();
					data = tc.getValue();
					email = data[6];
					object.setcomponentDescription(data[3]);
					object.setcomponentDetailDescription(data[4]);
					object.setserver(data[5]);
					object.setURL(getServerSettings("url", data[5]));
					object.setdbURL(getServerSettings("dburl", data[5]));
					object.setdbUserName(getServerSettings("dbname", data[5]));
					object.setdbPassword(getServerSettings("dbpassword",
							data[5]));
					String device = data[1];
					String browser = data[2];
					object.setbrowser(browser);
					object.setdevice(device);
					driver = driverInstance.Driver(device, browser);
					object.setDriver(driver);
					Class cls = Class.forName("com.shiksha.test."
							+ this.className);
					Object obj = cls.newInstance();
					String mkey = testCase;
					object.setParent(CommonFunctions.createParent(
							object.getReport(),
							object.getcomponentDescription(),
							object.getcomponentDetailDescription()));
					// new Report Parent
					object.setNewParent(GenericFunction.createParent(
							object.getNewReport(), object));
					Method methods = obj.getClass().getMethod(mkey,
							new Class[] { Objects.class });
					methods.invoke(obj, object);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				} finally {
					driver.quit();
					CommonFunctions.closeExtinctReport(object.getParent(),
							object.getReport());
					GenericFunction.closeReport(object.getNewReport());
				}
			}
			// // Send Mail
			String reportpath;
			reportpath = path;
			SendEmail se = new SendEmail();
			se.sendFromGMail(this.className, reportpath, email);
		} catch (Exception e) {

		} finally {
			try {
				object.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

package com.shiksha.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.DataPooling;

public class Objects {

	private DataPooling jdbcObj;
	private ResultSet rsObj;
	private DataSource dataSource;
	private Connection connObj;
	private PreparedStatement pstmtObj;
	private ExtentReports report;
	private com.aventstack.extentreports.ExtentReports newReport;
	private com.aventstack.extentreports.ExtentTest newParent;
	private ExtentTest parent;
	private WebDriver driver;
	private String url;
	private String path;
	private String moduleName;
	private String componentDescription;
	private String component;
	private String device;
	private String browser;
	private String server;
	private String dbUrl;
	private String dbUserName;
	private String dbPassword;

	public PreparedStatement getPreparedStatement() {
		return this.pstmtObj;
	}

	public void setPreparedStatement(PreparedStatement pstmtObj) {
		this.pstmtObj = pstmtObj;
	}

	public Connection getConnection() {
		return this.connObj;
	}

	public void setConnection(Connection connObj) {
		this.connObj = connObj;
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public ResultSet getResultSet() {
		return this.rsObj;
	}

	public void setResultSet(ResultSet rsObj) {
		this.rsObj = rsObj;
	}

	public DataPooling getDataPooling() {
		return this.jdbcObj;
	}

	public void setDataPooling(DataPooling jdbcObj) {
		this.jdbcObj = jdbcObj;
	}

	public String getpath() {
		return this.path;
	}

	public void setpath(String path) {
		this.path = path;
	}

	public String getmoduleName() {
		return this.moduleName;
	}

	public void setmoduleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getserver() {
		return this.server;
	}

	public void setserver(String server) {
		this.server = server;
	}

	public String getdevice() {
		return this.device;
	}

	public void setdevice(String device) {
		this.device = device;
	}

	public String getbrowser() {
		return this.browser;
	}

	public void setbrowser(String browser) {
		this.browser = browser;
	}

	public String getdbURL() {
		return this.dbUrl;
	}

	public void setdbURL(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getdbUserName() {
		return this.dbUserName;
	}

	public void setdbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getdbPassword() {
		return this.dbPassword;
	}

	public void setdbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getURL() {
		return this.url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String getcomponentDescription() {
		return this.component;
	}

	public void setcomponentDescription(String component) {
		this.component = component;
	}

	public String getcomponentDetailDescription() {
		return this.componentDescription;
	}

	public void setcomponentDetailDescription(String componentDescription) {
		this.componentDescription = componentDescription;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public ExtentTest getParent() {
		return this.parent;
	}

	public void setParent(ExtentTest parent) {
		this.parent = parent;
	}

	public ExtentReports getReport() {
		return this.report;
	}

	public void setReport(ExtentReports report) {
		this.report = report;
	}

	public com.aventstack.extentreports.ExtentReports getNewReport() {
		return this.newReport;
	}

	public void setNewReport(com.aventstack.extentreports.ExtentReports report) {
		this.newReport = report;
	}

	public com.aventstack.extentreports.ExtentTest getNewParent() {
		return this.newParent;
	}

	public void setNewParent(com.aventstack.extentreports.ExtentTest parent) {
		this.newParent = parent;
	}
}
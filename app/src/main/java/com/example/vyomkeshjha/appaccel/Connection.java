package com.example.vyomkeshjha.appaccel;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;

import java.util.Properties;

public class Connection {
	public static AmazonSimpleDB awsSimpleDB;
	public static Properties properties;

	// 1. Get Simple DB connection.
	public static AmazonSimpleDB getAwsSimpleDB()
	{
		if(awsSimpleDB==null)
		{
			BasicAWSCredentials credentials= new BasicAWSCredentials(getProperties().getProperty("accessKey"), Connection.getProperties().getProperty("secreteKey"));
			awsSimpleDB= new AmazonSimpleDBClient(credentials);
		}
		return awsSimpleDB;
	}
	
	public static Properties getProperties()
	{
		if(properties==null)
		{
			properties=new Properties();
			try {
				properties.load(StoreToDB.class.getResourceAsStream("credentials.properties"));
				
			} catch (Exception e) {
				// TODO: handle exception
			}		}
		return properties;	
	}
}

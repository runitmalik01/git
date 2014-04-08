package com.mootly.wcm.services.sync.mongodb;

import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mootly.wcm.services.sync.SyncToExternalDb;

public class SyncToMongoDb implements SyncToExternalDb {
	final List<ServerAddress> addresses;
	final String dbName;
	final String userName;
	final String password;
	
	
	MongoClient mongoClient = null;
	DB db = null; 
	
	/**
	 * 
	 * @param addresses
	 * @param db
	 * @param collection
	 * @param userName
	 * @param password
	 */
	public SyncToMongoDb(List<ServerAddress> addresses,String dbName,String userName,String password) {
		this.addresses = addresses;
		this.dbName = dbName;
		this.userName = userName;
		this.password = password;
	}
	
	public synchronized DBCollection getDBCollectionForITR(String collectionName) {
		if (mongoClient != null && db != null) {
			return db.getCollectionFromString(collectionName);
		}
		else {
			mongoClient = new MongoClient( addresses );
			db = mongoClient.getDB( dbName );
			db.authenticate(userName, password.toCharArray());
		}
		return db.getCollection(collectionName);
	}
	
	@Override
	public void insert(String XML) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

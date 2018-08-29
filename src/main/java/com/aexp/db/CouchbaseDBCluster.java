package com.aexp.db;

import com.couchbase.client.java.CouchbaseCluster;

public class CouchbaseDBCluster {

	private  CouchbaseCluster cluster;
	CouchbaseEnvironment env;

	public CouchbaseDBCluster(){
		env = new CouchbaseEnvironment();
		cluster = CouchbaseCluster.create(env.getEnv(), "lpdcbe01a.phx.aexp.com","lpdcbe01b.phx.aexp.com","lpdcbe01c.phx.aexp.com");
	}

	public  CouchbaseCluster getCluster() {
		return cluster;
	}


	public void setCluster(CouchbaseCluster cluster) {
		this.cluster = cluster;
	}
}

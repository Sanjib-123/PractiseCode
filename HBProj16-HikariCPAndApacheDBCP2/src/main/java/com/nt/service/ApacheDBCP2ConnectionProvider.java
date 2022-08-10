package com.nt.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class ApacheDBCP2ConnectionProvider implements ConnectionProvider {

	@Override
	public boolean isUnwrappableAs(Class<?> unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("ApacheDBCP2ConnectionProvider.getConnection()");
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/NTAJ115DB1");
		bds.setUsername("root");
		bds.setPassword("Sanjib@123");
		bds.setMaxTotal(20);
		bds.setMinIdle(5);
		//get polled connection
		Connection con = bds.getConnection();
		return con;
		
		
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		System.out.println("ApacheDBCP2ConnectionProvider.closeConnection()");
		conn.close();
		
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}

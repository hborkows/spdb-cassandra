package com.company;

import com.datastax.driver.core.ResultSet;

public class Main {

    public static void main(String[] args) {
        CassandraConnector client = new CassandraConnector();
        client.connect("127.0.0.1", 9042);
        //Session session = client.getSession();

        String keyspaceName = "library";
        client.createKeyspace(keyspaceName, "SimpleStrategy", 1);
        ResultSet result = client.getSession().execute("select * from system_schema.keyspaces where keyspace_name = 'library';");
        System.out.print(result.all().toString());
        client.close();
    }
}

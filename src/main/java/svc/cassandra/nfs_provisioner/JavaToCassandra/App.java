package svc.cassandra.nfs_provisioner.JavaToCassandra;
import java.util.List;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	org.apache.log4j.BasicConfigurator.configure();
    	String serverIP = " cassandra.cassandra.svc";
    	String keyspace = "system";

    	Cluster cluster = Cluster.builder()
    	  .addContactPoints(serverIP)
    	  .build();

    	Session session = cluster.connect(keyspace);
    	String cqlStatement = "SELECT * FROM local";
    	for (Row row : session.execute(cqlStatement)) {
    	  System.out.println(row.toString());
    	}
    	String cqlStatementC = "INSERT INTO exampkeyspace.users (username, password) " + 
                "VALUES ('Serenity', 'fa3dfQefx')";
    }
}

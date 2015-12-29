package ldap;

import java.io.IOException;

import org.apache.directory.api.ldap.model.cursor.CursorException;
import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.directory.ldap.client.template.exception.LdapRuntimeException;

public class ldapConnection {
	public ldapConnection() throws IOException, CursorException  {
		
		LdapConnection connection = new LdapNetworkConnection( "localhost", 10389 );
		
		try {
			connection.bind();
			
		System.out.print("It's ok ldap connection was established!!!");
		System.out.print("Next you can see the list of entries!!!!!!");
		System.out.print("And information is:");
		
		EntryCursor cursor = connection.search( "ou=system", "(objectclass=*)", SearchScope.ONELEVEL, "*" );

		while ( cursor.next() )
		{
		    Entry entry = cursor.get();
	
		    System.out.print( " "+ entry.toString());

		  
		   
		}
			
			connection.unBind();
			connection.close();
			
		} catch (LdapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
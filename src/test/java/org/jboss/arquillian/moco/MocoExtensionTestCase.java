package org.jboss.arquillian.moco;

import java.io.IOException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MocoExtensionTestCase {

	@Deployment(testable=true)
	public static WebArchive deploy() {
		return ShrinkWrap.create(WebArchive.class, "myapp.war")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	
	
	@Test
	public void shouldGetBitcoinTradeRates() throws IOException {
		
	    
		
	}
	
}

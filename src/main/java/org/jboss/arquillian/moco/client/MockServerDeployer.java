package org.jboss.arquillian.moco.client;

import org.jboss.arquillian.container.spi.Container;
import org.jboss.arquillian.container.spi.client.container.DeployableContainer;
import org.jboss.arquillian.container.spi.client.container.DeploymentException;
import org.jboss.arquillian.container.spi.event.container.AfterDeploy;
import org.jboss.arquillian.container.spi.event.container.AfterUnDeploy;
import org.jboss.arquillian.core.api.Instance;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.core.api.annotation.Observes;
import org.jboss.arquillian.moco.HelloWorldServlet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class MockServerDeployer {

    private WebArchive mockServerWebArchive;
	
    @Inject
    private Instance<Container> container;
    
    public void executeBeforeDeploy(@Observes AfterDeploy event) throws DeploymentException {
       
        
        if(mockServerWebArchive == null){
            resolveMockServerArchive();
        }
        
        DeployableContainer<?> deployableContainer = event.getDeployableContainer();
        deployableContainer.deploy(this.mockServerWebArchive);
        
    }

    public void executeAfterUnDeploy(@Observes AfterUnDeploy event) throws DeploymentException {
        
        if(mockServerWebArchive == null){
            resolveMockServerArchive();
        }
        
        DeployableContainer<?> deployableContainer = event.getDeployableContainer();
        deployableContainer.undeploy(this.mockServerWebArchive);
        
    }
    
    private void resolveMockServerArchive() {
        this.mockServerWebArchive = ShrinkWrap.create(WebArchive.class).addClass(HelloWorldServlet.class);
    }

}

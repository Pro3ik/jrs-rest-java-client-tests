package com.jaspersoft.jasperserver.jaxrs.client.apiadapters.domain;

import com.jaspersoft.jasperserver.dto.domain.DomainMetaData;
import com.jaspersoft.jasperserver.jaxrs.client.RestClientTestUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * @author Tetiana Iefimenko
 */
public class DomainMetadataServiceTest extends RestClientTestUtil{

    @BeforeClass
    public void before() {
        initClient();
        initSession();
    }

    @Test
    public void should_return_domain_metadata() {

        DomainMetaData domainMetaData = session.domainService()
                .domainMetadata("/organizations/organization_1/Domains/Simple_Domain")
                .retrieve()
                .getEntity();
        assertNotNull(domainMetaData);
        assertTrue(domainMetaData.getRootLevel().getId().equals("root"));
    }

    @AfterClass
    public  void after() {
     session.logout();
    }
}

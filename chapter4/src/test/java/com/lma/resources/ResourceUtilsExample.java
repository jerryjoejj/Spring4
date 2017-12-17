package com.lma.resources;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResourceUtilsExample {

    @Test
    public void getResources() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("");

        Assert.assertNotNull(resources);

        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }
    }
}

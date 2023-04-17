package com.example.demo;

import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.ImageNameSubstitutor;

public class ExampleImageNameSubstitutor extends ImageNameSubstitutor {

    @Override
    public DockerImageName apply(DockerImageName original) {
        // convert the original name to something appropriate for
        // our build environment

        System.out.println("Image Requested: " + original.asCanonicalNameString());

//        if (original.asCanonicalNameString().equals("harbor.services.h2o-2-9349.h2o.vmware.com/postgres:14-alpine")) {
//            return DockerImageName.parse(
//                    "harbor.services.h2o-2-9349.h2o.vmware.com/library/postgres:14-alpine"
//            );
//        }

        if (original.asCanonicalNameString().equals("postgres:14-alpine")) {
            return DockerImageName.parse(
                    "public.ecr.aws/docker/library/postgres:14-alpine"
            );
        }


        return original;
    }

    @Override
    protected String getDescription() {
        // used in logs
        return "example image name substitutor";
    }
}
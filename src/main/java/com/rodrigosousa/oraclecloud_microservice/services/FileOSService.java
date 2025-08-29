package com.rodrigosousa.oraclecloud_microservice.services;

import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import com.oracle.bmc.objectstorage.responses.GetObjectResponse;
import com.rodrigosousa.oraclecloud_microservice.config.OSClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class FileOSService {

    String bucketName = "analysis-reports";
    String namespace = "grzrm7itwkbs";

    @Autowired
    private OSClientConfiguration clientConfiguration;

    public String getReportFileContent(String fileName){
        GetObjectRequest objectRequest = GetObjectRequest.builder()
                .bucketName(bucketName)
                .namespaceName(namespace)
                .objectName(fileName)
                .build();

        try{
            GetObjectResponse objectResponse = clientConfiguration.getObjectStorage().getObject(objectRequest);
            InputStream inputStream = objectResponse.getInputStream();

            return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(java.util.stream.Collectors.joining());

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
}

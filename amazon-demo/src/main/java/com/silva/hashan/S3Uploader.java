package com.silva.hashan;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.File;

public class S3Uploader {

    private static final String S3_BUCKET_NAME = "aws-demo-s319890314";
    private static final String REGION_NAME = "us-east-1";

    public static void main(String[] args) {
        String filePath = S3Uploader.class.getClassLoader().getResource("DSC_4201.JPG").getPath();
        String keyName = "uploads/DSC_4201.JPG";

        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion(REGION_NAME)
                .build();

        try {
            File file = new File(filePath);
            PutObjectRequest request = new PutObjectRequest(S3_BUCKET_NAME, keyName, file);
            PutObjectResult result = s3client.putObject(request);
            System.out.println("File uploaded successfully to " + S3_BUCKET_NAME + "/" + keyName);
        } catch (AmazonServiceException ase) {
            System.out.println("AmazonServiceException: " + ase.getMessage());
        } catch (AmazonClientException ace) {
            System.out.println("AmazonClientException: " + ace.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

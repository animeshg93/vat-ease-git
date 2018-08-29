package com.aexp.parser;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.aexp.model.Parser;
import com.aexp.model.Receipt;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;

public class ImageParser implements Parser {
    @Override
    public ParserResponse parse(ByteString imgBytes) throws Exception {
        List<AnnotateImageRequest> requests = new ArrayList<>();
        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            return readAndAssignValues(responses);
        }

    }
    private ParserResponse readAndAssignValues( List<AnnotateImageResponse> responses){
        Receipt receipt = new Receipt();
        receipt.setBusinessName(responses.get(0).getTextAnnotationsList().get(0).getDescription());
        boolean gotDate=false;
        for (AnnotateImageResponse res : responses) {
            if (res.hasError()) {
                System.out.println("Error: " + res.getError().getMessage());
                throw new RuntimeException("Error Response from google API");
            }

            // For full list of available annotations, see http://g.co/cloud/vision/docs
            //  System.out.println(res);

            for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                if(!gotDate){
                    if(isDate(annotation.getDescription())){
                        gotDate=true;
                        receipt.setReceiptDate(annotation.getDescription());
                    }
                }
                System.out.println("Text: " + annotation.getDescription());
                System.out.println("Position : " + annotation.getBoundingPoly());
            }
        }
        return ReceiptResponseProvider.getResponse(receipt.getBusinessName());
    }
    private boolean isDate(String str){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Pattern DATE_PATTERN1 = Pattern.compile(
                "^\\d{4}-\\d{2}-\\d{2}$");
        Pattern DATE_PATTERN2 = Pattern.compile(
                "^\\d{2}\\d{2}-\\d{4}$");
        Pattern DATE_PATTERN3 = Pattern.compile(
                "^\\d{4}/\\d{2}/\\d{2}$");
        Pattern DATE_PATTERN4 = Pattern.compile(
                "^\\d{2}/\\d{2}/\\d{4}$");

        if(DATE_PATTERN1.matcher(str).matches() ||
                DATE_PATTERN2.matcher(str).matches() ||
                DATE_PATTERN3.matcher(str).matches() ||
                DATE_PATTERN4.matcher(str).matches()) return true;
        return false;
    }

    public static void main(String[] args) throws Exception{
        Parser parser = new ImageParser();
        // The path to the image file to annotate
        File resourcesDirectory = new File("src/main/resources");
        // String fileName = "./resources/receipt2.jpg";

        // Reads the image file into memory
        Path path = Paths.get(resourcesDirectory.getAbsolutePath() + "/receipt2.jpg");

        ByteString imgBytes = ByteString.readFrom(new FileInputStream(resourcesDirectory.getAbsolutePath() + "/Indian.jpg"));
        parser.parse(imgBytes);
    }
}

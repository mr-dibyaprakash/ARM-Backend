package com.armapp.controller;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.armapp.service.AwsS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.UUID;

/**
 * @author Dibya Prakash Ojha
 * @date : 18-Jul-22
 * @project : audit-request-management
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AwsS3Controller {
    private static final String MESSAGE_1 = "Uploaded the file successfully";
    private static final String FILE_NAME = "fileName";

    private AwsS3Service awsS3Service;

    @Autowired
    public void setAwsS3Service(AwsS3Service awsS3Service) {
        this.awsS3Service = awsS3Service;
    }

    @GetMapping("/generate-upload-url")
    public ResponseEntity<String> generateUploadUrl() {
        return ResponseEntity.ok(
                awsS3Service.generatePreSignedUrl(UUID.randomUUID()+".txt", "gryffindors-fp", HttpMethod.PUT));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        return ResponseEntity.ok(awsS3Service.uploadFile(file));
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable("fileName") String fileName){
        InputStreamResource resource = new InputStreamResource(awsS3Service.downloadFile((fileName)));
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.noCache())
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable("fileName") String fileName){
        return ResponseEntity.ok(awsS3Service.deleteFile(fileName));
    }

//    @GetMapping("/download")
//    public ResponseEntity<Object> findByName(@RequestBody(required = false) Map<String, String> params) {
//        return ResponseEntity
//                .ok()
//                .cacheControl(CacheControl.noCache())
//                .header("Content-type", "application/octet-stream")
//                .header("Content-disposition", "attachment; filename=\"" + params.get(FILE_NAME) + "\"")
//                .body(new InputStreamResource(awsS3Service.findByName(params.get(FILE_NAME))));
//    }

//    @PostMapping("/upload")
//    public ResponseEntity<Object> save(@RequestParam("file") MultipartFile multipartFile) {
//        awsS3Service.save(multipartFile);
//        return new ResponseEntity<>(MESSAGE_1+":"+multipartFile.getOriginalFilename(), HttpStatus.OK);
//    }


}

package com.armapp.controller;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.armapp.model.Assets;
import com.armapp.model.Request;
import com.armapp.model.Task;
import com.armapp.repository.AssetsRepository;
import com.armapp.repository.RequestRepository;
import com.armapp.repository.TaskRepository;
import com.armapp.service.AwsS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Dibya Prakash Ojha
 * @date : 18-Jul-22
 * @project : audit-request-management
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AwsS3Controller {

    private AwsS3Service awsS3Service;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AssetsRepository assetsRepository;

    @Autowired
    public void setAwsS3Service(AwsS3Service awsS3Service) {
        this.awsS3Service = awsS3Service;
    }


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("files") MultipartFile[] files, Integer requestId, Integer taskId){
        Assets assets = new Assets();
        assets.setCreatedAt(LocalDateTime.now());
        final String[] filePrefix = {null};
        String message;
        try{
            List<String> fileNames = new ArrayList<>();
//            List<Assets> assetList = new ArrayList<>();
            Arrays.asList(files).stream().forEach(file -> {
                if(requestId != null) {
                    filePrefix[0] = "r"+"_"+requestId+"_";
                    Request request = requestRepository.findById(requestId).get();
                    assets.setRequest(request);
                    assets.setAssetName(filePrefix[0] +file.getOriginalFilename());
//                    assetList.add(assets);
                    awsS3Service.uploadFile(file, filePrefix[0]);
                    assetsRepository.save(assets);
                    fileNames.add(file.getOriginalFilename());
                }
                if(taskId!=null) {
                    filePrefix[0] = "t"+"_"+taskId+"_";
                    Task task = taskRepository.findById(taskId).get();
                    assets.setTask(task);
                    assets.setAssetName(filePrefix[0] +file.getOriginalFilename());
//                    assetList.add(assets);
                    awsS3Service.uploadFile(file, filePrefix[0]);
                    assetsRepository.save(assets);
                    fileNames.add(file.getOriginalFilename());
                }
            });
//            assetsRepository.saveAll(assetList);
            message = "Uploaded the files successfully: "+ fileNames;
            return ResponseEntity.ok().body(message);
        } catch (Exception e) {
            message = " Failed to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
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

    @GetMapping("/generate-upload-url")
    public ResponseEntity<String> generateUploadUrl() {
        return ResponseEntity.ok(
                awsS3Service.generatePreSignedUrl(UUID.randomUUID()+".txt", "gryffindors-fp", HttpMethod.PUT));
    }
}

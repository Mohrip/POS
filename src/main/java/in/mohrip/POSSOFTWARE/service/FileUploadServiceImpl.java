package in.mohrip.POSSOFTWARE.service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import in.mohrip.POSSOFTWARE.service.FileUploadService;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String uploadFile(MultipartFile file) {
        // TODO Auto-generated method stub
        String fileNameExtintion = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String key = UUID.randomUUID().toString() + "." + fileNameExtintion;
        try {
            PutObjectRequest response = PutObjectRequest.builder()
                    .bucket("mohrip-pos-software")
                    .key(key)
                    .contentType(file.getContentType())
                    .contentLength(file.getSize())
                    .build();
            if(response.sdkFields().indexOf()){
                return "https://mohrip-pos-software.s3.amazonaws.com/"+key;
            }else{
                throw new RsponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "File upload failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // return null;
        }
    }
    @Override
    public boolean deleteFile(String imageUrl) {
        // TODO Auto-generated method stub
        return false;
    }


}

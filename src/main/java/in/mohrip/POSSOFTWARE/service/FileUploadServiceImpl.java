package in.mohrip.POSSOFTWARE.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import in.mohrip.POSSOFTWARE.service.FileUploadService;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String uploadFile(org.springframework.web.multipart.MultipartFile file) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteFile(String imageUrl) {
        // TODO Auto-generated method stub
        return false;
    }


}

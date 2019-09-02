package cloud.resource.admin.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import cloud.resource.admin.service.StorageService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class StorageServiceImpl implements StorageService {

    @Override
    public String save(Path directoryPath, MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }

        String fileType = StringUtils.getFilenameExtension(filename);
        String newFileName = UUID.randomUUID() + "." + fileType;
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, directoryPath.resolve(newFileName),
                StandardCopyOption.REPLACE_EXISTING);
        }
        return newFileName;
    }

    @Override
    public Resource loadAsResource(Path fullPath) throws FileNotFoundException {
        try {
            Resource resource = new UrlResource(fullPath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException(
                    "Could not read file: " + fullPath);

            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not read file: " + fullPath);
        }
    }
}

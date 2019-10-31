package br.com.rbsj.gif.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

@RestController
public class UploadResource {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${multipart.location}")
    private String location;

    @RequestMapping(value = "upload", method = RequestMethod.POST, produces = MediaType.IMAGE_GIF_VALUE)
    public String upload(@RequestPart("file")MultipartFile file,
                         @RequestPart("inicio") int inicio,
                         @RequestPart("fim") int fim,
                         @RequestPart("velocidade") int velocidade,
                         @RequestPart("repetir") boolean repetir
                         ) throws IOException {

        File video = new File(location + "/" + System.currentTimeMillis() + ".mp4");
        file.transferTo(video);

        log.info("Salvando arquivo em {}", video.getAbsolutePath());

        return "";

    }
}

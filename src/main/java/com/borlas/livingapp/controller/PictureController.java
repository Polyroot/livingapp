package com.borlas.livingapp.controller;


import com.borlas.livingapp.domain.Picture;
import com.borlas.livingapp.repos.PictureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class PictureController {

    @Autowired
    private PictureRepo pictureRepo;

    @Value("${upload.path}")
    public String pictureUploadPath;

@GetMapping("/picture")
    public String go(Model model){
    model.addAttribute("pictures", pictureRepo.findAll());
    return "picture";
}

@PostMapping("/picture")
    public String add(@RequestParam("picture") MultipartFile pictureFile, Model model) throws IOException {

    Picture picture = new Picture();

        if (pictureFile != null){

            File pictureUploadDir = new File(pictureUploadPath);

            if (!pictureUploadDir.exists()){
                pictureUploadDir.mkdir();
            }

            String pictureUUIDFile = UUID.randomUUID().toString();
            String resultPicturename = pictureUUIDFile + "." + pictureFile.getOriginalFilename();

            pictureFile.transferTo(new File(pictureUploadPath + "/" + resultPicturename));

            picture.setPicturename(resultPicturename);

        }

    pictureRepo.save(picture);
    model.addAttribute("pictures", pictureRepo.findAll());

    return "picture";
}



}

package com.borlas.livingapp.repos;

import com.borlas.livingapp.domain.Picture;
import org.springframework.data.repository.CrudRepository;

public interface PictureRepo extends CrudRepository<Picture, Long> {
}

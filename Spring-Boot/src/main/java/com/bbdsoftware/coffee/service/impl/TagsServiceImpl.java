package com.bbdsoftware.coffee.service.impl;

import com.bbdsoftware.coffee.model.MilkType;
import com.bbdsoftware.coffee.model.Tags;
import com.bbdsoftware.coffee.repository.TagsRepository;
import com.bbdsoftware.coffee.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    TagsRepository tagsRepository;

    @Override
    public Tags getTag(Integer tagID) {
        Optional<Tags> optional = tagsRepository.findById(tagID);
        return optional.orElseGet(() -> null);
    }

    @Override
    public List<Tags> getAllTags() {
        return tagsRepository.findAll();
    }
}

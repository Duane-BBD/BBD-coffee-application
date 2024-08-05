package com.bbdsoftware.coffee.service;

import com.bbdsoftware.coffee.model.Tags;

import java.util.List;

public interface TagsService {
    Tags getTag(Integer tagID);
    List<Tags> getAllTags();
}

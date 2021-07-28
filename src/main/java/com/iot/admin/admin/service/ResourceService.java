package com.iot.admin.admin.service;

import com.iot.admin.admin.dto.ResourceDetails;
import com.iot.admin.admin.dto.ResourceForm;

public interface ResourceService {

    /**
     * Saves a new resource data in database
     * 
     * @param formData resource data to save
     */
    ResourceDetails create(ResourceForm formData);

    /**
     * 
     * Returun a resource by tag
     * @return {@link ResourceDetails}
     */
    ResourceDetails findByTag(String tag);

     /**
     * 
     * @param fromData data from form
     * @param id is the current resorce id
     */
    void update(ResourceForm fromData, Long id);

    /**
     * Delete a resource by id from database. Throws a exception if it doesn't 
     * exist.
     * 
     * @param id the resource id.
     */
    void deleteById(Long id);
    
}

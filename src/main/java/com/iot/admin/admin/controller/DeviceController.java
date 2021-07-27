package com.iot.admin.admin.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.iot.admin.admin.dto.DeviceDetails;
import com.iot.admin.admin.dto.DeviceForm;
import com.iot.admin.admin.service.DeviceService;
import com.iot.admin.admin.utils.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("device")
public class DeviceController {

    @Autowired
    private DeviceService service;

    @GetMapping
    public List<DeviceDetails> list(){       
        return service.findAll();
    }

    @GetMapping("pageable")
    public Map<String,Object> page_list(@RequestParam Map<String,String> params){
        Page<DeviceDetails> data = service.paginate(params);
        Map<String,Object> result= Pagination.mapPage(data);
        return result;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public DeviceDetails create(@RequestBody @Valid DeviceForm data){        
        return service.create(data);
    }

    @GetMapping("/tag/{tag}")
    public DeviceDetails findByTag(@PathVariable final String tag){        
        return service.findByTag(tag);
    }

    @PutMapping("/tag/{tag}")
    public DeviceDetails update(@RequestBody @Valid DeviceForm formData, @PathVariable String tag){
        tag = tag.toUpperCase();
        return service.update(formData, tag);
    }

    @DeleteMapping("/tag/{tag}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean deleteByTag(@PathVariable String tag){        
        return service.deleteByTag(tag);
    }

    
}

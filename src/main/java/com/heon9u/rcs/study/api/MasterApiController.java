package com.heon9u.rcs.study.api;

import com.heon9u.rcs.study.domain.master.dto.request.CreateMasterRequest;
import com.heon9u.rcs.study.domain.master.entity.Master;
import com.heon9u.rcs.study.domain.master.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/master")
@RestController
public class MasterApiController {

    private final MasterService masterService;

    @GetMapping()
    public List<Master> list() {
        return masterService.getMasterList();
    }

    @GetMapping("/{masterId}")
    public Master findById(@PathVariable(name = "masterId") long masterId) {
        return masterService.getMaster(masterId);
    }

    @PostMapping("/new")
    public void create(@RequestBody CreateMasterRequest req) {
        masterService.create(req);
    }



}

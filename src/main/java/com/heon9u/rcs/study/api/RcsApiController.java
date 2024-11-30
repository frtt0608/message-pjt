package com.heon9u.rcs.study.api;

import com.heon9u.rcs.study.domain.rcs.dto.request.CreateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.dto.request.UpdateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.dto.response.UpdateRcsResponse;
import com.heon9u.rcs.study.domain.rcs.entity.Rcs;
import com.heon9u.rcs.study.domain.rcs.service.RcsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/rcs")
@RestController
public class RcsApiController {

    private final RcsService rcsService;

    @GetMapping("")
    public List<Rcs> list() {
        return rcsService.findByAll();
    }

    @GetMapping("/{id}")
    public Rcs findById(@PathVariable(name = "id") long rcsId) {
        return rcsService.findById(rcsId);
    }

    @PostMapping("/new")
    public void create(@RequestBody CreateRcsRequest req) {
        rcsService.create(req);
    }

    @PutMapping("/update/{id}")
    public UpdateRcsResponse update(@PathVariable(name = "id") Long rcsId,
                                    UpdateRcsRequest updateRcsRequest) {

        rcsService.update(rcsId, updateRcsRequest);
        Rcs rcs = rcsService.findById(rcsId);
        return UpdateRcsResponse.of(rcs);
    }

}

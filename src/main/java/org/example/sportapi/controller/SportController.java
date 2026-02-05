
package org.example.sportapi.repository;


import org.example.sportapi.model.Sport;
import org.example.sportapi.service.SportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sports")
@CrossOrigin(origins = "*")
public class SportController {

    private final SportService service;

    public SportController(SportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sport> all() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Sport sport) {
        service.add(sport);
        return ResponseEntity.ok("created");
    }
}

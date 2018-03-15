package be.ordina.demo.ehb.soccer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoccerController {

    private final Goalkeeper goalkeeper;
    private final Forward forward;

    @Autowired
    public SoccerController(
            final Goalkeeper goalkeeper,
            final Forward forward) {
        this.goalkeeper = goalkeeper;
        this.forward = forward;
    }

    @GetMapping
    public ResponseEntity<String> penalty(){
        forward.kick();

        return ResponseEntity.ok("kicked!");
    }

    @GetMapping("/results")
    public ResponseEntity<Results> results(){
        return ResponseEntity.ok(goalkeeper.getResults());
    }

}

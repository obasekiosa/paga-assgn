package com.example.pagaassgn;

import com.example.pagaassgn.pastebin.PastebinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
public class AppController {
    @Value("${app.host}")
    private String host;

    @Autowired
    private PastebinService pastebinService;

    @PostMapping("/")
    public ResponseEntity<AddBinResponse> paste(@Validated @RequestBody AddBinRequest request) {
        String key = this.pastebinService.createAnonymousBin(request.getContent(), request.getExpiry());

        if (key == null) {
            return ResponseEntity.internalServerError().build();
        }

        String uri = this.host + "/" + key;
        return  ResponseEntity.created(URI.create(uri)).body(new AddBinResponse(uri));
    }

    @PutMapping("/{id}")
    public void updatePaste(@PathVariable(value = "id") String id, @Validated @RequestBody AddBinRequest request) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBinResponse> getPaste(@PathVariable(value = "id") String id) {

        GetBinResponse response = new GetBinResponse(this.pastebinService.getAnonymousBin(id));
        if (response.getContent() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }
}

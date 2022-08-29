package com.example.pagaassgn;

import com.example.pagaassgn.pastebin.PastebinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AppController {
    @Value("${app.host}")
    private String host;

    @Autowired
    private PastebinService pastebinService;

    @PostMapping("/")
    public AddBinResponse paste(@Validated @RequestBody AddBinRequest request) {

        String key = this.pastebinService.createAnonymousBin(request.getContent(), request.getExpiry());

        if (key == null) {
            return new AddBinResponse("");
        }
        return new AddBinResponse(this.host + "/" + key);
    }

    @PutMapping("/{id}")
    public void updatePaste(@PathVariable(value = "id") String id, @Validated @RequestBody AddBinRequest request) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    @GetMapping("/{id}")
    public String getPaste(@PathVariable(value = "id") String id) {
        return this.pastebinService.getAnonymousBin(id);
    }
}

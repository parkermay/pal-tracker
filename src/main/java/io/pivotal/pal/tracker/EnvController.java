package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String _port;
    private String _memoryLimit;
    private String _cfInstanceIndex;
    private String _cfInstanceAddr;

    public EnvController(@Value("${PORT:NOT SET}") String _port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String _memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String _cfInstanceIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String _cfInstanceAddr) {
        this._port = _port;
        this._memoryLimit = _memoryLimit;
        this._cfInstanceIndex = _cfInstanceIndex;
        this._cfInstanceAddr = _cfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> map = new HashMap<>();
        map.put("PORT", _port);
        map.put("MEMORY_LIMIT", _memoryLimit);
        map.put("CF_INSTANCE_INDEX", _cfInstanceIndex);
        map.put("CF_INSTANCE_ADDR", _cfInstanceAddr);
        return map;
    }
}

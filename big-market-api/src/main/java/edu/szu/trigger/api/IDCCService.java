package edu.szu.trigger.api;
import edu.szu.trigger.api.response.Response;

public interface IDCCService {

    Response<Boolean> updateConfig(String key, String value);

}


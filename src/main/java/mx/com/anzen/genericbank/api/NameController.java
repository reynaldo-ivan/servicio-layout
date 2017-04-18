package mx.com.anzen.genericbank.api;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.mongodb.util.JSON;

import mx.com.anzen.mongo.services.MongoService;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
   
@RestController
public class NameController {
	
	@Autowired
	private MongoService mongo;
	 
	@CrossOrigin(origins = "http://54.215.247.221:9092")
	@RequestMapping(value="/layout")
    public Map<String,Object> layout(@RequestBody JSONObject  json ) throws UnknownHostException{ 
		
		Map<String,Object> map=new HashMap();
		map.put("fileDefinition.idFileType",json.get("IdFileType").toString()); 
		Map<String,Object> mapResult=mongo.consulta("ADBancaGenerica",map); 
		  
        return mapResult;
    }
}

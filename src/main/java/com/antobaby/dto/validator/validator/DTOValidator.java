package com.antobaby.dto.validator.validator;

import com.antobaby.dto.validator.model.ValidationError;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DTOValidator {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private Map<String, Validate> validateMap = new HashMap<>();
    private List<ValidationError> errorList = new ArrayList<>();
    private Object target;
    private String rootNode;
    AtomicReference path = new AtomicReference();


    /**
     * Validate
     *
     * @param payload
     * @param jsonNode
     */
    public void validate(Object payload, JsonNode jsonNode) {
        init();
        this.target = payload;
        List<Map> schema = OBJECT_MAPPER.convertValue(jsonNode.get("schema"), new TypeReference<List<Map>>() {
        });
        loadSchemaProperties(schema);
    }

    /**
     * Schame properties
     *
     * @param schema
     */
    private void loadSchemaProperties(List<Map> schema) {
        schema.forEach(objProp -> loadObjectProp(objProp));
    }

    /**
     * Load object properties
     *
     * @param objProp
     */
    private void loadObjectProp(Map objProp) {

        objProp.forEach((k, v) -> {
            this.rootNode = k.toString();
            if (!this.rootNode.contains("$."))
                this.rootNode = "$." + k.toString();
            getSchemaProperty(this.rootNode, v);
        });
    }

    /**
     * Schema Object Property
     *
     * @param rootNode
     * @param v
     */
    private void getSchemaProperty(String rootNode, Object v) {
        Map properties = OBJECT_MAPPER.convertValue(v, Map.class);
        if (properties.size() > 0) {
            getPropertyVal(properties);
        }

    }

    /**
     *
     * @param properties
     */
    private void getPropertyVal(Map properties) {

        if(properties.containsKey("type")){

        }
    }

    /**
     * Init
     * initialise validation class
     */
    private void init() {
        errorList.clear();
        this.validateMap.put("string", null);
        this.validateMap.put("integer", null);
    }
}

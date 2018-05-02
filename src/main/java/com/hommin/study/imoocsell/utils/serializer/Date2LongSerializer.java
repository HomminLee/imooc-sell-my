package com.hommin.study.imoocsell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @author Hommin
 * @ClassName: Date2LongSerializer
 * @Description:
 * @data 2018年04月15日 上午9:09
 */
public class Date2LongSerializer extends JsonSerializer<Date> {


    @Override
    public void serialize(Date data, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeNumber(data.getTime()/1000);
    }
}

package in.ankushs.linode4j.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import in.ankushs.linode4j.model.enums.EventAction;

import java.io.IOException;

/**
 * Created by ankushsharma on 29/11/17.
 */
public class EventActionDeserializer extends JsonDeserializer<EventAction> {

    @Override
    public EventAction deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return EventAction.from(jsonParser.getText());
    }

}
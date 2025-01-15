package com.nomoreft.todoapp.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nomoreft.todoapp.shared.identifier.TodoId;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TodoModule extends SimpleModule {

    public TodoModule() {
        super("todo-module");

        addSerializer(TodoId.class, Jackson2TodoIdSerdes.SERIALIZER);
        addDeserializer(TodoId.class, Jackson2TodoIdSerdes.DESERIALIZER);
    }

    static class Jackson2TodoIdSerdes {

        static final TodoIdSerializer SERIALIZER = new TodoIdSerializer();
        static final TodoIdDeserializer DESERIALIZER = new TodoIdDeserializer();

        static class TodoIdSerializer extends StdSerializer<TodoId> {

            TodoIdSerializer() {
                super(TodoId.class);
            }

            @Override
            public void serialize(TodoId id, JsonGenerator generator, SerializerProvider provider) throws IOException {
                generator.writeString(id.toString());
            }

        }

        static class TodoIdDeserializer extends StdDeserializer<TodoId> {

            TodoIdDeserializer() {
                super(TodoId.class);
            }

            @Override
            public TodoId deserialize(JsonParser parser, DeserializationContext context) throws IOException {
                return TodoId.of(parser.readValueAs(String.class));
            }

        }

    }

}

package com.nomoreft.todoapp.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nomoreft.todoapp.shared.identifier.UserId;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserModule extends SimpleModule {

    UserModule() {
        super("user-module");

        addSerializer(UserId.class, Jackson2UserIdSerdes.SERIALIZER);
        addDeserializer(UserId.class, Jackson2UserIdSerdes.DESERIALIZER);
    }


    static class Jackson2UserIdSerdes {

        static final UserIdSerializer SERIALIZER = new UserIdSerializer();
        static final UserIdDeserializer DESERIALIZER = new UserIdDeserializer();

        static class UserIdSerializer extends StdSerializer<UserId> {

            UserIdSerializer() {
                super(UserId.class);
            }

            @Override
            public void serialize(UserId id, JsonGenerator generator, SerializerProvider provider) throws IOException {
                generator.writeString(id.toString());
            }

        }

        static class UserIdDeserializer extends StdDeserializer<UserId> {

            UserIdDeserializer() {
                super(UserId.class);
            }

            @Override
            public UserId deserialize(JsonParser parser, DeserializationContext context) throws IOException {
                return UserId.of(parser.readValueAs(String.class));
            }

        }

    }

}
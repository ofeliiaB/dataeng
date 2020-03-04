package kstreams.exercise12.serdes;

import kafka.basic.exercise5.deserialization.TemperatureValueDeserializer;
import kafka.basic.exercise5.model.Temperature;
import kafka.basic.exercise5.serialization.TemperatureValueSerializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class TemperatureSerde implements Serde<Temperature> {

    TemperatureValueSerializer serializer = new TemperatureValueSerializer();
    TemperatureValueDeserializer deserializer = new TemperatureValueDeserializer();

    @Override
    public Serializer<Temperature> serializer() {
        return (topic, data) -> serializer.serialize(topic, data);
    }

    @Override
    public Deserializer<Temperature> deserializer() {
        return (topic, data) -> deserializer.deserialize(topic, data);
    }
}
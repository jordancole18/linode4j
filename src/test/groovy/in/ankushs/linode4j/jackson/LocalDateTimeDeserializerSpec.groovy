package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Created by Ankush on 13/06/17.
 */
class LocalDateTimeDeserializerSpec extends BaseSpec {

    def "Test out various date values. JsonDeserializer should convert string values to their LocalDate representation "(){
        given :
            def json = new JsonBuilder([dateTime: dateTimeStr ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new LocalDateTimeDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

            where:
            dateTimeStr  | expectedResult
            '2017-04-04T11:11:11' |  LocalDateTime.of(LocalDate.of(2017,4,4),LocalTime.of(11,11,11))
            '2017-09-23T01:11:11' |  LocalDateTime.of(LocalDate.of(2017,9,23),LocalTime.of(1,11,11))
            ''           | null
    }

}

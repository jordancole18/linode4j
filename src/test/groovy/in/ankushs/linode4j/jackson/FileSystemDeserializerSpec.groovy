package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.FileSystem

/**
 * Created by ankushsharma on 03/12/17.
 */
class FileSystemDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([fs: fs ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new FileSystemDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            fs                 |  expectedResult
            'raw'              |  FileSystem.RAW
            'swap'             |  FileSystem.SWAP
            'random_string'    |  FileSystem.UNKNOWN
            null               |    FileSystem.UNKNOWN
        }

}

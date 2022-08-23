package asciimirror.model

import spock.lang.Specification

class PictureTest extends Specification {

    def 'should calculate width of the picture'() {
        given:
        def picture = new Picture(content)

        expect:
        picture.width() == expected

        where:
        content << [
                '', '1', 'abcdef',
                $/
                123
                12345
                /$.stripIndent()
        ]
        and:
        expected << [0, 1, 6, 5]
    }

}

package asciimirror.function

import spock.lang.Specification
import spock.lang.Subject

import java.util.function.IntUnaryOperator

@Subject(ReverseLine)
class ReversedStringTest extends Specification {

    def "Apply"() {
        given:
        def underTest = new ReverseLine(IntUnaryOperator.identity())

        expect:
        underTest.apply(source) == target

        where:
        source  | target
        ''      | ''
        ' '     | ' '
        'a'     | 'a'
        'ab'    | 'ba'
        'hello' | 'olleh'
        '*  '   | '  *'
    }
}

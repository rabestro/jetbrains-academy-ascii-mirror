package asciimirror.function

import spock.lang.Specification
import spock.lang.Subject

import java.util.function.IntUnaryOperator

@Subject(ReversedString)
class ReversedStringTest extends Specification {

    def "Apply"() {
        given:
        def underTest = new ReversedString(IntUnaryOperator.identity())

        expect:
        underTest.apply(source) == target

        where:
        source  | target
        ''      | ''
        ' '     | ' '
        'a'     | 'a'
        'ab'    | 'ba'
        'hello' | 'olleh'
    }
}

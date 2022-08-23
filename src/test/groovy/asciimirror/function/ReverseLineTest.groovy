package asciimirror.function

import spock.lang.Specification
import spock.lang.Subject

import java.util.function.IntUnaryOperator

@Subject(ReverseLine)
class ReverseLineTest extends Specification {

    def 'Should reverse the line and reflect characters'() {
        given: 'No reflection for characters defined'
        def underTest = new ReverseLine(IntUnaryOperator.identity())

        when: 'we reverse line'
        def actual = underTest.apply(original)

        then: 'The source line just reversed'
        actual == expected

        where:
        original  | expected
        ''        | ''
        ' '       | ' '
        'a'       | 'a'
        'ab'      | 'ba'
        'hello'   | 'olleh'
        '*  '     | '  *'
        '< ABC >' | '> CBA <'

    }
}

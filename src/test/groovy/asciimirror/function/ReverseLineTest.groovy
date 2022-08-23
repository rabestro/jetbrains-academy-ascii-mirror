package asciimirror.function

import spock.lang.Specification
import spock.lang.Subject

import java.util.function.IntUnaryOperator

@Subject(ReverseLine)
class ReverseLineTest extends Specification {

    def 'Should reverse the line without character reflection'() {
        given: 'No reflection for characters defined'
        def codePointReflection = IntUnaryOperator.identity()
        and: 'reverse line function without characters reflection'
        def underTest = new ReverseLine(codePointReflection)

        when: 'we reverse line'
        def actual = underTest.apply(original)

        then: 'The line just reversed'
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
        '[]'      | ']['

    }

    def 'Should reverse the line and reflect characters'() {
        given: 'The reflection defined for special characters'
        def codePointReflection = new ReflectCodePoint('<>(){}[]')
        and:
        def underTest = new ReverseLine(codePointReflection)

        when: 'we reverse line'
        def actual = underTest.apply(original)

        then: 'The line reversed with special chars reflection'
        actual == expected

        where:
        original    | expected
        ''          | ''
        ' '         | ' '
        'a'         | 'a'
        'ab'        | 'ba'
        '< ABC >'   | '< CBA >'
        '[]'        | '[]'
        '{(HELLO)}' | '{(OLLEH)}'
    }
}

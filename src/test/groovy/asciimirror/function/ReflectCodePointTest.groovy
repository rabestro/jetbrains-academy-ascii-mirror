package asciimirror.function

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title('Reflect CodePoint function')
@Subject(ReflectCodePoint)
@Narrative('Replace the characters that are not horizontally symmetrical with their horizontally-opposite chars')
class ReflectCodePointTest extends Specification {
    final PAIRED_CHARS = '<>[](){}/\\'

    def 'should not replace horizontally symmetrical characters'() {
        given: 'function with defined paired characters'
        def underTest = new ReflectCodePoint(PAIRED_CHARS)

        expect: 'the character not in the paired group'
        !PAIRED_CHARS.contains(character)

        and: 'the function does not change code point'
        underTest.applyAsInt(codePoint) == codePoint

        where: 'horizontally symmetrical characters'
        character << [' ', 'O', 'w', '|', '#', 'o']

        and: 'code point of the character'
        codePoint = character.codePointAt(0)
    }

    def 'should replace not horizontally symmetrical characters'() {
        given: 'function with defined paired chars'
        def underTest = new ReflectCodePoint(PAIRED_CHARS)

        expect: 'the source character in the paired group'
        PAIRED_CHARS.contains(source)

        and: 'the source code point replaced with their horizontally-opposite chars'
        underTest.applyAsInt(sourceCodePoint) == targetCodePoint

        where: 'not horizontally symmetrical characters'
        source | target
        '<'    | '>'
        '>'    | '<'
        '['    | ']'
        ']'    | '['
        '{'    | '}'
        '}'    | '{'
        '('    | ')'
        ')'    | '('
        '/'    | '\\'
        '\\'   | '/'

        and: 'their corresponding code points'
        sourceCodePoint = source.codePointAt(0)
        targetCodePoint = target.codePointAt(0)
    }
}

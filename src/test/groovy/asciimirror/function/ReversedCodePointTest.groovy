package asciimirror.function

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title('ReversedCodePoint')
@Narrative('Replace the characters that are not horizontally symmetrical with their horizontally-opposite chars')
class ReversedCodePointTest extends Specification {
    final PAIRED_CHARS = '<>[](){}/\\'

    def 'should not reverse horizontally symmetrical characters'() {
        given: 'reversed code point function with defined paired characters'
        def underTest = new ReversedCodePoint(PAIRED_CHARS)

        expect: 'the character is not in paired group'
        !PAIRED_CHARS.contains(character)

        and: 'the function does not change code point'
        underTest.applyAsInt(codePoint) == codePoint

        where: 'horizontally symmetrical characters'
        character << [' ', 'O', 'w', '|', '#', 'o']

        and: 'code point of the character'
        codePoint = character.codePointAt(0)
    }

    def 'should reverse not horizontally symmetrical characters'() {
        given: 'reversed code point function with defined paired chars'
        def underTest = new ReversedCodePoint(PAIRED_CHARS)

        expect: 'the source character is in paired group'
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

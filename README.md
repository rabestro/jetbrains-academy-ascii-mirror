# ASCII Mirror

The solution of a simple [educational project](https://hyperskill.org/projects/260) from JetBrains Academy made in a functional style.

## Objectives 
- Ask an user for a path to the text file. 
- If users inputted a file path that does not exist, print out the error with the `File not found` substring.
- Otherwise, horizontally mirror the text to the right of the center line and print it out line-by-line.

```
{modified line} | {reversed modified line}
```

reversed modified line is a modified line printed backward. Replace the characters that are not horizontally symmetrical with their horizontally-opposite chars: `<` to `>`, `[` to `]`, `{` to `}`, `(` to `)`, `/` to `\`, and vice versa.

### Example 1:
```
Input the file path:
> C:\ASCII_Animals\MooFolder\Cow.txt
            ^__^ | ^__^
    _______/(oo) | (oo)\_______
/\/(       /(__) | (__)\       )\/\
   | w----||     |     ||----w |
   ||     ||     |     ||     ||   
```
### Example 2:
```
Input the file path:
> C:\ASCII_Animals\HumphFolder\Camel.txt
   //            |            \\
 _oo\            |            /oo_
(__/ \  _  _     |     _  _  / \__)
   \  \/ \/ \    |    / \/ \/  /
   (         )\  |  /(         )
    \_______/  \ | /  \_______/
     [[] [[]     |     []] []]
     [[] [[]     |     []] []]     
```
### Example 3:
```
Input the file path:
> C:\ASCII_Animals\MeowFolder\Cat.txt
File not found!
```
### Demo

[![asciicast](https://asciinema.org/a/516521.svg)](https://asciinema.org/a/516521)

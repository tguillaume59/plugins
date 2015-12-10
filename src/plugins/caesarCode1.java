package plugins;

public class caesarCode1 implements Plugin {

    public caesarCode1() {

    }

    @Override
    public String getLabel() {
        return "Code Cesar 1";
    }

    @Override
    public String transform(String paramString) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : paramString.toCharArray()) {

            if (c >= 'a' && c <= 'z') {
                stringBuilder.append(changeLetter(c, 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                stringBuilder.append(changeLetter(c, 'A'));
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    public char changeLetter(char character, int debutCharat) {
        return (char) (((character) - debutCharat + 1) % 26 + debutCharat);
    }
}

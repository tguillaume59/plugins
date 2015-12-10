package plugins;

public class caesarCode13 implements Plugin {

    public caesarCode13() {

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
        return (char) (((character) - debutCharat + 13) % 26 + debutCharat);
    }
}

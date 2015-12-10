package plugins;

public class deleteVowels implements Plugin {

    public deleteVowels() {

    }

    @Override
    public String getLabel() {
        return "Supprime voyelles";
    }

    @Override
    public String transform(String paramString) {
        return paramString.replace("a", "").replace("e", "").replace("y", "").replace("u", "").replace("i", "").replace("o", "")
                .replace("A", "").replace("E", "").replace("Y", "").replace("U", "").replace("I", "").replace("O", "");
    }
}

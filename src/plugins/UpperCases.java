package plugins;

public class UpperCases implements Plugin {
    
    public UpperCases(){
        
    }

    @Override
    public String getLabel() {
        return "En majuscules";
    }

    @Override
    public String transform(String paramString) {
        return paramString.toUpperCase();
    }
}

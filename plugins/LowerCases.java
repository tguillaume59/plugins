package plugins;

public class LowerCases implements Plugin{
    
    public LowerCases(){
        
    }

    @Override
    public String getLabel() {
        return "En minuscules";
    }

    @Override
    public String transform(String paramString) {
        return paramString.toLowerCase();
    }
}

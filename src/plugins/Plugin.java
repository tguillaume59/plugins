package plugins;

public abstract interface Plugin
{
  public abstract String getLabel();
  
  public abstract String transform(String paramString);
}
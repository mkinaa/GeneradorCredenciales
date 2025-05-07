public class ConfiguracionEvento {
    private static ConfiguracionEvento instancia;
    private String atributo;

    private ConfiguracionEvento() {}

    public static ConfiguracionEvento getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionEvento();
        }
        return instancia;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getAtributo() {
        return atributo;
    }
}
package models;

public class TextFile {
    // Atributes
    private String name;
    private String content;
    private int size;
    
    // Constructors
    public TextFile(String name){
        this(name,"");
    }

    public TextFile(String name, String content){
        this.name = checkName(name);;
        this.content = content;
        size = calculeSize();
    }

    // Methodes
    public void edit(String content){
        if(content==null)
            throw new IllegalArgumentException("O conteúdo do arquivo não pode ser nulo.");
        this.content=content;
        size = calculeSize();
    }

    public void clear(){
        content = "";
        size = calculeSize();
    }

    public void rename(String name){
        this.name=checkName(name);
    }

    private String checkName(String name){
        if(name==null)
            throw new IllegalArgumentException("Nome inválido!");

        String nameChecked = name.replaceAll("[^a-zA-Z0-9]", "");

        if(nameChecked.isBlank())
            throw new IllegalArgumentException("Nome inválido!");
        
        return nameChecked;
    }

    private int calculeSize(){
        return content.length();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    // toString()
    @Override
    public String toString() {
        return "Arquivo: " + name + " | tamanho: " + size + " bytes.";
    }

    

}

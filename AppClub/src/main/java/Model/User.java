package Model;

public class User {
    private long id;
    private String userName;
    private String password; 
    private String rol;
    private Person personId;

    public User() {
    }
    
    
    
    public long getid(){
        return id;
    }
    
    public void setid(long id){
        this.id = id; 
    }
    
    public String getuserName(){
        return userName;
    }
    
    public void setuserName(String userName){
        this.userName = userName;
    }
    
    public String getpassword(){
        return password;
    }
    
    public void setpassword(String password){
        this.password = password;
    }
    
    public String getrol(){
        return rol;
    }
    
    public void setrol(String rol){
        this.rol = rol;
    }
    
    public Person getpersonId(){
        return personId;
    }
    
    public void getpersonId(Person personId){
        this.personId = personId;
    }
    
    
    
    
}

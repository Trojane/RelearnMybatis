package POJO.Other;

public  enum SexEnum {

    Male(1,"男"),
    Female(0,"女");

    private Integer id;
    private String sex;

    SexEnum(int id, String sex){

        this.id = id;
        this.sex = sex;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static SexEnum getSexById(int id){

        for(SexEnum sexId : SexEnum.values()){
            if(sexId.id == id){
                return sexId;
            }
        }

        return null;

    }

}

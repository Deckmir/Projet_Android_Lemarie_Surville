package com.example.nicolassurville.projet_android_lemarie_surville.Cards;

/**
 * Created by nicolas on 11/05/2018.
 */

public class Cards {

    private String name;
    private String classe;
    private String attaque;
    private String point_de_vie;
    private String cout;
    private String race;
    private String image_url;

    public Cards(){

    }

    public Cards (String name, String classe, String attaque, String point_de_vie, String cout,String race, String image_url){
        this.name= name;
        this.classe = classe;
        this.attaque= attaque;
        this.point_de_vie= point_de_vie;
        this.cout= cout;
        this.image_url= image_url;
       // this.race= race;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getclasse() {
        return classe;
    }

    public void setclasse(String classe) { this.classe = classe;
    }

    public String getAttaque() {
        return attaque;
    }

    public void setAttaque(String attaque) {
        this.attaque = attaque;
    }

    public String getPoint_de_vie() {
        return point_de_vie;
    }

    public void setPoint_de_vie(String point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public String getRace(){return race;}

    public void setRace(String race){this.race= race;}

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

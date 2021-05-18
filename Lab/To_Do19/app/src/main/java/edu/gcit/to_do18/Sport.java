package edu.gcit.to_do18;

public class Sport {
    private String title;
    private String info;
    private final int imageResources;


    Sport(String title, String info, int imageResources){
        this.title = title;
        this.info = info;
        this.imageResources = imageResources;

    }

    public String getTitle() {
        return title;
    }
    public String getInfo() {
        return info;
    }
    public int getImageResources(){
        return imageResources;
    }

}

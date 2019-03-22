package models;

public class VideoGames {

    private String name;
    private Float price;
    private String publisher;
    private String releaseDate;
    private Integer SKU;

    public VideoGames(String name, Float price, String publisher, String releaseDate, Integer SKU){
        this.name = name;
        this.price = price;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.SKU = SKU;
    }

    public VideoGames(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getSKU() {
        return SKU;
    }

    public void setSKU(Integer SKU) {
        this.SKU = SKU;
    }
}

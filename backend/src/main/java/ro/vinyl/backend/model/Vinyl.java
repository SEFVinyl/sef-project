package ro.vinyl.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vinyl")
public class Vinyl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String albumName;

    @Column(nullable = false)
    private String artistName;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private int releaseDate;

    @Column(nullable = false)
    private double price;

    public Vinyl(int id, String albumName, String artistName, String genre, String imgUrl, int releaseDate, double price) {
        this.id = id;
        this.albumName = albumName;
        this.artistName = artistName;
        this.genre = genre;
        this.imgUrl = imgUrl;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

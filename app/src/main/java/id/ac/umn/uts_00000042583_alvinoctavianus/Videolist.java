package id.ac.umn.uts_00000042583_alvinoctavianus;

public class Videolist {
    private int imageView, linkvideo;
    private String judulVideo;
    private String viddeskripsi;
    private String deskripsi;
    private String resvid;
    private String sumbervid;


    public Videolist(int imageResource, String Judulvideo, String Viddesc, String Deskripsi, String ResVid, String SumberVid, int linkvideo) {
        imageView = imageResource;
        judulVideo = Judulvideo;
        viddeskripsi = Viddesc;
        deskripsi = Deskripsi;
        resvid = ResVid;
        sumbervid = SumberVid;
        this.linkvideo = linkvideo;
    }

    public int getImageResource() {
        return imageView;
    }

    public String getText1() {
        return judulVideo;
    }

    public String getViddesc() {
        return viddeskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getResvid(){ return resvid; }

    public String getSumbervid(){ return sumbervid; }

    public int getlinkvideo() {
        return linkvideo;
    }



}

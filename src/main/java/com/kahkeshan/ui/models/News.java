package com.kahkeshan.ui.models;

import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Base64;

public class News {
    private String subject;
    private String title;
    private String body;
    private String base64Image;
    private Blob img;
    private int id;
    private int adminId;
    private String newsDate;


    public News(String subject, String title, String body, Blob img, int id, int adminId , String newsDate) throws SQLException, IOException {
        this.subject = subject;
        this.title = title;
        this.body = body;
        this.img = img;
        this.base64Image = convertBlobToBase64String(img);
        this.id = id;
        this.adminId = adminId;
        this.newsDate = newsDate;
    }

    public News(String subject, String title, String body, String base64Image) {
        this.subject = subject;
        this.title = title;
        this.body = body;
        this.base64Image = base64Image;
    }

    public News(String subject, String title, String body, String base64Image, int id) {
        this.subject = subject;
        this.title = title;
        this.body = body;
        this.base64Image = base64Image;
        this.id = id;
    }

    public News(String subject, String title, String body,int adminId) {    // use for set a news in db
        this.subject = subject;
        this.title = title;
        this.body = body;
        this.adminId = adminId;
        this.setNewsDate(this.currentDate());
    }
    public News(String subject, String title, String body) {
        this.subject = subject;
        this.title = title;
        this.body = body;
    }

    public News() {

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) throws SQLException, IOException {
        this.img = img;
        this.base64Image = convertBlobToBase64String(img);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String currentDate(){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sdf.format(date);
        return currentDate;
    }

    private String convertBlobToBase64String(Blob blob) throws SQLException, IOException {
        InputStream inputStream = blob.getBinaryStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[80000];
        int byteReads = inputStream.read(buffer);
        while (byteReads != -1){
            byteArrayOutputStream.write(buffer,0,byteReads);
            byteReads = inputStream.read(buffer);
        }
        byte[] bytesImage = byteArrayOutputStream.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(bytesImage);
        inputStream.close();
        byteArrayOutputStream.close();
        return base64Image;

    }

    public static InputStream partToStream(Part filePart) throws IOException {
        InputStream is = null ;
        if (filePart != null){
            System.out.println(String.format("FileName:%s , FileSize:%s , FileType:%s",filePart.getName(),filePart.getSize(),filePart.getContentType()));
            is = filePart.getInputStream();
        }
        return is;
    }
}
